package com.tcsr.panorama.sys.service;

import com.tcsr.framework.mybatis.service.IBaseService;
import com.tcsr.panorama.sys.dto.SysRoleDTO;
import com.tcsr.panorama.sys.entity.SysRole;

import java.util.List;

/**
 *
 * @author tangzhong
 * @date   2025-08-28 15:57
 * @since  V1.0.0
 */
public interface ISysRoleService extends IBaseService<SysRole> {

    List<SysRole> listByIds(List<Long> roleIds);

    List<SysRole> listByRoleKeys(List<String> roleKeys);

    void add(SysRoleDTO addDTO);

    void edit(SysRoleDTO editDTO);

    void delete(Long id);

}
