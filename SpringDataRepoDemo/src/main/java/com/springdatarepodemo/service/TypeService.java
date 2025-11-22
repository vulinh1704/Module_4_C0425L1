package com.springdatarepodemo.service;

import com.springdatarepodemo.entity.Type;
import com.springdatarepodemo.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;

    public List<Type> findAll() {
        return this.typeRepository.findAll();
    }
}
