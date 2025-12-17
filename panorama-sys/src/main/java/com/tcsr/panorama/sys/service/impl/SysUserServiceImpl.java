package com.tcsr.panorama.sys.service.impl;

import com.tcsr.framework.mybatis.service.impl.BaseServiceImpl;
import com.tcsr.panorama.sys.entity.SysUser;
import com.tcsr.panorama.sys.mapper.SysUserMapper;
import com.tcsr.panorama.sys.service.ISysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author tangzhong
 * @date   2025-10-14 09:03
 * @since  V1.0.0
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public SysUser getByUsername(String username) {
        return getByCondition(SysUser::getUsername, username);
    }
}