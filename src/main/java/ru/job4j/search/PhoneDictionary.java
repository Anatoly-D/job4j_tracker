package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        String concatPerson;
        for (Person person : persons) {
            concatPerson = person.getAddress() + person.getName() + person.getPhone() + person.getSurname();
            if (concatPerson.contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
}
