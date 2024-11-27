package com.green.greengram_test1.feed;

import com.green.greengram_test1.feed.model.FeedGetReq;
import com.green.greengram_test1.feed.model.FeedGetRes;
import com.green.greengram_test1.feed.model.FeedPicDto;
import com.green.greengram_test1.feed.model.FeedPostReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {
    int insFeed(FeedPostReq p);
    int insFeedPic(FeedPicDto p);
    List<FeedGetRes> selFeedList(FeedGetReq p);
    List<String> selFeedPicList(long p);
}
