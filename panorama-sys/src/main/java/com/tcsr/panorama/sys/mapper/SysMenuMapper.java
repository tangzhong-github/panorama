package com.tcsr.panorama.sys.mapper;

import com.tcsr.framework.mybatis.mapper.BaseMapper;
import com.tcsr.panorama.sys.entity.SysMenu;
import com.tcsr.panorama.sys.vo.SysMenuTreeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * @author tangzhong
 * @date   2025-08-28 15:56
 * @since  V1.0.0
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenuTreeVO> list();

}
