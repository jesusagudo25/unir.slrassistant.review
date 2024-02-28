package com.unir.slrassistant.review.service;

import com.unir.slrassistant.review.data.ObjectiveRepository;

import com.unir.slrassistant.review.model.pojo.Objective;

import com.unir.slrassistant.review.model.request.ObjectiveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObjectiveService {

    private final ObjectiveRepository repository;

    public List<Objective> getObjectivesByProjectId(Integer projectId) {
        return repository.findByProjectId(projectId);
    }

    public Objective createObjective(ObjectiveRequest objectiveRequest) {
        return repository.save(Objective.builder()
                .projectId(objectiveRequest.getProjectId())
                .description(objectiveRequest.getDescription())
                .build());
    }

    public void deleteObjective(Integer id) {
        repository.deleteById(id);
    }
}
