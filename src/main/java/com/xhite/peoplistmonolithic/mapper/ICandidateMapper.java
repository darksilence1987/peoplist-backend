package com.xhite.peoplistmonolithic.mapper;

import com.xhite.peoplistmonolithic.dto.request.CandidateRequestDto;
import com.xhite.peoplistmonolithic.dto.response.CandidateInteractionResponseDto;
import com.xhite.peoplistmonolithic.dto.response.CandidateResponseDto;
import com.xhite.peoplistmonolithic.entity.Candidate;
import com.xhite.peoplistmonolithic.entity.CandidateInteraction;
import org.mapstruct.*;

import java.util.List;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface ICandidateMapper {
    ICandidateMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(ICandidateMapper.class);

    @Mapping(source = "candidate.previousInteractions", target = "previousInteractions", qualifiedByName = "toCandidateInteractionResponseDtoList")
    CandidateResponseDto toCandidateResponseDto(Candidate candidate);

    @Named("toCandidateInteractionResponseDtoList")
    List<CandidateInteractionResponseDto> toCandidateInteractionResponseDtoList(List<CandidateInteraction> candidateInteractions);
    Candidate toCandidate(CandidateRequestDto candidateRequestDto);
    List<CandidateRequestDto> toCandidateRequestDtoList(List<Candidate> candidates);

    List<CandidateResponseDto> toCandidateResponseDtoList(List<Candidate> all);
}
