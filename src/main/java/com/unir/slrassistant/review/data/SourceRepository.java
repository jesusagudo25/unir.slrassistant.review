package com.unir.slrassistant.review.data;

import com.unir.slrassistant.review.model.pojo.Source;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SourceRepository extends JpaRepository<Source, Integer> {

    List<Source> findByProjectId(Integer projectId);


}
