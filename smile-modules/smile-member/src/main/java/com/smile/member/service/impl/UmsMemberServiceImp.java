package com.smile.member.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smile.member.entity.UmsMemberEntity;
import com.smile.member.mapper.UmsMemberDao;
import com.smile.member.service.UmsMemberService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author 张维麟
 * @since 2021-11-08 16:05:24
 */
@Service
public class UmsMemberServiceImp extends ServiceImpl<UmsMemberDao, UmsMemberEntity> implements UmsMemberService {

}
