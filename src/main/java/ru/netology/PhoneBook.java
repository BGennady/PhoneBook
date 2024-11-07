package ru.netology;


import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, String> contacts = new HashMap<>();
    private Map<String, String> reverseContacts = new HashMap<>();

    public PhoneBook(Map<String, String> contacts) {
        this.contacts = contacts;
    }

    public int add(String name, String number) {
        if (!contacts.containsKey(name)) {
            contacts.put(name, number);
            reverseContacts.put(number, name);
        } else {
            String oldNumber = contacts.get(name);
            reverseContacts.remove(oldNumber);
            contacts.put(name, number);
            reverseContacts.put(number, name);
        }
        return contacts.size();
    }

    public String findByNumber(String phoneNumber) {
        return reverseContacts.get(phoneNumber);
    }
}

