package com.smile.auth.feign;

import com.smile.auth.vo.SysUserVo;
import com.smile.common.core.domain.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 张维麟
 * @date 2021/11/10 10:09
 */
@FeignClient("smile-member")
public interface SysUserService {

    @PostMapping("/insertOne")
    R doRegister(@RequestBody  SysUserVo syUserVo);


    @PostMapping("/selectOne")
    R doLogin(@RequestBody SysUserVo syUserVo);

}
