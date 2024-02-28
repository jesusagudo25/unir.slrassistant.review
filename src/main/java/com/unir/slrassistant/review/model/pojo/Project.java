package com.unir.slrassistant.review.model.pojo;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="_project")
public class Project {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer userId;
    private String name;
    private String description;
    private String category;
    private String keywords;
    private Date startDate;
    private Date endDate;
    private String visibility;
    private Date createdDate = new Date();
    private Date updatedDate = new Date();
}
