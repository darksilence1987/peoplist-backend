package com.xhite.peoplistmonolithic.dto.response;

import com.xhite.peoplistmonolithic.entity.enums.InteractionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateInteractionResponseDto {
    InteractionType interactionType;
    String content;

    LocalDateTime updatedDate;

    boolean candidateResponded;
}
