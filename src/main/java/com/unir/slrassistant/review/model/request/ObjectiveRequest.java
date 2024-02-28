package com.unir.slrassistant.review.model.request;

import com.unir.slrassistant.review.model.pojo.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ObjectiveRequest {
    private Integer projectId;
    private String description;
}
