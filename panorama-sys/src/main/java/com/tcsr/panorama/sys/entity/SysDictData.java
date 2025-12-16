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
@TableName("sys_dict_data")
public class SysDictData extends BaseEntity{

    /** 字典Key */
    private String dictKey;

    /** 字典值 */
    private String dictValue;

    /** 字典Label */
    private String dictLabel;

    /** 备注 */
    private String remark;

}