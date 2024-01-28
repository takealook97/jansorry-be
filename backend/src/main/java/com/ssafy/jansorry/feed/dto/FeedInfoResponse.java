package com.ssafy.jansorry.feed.dto;

import lombok.Builder;

@Builder
public record FeedInfoResponse(
	Long memberId,
	String nickname,
	String nag,
	String action,
	String category,
	String createdAt
) {
}