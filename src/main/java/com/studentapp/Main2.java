package com.studentapp;

import java.util.*;

public class Main2 {
    private static List<Student> studentList;

    public static void main(String[] args) {
        System.out.println("********** Student Management System ******************");
        System.out.println(" ***************** Welcome *****************");

        studentList = new ArrayList<>();

        Student s1 = new Student("Raj",22, "S-101");
        s1.enrollCourse("Java");
        s1.enrollCourse("Python");
        s1.enrollCourse("DevOps");
        s1.enrollCourse("C#");

        Student s2 = new Student("Uday",24, "S-102");
        s2.enrollCourse("Python");

        Student s3 = new Student("Ritu",28, "S-103");
        s3.enrollCourse("DevOps");

        Student s4 = new Student("David",32, "S-104");
        s4.enrollCourse("DevOps");

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);

        Student result = findStudentById("S-101");
        System.out.println("Result: "+result);
        sortByName();



    }

    public static Student findStudentById(String studentId) {
        Student result = null;
        try {
            result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No Data found!!!"));
            return result;
        } catch (RuntimeException e) {
            System.err.println("Student with ID " + studentId + " not found!!!");
        }

        return result;
    }

    private static void sortByName(){
        Comparator<Student> studentNameComparator = Comparator.comparing(Student::getName);


                /*new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName()); //comparison happen lexographically
            }
        };*/

        Collections.sort(studentList, studentNameComparator);
        System.out.println(studentList);

    }


}
