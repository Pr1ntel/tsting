package org.example.tsting.repositorys;

import org.example.tsting.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Project deleteById(int id);
    Project findProjectById(int id);
}
