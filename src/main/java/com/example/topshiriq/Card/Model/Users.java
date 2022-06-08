package com.example.topshiriq.Card.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 3,max = 20)
    @Column(nullable = false,length = 20)
    private String ism;

    @Size(min = 5,max = 24)
    @Column(nullable = false,length = 24)
    private String familya;

    @Column(nullable = false)
    private String passport;

    @Column(nullable = false)
    private String telRaqam;

//    @OneToMany
//    private List<Card> cards;
}
