package com.unir.slrassistant.review.data;

import com.unir.slrassistant.review.model.pojo.Objective;
import com.unir.slrassistant.review.model.pojo.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObjectiveRepository extends JpaRepository<Objective, Integer> {

    List<Objective> findByProjectId(Integer projectId);
}
