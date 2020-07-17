package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student studentOne = new Student();
        studentOne.setFirstName("Anatoly");
        studentOne.setPatronymicName("Vladimirovich");
        studentOne.setLastName("Dudenkov");
        studentOne.setGroup("MP25");
        studentOne.setJoinData("01.09.2005");

        System.out.println(studentOne.getFirstName());
        System.out.println(studentOne.getPatronymicName());
        System.out.println(studentOne.getLastName());
        System.out.println(studentOne.getGroup());
        System.out.println(studentOne.getJoinData());
    }
}
