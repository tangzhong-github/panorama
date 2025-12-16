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
@TableName("sys_org")
public class SysOrg extends BaseEntity {

    /** 机构类型： sys_org_type */
    private String orgType;

    /** 机构名称 */
    private String orgName;

    /** 机构码 */
    private String roleCode;

    /** 上级机构ID */
    private Long parentId;

    /** 状态：common_turn_status */
    //@Metadata(dataType = MetadataType.CONSTANTS, value = SysDictConstants.COMMON_ABLE_STATUS_ENABLE)
    private String status;

    /** 备注 */
    private String remark;

}