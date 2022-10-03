package com.nalstudio.JPA_BASIC.service;

import com.nalstudio.JPA_BASIC.entities.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SingerService{
    List<Singer> findAll();
    List<Singer> findByFirstName(String firstName);
    List<Singer> findByFirstNameAndLastName(String firstName, String lastName);

    List<Singer> findByAllWithAlbum();

    List<Singer> findNySingerID(Long singerId);
}
