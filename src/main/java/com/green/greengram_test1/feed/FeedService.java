package com.green.greengram_test1.feed;

import com.green.greengram_test1.common.MyFileUtils;
import com.green.greengram_test1.feed.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper mapper;
    private final MyFileUtils myFileUtils;


    public FeedPostRes postFeed(List<MultipartFile> pics, FeedPostReq p){
        int result = mapper.insFeed(p);

        List<String> picsStr = new ArrayList<>();

        long feedId = p.getFeedId();
        String middlePath = String.format("feed/%d", feedId);

        myFileUtils.makeFolders(middlePath);

        FeedPicDto feedPicDto = new FeedPicDto();
        feedPicDto.setFeedId(feedId);

        for(MultipartFile pic : pics){
            String savedPicName = myFileUtils.makeRandomFileName(pic);
            String filePath = String.format("%s/%s", middlePath, savedPicName);

            try{
                myFileUtils.transferTo(pic, filePath);
            } catch(IOException e){
                e.printStackTrace();
            }
            feedPicDto.setPic(savedPicName);
            mapper.insFeedPic(feedPicDto);

            picsStr.add(savedPicName);
        }

        FeedPostRes res = new FeedPostRes();

        res.setFeedId(p.getFeedId());
        res.setPics(picsStr);
        return res;
    }

    public List<FeedGetRes> getFeedList(FeedGetReq p){
        List<FeedGetRes> list = mapper.selFeedList(p);

        for(FeedGetRes res : list){
            List<String> picList = mapper.selFeedPicList(res.getFeedId());
            res.setPics(picList);
        }
        return list;
    }
}
