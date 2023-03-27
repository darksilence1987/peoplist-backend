package com.xhite.peoplistmonolithic.dto.request;

import com.xhite.peoplistmonolithic.entity.enums.CandidateStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateRequestDto {

    //Validasyonlar
    String fullName;
    String email;
    String phoneNumber;
    CandidateStatus status;
}
