package org.example.tsting.repositorys;

import org.example.tsting.models.TaskStageName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskStageNameRepository extends JpaRepository<TaskStageName, Integer> {
}
