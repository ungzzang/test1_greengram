package com.green.greengram_test1.feed;

import com.green.greengram_test1.common.MyFileUtils;
import com.green.greengram_test1.feed.model.FeedPostReq;
import com.green.greengram_test1.feed.model.FeedPostRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper mapper;
    private final MyFileUtils myFileUtils;

    public FeedPostRes postFeed(List<MultipartFile> pics, FeedPostReq p){
        int result = mapper.insFeed(p);

        List<String> picsStr = new ArrayList<>();

        long feedId = p.getFeedId();
        String middlePath = String.format("feed/%s", feedId);


    }
}
