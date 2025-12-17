package com.tcsr.panorama.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tcsr.framework.mybatis.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author tangzhong
 * @date   2025-08-28 11:17
 * @since  V1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
@TableName("sys_role")
public class SysRole extends BaseEntity {

    /** 角色名称 */
    private String roleName;

    /** 角色Key */
    private String roleKey;

    /** 数据权限： sys_data_scope */
    private String dataScope;

    /** 角色类型： sys_role_type */
    //@Metadata(dataType = MetadataType.CONSTANTS, value = SysDictConstants.SYS_ROLE_TYPE_CUSTOM)
    private String roleType;

    /** 角色状态：common_turn_status */
    //@Metadata(dataType = MetadataType.CONSTANTS, value = SysDictConstants.COMMON_ABLE_STATUS_ENABLE)
    private String status;

    /** 备注 */
    private String remark;

}