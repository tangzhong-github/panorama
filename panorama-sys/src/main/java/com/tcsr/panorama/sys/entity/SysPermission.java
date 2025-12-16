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
 * @since  v1.0
 */
@Getter
@Setter
@NoArgsConstructor
@TableName("sys_permission")
public class SysPermission extends BaseEntity {

    /** 权限名称 */
    private String permissionName;

    /** 权限类型：sys_permission_type  */
    private String permissionType;

    /** 权限码 */
    private String permissionCode;

    /** 父级权限ID */
    private Long parentId;

    /** 权限状态：common_turn_status */
    //@Metadata(dataType = MetadataType.CONSTANTS, value = SysDictConstants.COMMON_ABLE_STATUS_ENABLE)
    private String status;

    /** 备注 */
    private String remark;

}