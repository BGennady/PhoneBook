package ru.netology;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PhoneBookTest {
    PhoneBook phoneBook;
    Map<String, String> mockMap;

    @BeforeEach
    void setUp() {
        mockMap = Mockito.mock(HashMap.class); // мокирую мапу
        phoneBook = new PhoneBook(mockMap); // передаю заглушку в класс PhoneBook

        // завожу пачку контактов
        phoneBook.add("Иван Иваныч", "+79107775533");
        phoneBook.add("Мария Смирнова", "+79107775534");
        phoneBook.add("Алексей Иванов", "+79107775535");
        phoneBook.add("Иван Иваныч", "+79107775536");
        phoneBook.add("Анна Петрова", "+79107775537");
    }

    @Test
    void addTestNumberOfContacts() {
        assertEquals(4, mockMap.size());
    }

    @Test
    void addTestListOfNames(){
        // получаю все имена (ключи) из mockMap
        var listNames = mockMap.keySet();
        // получаю колличество униальных
        long uniqueNamesCount = listNames.stream().distinct().count();

        // сравниваю ожидаемое с полученым
        assertEquals(4, uniqueNamesCount);
    }

}