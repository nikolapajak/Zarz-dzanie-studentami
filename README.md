# Zarządzanie studentami


Opis projektu
System zarządzania studentami to aplikacja w języku Java, która umożliwia:

Dodawanie, modyfikowanie i usuwanie danych studentów.
Wyświetlanie listy studentów przechowywanej w bazie danych SQLite.
Obliczanie średniej ocen wszystkich studentów.
Dane są zapisywane w lokalnym pliku bazy danych SQLite (students.db), a aplikacja korzysta z graficznego interfejsu użytkownika (GUI).

Wymagania systemowe
Java: Wersja 8 lub nowsza.
SQLite: Baza danych SQLite oraz sterownik JDBC (sqlite-jdbc-3.36.0.3.jar).
Przygotowanie środowiska
Pobierz sterownik SQLite JDBC: Umieść plik sqlite-jdbc-3.36.0.3.jar w folderze lib w katalogu projektu.

Zainstaluj JDK: Upewnij się, że masz zainstalowany Java Development Kit (JDK).

Przygotuj bazę danych: W głównym katalogu projektu utwórz plik students.db. Wewnątrz bazy danych dodaj tabelę students z następującymi kolumnami:

name (TEXT) - Imię studenta.
age (INTEGER) - Wiek studenta.
grade (REAL) - Ocena studenta.
studentID (TEXT) - Unikalny identyfikator studenta.
Uruchamianie projektu
Kompilacja
Przejdź do katalogu projektu i skompiluj pliki źródłowe:

bash
Copy code
javac -cp ".:lib/sqlite-jdbc-3.36.0.3.jar" src/*.java
Uruchamianie
Po kompilacji uruchom aplikację:

bash
Copy code
java -cp ".:lib/sqlite-jdbc-3.36.0.3.jar" src/StudentManagerGUI
Funkcjonalności aplikacji
Dodawanie nowych studentów
Wprowadź dane studenta (imię, wiek, ocenę oraz identyfikator) i zapisz je w bazie.

Aktualizacja danych studenta
Zmodyfikuj dane istniejącego studenta, korzystając z jego identyfikatora.

Usuwanie studentów
Usuń dane wybranego studenta, podając jego unikalny identyfikator.

Wyświetlanie listy studentów
Obejrzyj wszystkich zapisanych studentów w jednym miejscu.

Obliczanie średniej ocen
Oblicz średnią ocen studentów i wyświetl wynik w interfejsie aplikacji.

Struktura projektu
src/: Pliki źródłowe aplikacji w języku Java.
lib/: Katalog zawierający sterownik SQLite JDBC.
bin/: Kompilowane pliki .class.
students.db: Plik bazy danych SQLite przechowujący dane studentów.

- `students.db` - plik bazy danych SQLite




