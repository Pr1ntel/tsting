package org.example.tsting.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "project")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_description")
    private String projectDescription;

    @Column(name = "project_task")
    private String projectTask;

    @ManyToOne
    @JoinColumn(name = "project_stage_id")
    private ProjectStageName projectStage;

    @Column(name = "project_duration_time")
    private int projectDurationTime;

    @ManyToOne
    @JoinColumn(name = "project_duration_term_id")
    private ProjectTermName projectTerm;
}
