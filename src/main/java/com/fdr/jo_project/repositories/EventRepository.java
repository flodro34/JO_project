package com.fdr.jo_project.repositories;

import com.fdr.jo_project.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
