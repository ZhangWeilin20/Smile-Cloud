package com.smile.member.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smile.common.core.constant.ModuleConstant;
import com.smile.common.core.exception.BaseException;
import com.smile.member.entity.UmsMemberEntity;
import com.smile.member.mapper.UmsMemberDao;
import com.smile.member.service.UmsMemberService;
import com.smile.member.vo.UmsMemberVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author 张维麟
 * @since 2021-11-08 16:05:24
 */
@Service
public class UmsMemberServiceImpl extends ServiceImpl<UmsMemberDao, UmsMemberEntity> implements UmsMemberService {

    final
    UmsMemberDao umsMemberDao;

    public UmsMemberServiceImpl(UmsMemberDao umsMemberDao) {
        this.umsMemberDao = umsMemberDao;
    }

    @Override
    public void insertOne(UmsMemberVo umsMemberVo) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String userName = umsMemberVo.getUserName();
        String userPassword = bCryptPasswordEncoder.encode(umsMemberVo.getUserPassword());

        //判断输入的数据是否为空
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(userPassword)) {
            throw new BaseException(ModuleConstant.SMILE_MEMBER, 10001, new String[]{userName, userPassword}, "参数校验失败");
        }
        //判断输入用户名的数据是否存在
        UmsMemberEntity umsMemberEntity = new UmsMemberEntity();
        BeanUtil.copyProperties(umsMemberVo,umsMemberEntity,true);
        umsMemberEntity.setUserPassword(userPassword);

        QueryWrapper<UmsMemberEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userName);

        List<UmsMemberEntity> hasUmsMemberEntity = umsMemberDao.selectList(queryWrapper);

        if (!hasUmsMemberEntity.isEmpty()) {
            throw new BaseException(ModuleConstant.SMILE_MEMBER, 20002, new String[]{userName}, "用户已存在");
        }
        //添加
        int insert = umsMemberDao.insert(umsMemberEntity);
        if (insert < 0) {
            throw new BaseException(ModuleConstant.SMILE_MEMBER, 10002, new String[]{userName}, "添加失败");
        }


    }

    @Override
    public UmsMemberEntity selectOne(UmsMemberVo umsMemberVo) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String userName = umsMemberVo.getUserName();
        String userPassword = umsMemberVo.getUserPassword();
        //判断输入的数据是否为空
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(userPassword)) {
            throw new BaseException(ModuleConstant.SMILE_MEMBER, 10001, new String[]{userName, userPassword}, "参数校验失败");
        }
        QueryWrapper<UmsMemberEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userName);

        List<UmsMemberEntity> hasUmsMemberEntity = umsMemberDao.selectList(queryWrapper);
        if (hasUmsMemberEntity.isEmpty()) {
            throw new BaseException(ModuleConstant.SMILE_MEMBER, 20002, new String[]{userName}, "用户不存在，请先注册");
        }
        HashMap<Object,UmsMemberEntity> map = new HashMap<>(16);

        hasUmsMemberEntity.forEach( t->{
            boolean matches = bCryptPasswordEncoder.matches(userPassword, t.getUserPassword());
            if (matches) {
                map.put(t.getUserName(),t);
            }else {
                throw new BaseException(ModuleConstant.SMILE_MEMBER, 10001, new String[]{userPassword}, "密码错误");
            }
        });

        return map.get(userName);
    }

}
