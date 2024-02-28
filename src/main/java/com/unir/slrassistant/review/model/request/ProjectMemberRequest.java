package com.unir.slrassistant.review.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectMemberRequest {
    private Integer projectId;
    private Integer userId;
    private String role;
    private String status;
}
