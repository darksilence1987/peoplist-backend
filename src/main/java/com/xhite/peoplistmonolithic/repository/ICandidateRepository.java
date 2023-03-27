package com.xhite.peoplistmonolithic.repository;

import com.xhite.peoplistmonolithic.entity.Candidate;
import com.xhite.peoplistmonolithic.entity.enums.CandidateStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICandidateRepository extends JpaRepository<Candidate, Long> {
    @Query("SELECT c FROM Candidate c WHERE c.status = ?1")
    List<Candidate> findByStatus(CandidateStatus status);
}
