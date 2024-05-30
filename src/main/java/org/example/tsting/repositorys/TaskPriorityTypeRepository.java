package org.example.tsting.repositorys;

import org.example.tsting.models.TaskPriorityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskPriorityTypeRepository extends JpaRepository<TaskPriorityType, Integer> {
}
