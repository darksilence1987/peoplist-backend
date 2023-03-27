package com.xhite.peoplistmonolithic.entity;

import com.xhite.peoplistmonolithic.entity.base.BaseEntity;
import com.xhite.peoplistmonolithic.entity.enums.CandidateStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Candidate extends BaseEntity {
    String fullName;
    String email;
    String phoneNumber;
    @Enumerated(EnumType.STRING)
    CandidateStatus status;
    @OneToMany(fetch = FetchType.EAGER)
    List<CandidateInteraction> previousInteractions;


}
