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
@Table(name="_project_member")
public class ProjectMember {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer projectId;
    private Integer userId;
    private String role;
    private String status;
    private Date createdDate = new Date();
    private Date updatedDate = new Date();
}
