package com.tcsr.panorama.sys.service.impl;

import com.tcsr.framework.common.utils.AssertUtils;
import com.tcsr.framework.mybatis.entity.BaseEntity;
import com.tcsr.framework.mybatis.execute.ExecuteDescriptorForAdd;
import com.tcsr.framework.mybatis.execute.ExecuteDescriptorForDelete;
import com.tcsr.framework.mybatis.execute.ExecuteDescriptorForEdit;
import com.tcsr.framework.mybatis.service.impl.BaseServiceImpl;
import com.tcsr.panorama.sys.constant.SysDictConstants;
import com.tcsr.panorama.sys.dto.SysRoleDTO;
import com.tcsr.panorama.sys.entity.SysRole;
import com.tcsr.panorama.sys.mapper.SysRoleMapper;
import com.tcsr.panorama.sys.service.ISysRoleService;
import com.tcsr.panorama.sys.service.ISysUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author tangzhong
 * @date   2025-08-28 16:03
 * @since  V1.0.0
 */
@Service
@RequiredArgsConstructor
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    private final ISysUserRoleService sysUserRoleService;

    @Override
    public List<SysRole> listByIds(List<Long> roleIds) {
        return listByConditions(wrapper().in(SysRole::getId, roleIds));
    }

    @Override
    public List<SysRole> listByRoleKeys(List<String> roleKeys) {
        return listByConditions(wrapper().in(SysRole::getRoleKey, roleKeys));
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void add(SysRoleDTO addDTO) {
        //校验角色名是否重复
        Consumer<SysRoleDTO> validateRoleName = (executeDTO) -> {
            SysRole stockByRoleName = super.getByCondition(SysRole::getRoleName, executeDTO.getRoleName());
            AssertUtils.predicate(Objects::nonNull, stockByRoleName, () -> String.format("角色名称【%s】已经存在，请确认！", executeDTO.getRoleName()));
        };
        //校验角色Key是否重复
        Consumer<SysRoleDTO> validateRoleKey = (executeDTO) -> {
            SysRole stockByRoleKey = super.getByCondition(SysRole::getRoleKey, executeDTO.getRoleKey());
            AssertUtils.predicate(Objects::nonNull, stockByRoleKey, () -> String.format("角色Key【%s】已经存在，请确认！", executeDTO.getRoleKey()));
        };
        //新增
        super.execute(ExecuteDescriptorForAdd.of(addDTO, validateRoleName.andThen(validateRoleKey)));
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void edit(SysRoleDTO editDTO) {
        Consumer<SysRoleDTO> bizHandlerBeforeExecute = executeDTO->{
            Long roleId = executeDTO.getId();
            //校验：1、角色是否存在；2、角色是否为系统预设角色（系统预设角色不允许删除）
            SysRole stock = super.getById(roleId);
            AssertUtils.predicate(Objects::isNull, stock, "未知角色，请联系管理员！");
            AssertUtils.predicate(SysDictConstants.SYS_ROLE_TYPE_PRESET::equals, stock.getRoleType(), "系统预设角色不允许修改，请确认！");
            //校验：角色名是否重复
            if(!Objects.equals(stock.getRoleName(), executeDTO.getRoleName())){
                AssertUtils.predicate(baseMapper::exists, wrapper().eq(SysRole::getRoleName, executeDTO.getRoleName()).ne(BaseEntity::getId, roleId),
                        () -> String.format("角色名称【%s】已经存在，请确认！", executeDTO.getRoleName()));
            }
            //校验：角色Key是否重复
            if(!Objects.equals(stock.getRoleKey(), executeDTO.getRoleKey())){
                AssertUtils.predicate(baseMapper::exists, wrapper().eq(SysRole::getRoleKey, executeDTO.getRoleKey()).ne(BaseEntity::getId, roleId),
                        () -> String.format("角色Key【%s】已经存在，请确认！", executeDTO.getRoleKey()));
            }
        };

        super.execute(ExecuteDescriptorForEdit.of(editDTO, bizHandlerBeforeExecute));
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void delete(Long id) {
        //校验：预设角色不允许删除
        SysRole stock = super.getByConditions(wrapper().eq(SysRole::getRoleType, SysDictConstants.SYS_ROLE_TYPE_PRESET).eq(BaseEntity::getId, id));
        AssertUtils.predicate(Objects::nonNull, stock, ()->String.format("系统预设角色[%s]不允许删除！", stock.getRoleName()));
        //校验：已分配给用户的角色不允许删除
        Consumer<List<Long>> ordinaryDeleteValidator = roleIds -> {
            AssertUtils.predicate(sysUserRoleService::validateRoleIsAssigned, roleIds.get(0), "该角色已授权给用户，请确认！");
        };
        //强制删除：解除角色的所有分配关系
        Consumer<List<Long>> forceDeleteHandler = sysUserRoleService::deleteByRoleIds;
        super.execute(ExecuteDescriptorForDelete.of(Collections.singletonList(id), ordinaryDeleteValidator, forceDeleteHandler));
    }
}