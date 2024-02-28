package com.unir.slrassistant.review.service;

import com.unir.slrassistant.review.data.SearchStringRepository;

import com.unir.slrassistant.review.model.pojo.SearchString;

import com.unir.slrassistant.review.model.request.ListSearchStringRequest;
import com.unir.slrassistant.review.model.request.SearchStringRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchStringService {

    private final SearchStringRepository repository;

    public List<SearchString> getSearchStringsByProjectId(Integer projectId) {
        return repository.findByProjectId(projectId);
    }

    public SearchString createSearchString(ListSearchStringRequest searchStringRequest) {

        //iterate through the list of search strings and save them
        for (SearchStringRequest request : searchStringRequest.getSearchStrings()) {
            repository.save(SearchString.builder()
                    .projectId(request.getProjectId())
                    .terms(request.getTerms())
                    .metadata(request.getMetadata())
                    .operator(request.getOperator())
                    .uuid(request.getUuid())
                    .orderByIndex(request.getOrderByIndex())
                    .build());
        }

        return null;
    }

    public void deleteSearchString(String id) {
        repository.deleteByUuid(id);
    }
}
