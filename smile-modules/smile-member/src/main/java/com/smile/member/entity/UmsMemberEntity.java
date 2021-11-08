package com.smile.member.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
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
@Getter
@Setter
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
    @TableField("status_flag")
    private Integer statusFlag;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;




    public static final String ID_CARD = "id_card";

    public static final String USER_NAME = "user_name";

    public static final String USER_PASSWORD = "user_password";

    public static final String USER_NICKNAME = "user_nickname";

    public static final String USER_MOBILE = "user_mobile";

    public static final String USER_EMAIL = "user_email";

    public static final String USER_AVATAR = "user_avatar";

    public static final String USER_GENDER = "user_gender";

    public static final String STATUS_FLAG = "status_flag";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
