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
@TableName("sys_param")
public class SysParam extends BaseEntity {

    /** 参数名 */
    private String paramName;

    /** 参数Key */
    private String paramKey;

    /** 参数值 */
    private String paramValue;

    /** 备注 */
    private String remark;

}