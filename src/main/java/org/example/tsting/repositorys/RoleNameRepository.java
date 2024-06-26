package org.example.tsting.repositorys;

import org.example.tsting.models.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleNameRepository extends JpaRepository<RoleName, Integer> {
}
