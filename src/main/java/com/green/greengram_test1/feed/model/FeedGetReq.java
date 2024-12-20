package com.green.greengram_test1.feed.model;

import com.green.greengram_test1.common.model.Paging;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FeedGetReq extends Paging {
    public FeedGetReq(Integer page, Integer size) {
        super(page, size);
        log.info("size: {}", getSize());
    }
}
