package com.tcsr.panorama.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tcsr.framework.mybatis.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author tangzhong
 * @date   2025-08-28 11:17
 * @since  V1.0.0
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@TableName("sys_user_role")
public class SysUserRole extends BaseEntity {

    /** 用户ID */
    private Long userId;

    /** 角色ID */
    private Long roleId;

    @TableField(exist = false)
    private String username;

    @TableField(exist = false)
    private String roleName;

    @TableField(exist = false)
    private String roleKey;
}