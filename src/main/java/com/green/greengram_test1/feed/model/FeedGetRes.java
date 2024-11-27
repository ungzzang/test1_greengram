package com.green.greengram_test1.feed.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FeedGetRes {
    private long feedId;
    private String Contents;
    private String location;
    private String createdAt;
    private long writerId;
    private String writerNm;
    private String writerPic;

    private List<String> pics;
}
