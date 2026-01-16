package com.tcsr.panorama.sys.controller;

import com.tcsr.framework.common.validate.GroupAdd;
import com.tcsr.framework.common.validate.GroupEdit;
import com.tcsr.framework.mybatis.api.Page;
import com.tcsr.framework.mybatis.api.PageResult;
import com.tcsr.framework.web.controller.BaseController;
import com.tcsr.panorama.sys.request.SysRoleRequest;
import com.tcsr.panorama.sys.dto.SysRoleDTO;
import com.tcsr.panorama.sys.entity.SysRole;
import com.tcsr.panorama.sys.service.ISysRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tangzhong
 * @date   2025-08-28 15:04
 * @since  V1.0.0
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/sys/role")
public class SysRoleController extends BaseController {

    private final ISysRoleService sysRoleService;

    @GetMapping("/pageList")
    public PageResult<SysRole> pageList(SysRoleRequest request) {
        return sysRoleService.pageList(Page.of(request));
    }

    @PostMapping
    public void add(@RequestBody @Validated(GroupAdd.class) SysRoleDTO addDTO){
        sysRoleService.add(addDTO);
    }

    @PutMapping
    public void edit(@RequestBody @Validated(GroupEdit.class) SysRoleDTO editDTO){
        sysRoleService.edit(editDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        sysRoleService.delete(id);
    }

}