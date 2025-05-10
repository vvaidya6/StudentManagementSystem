package com.studentapp;

public class Main {

    public static void main(String[] args) {
        System.out.println("********** Student Management System ******************");
        System.out.println(" ***************** Welcome *****************");


        Student s1 = new Student("Raj",22, "S-101");
        s1.enrollCourse("Java");
        s1.printStudentInfo();



        Student s2 = new Student("Uday",24, "S-102");
        s2.enrollCourse("Python");
        s2.printStudentInfo();



        Student s3 = new Student("Ritu",28, "S-103");
        s3.enrollCourse("DevOps");
        s3.printStudentInfo();

    }


}
