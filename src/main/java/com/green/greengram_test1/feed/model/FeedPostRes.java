package com.green.greengram_test1.feed.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FeedPostRes {
    private long feedId;
    private List<String> pics;
}
