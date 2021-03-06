package com.example.pokemon.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_pokemon")
public class UserPokemon  extends  BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "pokemon_name")
    private String pokemonName;


}
