package com.green.greengram_test1.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignInRes {
    private long userId;
    private String nickName;
    private String pic;
    @JsonIgnore
    private String upw;
    @JsonIgnore
    private String Message;
}

