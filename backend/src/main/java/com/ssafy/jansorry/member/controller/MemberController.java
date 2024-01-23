package com.ssafy.jansorry.member.controller;

import com.ssafy.jansorry.member.domain.Member;
import com.ssafy.jansorry.member.domain.type.OauthServerType;
import com.ssafy.jansorry.member.dto.MemberResponse;
import com.ssafy.jansorry.member.dto.MemberEditDto;
import com.ssafy.jansorry.member.dto.SignUpRequest;
import com.ssafy.jansorry.member.dto.SignUpResponse;
import com.ssafy.jansorry.member.service.MemberService;
import com.ssafy.jansorry.member.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/members")
public class MemberController {
	private final MemberService memberService;
	private final TokenService tokenService;

	@GetMapping("/reissue")
	public ResponseEntity<Void> reissueAccessToken(
		HttpServletRequest request, HttpServletResponse response) {
		String accessToken = tokenService.reissueAccessToken(request, response);
		response.setHeader("Authorization", accessToken);

		return ResponseEntity.ok().build();
	}

	@PostMapping("/signup")
	public ResponseEntity<SignUpResponse> addMember(
		@RequestBody SignUpRequest request
	) {
		return ResponseEntity.ok(memberService.createMember(request));
	}

	@PutMapping("/rename")
	public ResponseEntity<MemberEditDto> editNickname(
		@AuthenticationPrincipal Member member,
		@Valid @RequestBody MemberEditDto request
	) {
		return ResponseEntity.ok(memberService.updateMember(member, request));
	}

	@DeleteMapping("/withdraw/{oauthServerType}")
	public ResponseEntity<Void> removeMember(
		@AuthenticationPrincipal Member member,
		@PathVariable OauthServerType oauthServerType,
		HttpServletResponse response
	) {
		memberService.deleteMember(oauthServerType, member, response);
		return ResponseEntity.ok().build();
	}

	@GetMapping()
	public ResponseEntity<MemberResponse> getMember(
		@AuthenticationPrincipal Member member
	) {
		return ResponseEntity.ok(memberService.readMember(member));
	}
}
