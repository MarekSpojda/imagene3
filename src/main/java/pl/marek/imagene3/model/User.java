package pl.marek.imagene3.model;

import javax.persistence.Entity;

@Entity
public class User {
//  **Rejestracja i logowanie użytkownika
//    Rejestracja wymaga podania hasła dłuższego niż 7 znaków i zawierającego przynajmniej jedną cyfrę.
//    Przy rejestracji system nadaje unikatowy, "trudny do odgadnięcia" identyfikator użytkownika.
//    Logowanie przy pomocy identyfikatora i hasła tworzy sesję, wymaganą do dalszej pracy.
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
}
