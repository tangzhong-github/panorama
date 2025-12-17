package com.tcsr.panorama.sys.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author tangzhong
 * @date   2025-12-15 10:12
 * @since  V1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
public class SysUserListVO implements Serializable {

    /** 用户ID */
    private Long id;

    /** 用户名 */
    private String username;

    /** 创建人 */
    private String creator;

    /** 创建时间 */
    private LocalDateTime createTime;

    /** 更新人 */
    private String updater;

    /** 更新时间 */
    private LocalDateTime updateTime;

}