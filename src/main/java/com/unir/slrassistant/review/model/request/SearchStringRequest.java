package com.unir.slrassistant.review.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchStringRequest {

    private Integer projectId;
    private String terms;
    private String metadata;
    private String operator;
    private String uuid;
    private Integer orderByIndex;
}
