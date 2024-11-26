package com.green.greengram_test1.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Schema(title = "회원가입")
public class UserSignUpReq {
    @JsonIgnore
    private long userId;
    @Schema(description = "유저 아이디", example = "userID")
    private String uid;
    @Schema(description = "유저 비밀번호", example = "userPW")
    private String upw;
    @Schema(description = "유저 닉네임", example = "NICKNAME")
    private String nickName;
    @JsonIgnore
    private String pic;
}
