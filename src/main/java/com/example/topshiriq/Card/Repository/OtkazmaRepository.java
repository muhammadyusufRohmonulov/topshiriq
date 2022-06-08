package com.example.topshiriq.Card.Repository;

import com.example.topshiriq.Card.Model.Card;
import com.example.topshiriq.Card.Model.Otkazma;
import com.example.topshiriq.Card.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtkazmaRepository extends JpaRepository<Otkazma,Integer> {

}
