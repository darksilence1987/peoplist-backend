package com.xhite.peoplistmonolithic.mapper;

import com.xhite.peoplistmonolithic.dto.request.CandidateInteractionRequestDto;
import com.xhite.peoplistmonolithic.entity.CandidateInteraction;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICandidateInteractionMapper {
    ICandidateInteractionMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(ICandidateInteractionMapper.class);
    List<CandidateInteractionRequestDto> toCandidateInteractionRequestDto(List<CandidateInteraction> candidateInteractions);


    CandidateInteraction toCandidateInteraction(CandidateInteractionRequestDto candidateInteractionRequestDto, Long id);
}
