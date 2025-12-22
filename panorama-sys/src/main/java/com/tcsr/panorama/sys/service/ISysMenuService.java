package com.tcsr.panorama.sys.service;

import com.tcsr.framework.mybatis.service.IBaseService;
import com.tcsr.panorama.sys.entity.SysMenu;
import com.tcsr.panorama.sys.vo.SysMenuTreeVO;

import java.util.List;

/**
 *
 * @author tangzhong
 * @date   2025-08-28 15:57
 * @since  V1.0.0
 */
public interface ISysMenuService extends IBaseService<SysMenu> {

    List<SysMenuTreeVO> tree();

}
