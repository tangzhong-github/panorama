package com.tcsr.panorama.auth.provider;

import com.tcsr.framework.common.constant.RoleKeyConstants;
import com.tcsr.framework.redis.RedisUtils;
import com.tcsr.framework.web.constant.RedisConstants;
import com.tcsr.framework.web.provider.UserInfoProvider;
import com.tcsr.framework.web.provider.UserPermissionProvider;
import com.tcsr.framework.web.user.UserDTO;
import com.tcsr.framework.web.utils.SecurityUtils;
import com.tcsr.panorama.sys.entity.SysRole;
import com.tcsr.panorama.sys.entity.SysUser;
import com.tcsr.panorama.sys.entity.SysUserRole;
import com.tcsr.panorama.sys.service.ISysRoleService;
import com.tcsr.panorama.sys.service.ISysUserRoleService;
import com.tcsr.panorama.sys.service.ISysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author tangzhong
 * @date   2025-10-14 09:03
 * @since  V1.0.0
 */
@Service
@RequiredArgsConstructor
public class PanoramaUserInfoProvider implements UserInfoProvider, UserPermissionProvider {

    private final ISysUserService sysUserService;
    private final ISysRoleService sysRoleService;
    private final ISysUserRoleService sysUserRoleService;

    @Override
    public Optional<UserDTO> getByUsername(String username) {
        SysUser user = sysUserService.getByUsername(username);
        return Optional.ofNullable(user).map(this::buildUserDetails);
    }

    private UserDTO buildUserDetails(SysUser user){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        Optional<List<SysUserRole>> userRoleOptional = sysUserRoleService.getUserRoles(user.getId());
        userRoleOptional.ifPresent(sysUserRoles -> {
            List<Long> roleIds = sysUserRoles.stream().map(SysUserRole::getRoleId).toList();
            List<String> roleKeys = sysRoleService.listByIds(roleIds).stream().map(SysRole::getRoleKey).toList();
            userDTO.setRoles(roleKeys);
        });
        return userDTO;
    }

    @Override
    public List<String> getDataScopes(Long userId) {
        List<SysRole> list = sysRoleService.listByRoleKeys(SecurityUtils.getUserRoles());
        return list.stream().map(SysRole::getDataScope).toList();
    }

    @Override
    public boolean hasAnyRole(Long userId, List<String> roles) {
        List<String> userRoles = SecurityUtils.getUserRoles();
        if(userRoles.contains(RoleKeyConstants.ROLE_ADMIN)){
            return Boolean.TRUE;
        }
        return userRoles.stream().anyMatch(roles::contains);
    }

    @Override
    public boolean hasAnyPermission(Long userId, List<String> permissions) {
        List<String> userRoles = SecurityUtils.getUserRoles();
        if(userRoles.contains(RoleKeyConstants.ROLE_ADMIN)){
            return Boolean.TRUE;
        }
        //获取用户角色权限，判断是否存在指定的权限
        Map<String, List<String>> rolePermissionMap = RedisUtils.getCacheMapValue(RedisConstants.ROLE_PERMISSIONS);
        if(!CollectionUtils.isEmpty(rolePermissionMap)){
            for (Map.Entry<String, List<String>> tmpRolePermissions : rolePermissionMap.entrySet()) {
                if(userRoles.contains(tmpRolePermissions.getKey())){
                    boolean isHasAppointPermission = tmpRolePermissions.getValue().stream().anyMatch(permissions::contains);
                    if(isHasAppointPermission){
                        return Boolean.TRUE;
                    }
                }
            }
        }
        return false;
    }

}