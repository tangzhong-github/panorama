package com.tcsr.panorama.sys.service.impl;

import com.tcsr.framework.common.utils.TreeUtils;
import com.tcsr.framework.mybatis.service.impl.BaseServiceImpl;
import com.tcsr.panorama.sys.entity.SysMenu;
import com.tcsr.panorama.sys.mapper.SysMenuMapper;
import com.tcsr.panorama.sys.service.ISysMenuService;
import com.tcsr.panorama.sys.vo.SysMenuTreeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tangzhong
 * @date   2025-08-28 16:03
 * @since  V1.0.0
 */
@Service
@RequiredArgsConstructor
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Override
    public List<SysMenuTreeVO> tree() {
        //菜单列表
        List<SysMenuTreeVO> menuVOList = baseMapper.list();
        //构建菜单树
        TreeUtils<SysMenuTreeVO> treeUtils = new TreeUtils<>(SysMenuTreeVO::getId, SysMenuTreeVO::getParentId, SysMenuTreeVO::getChildrenMenus);
        return treeUtils.build(menuVOList);
    }

}