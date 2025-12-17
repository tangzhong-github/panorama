package com.tcsr.panorama.sys.service.impl;

import com.tcsr.framework.mybatis.service.impl.BaseServiceImpl;
import com.tcsr.panorama.sys.entity.SysUserRole;
import com.tcsr.panorama.sys.mapper.SysUserRoleMapper;
import com.tcsr.panorama.sys.service.ISysUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author tangzhong
 * @date   2025-10-14 09:03
 * @since  V1.0.0
 */
@Service
@RequiredArgsConstructor
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

    @Override
    public Optional<List<SysUserRole>> getUserRoles(Long userId) {
        List<SysUserRole> userRoleList = listByCondition(SysUserRole::getUserId, userId);
        return Optional.ofNullable(userRoleList);
    }

    @Override
    public boolean validateRoleIsAssigned(Long roleId) {
        return super.baseMapper.exists(wrapper().eq(SysUserRole::getRoleId, roleId));
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void deleteByRoleIds(List<Long> roleIds) {
        super.baseMapper.delete(wrapper().in(SysUserRole::getRoleId, roleIds));
    }

}