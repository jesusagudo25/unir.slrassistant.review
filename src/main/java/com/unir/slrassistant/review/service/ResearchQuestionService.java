package com.unir.slrassistant.review.service;


import com.unir.slrassistant.review.data.ResearchQuestionRepository;

import com.unir.slrassistant.review.model.pojo.ResearchQuestion;

import com.unir.slrassistant.review.model.request.ResearchQuestionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResearchQuestionService {
    private final ResearchQuestionRepository repository;

    public List<ResearchQuestion> getResearchQuestionsByProjectId(Integer projectId) {
        return repository.findByProjectId(projectId);
    }

    public ResearchQuestion createResearchQuestion(ResearchQuestionRequest researchQuestionRequest) {
        return repository.save(ResearchQuestion.builder()
                .projectId(researchQuestionRequest.getProjectId())
                .description(researchQuestionRequest.getDescription())
                .build());
    }

    public void deleteResearchQuestion(Integer id) {
        repository.deleteById(id);
    }
}
