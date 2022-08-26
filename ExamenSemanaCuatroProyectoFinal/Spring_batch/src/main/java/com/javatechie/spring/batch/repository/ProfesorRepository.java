package com.javatechie.spring.batch.repository;

import com.javatechie.spring.batch.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository  extends JpaRepository<Profesor,Integer> {
}
