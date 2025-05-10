package com.studentapp;

import java.util.*;

public class Main3 {
    private static List<Student> studentList;

    public static void main(String[] args) {
        System.out.println("********** Student Management System ******************");
        System.out.println(" ***************** Welcome *****************");
        studentList = new ArrayList<>();
        //Read input from the terminal
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student Name: ");
        String name = scanner.next(); //if you want to read the input in string format you will use next()
        System.out.println("You have entered the name: "+name);

        //To read integer values from console
        System.out.println("Enter Student Age: ");
        int age = scanner.nextInt(); //if you want to read the input in int format you will use nextInt()
        System.out.println("The student age is "+age);








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
