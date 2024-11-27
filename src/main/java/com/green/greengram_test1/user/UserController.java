package com.green.greengram_test1.user;

import com.green.greengram_test1.common.model.ResultResponse;
import com.green.greengram_test1.user.model.UserSignInReq;
import com.green.greengram_test1.user.model.UserSignInRes;
import com.green.greengram_test1.user.model.UserSignUpReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("user")
@Tag(name = "유저", description = "회원가입, 로그인, 마이페이지")
public class UserController {
    private final UserService service;

    @PostMapping("sign-up")
    @Operation(summary =  "회원가입")
    public ResultResponse<Integer> signUp(@RequestPart(required = false) MultipartFile pic
                                        , @RequestPart UserSignUpReq p){

        int result = service.postSignUp(pic,p);

        return ResultResponse.<Integer>builder()
                .resultMessage("회원가입 완료")
                .resultData(result)
                .build();
    }

    @PostMapping("sign-in")
    @Operation(summary = "로그인")
    public ResultResponse<UserSignInRes> signIn(@RequestBody UserSignInReq p){
        UserSignInRes res = service.postSignIn(p);
        return ResultResponse.<UserSignInRes>builder()
                .resultMessage(res.getMessage())
                .resultData(res)
                .build();
    }

}
