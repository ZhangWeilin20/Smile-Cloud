package com.smile.auth.feign;

import com.smile.auth.vo.UmsMemberVo;
import com.smile.common.core.domain.Res;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 张维麟
 * @date 2021/11/10 10:09
 */
@FeignClient("smile-member")
public interface UmsMemberService {

    @PostMapping("/insertOne")
    Res doRegister(@RequestBody UmsMemberVo umsMemberVo);


    @PostMapping("/selectOne")
    Res doLogin(@RequestBody UmsMemberVo umsMemberVo);

}
