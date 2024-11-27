package com.green.greengram_test1.feed;

import com.green.greengram_test1.common.model.ResultResponse;
import com.green.greengram_test1.feed.model.FeedGetReq;
import com.green.greengram_test1.feed.model.FeedGetRes;
import com.green.greengram_test1.feed.model.FeedPostReq;
import com.green.greengram_test1.feed.model.FeedPostRes;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/feed")
public class FeedController {
    private final FeedService service;

    @PostMapping
    public ResultResponse<FeedPostRes> postFeed(@RequestPart List<MultipartFile> pics
                                               , @RequestPart FeedPostReq p){
        FeedPostRes res = service.postFeed(pics, p);
        return ResultResponse.<FeedPostRes>builder()
                .resultMessage("피드등록완료")
                .resultData(res)
                .build();
    }

    @GetMapping
    public ResultResponse<List<FeedGetRes>> getFeedList(@ParameterObject @ModelAttribute FeedGetReq p){
        log.info("p: {}", p);
        List<FeedGetRes> list = service.getFeedList(p);
        return ResultResponse.<List<FeedGetRes>>builder()
                .resultMessage(String.format("%d row", list.size()))
                .resultData(list)
                .build();
    }
}
