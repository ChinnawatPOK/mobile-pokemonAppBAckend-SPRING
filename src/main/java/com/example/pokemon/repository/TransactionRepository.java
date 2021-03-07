package com.example.pokemon.repository;

import com.example.pokemon.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    List<Transaction> findByDate(LocalDate date);
    List<Transaction> findByDateAndUser_UserId(LocalDate nowDate,Integer userId);

}
