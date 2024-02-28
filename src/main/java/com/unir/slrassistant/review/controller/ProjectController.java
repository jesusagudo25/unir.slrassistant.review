package com.unir.slrassistant.review.controller;

import com.unir.slrassistant.review.model.pojo.Project;
import com.unir.slrassistant.review.model.request.*;
import com.unir.slrassistant.review.service.ObjectiveService;
import com.unir.slrassistant.review.service.ProjectService;
import com.unir.slrassistant.review.service.ResearchQuestionService;
import com.unir.slrassistant.review.service.SearchStringService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final ObjectiveService objectiveService;
    private final ResearchQuestionService researchQuestionService;
    private final SearchStringService searchStringService;


    /* Project  */
    @GetMapping
    public ResponseEntity<List<Project>> getProjects(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer userId
    ) {
        List<Project> projectList;

        if (name != null) {
            projectList = projectService.findByName(name);
        } else if (userId != null) {
            projectList = projectService.findByUserId(userId);
        } else {
            projectList = projectService.getProjects();
        }

        if (Objects.nonNull(projectList)) {
            return ResponseEntity.ok(projectList);
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable Integer id) {
       try {
           return ResponseEntity.ok(projectService.getProject(id));
       } catch (Exception e) {
           return ResponseEntity.badRequest().build();
       }
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody ProjectRequest project) {
       try {
           return ResponseEntity.ok(projectService.createProject(project));
       } catch (Exception e) {
           return ResponseEntity.badRequest().build();
       }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Integer id, @RequestBody ProjectRequest project) {
       try {
           return ResponseEntity.ok(projectService.updateProject(id, project));
       } catch (Exception e) {
           return ResponseEntity.badRequest().build();
       }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable Integer id) {
       try {
           projectService.deleteProject(id);
           return ResponseEntity.ok().build();
       } catch (Exception e) {
           return ResponseEntity.badRequest().build();
       }
    }

    /* Project members */
    @PostMapping("/members")
    public ResponseEntity<?> addMember(@RequestBody ProjectMemberRequest projectMember) {
       try {
           return ResponseEntity.ok(projectService.addMember(projectMember));
       } catch (Exception e) {
           return ResponseEntity.badRequest().build();
       }
    }

    /* Planning > General > Objectives */
    @GetMapping("/{id}/objectives")
    public ResponseEntity<?> getObjectives(@PathVariable Integer id) {
       try {
           return ResponseEntity.ok(objectiveService.getObjectivesByProjectId(id));
       } catch (Exception e) {
           return ResponseEntity.badRequest().build();
       }
    }

    @PostMapping("/{id}/objectives")
    public ResponseEntity<?> addObjective(@PathVariable Integer id, @RequestBody ObjectiveRequest objective) {
       try {
           return ResponseEntity.ok(objectiveService.createObjective(objective));
       } catch (Exception e) {
           return ResponseEntity.badRequest().build();
       }
    }

    @DeleteMapping("/{id}/objectives/{objectiveId}")
    public ResponseEntity<?> deleteObjective(@PathVariable Integer id, @PathVariable Integer objectiveId) {
       try {
              objectiveService.deleteObjective(objectiveId);
           return ResponseEntity.ok().build();
       } catch (Exception e) {
           return ResponseEntity.badRequest().build();
       }
    }

    /* Planning > General > Research questions */
    @GetMapping("/{id}/research-questions")
    public ResponseEntity<?> getResearchQuestions(@PathVariable Integer id) {
       try {
           return ResponseEntity.ok(researchQuestionService.getResearchQuestionsByProjectId(id));
       } catch (Exception e) {
           return ResponseEntity.badRequest().build();
       }
    }

    @PostMapping("/{id}/research-questions")
    public ResponseEntity<?> addResearchQuestion(@PathVariable Integer id, @RequestBody ResearchQuestionRequest researchQuestion) {
       try {
           return ResponseEntity.ok(researchQuestionService.createResearchQuestion(researchQuestion));
       } catch (Exception e) {
           return ResponseEntity.badRequest().build();
       }
    }

    @DeleteMapping("/{id}/research-questions/{researchQuestionId}")
    public ResponseEntity<?> deleteResearchQuestion(@PathVariable Integer id, @PathVariable Integer researchQuestionId) {
       try {
              researchQuestionService.deleteResearchQuestion(researchQuestionId);
           return ResponseEntity.ok().build();
       } catch (Exception e) {
           return ResponseEntity.badRequest().build();
       }
    }

    /* Planning > Review protocol > Search strings */
    @GetMapping("/{id}/search-strings")
    public ResponseEntity<?> getSearchStrings(@PathVariable Integer id) {
       try {
           return ResponseEntity.ok(searchStringService.getSearchStringsByProjectId(id));
       } catch (Exception e) {
           return ResponseEntity.badRequest().build();
       }
    }

    @PostMapping("/{id}/search-strings")
    public ResponseEntity<?> addSearchString(@PathVariable Integer id, @RequestBody ListSearchStringRequest searchString) {
       try {
           return ResponseEntity.ok(searchStringService.createSearchString(searchString));
       } catch (Exception e) {
           return ResponseEntity.badRequest().build();
       }
    }

    @DeleteMapping("/{id}/search-strings/{searchStringUuid}")
    public ResponseEntity<?> deleteSearchString(@PathVariable Integer id, @PathVariable String searchStringUuid) {
       try {
           searchStringService.deleteSearchString(searchStringUuid);
           return ResponseEntity.ok().build();
       } catch (Exception e) {
           return ResponseEntity.badRequest().build();
       }
    }
}
