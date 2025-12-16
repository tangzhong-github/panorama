package com.tcsr.panorama.sys.service;

import com.tcsr.framework.mybatis.service.IBaseService;
import com.tcsr.panorama.sys.entity.SysUserRole;

import java.util.List;

/**
 *
 * @author tangzhong
 * @since  2025-08-28 15:57
 */
public interface ISysUserRoleService extends IBaseService<SysUserRole> {

    boolean validateRoleIsAssigned(Long roleId);

    void deleteByRoleIds(List<Long> roleIds);
}
