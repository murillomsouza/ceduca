package com.ceduca.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ceduca.model.Secretaria;

public interface SecretariaRepository extends MongoRepository<Secretaria, String> {

    Optional<Secretaria> findByEmail(String email);

    boolean existsByEmail(String email);
}