package com.tcsr.panorama.sys.condition;

import com.tcsr.framework.mybatis.api.QueryCondition;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tangzhong
 * @since  2025-12-15 10:01
 */
@Getter
@Setter
public class SysUserCondition extends QueryCondition {

    /** 用户名 */
    private String username;

}