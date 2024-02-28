package com.unir.slrassistant.review.data;

import com.unir.slrassistant.review.model.pojo.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {


    List<Project> findByName(String name);

    List<Project> findByUserId(Integer userId);
}
