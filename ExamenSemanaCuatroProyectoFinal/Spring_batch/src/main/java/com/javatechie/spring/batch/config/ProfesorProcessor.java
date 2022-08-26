package com.javatechie.spring.batch.config;

import com.javatechie.spring.batch.entity.Profesor;
import org.springframework.batch.item.ItemProcessor;

public class ProfesorProcessor implements ItemProcessor<Profesor,Profesor> {

    @Override
    public Profesor process(Profesor profesor) throws Exception {
        return profesor;
        
    }
}
