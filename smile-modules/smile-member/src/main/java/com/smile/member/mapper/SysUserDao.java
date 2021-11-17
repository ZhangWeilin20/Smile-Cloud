package com.smile.member.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smile.member.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统用户 Mapper 接口
 * </p>
 *
 * @author 张维麟
 * @since 2021-11-17 10:16:20
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {

}
