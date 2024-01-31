package com.ssafy.jansorry.follow.controller;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.jansorry.follow.service.FollowBatchService;
import com.ssafy.jansorry.follow.service.FollowService;
import com.ssafy.jansorry.member.domain.Member;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "팔로우 컨트롤러", description = "팔로우 관련 인원 수, 여부, 추가 및 취소 기능이 포함되어 있음")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/follows")
public class FollowController {
	private final FollowService followService;
	private final FollowBatchService followBatchService;

	@Operation(
		summary = "팔로우 여부 확인",
		description = "본인이 팔로우 한 유저인지 여부를 확인한다.")
	@GetMapping("/{toId}/check")
	public ResponseEntity<Boolean> getFollowCheck(
		@AuthenticationPrincipal Member member,
		@PathVariable Long toId) {
		return ResponseEntity.ok(followService.readFollowCheck(member.getId(), toId));
	}

	@Operation(
		summary = "팔로우 추가",
		description = "해당 유저에게 팔로우를 추가한다.")
	@PostMapping("/{toId}")
	public ResponseEntity<Void> addFollow(
		@AuthenticationPrincipal Member member,
		@PathVariable Long toId) {
		followService.updateFollow(member.getId(), toId, true);
		return ResponseEntity.ok().build();
	}

	@Operation(
		summary = "팔로우 취소",
		description = "해당 유저에게 추가했던 팔로우를 취소한다.")
	@DeleteMapping("/{toId}")
	public ResponseEntity<Void> removeFollow(
		@AuthenticationPrincipal Member member,
		@PathVariable Long toId) {
		followService.updateFollow(member.getId(), toId, false);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/sync")
	private ResponseEntity<Void> sync() {
		Set<String> updatedActionIds = followBatchService.synchronizeUpdatedData(LocalDateTime.now().minusHours(1));
		followBatchService.deleteEmptySet(updatedActionIds);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/delete")
	private ResponseEntity<Void> deleteEmptySet() {
		followBatchService.refreshZSetAfterBatch();
		return ResponseEntity.ok().build();
	}
}
