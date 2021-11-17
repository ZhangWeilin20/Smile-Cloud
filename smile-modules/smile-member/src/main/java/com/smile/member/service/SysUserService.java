package com.smile.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smile.member.entity.SysUserEntity;
import com.smile.member.vo.SysUserVo;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author 张维麟
 * @since 2021-11-17 10:16:20
 */
public interface SysUserService extends IService<SysUserEntity> {
    /**
     * 添加一个用户
     * @param sysUserVo 用户类
     */
    void doRegister(SysUserVo sysUserVo);

    /**
     * 用户名密码查询账号信息
     * @param sysUserVo 用户名和密码封装的对象
     * @return 数据库实体类
     */
    SysUserEntity doLogin(SysUserVo sysUserVo);


}
