package com.tcsr.panorama.sys.condition;

import com.tcsr.framework.mybatis.api.QueryCondition;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tangzhong
 * @date   2025-12-15 10:01
 * @since  V1.0.0.0
 */
@Getter
@Setter
public class SysRoleCondition extends QueryCondition {

    /** 角色名 */
    private String roleName;

}