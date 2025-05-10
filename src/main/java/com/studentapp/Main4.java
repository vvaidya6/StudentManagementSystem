package com.studentapp;

import java.util.*;

import static java.lang.System.exit;

public class Main4 {
    private static List<Student> studentList;
    private static  Scanner scanner;

    public static void main(String[] args) {
        System.out.println("********** Student Management System ******************");
        studentList = new ArrayList<>();
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println(" ***************** Welcome *****************");
            System.out.println("Select an Option.....");
            System.out.println("1. Register a Student");
            System.out.println("2. Find Student with Student Id");
            System.out.println("3. List all student information");
            System.out.println("4. List student information in sorted order");
            System.out.println("5. Exit");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    enrollStudent(scanner);
                    break;
                case 2:
                    findStudentById(scanner);
                    break;
                case 3:
                    printAllStudentData();
                    break;
                case 4:
                    sortByName();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    System.out.println("Invalid option selected!...Enter between 1 to 5 ");
            }

        }
    }

    private static void exit(){
        System.out.println("Goood Bye !!");

    }



    private static void printAllStudentData() {
        if (studentList.size() > 0) {
            System.out.println("********* Print All Student Data **************");
            for (Student s : studentList) {
                s.printStudentInfo();
            }
            System.out.println("---------------------------------------------");
        } else {
            System.err.println("Student list is empty!!....No records found");
        }
    }

    private static void findStudentById(Scanner scanner) {
        Student studentFound = null;
        System.out.println("Enter the student Id....");
        String studentId = scanner.next();
        try {
            studentFound = studentList.stream().filter(student -> student.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No Data found!!!"));
        } catch (RuntimeException e) {
            System.err.println("Student with ID " + studentId + " not found!!!");
        }

        studentFound.printStudentInfo();
    }

    private static void enrollStudent(Scanner scanner) {
        System.out.println("Enter the Student Name");
        String studentName = scanner.next();

        System.out.println("Enter the Student Age");
        int studentAge = scanner.nextInt();

        System.out.println("Enter the Student Id");
        String studentId = scanner.next();

        Student newStudent = new Student(studentName, studentAge, studentId);
        studentList.add(newStudent);
        while(true) {
            System.out.println("Enter the course to be enrolled!! ...Type Done to exit");
            String courseName = scanner.next();
            if(courseName.equalsIgnoreCase("done")){
                break; //exit from the loop
            }
            newStudent.enrollCourse(courseName);
        }
        newStudent.printStudentInfo();
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
        Collections.sort(studentList, studentNameComparator);
        System.out.println(studentList);
        printAllStudentData();

    }


}
