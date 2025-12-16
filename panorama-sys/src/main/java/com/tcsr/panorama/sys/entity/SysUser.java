package com.tcsr.panorama.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@TableName("sys_user")
public class SysUser extends BaseEntity {

    /** 用户名称 */
    private String username;

    /** 密码 */
    @JsonIgnore
    private String password;

    /** 用户类型： sys_user_type */
    //@Metadata(dataType = MetadataType.CONSTANTS, value = SysDictConstants.SYS_USER_TYPE_COMMON)
    private String userType;

    /** 用户状态：common_turn_status */
    //@Metadata(dataType = MetadataType.CONSTANTS, value = SysDictConstants.COMMON_ABLE_STATUS_ENABLE)
    private String status;

    /** 备注 */
    private String remark;

}