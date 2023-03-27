package com.xhite.peoplistmonolithic.controller;

import com.xhite.peoplistmonolithic.dto.ApiResponse;
import com.xhite.peoplistmonolithic.dto.request.CandidateInteractionRequestDto;
import com.xhite.peoplistmonolithic.entity.Candidate;
import com.xhite.peoplistmonolithic.mapper.ICandidateInteractionMapper;
import com.xhite.peoplistmonolithic.repository.ICandidateRepository;
import com.xhite.peoplistmonolithic.service.CandidateInteractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.xhite.peoplistmonolithic.constant.Paths.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(CANDIDATE)
@CrossOrigin(origins = "*")
public class CandidateInteractionController {
    private final CandidateInteractionService candidateInteractionService;
    private final ICandidateRepository candidateRepository;
    private final ApiResponse apiResponse;

    @GetMapping(ID+INTERACTION)
    public ResponseEntity<ApiResponse> getInteractions(@PathVariable Long id) {
        List<CandidateInteractionRequestDto> candidateInteractionRequestDtos =
                ICandidateInteractionMapper.INSTANCE.toCandidateInteractionRequestDto(
                        candidateInteractionService.findAllByCandidateId(id));
        return apiResponse.createOkResponse(candidateInteractionRequestDtos);
    }

    @PostMapping(ID+INTERACTION)
    public ResponseEntity<ApiResponse> create(@RequestBody CandidateInteractionRequestDto candidateInteractionRequestDto, @PathVariable Long id) {
        return apiResponse.createOkResponse(candidateInteractionService.create(candidateInteractionRequestDto, id));

    }

    @GetMapping(ID+INTERACTION+INTERACTION_ID)
    public ResponseEntity<ApiResponse> findById(@PathVariable Long id, @PathVariable Long interactionId) {
        return apiResponse.createOkResponse(candidateInteractionService.findById(id, interactionId));
    }

    @PutMapping(ID+INTERACTION+INTERACTION_ID)
    public ResponseEntity<ApiResponse> update( @PathVariable Long id, @PathVariable Long interactionId, @RequestBody CandidateInteractionRequestDto candidateInteractionRequestDto) {

        return apiResponse.createOkResponse(candidateInteractionService.update(candidateInteractionRequestDto, id, interactionId));

    }

    @DeleteMapping(ID+INTERACTION+INTERACTION_ID)
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id , @PathVariable Long interactionId) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Candidate not found"));
        candidate.getPreviousInteractions().removeIf(candidateInteraction -> candidateInteraction.getId().equals(interactionId));
        candidateInteractionService.delete(interactionId);
        return apiResponse.createOkResponse("Deleted");
    }
}