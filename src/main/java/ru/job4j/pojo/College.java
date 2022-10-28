package ru.job4j.pojo;

public class College {

    public static void main(String[] args) {
        Student ivan = new Student();
        ivan.setFullName("Иванов Иван Иванович");
        ivan.setAdmissionDate("15.04.2020");
        ivan.setGroup("Первая группа");
        System.out.println(ivan.getFullName());
        System.out.println(ivan.getAdmissionDate());
        System.out.println(ivan.getGroup());
    }
}
