package com.example.topshiriq.Card.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 9,max = 9)
    @Column(nullable = false)
    private String username;

    @Size(min = 16,max = 16)
    @Column(nullable = false,length = 16)
    private String kartaRaqam;

    @Column(nullable = false)
    private String balance;

    @Column(nullable = false)
    private String muddati;

    @Size(min = 4)
    @Column(nullable = false)
    private String parol;

    @Column(nullable = false)
    private boolean active;
}
