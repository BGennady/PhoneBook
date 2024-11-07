package ru.netology;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PhoneBookTest {
    PhoneBook phoneBook;
    Map<String, String> testMap;
    ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        testMap = new HashMap<>();
        phoneBook = new PhoneBook(testMap);

        // настройка ByteArrayOutputStream для перехвата вывода
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // завожу пачку контактов
        phoneBook.add("Иван Иваныч", "+79107775533");
        phoneBook.add("Мария Смирнова", "+79107775534");
        phoneBook.add("Алексей Иванов", "+79107775535");
        phoneBook.add("Иван Иваныч", "+79107775536");
        phoneBook.add("Анна Петрова", "+79107775537");
    }

    @AfterEach
    void tearDown() {
        phoneBook = null;
    }

    @Test
    void addTestNumberOfContacts() {
        assertEquals(5, phoneBook.add("Новый Контакт", "+79107775538"));
    }

    @Test
    void addTestListOfNames(){
        // получаю все имена (ключи) из mockMap
        var listNames = testMap.keySet();
        // получаю колличество униальных
        long uniqueNamesCount = listNames.stream().distinct().count();

        // сравниваю ожидаемое с полученым
        assertEquals(4, uniqueNamesCount);
    }
    @Test
    void findByNumberTest(){
        assertEquals("Иван Иваныч", phoneBook.findByNumber("+79107775536"));
        assertEquals("Мария Смирнова", phoneBook.findByNumber("+79107775534"));
    }

    @Test
    void findByNameTest(){
        assertEquals("+79107775537", phoneBook.findByName("Анна Петрова"));
    }

    @Test
    void printAllNames(){
        phoneBook.printAllNames();

        // получаю вывод как строку
        String actualOutput = outputStream.toString().trim();
        // ожидаемый результат
        String expectedOutput = String.join("\n", "Иван Иваныч", "Мария Смирнова", "Алексей Иванов", "Анна Петрова");

        assertEquals(expectedOutput, actualOutput);
    }

}