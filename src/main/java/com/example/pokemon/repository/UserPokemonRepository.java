package com.example.pokemon.repository;

import com.example.pokemon.model.UserPokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPokemonRepository extends JpaRepository<UserPokemon,Integer> {
}
