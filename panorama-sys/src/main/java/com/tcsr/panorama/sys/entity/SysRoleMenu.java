package com.tcsr.panorama.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tcsr.framework.mybatis.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 *
 * @author tangzhong
 * @date   2025-08-28 11:17
 * @since  V1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
@TableName("sys_role_menu")
public class SysRoleMenu extends BaseEntity{

    /** 角色ID */
    private Long roleId;

    /** 菜单ID */
    private Long menuId;

    @TableField(exist = false)
    private String roleKey;

}