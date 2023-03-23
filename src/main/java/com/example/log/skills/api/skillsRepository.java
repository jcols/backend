package com.example.log.skills.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface skillsRepository extends JpaRepository<skills, Integer> {

}
