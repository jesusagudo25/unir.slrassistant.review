package com.unir.slrassistant.review.data;

import com.unir.slrassistant.review.model.pojo.Project;
import com.unir.slrassistant.review.model.pojo.ResearchQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResearchQuestionRepository extends JpaRepository<ResearchQuestion, Integer> {

    List<ResearchQuestion> findByProjectId(Integer projectId);
}
