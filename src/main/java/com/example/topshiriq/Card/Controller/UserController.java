package com.example.topshiriq.Card.Controller;

import com.example.topshiriq.Card.DTO.CardDTO;
import com.example.topshiriq.Card.DTO.OtkazmaDTO;
import com.example.topshiriq.Card.DTO.UserDTO;
import com.example.topshiriq.Card.Model.Otkazma;
import com.example.topshiriq.Card.Model.Users;
import com.example.topshiriq.Card.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/card")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/insert")
    public HttpEntity<?> insert(@RequestBody UserDTO userDTO){
        boolean insert = userService.insert(userDTO);
        if (insert){
            return ResponseEntity.ok("Muvaffaqiyatli joylandi");
        }
        return ResponseEntity.ok("Allaqachon Ro'yxatdan O'tilgan");
    }
    @PostMapping("/cardInsert")
    public HttpEntity<?> insert2(@RequestBody CardDTO cardDTO){
        boolean insertCard = userService.insertCard(cardDTO);
        if (insertCard){
            return ResponseEntity.ok("Muvaffaqiyatli Joylandi");
        }
        return ResponseEntity.ok("Bu Karta Mavjud yoki Bunday Username Topilmadi");
    }
    @PostMapping("/otkazma")
    public HttpEntity<?> otkazma(OtkazmaDTO otkazmaDTO){
        return ResponseEntity.status(HttpStatus.OK).body(userService.otkazma(otkazmaDTO));
    }
}
