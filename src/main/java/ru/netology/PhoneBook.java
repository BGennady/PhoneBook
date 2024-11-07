package ru.netology;


import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, String> contacts = new HashMap<>();

    public PhoneBook(Map<String, String> contacts) {
        this.contacts = contacts;
    }

    public int add(String name, String number) {
        contacts.put(name, number);
        return contacts.size();
    }
    public String findByNumber(){
        return null;
    }
}

