package org.example.tsting.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tasks")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "task_stage_id")
    private TaskStageName taskStageName;

    @Column(name = "task_title")
    private String taskTitle;

    @Column(name = "task_description")
    private String taskDescription;

    @ManyToOne
    @JoinColumn(name = "executor_id")
    private User executorId;

    @Column(name = "task_duration_time")
    private int taskDurationTime;

    @ManyToOne
    @JoinColumn(name = "task_duration_term_id")
    private ProjectTermName projectTerm;

    @ManyToOne
    @JoinColumn(name = "priority_type_id")
    private TaskPriorityType taskPriorityType;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project projectId;
}
