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
    void insertOne(UmsMemberVo umsMemberVo);
}
