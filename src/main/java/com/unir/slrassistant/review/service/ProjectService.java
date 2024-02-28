package com.unir.slrassistant.review.service;

import com.unir.slrassistant.review.data.ProjectMemberRepository;
import com.unir.slrassistant.review.data.ProjectRepository;
import com.unir.slrassistant.review.model.pojo.Project;
import com.unir.slrassistant.review.model.pojo.ProjectMember;
import com.unir.slrassistant.review.model.request.ProjectMemberRequest;
import com.unir.slrassistant.review.model.request.ProjectRequest;
import com.unir.slrassistant.review.util.EmailUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    @Autowired
    private EmailUtil emailUtil;

    @Value("${slr-assistant.app.frontend.url}")
    private String frontEndUrl;

    private final ProjectRepository repository;
    private final ProjectMemberRepository projectMemberRepository;

    public List<Project> getProjects() {
        return repository.findAll();
    }

    public List<Project> findByUserId(Integer userId) {
        return repository.findByUserId(userId);
    }

    public Project getProject(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Project createProject(ProjectRequest projectRequest) {
        Project project = Project.builder()
                .userId(projectRequest.getUserId())
                .name(projectRequest.getName())
                .description(projectRequest.getDescription())
                .category(projectRequest.getCategory())
                .keywords(projectRequest.getKeywords())
                .startDate(projectRequest.getStartDate())
                .endDate(projectRequest.getEndDate())
                .visibility(projectRequest.getVisibility())
                .createdDate(new Date())
                .updatedDate(new Date())
                .build();

        Project savedProject = repository.save(project);

        ProjectMember projectMember = ProjectMember.builder()
                .projectId(savedProject.getId())
                .userId(savedProject.getUserId())
                .role("OWNER")
                .status("ACCEPTED")
                .createdDate(new Date())
                .updatedDate(new Date())
                .build();

        projectMemberRepository.save(projectMember);

        return savedProject;

    }

    public Project updateProject(Integer id, ProjectRequest projectRequest) {
        Project project = repository.findById(id).orElse(null);
        if (project == null) {
            return null;
        }

        project.setName(projectRequest.getName());
        project.setDescription(projectRequest.getDescription());
        project.setCategory(projectRequest.getCategory());
        project.setKeywords(projectRequest.getKeywords());
        project.setStartDate(projectRequest.getStartDate());
        project.setEndDate(projectRequest.getEndDate());
        project.setVisibility(projectRequest.getVisibility());
        project.setUpdatedDate(new Date());

        return repository.save(project);
    }

    public void deleteProject(Integer id) {
        repository.deleteById(id);
    }

    public List<Project> findByName(String name) {
        return repository.findByName(name);
    }

    public ProjectMember addMember(ProjectMemberRequest projectMemberRequest) {
        Project project = repository.findById(projectMemberRequest.getProjectId()).orElse(null);
        if (project == null) {
            return null;
        }

        /*
        send email to user (Pending)
            try {
                emailUtil.sendInviteCollaborator(projectMemberRequest.getEmail(), projectMemberRequest.getName(), projectMemberRequest.getToken(), frontEndUrl);
            } catch (Exception e) {
                throw new IllegalStateException("Error sending email");
            }
        */

        ProjectMember projectMember = ProjectMember.builder()
                .projectId(projectMemberRequest.getProjectId())
                .userId(projectMemberRequest.getUserId())
                .role(projectMemberRequest.getRole())
                .status("INVITED")
                .createdDate(new Date())
                .updatedDate(new Date())
                .build();

        projectMemberRepository.save(projectMember);

        return projectMember;
    }

}
