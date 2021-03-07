package com.example.pokemon.Controller;

import com.example.pokemon.model.LoginReqDto;
import com.example.pokemon.model.User;
import com.example.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class ApiController {

    @Autowired
    PokemonService pokemonService;

    @PostMapping("/api/register")
    public ResponseEntity<?> register(@RequestBody LoginReqDto user){
        return pokemonService.register(user);
    }

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody LoginReqDto user){
        return pokemonService.login(user);
    }
    @GetMapping("/api/getPokemonById")
    public ResponseEntity<?> getPokemonById(@RequestParam Integer userId){
        return pokemonService.getPokemonById(userId);
    }
    @GetMapping("/api/checkRandomPerDays")
    public ResponseEntity<?> checkRandomPerDays(@RequestParam Integer userId,@RequestParam String pokeName,@RequestParam Integer pokeId){
        return pokemonService.checkRandomPerDays(userId,pokeName,pokeId);
    }
    @GetMapping("/api/getCountPerDay")
    public ResponseEntity<?> getCountPerDay(@RequestParam String userId){
        return pokemonService.getCountPerDay(Integer.parseInt(userId));
    }

}
