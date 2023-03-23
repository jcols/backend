package com.example.log.idiomas.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface idiomasRepository extends JpaRepository<idiomas, Integer> {

}

