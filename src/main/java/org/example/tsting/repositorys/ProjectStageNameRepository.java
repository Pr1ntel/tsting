package org.example.tsting.repositorys;

import org.example.tsting.models.ProjectStageName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectStageNameRepository extends JpaRepository<ProjectStageName, Integer> {
}
