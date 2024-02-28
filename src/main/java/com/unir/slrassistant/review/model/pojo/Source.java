package com.unir.slrassistant.review.model.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="_source")
public class Source {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer projectId;
    private String name;
    private String url;
}
