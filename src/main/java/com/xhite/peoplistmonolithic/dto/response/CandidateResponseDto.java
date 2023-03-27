package com.xhite.peoplistmonolithic.dto.response;


import com.xhite.peoplistmonolithic.entity.enums.CandidateStatus;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateResponseDto {
    Long id;
    String fullName;
    String email;
    String phoneNumber;
    CandidateStatus status;
    List<CandidateInteractionResponseDto> previousInteractions;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
