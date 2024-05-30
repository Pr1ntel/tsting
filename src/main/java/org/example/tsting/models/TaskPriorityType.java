package org.example.tsting.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "task_priority_type")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskPriorityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "task_priority_type_name")
    private String taskPriorityTypeName;
}
