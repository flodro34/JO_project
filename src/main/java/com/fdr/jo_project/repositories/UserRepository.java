package com.fdr.jo_project.repositories;

import com.fdr.jo_project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
