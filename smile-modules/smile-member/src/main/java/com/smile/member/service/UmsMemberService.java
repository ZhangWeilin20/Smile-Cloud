package com.smile.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smile.member.entity.UmsMemberEntity;
import com.smile.member.vo.UmsMemberVo;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author 张维麟
 * @since 2021-11-08 16:05:24
 */
public interface UmsMemberService extends IService<UmsMemberEntity> {
    /**
     * 添加一个用户
     * @param umsMemberVo 用户类
     */
    void doRegister(UmsMemberVo umsMemberVo);

    /**
     * 用户名密码查询账号信息
     * @param umsMemberVo 用户名和密码封装的对象
     * @return 数据库实体类
     */
    UmsMemberEntity doLogin(UmsMemberVo umsMemberVo);

}
