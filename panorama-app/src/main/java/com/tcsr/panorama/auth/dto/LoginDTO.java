package com.tcsr.panorama.auth.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author tangzhong
 * @since  2025-11-03 11:04
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