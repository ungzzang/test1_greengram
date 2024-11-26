package com.green.greengram_test1.feed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedPostReq {
    @JsonIgnore
    private long feedId;
    @Schema(title = "로그인 유저 PK")
    private long writerUserId;
    @Schema(title = "내용")
    private String contents;
    @Schema(title = "위치")
    private String location;
}
