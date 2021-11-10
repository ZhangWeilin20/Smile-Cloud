package com.smile.member.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author 张维麟
 * @since 2021-11-08 16:05:24
 */
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("ums_member")
@ApiModel(value = "UmsMemberEntity对象", description = "用户信息表")
public class UmsMemberEntity extends Model<UmsMemberEntity> {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("身份证")
    @TableField("id_card")
    private String idCard;

    @ApiModelProperty("用户名")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty("用户密码")
    @TableField("user_password")
    private String userPassword;

    @ApiModelProperty("用户昵称")
    @TableField("user_nickname")
    private String userNickname;

    @ApiModelProperty("手机号")
    @TableField("user_mobile")
    private String userMobile;

    @ApiModelProperty("邮箱")
    @TableField("user_email")
    private String userEmail;

    @ApiModelProperty("头像")
    @TableField("user_avatar")
    private String userAvatar;

    @ApiModelProperty("性别")
    @TableField("user_gender")
    private Integer userGender;

    @ApiModelProperty("启用状态")
    @TableLogic
    @TableField(value = "is_deleted", fill = FieldFill.INSERT)
    private Integer isDeleted;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
