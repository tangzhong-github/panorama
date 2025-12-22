package com.tcsr.panorama.sys.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tcsr.framework.common.utils.DateUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author tangzhong
 * @date   2025-12-17 16:07
 * @since  V1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
public class SysMenuTreeVO{

    /** 主键ID */
    private Long id;

    /** 菜单名称 */
    private String menuName;

    /** 权限类型：sys_menu_type  */
    private String menuType;

    /** 父级菜单ID */
    private Long parentId;

    /** 权限码 */
    private String permissionCode;

    /** 权限状态：common_turn_status */
    private String status;

    /** 创建人 */
    private String creatorName;

    /** 创建时间 */
    @JsonFormat(pattern = DateUtils.YYYY_MM_DD_HH_MM_SS)
    private LocalDateTime createTime;

    /** 更新人 */
    private String updaterName;

    /** 更新时间 */
    @JsonFormat(pattern = DateUtils.YYYY_MM_DD_HH_MM_SS)
    private LocalDateTime updateTime;

    /** 子菜单列表 */
    private List<SysMenuTreeVO> childrenMenus;

}