package com.xhite.peoplistmonolithic.service;

import com.xhite.peoplistmonolithic.dto.request.CandidateInteractionRequestDto;
import com.xhite.peoplistmonolithic.entity.CandidateInteraction;
import com.xhite.peoplistmonolithic.mapper.ICandidateInteractionMapper;
import com.xhite.peoplistmonolithic.repository.ICandidateInteractionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateInteractionService {
    private final ICandidateInteractionRepository candidateInteractionRepository;
    private final CandidateService candidateService;

    public List<CandidateInteraction> findAllByCandidateId(Long id) {
        return candidateInteractionRepository.findAllByCandidateId(id);
    }

    public Long create(CandidateInteractionRequestDto candidateInteractionRequestDto, Long id) {
        CandidateInteraction candidateInteraction = ICandidateInteractionMapper.INSTANCE.toCandidateInteraction(candidateInteractionRequestDto, id);
        candidateInteractionRepository.save(candidateInteraction);
        candidateService.addInteraction(id, candidateInteraction);
        return candidateInteraction.getId();

    }


    public CandidateInteractionRequestDto findById(Long id, Long interactionId) {
        List<CandidateInteraction> candidateInteractions = findAllByCandidateId(id);
        return ICandidateInteractionMapper.INSTANCE.toCandidateInteractionRequestDto(candidateInteractions).stream()
                .filter(candidateInteraction -> candidateInteraction.getId().equals(interactionId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Candidate interaction not found"));
    }

    public CandidateInteraction update(CandidateInteractionRequestDto candidateInteractionRequestDto, Long id, Long interactionId) {
        CandidateInteraction candidateInteraction = ICandidateInteractionMapper.INSTANCE.toCandidateInteraction(candidateInteractionRequestDto, id);
        candidateInteraction.setId(interactionId);
        System.out.println(candidateInteraction.toString());
        return candidateInteractionRepository.save(candidateInteraction);
    }

    public void delete(Long interactionId) {
        candidateInteractionRepository.deleteById(interactionId);
    }
}
