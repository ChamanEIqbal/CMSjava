/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOClasses;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mustafa
 */
public class Student {
    private int studentId;
    private String name;
    private String semester;
    private String department;
    private List<Course> coursesEnrolled;
    
    public Student(int studentId, String name, String semester, String department){
        this.studentId = studentId;
        this.name = name;
        this.semester = semester;
        this.department = department;
        coursesEnrolled = new ArrayList<>();
    }

    public int getStudentId() {return studentId;}
    public String getName() {return name;}
    public List<Course> getCoursesEnrolled() {return coursesEnrolled;}
    public void enrollCourse(Course course) {coursesEnrolled.add(course);}
    public String getDepartment() {return department;}
    public String getSemester(){return semester;}
    
}
