package com.ssafy.jansorry.nag.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.jansorry.nag.domain.Nag;
import com.ssafy.jansorry.nag.dto.NagDto;

@Repository
public interface NagRepository extends JpaRepository<Nag, Long> {
	Optional<Nag> findNagById(Long nagId);

	List<NagDto> findAllByDeletedFalse();
}
