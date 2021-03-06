package com.example.pokemon.service;

import com.example.pokemon.model.LoginReqDto;
import com.example.pokemon.model.Transaction;
import com.example.pokemon.model.User;
import com.example.pokemon.model.UserPokemon;
import com.example.pokemon.repository.TransactionRepository;
import com.example.pokemon.repository.UserPokemonRepository;
import com.example.pokemon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PokemonService {

    private UserRepository userRepository;
    private TransactionRepository transactionRepository;
    private UserPokemonRepository userPokemonRepository;

    @Autowired
    public PokemonService(UserRepository userRepository,UserPokemonRepository userPokemonRepository,TransactionRepository transactionRepository){
        this.userRepository = userRepository;
        this.userPokemonRepository = userPokemonRepository;
        this.transactionRepository = transactionRepository;
    }

    public ResponseEntity<?> register(User user){
        if(!userRepository.existsByUsername(user.getUsername()))
            return ResponseEntity.ok(userRepository.save(user));
        else
            return new ResponseEntity<String>("Username already exists", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> login(LoginReqDto user){
        if(userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword()).isPresent())
            return ResponseEntity.ok(userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword()).get());
        else return new ResponseEntity<String>("Username or password incorrect",HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<?> getPokemonById(Integer userId){
        List<UserPokemon> pokemonList = userPokemonRepository.findByUser_UserId(userId);
        // Not have return []
        return ResponseEntity.ok(pokemonList);
    }
    public ResponseEntity<?> checkRandomPerDays(Integer userId,String pokeName){
        User user = userRepository.findById(userId).get();
        // check per day grater 2 times
        if(transactionRepository.findByDate(LocalDate.now()).size() < 2) {
            // save to userPokemon
            UserPokemon userPokemon = new UserPokemon();
            userPokemon.setUser(user);
            userPokemon.setPokemonName(pokeName);
            userPokemonRepository.save(userPokemon);
            // save to transaction
            Transaction transaction = new Transaction();
            transaction.setUser(user);
            transaction.setDate(LocalDate.now());
            transactionRepository.save(transaction);
            return new ResponseEntity<String>("Saved. ",HttpStatus.OK);
        }else {
            return new ResponseEntity<String>("You random greater 2 times. ",HttpStatus.BAD_REQUEST);
        }
    }
}
