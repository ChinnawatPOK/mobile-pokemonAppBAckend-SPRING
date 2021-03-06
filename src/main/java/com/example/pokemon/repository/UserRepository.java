package com.example.pokemon.repository;

import com.example.pokemon.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Boolean existsByUsername(String username);
    Optional<User> findByUsernameAndPassword(String username,String password);
}
