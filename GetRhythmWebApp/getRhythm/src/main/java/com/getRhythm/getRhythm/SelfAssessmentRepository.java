package com.getRhythm.getRhythm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SelfAssessmentRepository extends JpaRepository<SelfAssessment, Integer> {
	@Query("SELECT u FROM SelfAssessment u WHERE u.userID = ?1")
    public List<SelfAssessment> findAssesmentsByUserID(Integer userID);
}
