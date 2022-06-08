package com.example.topshiriq.Card.Service;

import com.example.topshiriq.Card.DTO.CardDTO;
import com.example.topshiriq.Card.DTO.OtkazmaDTO;
import com.example.topshiriq.Card.DTO.UserDTO;
import com.example.topshiriq.Card.Model.Card;
import com.example.topshiriq.Card.Model.Otkazma;
import com.example.topshiriq.Card.Model.Users;
import com.example.topshiriq.Card.Repository.CardRepository;
import com.example.topshiriq.Card.Repository.OtkazmaRepository;
import com.example.topshiriq.Card.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CardRepository cardRepository;
    @Autowired
    OtkazmaRepository otkazmaRepository;

    public boolean insert(UserDTO userDTO){
        boolean seriyaRaqam = userRepository.existsByPassportAndTelRaqam(userDTO.getPassport(), userDTO.getTel());
        if (!seriyaRaqam){
            Users users = new Users();
            users.setIsm(userDTO.getIsm());
            users.setFamilya(userDTO.getFamilya());
            users.setPassport(userDTO.getPassport());
            users.setTelRaqam(userDTO.getTel());
            userRepository.save(users);
            return true;
        }
        return false;
    }
    public boolean insertCard(CardDTO cardDTO){
        boolean kartaRaqam = cardRepository.existsByKartaRaqam(cardDTO.getPassport());
        if (!kartaRaqam){
            boolean byPassport = userRepository.existsByPassport(cardDTO.getPassport());
            if (byPassport){
                Card card = new Card();
                card.setUsername(cardDTO.getPassport());
                card.setKartaRaqam(cardDTO.getNumber());
                card.setBalance(cardDTO.getBalance());
                card.setMuddati(cardDTO.getMuddati());
                card.setParol(cardDTO.getParol());
                cardRepository.save(card);
                return true;
            }
            return false;
        }
        return false;
    }

    public String otkazma(OtkazmaDTO otkazmaDTO){
        boolean existsByKartaRaqam = cardRepository.existsByKartaRaqam(otkazmaDTO.getKarta());
        if (existsByKartaRaqam){
            Otkazma otkazma = new Otkazma();
            otkazma.setKartaRaqam2(otkazmaDTO.getKarta());
            otkazma.setParol(otkazmaDTO.getParol());
            otkazma.setOtkazmaRaqam(otkazmaDTO.getKarta2());
            otkazma.setOtkazmaMiqdori(otkazmaDTO.getMiqdor());
            boolean byKartaRaqam = cardRepository.existsByKartaRaqam(otkazmaDTO.getKarta2());
            if (byKartaRaqam){
                String summ = otkazmaDTO.getMiqdor();
                Card card = new Card();
                String m = card.getBalance();
                System.out.println("m= "+m+"\nsumm= "+summ);
                double nm = Double.parseDouble(summ)+Double.parseDouble(summ)/100;
                double itogo = Double.parseDouble(m) - nm;

                if (itogo>0){
                    card.setBalance(String.valueOf((Double.parseDouble(card.getBalance())-nm)));
                    otkazmaRepository.save(otkazma);
                    return "O'tkazma Muvaffaqiyatli Yakunlandi";
                }
                return "Kartangizda Mablag' Yetarli Emas";
            }
            return "Tanlagan Kartangiz Mavjud Emas";
        }
        return "Karta Topilmadi";
    }

}
