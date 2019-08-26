package pl.marek.imagene3.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
public class User {
    //
//  **Rejestracja i logowanie użytkownika
//ok   Rejestracja wymaga podania hasła dłuższego niż 7 znaków i zawierającego przynajmniej jedną cyfrę.
//ok   Przy rejestracji system nadaje unikatowy, "trudny do odgadnięcia" identyfikator użytkownika.
//ok   Logowanie przy pomocy identyfikatora i hasła tworzy sesję, wymaganą do dalszej pracy.

//  **Dodawanie wariantów
//    Końcówka niewymagająca autoryzacji.
//    Pozwala na dodanie nowego wariantu.
//    Aktualizacja wariantu jest zabroniona.
//    Wariant to rekord składający się z następujących pól:
//    position (long int),
//    alteration (string),
//    chromosome (string),
//    opis (string, nawet kilka tysięcy znaków).

//  **Przypisanie wariantu do użytkownika
//    Końcówka niewymagająca autoryzacji.
//    Każdy użytkownik może mieć wiele wariantów, ale tylko jeden wariant o tych samych polach position, alteration, chromosome.

//  **Pobieranie wariantów
//    Zwraca listę wariantów (same opisy) aktualnie zalogowanego użytkownika.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userid;

    @Length(min = 8)
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
