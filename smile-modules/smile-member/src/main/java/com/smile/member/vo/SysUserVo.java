package com.smile.member.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 张维麟
 * @date 2021/11/8 16:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUserVo {

    private String account;

    private String password;

}
