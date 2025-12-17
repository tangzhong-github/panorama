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
@TableName("sys_dict")
public class SysDict extends BaseEntity {

    /** 字典名 */
    private String dictName;

    /** 字典Key */
    private String dictKey;

    /** 备注 */
    private String remark;

}