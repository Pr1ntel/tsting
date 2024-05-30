package org.example.tsting.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "task_stage_name")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskStageName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "task_stage_name")
    private String taskStageName;
}
