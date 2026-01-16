package com.tcsr.panorama.sys.controller;

import com.tcsr.framework.mybatis.api.Page;
import com.tcsr.framework.mybatis.api.PageResult;
import com.tcsr.framework.web.controller.BaseController;
import com.tcsr.panorama.sys.request.SysUserRequest;
import com.tcsr.panorama.sys.service.ISysUserService;
import com.tcsr.panorama.sys.vo.SysUserListVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tangzhong
 * @date   2025-08-28 15:04
 * @since  V1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/sys/user")
public class SysUserController extends BaseController {

    private final ISysUserService sysUserService;

    @GetMapping("/pageList")
    public PageResult<SysUserListVO> pageList(SysUserRequest request) {
        return sysUserService.pageList(Page.of(request));
    }

}