package com.ssafy.jansorry.action.util;

import com.ssafy.jansorry.action.domain.Action;
import com.ssafy.jansorry.action.dto.ActionCreationDto;
import com.ssafy.jansorry.action.dto.ActionDto;
import com.ssafy.jansorry.member.domain.Member;
import com.ssafy.jansorry.nag.domain.Nag;

public class ActionMapper {
	public static Action toEntity(Nag nag, Member member, ActionCreationDto actionCreationDto) {
		return Action.builder()
			.member(member)
			.nag(nag)
			.content(actionCreationDto.content())
			.build();
	}

	public static ActionDto toDto(Action action) {
		return ActionDto.builder()
			.nagId(action.getNag().getId())
			.categoryId(action.getNag().getCategory().getId())
			.content(action.getContent())
			.createdAt(action.getCreatedAt())
			.price(action.getNag().getPrice())
			.build();
	}
}
