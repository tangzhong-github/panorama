package com.tcsr.panorama.sys.service;

import com.tcsr.framework.mybatis.service.IBaseService;
import com.tcsr.panorama.sys.entity.SysUserRole;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author tangzhong
 * @date   2025-08-28 15:57
 * @since  V1.0.0
 */
public interface ISysUserRoleService extends IBaseService<SysUserRole> {

    Optional<List<SysUserRole>> getUserRoles(Long userId);

    boolean validateRoleIsAssigned(Long roleId);

    void deleteByRoleIds(List<Long> roleIds);

}
