package com.tcsr.panorama.sys.constant;

import com.tcsr.framework.common.constant.DictConstants;

/**
 *
 * 字典常量-系统管理模块
 * 说明：字典范围(2001 - 2999)
 * @author tangzhong
 * @date  2025-11-20 9:50
 * @since  V1.0.0
 */
public interface SysDictConstants extends DictConstants {

    /** 系统-角色类型 */
    String SYS_ROLE_TYPE = "sys_role_type";
    /** 系统-角色类型：系统预设 */
    String SYS_ROLE_TYPE_PRESET = "20010001";
    /** 系统-角色类型：用户自定义 */
    String SYS_ROLE_TYPE_CUSTOM = "20010002";

    /** 系统-数据权限 */
    String SYS_DATA_SCOPE = "sys_data_scope";
    /** 系统-数据权限：个人 */
    String SYS_DATA_SCOPE_PERSONAL = "20020001";
    /** 系统-数据权限：全部 */
    String SYS_DATA_SCOPE_ALL = "20020002";
    /** 系统-数据权限：机构及下级机构 */
    String SYS_DATA_SCOPE_ORG = "20020003";

    /** 系统-菜单类型 */
    String SYS_MENU_TYPE = "SYS_MENU_TYPE";
    /** 系统-菜单类型：目录 */
    String SYS_MENU_TYPE_CATALOG = "20100001";
    /** 系统-菜单类型：菜单 */
    String SYS_MENU_TYPE_MENU = "20100002";
    /** 系统-菜单类型：按钮 */
    String SYS_MENU_TYPE_BUTTON = "20100003";

    /** 系统-用户类型 */
    String SYS_USER_TYPE = "sys_user_type";
    /** 系统-用户类型：系统管理员 */
    String SYS_USER_TYPE_PRESET = "20200001";
    /** 系统-用户类型：普通用户 */
    String SYS_USER_TYPE_COMMON = "20200002";

    /** 系统-机构类型 */
    String SYS_ORG_TYPE = "sys_org_type";
    /** 系统-机构类型：根组织 */
    String SYS_ORG_TYPE_ROOT = "20300001";
    /** 系统-机构类型：公司 */
    String SYS_ORG_TYPE_COMPANY = "20300002";
    /** 系统-机构类型：部门 */
    String SYS_ORG_TYPE_DEPT = "20300003";

}