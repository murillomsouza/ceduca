package com.ceduca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ceduca.model.Aluno;

public interface AlunoRepository extends MongoRepository<Aluno, String> {

    Optional<Aluno> findByEmail(String email);

    boolean existsByEmail(String email);

    List<Aluno> findByTagsContaining(String tag);
}