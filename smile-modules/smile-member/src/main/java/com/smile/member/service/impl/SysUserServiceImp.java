package com.smile.member.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.nacos.common.utils.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smile.common.core.constant.ModuleConstant;
import com.smile.common.core.exception.BaseException;
import com.smile.member.entity.SysUserEntity;
import com.smile.member.mapper.SysUserDao;
import com.smile.member.service.SysUserService;
import com.smile.member.vo.SysUserVo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author 张维麟
 * @since 2021-11-17 10:16:20
 */
@Service
public class SysUserServiceImp extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
    final
    SysUserDao sysUserDao;

    public SysUserServiceImp(SysUserDao sysUserDao) {
        this.sysUserDao = sysUserDao;
    }

    @Override
    public void doRegister(SysUserVo sysUserVo) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String account = sysUserVo.getAccount();
        String password = bCryptPasswordEncoder.encode(sysUserVo.getPassword());

        //判断输入的数据是否为空
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
            throw new BaseException(ModuleConstant.SMILE_MEMBER, 10001, new String[]{account, password}, "参数校验失败");
        }
        //判断输入用户名的数据是否存在
        SysUserEntity sysUserEntity = new SysUserEntity();
        BeanUtil.copyProperties(sysUserVo,sysUserEntity,true);
        sysUserEntity.setPassword(password);

        QueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", account);

        List<SysUserEntity> hasSysUserEntity = sysUserDao.selectList(queryWrapper);

        if (!hasSysUserEntity.isEmpty()) {
            throw new BaseException(ModuleConstant.SMILE_MEMBER, 20002, new String[]{account}, "用户已存在");
        }
        //添加
        int insert = sysUserDao.insert(sysUserEntity);
        if (insert < 0) {
            throw new BaseException(ModuleConstant.SMILE_MEMBER, 10002, new String[]{account}, "添加失败");
        }


    }

    @Override
    public SysUserEntity doLogin(SysUserVo sysUserVo) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String account = sysUserVo.getAccount();
        String password = sysUserVo.getPassword();
        //判断输入的数据是否为空
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
            throw new BaseException(ModuleConstant.SMILE_MEMBER, 10001, new String[]{account, password}, "参数校验失败");
        }
        QueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", account);

        List<SysUserEntity> hasSysUserEntity = sysUserDao.selectList(queryWrapper);
        if (hasSysUserEntity.isEmpty()) {
            throw new BaseException(ModuleConstant.SMILE_MEMBER, 20002, new String[]{account}, "用户不存在，请先注册");
        }
        HashMap<Object,SysUserEntity> map = new HashMap<>(16);

        hasSysUserEntity.forEach( t->{
            boolean matches = bCryptPasswordEncoder.matches(password, t.getPassword());
            if (matches) {
                map.put(t.getAccount(),t);
            }else {
                throw new BaseException(ModuleConstant.SMILE_MEMBER, 10001, new String[]{password}, "密码错误");
            }
        });
        return map.get(account);
    }

}
