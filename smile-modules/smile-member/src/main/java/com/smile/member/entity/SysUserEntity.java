package com.smile.member.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author 张维麟
 * @since 2021-11-17 10:16:20
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_user")
@ApiModel(value = "SysUserEntity对象", description = "系统用户")
public class SysUserEntity extends Model<SysUserEntity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("身份证")
    @TableField("id_card")
    private String idCard;

    @ApiModelProperty("姓名")
    @TableField("real_name")
    private String realName;

    @ApiModelProperty("昵称")
    @TableField("nick_name")
    private String nickName;

    @ApiModelProperty("账号")
    @TableField("account")
    private String account;

    @ApiModelProperty("密码，加密方式为BCrypt")
    @TableField("password")
    private String password;

    @ApiModelProperty("头像，存的为文件id")
    @TableField("avatar")
    private Long avatar;

    @ApiModelProperty("生日")
    @TableField("birthday")
    private LocalDate birthday;

    @ApiModelProperty("性别：1-男，0-女")
    @TableField("sex")
    private Integer sex;

    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("手机")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("电话")
    @TableField("tel")
    private String tel;

    @ApiModelProperty("是否是超级管理员：Y-是，N-否")
    @TableField("super_admin_flag")
    private String superAdminFlag;

    @ApiModelProperty("状态：0-激活，1-未激活")
    @TableField("active_flag")
    private Integer activeFlag;

    @ApiModelProperty("状态：0-正常，1-冻结")
    @TableField("status_flag")
    private Integer statusFlag;

    @ApiModelProperty("最后登陆IP")
    @TableField("last_login_ip")
    private String lastLoginIp;

    @ApiModelProperty("最后登陆时间")
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;

    @ApiModelProperty("删除标记：1-已删除，0-未删除")
    @TableField(value = "del_flag", fill = FieldFill.INSERT)
    @TableLogic
    private Integer delFlag;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("创建人")
    @TableField("create_user")
    private Long createUser;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("更新人")
    @TableField("update_user")
    private Long updateUser;


    public static final String ID = "id";

    public static final String ID_CARD = "id_card";

    public static final String REAL_NAME = "real_name";

    public static final String NICK_NAME = "nick_name";

    public static final String ACCOUNT = "account";

    public static final String PASSWORD = "password";

    public static final String AVATAR = "avatar";

    public static final String BIRTHDAY = "birthday";

    public static final String SEX = "sex";

    public static final String EMAIL = "email";

    public static final String PHONE = "phone";

    public static final String TEL = "tel";

    public static final String SUPER_ADMIN_FLAG = "super_admin_flag";

    public static final String ACTIVE_FLAG = "active_flag";

    public static final String STATUS_FLAG = "status_flag";

    public static final String LAST_LOGIN_IP = "last_login_ip";

    public static final String LAST_LOGIN_TIME = "last_login_time";

    public static final String DEL_FLAG = "del_flag";

    public static final String CREATE_TIME = "create_time";

    public static final String CREATE_USER = "create_user";

    public static final String UPDATE_TIME = "update_time";

    public static final String UPDATE_USER = "update_user";

    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
