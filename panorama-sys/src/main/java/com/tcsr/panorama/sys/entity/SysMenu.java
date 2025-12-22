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
@TableName("sys_permission")
public class SysMenu extends BaseEntity {

    /** 菜单名称 */
    private String menuName;

    /** 权限类型：sys_menu_type  */
    private String menuType;

    /** 父级菜单ID */
    private Long parentId;

    /** 权限码 */
    private String permissionCode;

    /** 权限状态：common_turn_status */
    //@Metadata(dataType = MetadataType.CONSTANTS, value = SysDictConstants.COMMON_ABLE_STATUS_ENABLE)
    private String status;

    /** 备注 */
    private String remark;

}