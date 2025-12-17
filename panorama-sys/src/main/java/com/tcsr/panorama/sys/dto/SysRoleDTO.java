package com.tcsr.panorama.sys.dto;

import com.tcsr.framework.common.validate.GroupAdd;
import com.tcsr.framework.common.validate.GroupEdit;
import com.tcsr.framework.common.dto.BaseDTO;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author tangzhong
 * @date   2025-08-28 15:43
 * @since  V1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
public class SysRoleDTO extends BaseDTO {

    /** 角色名称 */
    @NotNull(message = "角色名称不能为空", groups = {GroupAdd.class, GroupEdit.class})
    private String roleName;

    /** 角色Key */
    @NotNull(message = "角色Key不能为空", groups = {GroupAdd.class, GroupEdit.class})
    private String roleKey;

    /** 备注 */
    private String remark;

}