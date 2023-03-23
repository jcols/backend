package com.example.log.about.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface aboutRepository extends JpaRepository<about, Integer> {

}

