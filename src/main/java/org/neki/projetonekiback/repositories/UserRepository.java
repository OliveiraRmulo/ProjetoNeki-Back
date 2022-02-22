package org.neki.projetonekiback.repositories;

import java.util.Optional;

import org.neki.projetonekiback.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	Optional<UserEntity> findById(Long id);
	UserEntity findByLogin(String login);

}
