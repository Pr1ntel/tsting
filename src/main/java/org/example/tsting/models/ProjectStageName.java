package org.example.tsting.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "project_stage_name")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectStageName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "project_stage_name")
    private String projectStageName;
}
