package com.tcsr.panorama.auth.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author tangzhong
 * @date   2025-11-03 11:04
 * @since  V1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
public class LoginDTO {

    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;

}