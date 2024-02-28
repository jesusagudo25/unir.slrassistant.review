package com.unir.slrassistant.review.data;

import com.unir.slrassistant.review.model.pojo.QualityCriteria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QualityCriteriaRepository extends JpaRepository<QualityCriteria, Integer> {
    List<QualityCriteria> findByProjectId(Integer projectId);
}
