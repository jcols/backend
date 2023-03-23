package com.example.log.trabajo.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface trabajoRepository extends JpaRepository<trabajo, Integer> {

}
