/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOClasses;

import java.util.ArrayList;

/**
 *
 * @author Mustafa
 */
public class Course {
    private final int courseId;
    private final String title;
    private Faculty faculty;
    private final String semester;
    private ArrayList<Student> studentList;
    
    public Course(int courseId, String title, String semester){
        this.courseId = courseId;
        this.title = title;
        this.semester = semester;
        studentList = new ArrayList<>();
    }
    
    public Course(int courseId, String title, Faculty faculty, String semester) {
        this.courseId = courseId;
        this.title = title;
        this.semester = semester;
        this.faculty = faculty;
        studentList = new ArrayList<>();
    }
    
    public int getCourseid() {return courseId;}
    public String getTitle() {return title;}
    public Faculty getFaculty() {return faculty;}
    public String getSemester() {return semester;}
    public ArrayList<Student> getStudents() {return studentList;}
    
    // setters for non-primitive datatype, datamembers
    public void setFaculty(Faculty faculty) {this.faculty = faculty;}
    public void setStudentList(ArrayList<Student> stdList) {studentList = stdList;}
    public void setFacultyFromDB(int ID) {
        Faculty facultyTemp = DAOClasses.Faculty.getFaculty(ID);
        this.faculty = facultyTemp;
        facultyTemp.getCoursesTaught().add(this);
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.courseId) + "\n" + this.title + "\n" + this.semester + "\n" + this.faculty.getName() + "\n";
    }
    
    public String displayInfo() {
         return  this.title + "\n" + this.semester + "\n" + this.faculty.getName() + "\n";
    }
    
}
