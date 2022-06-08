package com.example.topshiriq.Card.Repository;

import com.example.topshiriq.Card.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.Size;

public interface CardRepository extends JpaRepository<Card,Integer> {
    boolean existsByKartaRaqam(@Size(min = 16, max = 16) String kartaRaqam);
}
