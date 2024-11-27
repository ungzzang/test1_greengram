package com.green.greengram_test1.user;

import com.green.greengram_test1.feed.model.FeedGetReq;
import com.green.greengram_test1.feed.model.FeedGetRes;
import com.green.greengram_test1.user.model.UserSignInReq;
import com.green.greengram_test1.user.model.UserSignInRes;
import com.green.greengram_test1.user.model.UserSignUpReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int insUser(UserSignUpReq p);
    UserSignInRes selUserForSignIn(UserSignInReq p);
}
