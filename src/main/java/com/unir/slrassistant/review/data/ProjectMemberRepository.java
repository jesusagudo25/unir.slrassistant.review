package com.unir.slrassistant.review.data;

import com.unir.slrassistant.review.model.pojo.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Integer> {
}
