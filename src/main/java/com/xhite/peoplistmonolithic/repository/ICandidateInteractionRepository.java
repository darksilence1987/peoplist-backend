package com.xhite.peoplistmonolithic.repository;

import com.xhite.peoplistmonolithic.entity.CandidateInteraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICandidateInteractionRepository extends JpaRepository<CandidateInteraction, Long> {
    @Query("SELECT c.previousInteractions FROM Candidate c WHERE c.id = ?1")
    List<CandidateInteraction> findAllByCandidateId(Long id);
}
