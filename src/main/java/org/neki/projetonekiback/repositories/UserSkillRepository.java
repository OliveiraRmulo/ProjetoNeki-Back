package org.neki.projetonekiback.repositories;

import org.neki.projetonekiback.entity.UserSkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSkillRepository extends JpaRepository<UserSkillEntity, Long>{

}
