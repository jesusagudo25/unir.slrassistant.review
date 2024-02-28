package com.unir.slrassistant.review.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRequest {

    private Integer userId;
    private String name;
    private String description;
    private String category;
    private String keywords;
    private Date startDate;
    private Date endDate;
    private String visibility;
}
