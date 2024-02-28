package com.unir.slrassistant.review.data;

import com.unir.slrassistant.review.model.pojo.SelectionCriteria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SelectionCriteriaRepository extends JpaRepository<SelectionCriteria, Integer> {
    List<SelectionCriteria> findByProjectId(Integer projectId);
}
