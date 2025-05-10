package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

    private String name;
    private int age;
    private String studentId;
    private List<String> courses;

    public Student(String name, int age, String studentId) {
        if (validateAge(age) && validateName(name) && validateStudentId(studentId)) {
            this.name = name;
            this.age = age;
            this.studentId = studentId;
            courses = new ArrayList<String>(); //Initialization of courses!!
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", studentId='" + studentId + '\'' +
                ", courses=" + courses +
                '}';
    }

    public void enrollCourse(String course) {
        if (validateCourseName(course)) {
            if (!courses.contains(course)) {
                courses.add(course);
                System.out.println("Student is enrolled to " + course + " successfully!!");
            } else {
                System.err.println("Student is already enrolled to the course " + course);
            }

        }


    }

    public void printStudentInfo(){
        System.out.println("******* Student Information **********");
        System.out.println("Student Name: "+name);
        System.out.println("Student Age: "+age);
        System.out.println("Student Id: "+studentId);
        System.out.println("Enrolled for: "+courses);
    }

    //Validation Methods
    public boolean validateAge(int age){
        if(age>=18 && age<=35){
            return true;
        }
        else {
            System.err.println("Invalid Age!! Student age needs to be between 18 & 35");
            return false;
        }
    }

    public boolean validateName(String name){
        String nameRegex = "^[a-zA-Z\\s]+$";
        Pattern namePattern = Pattern.compile(nameRegex);
        Matcher nameMatcher = namePattern.matcher(name);
        if(nameMatcher.matches()){
            return true;
        }
        else{
            System.err.println("Invalid name!! Please enter alphabets only");
            return false;
        }

    }

    private boolean validateStudentId(String studentId){
        String studentIdRegex = "S-\\d+$";   //S-123
        Pattern studentIdPattern = Pattern.compile(studentIdRegex);
        Matcher studentIdMatcher = studentIdPattern.matcher(studentId);
        if(studentIdMatcher.matches()){
            return true;
        }
        else{
            System.err.println("Invalid student Id......Use format for eg. S-1232");
            return false;

        }
    }

    public boolean validateCourseName(String course){
        if(course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DevOps")|| course.equalsIgnoreCase("Python")){
            return true;
        }
        else{
            System.err.println("Invalid course name......Please select courses from list !![Java, DevOps, Python]");
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStudentId() {
        return studentId;
    }

    public List<String> getCourses() {
        return courses;
    }
}
