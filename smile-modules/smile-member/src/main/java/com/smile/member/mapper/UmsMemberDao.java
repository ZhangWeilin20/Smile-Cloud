package com.smile.member.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smile.member.entity.UmsMemberEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author 张维麟
 * @since 2021-11-08 16:05:24
 */
@Mapper
public interface UmsMemberDao extends BaseMapper<UmsMemberEntity> {

}
