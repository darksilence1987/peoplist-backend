package com.xhite.peoplistmonolithic.service;

import com.xhite.peoplistmonolithic.dto.request.CandidateRequestDto;
import com.xhite.peoplistmonolithic.dto.response.CandidateResponseDto;
import com.xhite.peoplistmonolithic.entity.Candidate;
import com.xhite.peoplistmonolithic.entity.CandidateInteraction;
import com.xhite.peoplistmonolithic.entity.enums.CandidateStatus;
import com.xhite.peoplistmonolithic.mapper.ICandidateMapper;
import com.xhite.peoplistmonolithic.repository.ICandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CandidateService {
    private final ICandidateRepository candidateRepository;

    public List<CandidateResponseDto> findAll() {
        return ICandidateMapper.INSTANCE.toCandidateResponseDtoList(candidateRepository.findAll());
    }

    public CandidateResponseDto create(CandidateRequestDto candidateRequestDto) {
        Candidate candidate = ICandidateMapper.INSTANCE.toCandidate(candidateRequestDto);
        candidate = candidateRepository.save(candidate);
        return ICandidateMapper.INSTANCE.toCandidateResponseDto(candidate);
    }

    public CandidateResponseDto findById(Long id) {
        return ICandidateMapper.INSTANCE.toCandidateResponseDto(candidateRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Candidate not found")
        ));
    }
    public CandidateResponseDto update(CandidateRequestDto candidateRequestDto, Long id) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Candidate not found")
        );
        candidate.setFullName(candidateRequestDto.getFullName());
        candidate.setPhoneNumber(candidateRequestDto.getPhoneNumber());
        candidate.setEmail(candidateRequestDto.getEmail());
        candidate.setStatus(candidateRequestDto.getStatus());
        candidate = candidateRepository.save(candidate);
        return ICandidateMapper.INSTANCE.toCandidateResponseDto(candidate);
    }

    public void delete(Long id) {
        try {
            candidateRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Candidate could not deleted");
        }
    }

    public List<Candidate> findAllByStatus(String status) {
        return candidateRepository.findByStatus(CandidateStatus.valueOf(status));
    }

    public void addInteraction(Long id, CandidateInteraction candidateInteraction) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Candidate not found")
        );
        candidate.getPreviousInteractions().add(candidateInteraction);
        candidateRepository.save(candidate);
    }
}
