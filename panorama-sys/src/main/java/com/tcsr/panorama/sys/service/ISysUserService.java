package com.tcsr.panorama.sys.service;

import com.tcsr.framework.mybatis.service.IBaseService;
import com.tcsr.panorama.sys.entity.SysUser;

/**
 *
 * @author tangzhong
 * @since  2025-08-28 15:57
 */
public interface ISysUserService extends IBaseService<SysUser> {

    SysUser getByUsername(String username);

}
