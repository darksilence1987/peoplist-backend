package com.xhite.peoplistmonolithic.dto.request;

import com.xhite.peoplistmonolithic.entity.enums.InteractionType;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateInteractionRequestDto {
    Long id;
    InteractionType interactionType;
    String content;

    LocalDateTime updatedDate;

    boolean candidateResponded;

}
