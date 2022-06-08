package com.example.topshiriq.Card.Repository;

import com.example.topshiriq.Card.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.Size;

public interface UserRepository extends JpaRepository<Users,Integer> {
    boolean existsByPassportAndTelRaqam(String passport, String telRaqam);
    boolean existsByPassport(String passport);

}
