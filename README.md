# Advanced-management-system-students


# Student Manager

Aplikacja do zarządzania studentami, która umożliwia dodawanie, usuwanie, aktualizowanie oraz wyświetlanie informacji o studentach. Dane są przechowywane w bazie danych SQLite. Aplikacja posiada również funkcję obliczania średniej ocen studentów.

## Wymagania

- Java 8 lub nowsza
- SQLite

## Instalacja

1. Skopiuj plik sterownika SQLite JDBC do folderu `lib` w projekcie:
   - `sqlite-jdbc-3.36.0.3.jar`

2. Skonfiguruj środowisko Java:
   - Zainstaluj JDK (Java Development Kit), jeśli jeszcze tego nie zrobiłeś.

3. Skompiluj i uruchom aplikację:
   - W terminalu, przejdź do głównego folderu projektu i uruchom polecenie kompilacji:
     ```bash
     javac -cp ".:lib/sqlite-jdbc-3.36.0.3.jar" src/StudentManager.java src/Student.java src/StudentManagerImpl.java src/StudentManagerGUI.java
     ```
   - Następnie uruchom aplikację:
     ```bash
     java -cp ".:lib/sqlite-jdbc-3.36.0.3.jar" StudentManagerGUI
     ```

4. Utwórz bazę danych `students.db` w tym samym folderze, co aplikacja. Baza danych będzie zawierać tabelę `students` z następującymi kolumnami:
   - `name` (TEXT)
   - `age` (INTEGER)
   - `grade` (REAL)
   - `studentID` (TEXT)

## Funkcje

- **Dodawanie studenta**: Można dodać nowego studenta, podając imię, wiek, ocenę oraz identyfikator studenta.
- **Usuwanie studenta**: Można usunąć studenta, podając jego identyfikator.
- **Aktualizowanie studenta**: Można zaktualizować dane studenta (imię, wiek, ocenę) na podstawie jego identyfikatora.
- **Wyświetlanie wszystkich studentów**: Można wyświetlić listę wszystkich studentów zapisanych w bazie danych.
- **Obliczanie średniej ocen**: Aplikacja oblicza średnią ocen wszystkich studentów.

## Struktura katalogów

- `src/` - katalog źródłowy, zawierający pliki Java
- `lib/` - katalog zawierający plik sterownika JDBC SQLite
- `bin/` - katalog, w którym kompilowane są pliki `.class`
- `students.db` - plik bazy danych SQLite




