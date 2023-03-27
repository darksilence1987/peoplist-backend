package com.xhite.peoplistmonolithic.entity;

import com.xhite.peoplistmonolithic.entity.base.BaseEntity;
import com.xhite.peoplistmonolithic.entity.enums.InteractionType;
import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CandidateInteraction extends BaseEntity {

    @Enumerated(EnumType.STRING)
    InteractionType interactionType;
    String content;

    boolean candidateResponded;



}
