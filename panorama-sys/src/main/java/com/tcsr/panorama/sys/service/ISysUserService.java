package com.tcsr.panorama.sys.service;

import com.tcsr.framework.mybatis.service.IBaseService;
import com.tcsr.panorama.sys.entity.SysUser;

/**
 *
 * @author tangzhong
 * @date   2025-08-28 15:57
 * @since  V1.0.0
 */
public interface ISysUserService extends IBaseService<SysUser> {

    SysUser getByUsername(String username);

}
