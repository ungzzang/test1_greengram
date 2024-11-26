package com.green.greengram_test1.feed;

import com.green.greengram_test1.feed.model.FeedPostReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedMapper {
    int insFeed(FeedPostReq p);
}
