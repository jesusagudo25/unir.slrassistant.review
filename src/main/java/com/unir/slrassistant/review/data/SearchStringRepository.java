package com.unir.slrassistant.review.data;

import com.unir.slrassistant.review.model.pojo.SearchString;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SearchStringRepository extends JpaRepository<SearchString, Integer> {

    List<SearchString> findByProjectId(Integer projectId);

    @Transactional
    @Modifying
    @Query("delete from SearchString s where s.uuid = :uuid")
    void deleteByUuid(String uuid);
}
