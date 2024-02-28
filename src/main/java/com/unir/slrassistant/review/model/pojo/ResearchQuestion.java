package com.unir.slrassistant.review.model.pojo;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="_research_question")
public class ResearchQuestion {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer projectId;
    private String description;
}
