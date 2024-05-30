package org.example.tsting.repositorys;

import org.example.tsting.models.ProjectTermName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTermNameRepository extends JpaRepository<ProjectTermName, Integer> {
}
