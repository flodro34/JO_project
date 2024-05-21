package com.fdr.jo_project.repositories;

import com.fdr.jo_project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface UserRepository extends JpaRepository<User, Long> {
}
