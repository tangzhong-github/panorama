package com.tcsr.panorama.auth.controller;

import com.tcsr.framework.redis.RedisUtils;
import com.tcsr.framework.web.user.TcsrUserDetail;
import com.tcsr.framework.web.constant.RedisConstants;
import com.tcsr.framework.web.constant.WebConstants;
import com.tcsr.framework.web.provider.JwtTokenProvider;
import com.tcsr.framework.web.utils.SecurityUtils;
import com.tcsr.panorama.auth.dto.LoginDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginDTO loginDTO) {
        //认证
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String userIdStr = String.valueOf(SecurityUtils.getUserId());
        //生成Token
        String token = jwtTokenProvider.generateToken(userIdStr, loginDTO.getUsername());
        //缓存用户Token
        TcsrUserDetail userDetail = (TcsrUserDetail) authentication.getPrincipal();
        RedisUtils.setCacheMapValue(RedisConstants.USER_TOKEN_ACTIVE, token, userDetail.getUser());
        //缓存用户角色信息
        Collection<? extends GrantedAuthority> authorities = userDetail.getAuthorities();
        if(!CollectionUtils.isEmpty(authorities)){
            Set<String> userRoleSet = authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
            RedisUtils.setCacheMapValue(RedisConstants.USER_ROLES, userIdStr, userRoleSet);
        }
        return Map.of(WebConstants.TOKEN, token);
    }
    
    @PostMapping("/logout")
    public void logout() {
        String token = jwtTokenProvider.getToken();
        // 将Token加入Redis黑名单
        SecurityUtils.getAuthentication().ifPresent(e->RedisUtils.setCacheMapValue(RedisConstants.USER_TOKEN_BLACK, token, e));
    }

}
