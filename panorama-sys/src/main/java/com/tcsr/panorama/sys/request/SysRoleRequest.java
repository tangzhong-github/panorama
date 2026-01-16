package com.tcsr.panorama.sys.request;

import com.tcsr.framework.common.api.Request;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tangzhong
 * @date   2025-12-15 10:01
 * @since  V1.0.0
 */
@Getter
@Setter
public class SysRoleRequest extends Request {

    /** 角色名 */
    private String roleName;

}