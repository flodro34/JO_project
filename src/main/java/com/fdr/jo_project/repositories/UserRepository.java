package com.fdr.jo_project.repositories;

import com.fdr.jo_project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

   User findByUsername(String username);
   Optional<User> findByEmail(String email);
//   User saveWithToken(User user) ;

}
