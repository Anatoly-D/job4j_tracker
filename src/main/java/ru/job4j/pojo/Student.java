package ru.job4j.pojo;

import java.util.Date;

public class Student {
    private String firstName;
    private String lastName;
    private String patronymicName;
    private String group;
    private String joinData;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getJoinData() {
        return joinData;
    }

    public void setJoinData(String joinData) {
        this.joinData = joinData;
    }
}
