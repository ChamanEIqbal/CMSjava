/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOClasses;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Choco
 */
public class Faculty {
    private int facultyId;
    private String name;
    private List<Object> coursesTaught;
    
    public Faculty(int facultyId,String name){
        this.facultyId = facultyId;
        this.name = name;
        coursesTaught = new ArrayList<>();
    }
    
    public Faculty(int facultyId, String name, ArrayList<Object> coursesTaught) {
        this.facultyId = facultyId;
        this.name = name;
        this.coursesTaught = coursesTaught;
    }

    public int getFacultyid() {
        return facultyId;
    }

    public String getName() {
        return name;
    }

    public List<Object> getCoursesTaught() {
        return coursesTaught;
    }
    
    public void setCoursesTaught(ArrayList<Object> coursesTaught) {
        this.coursesTaught = coursesTaught;
    }
    
    @Override
    public String toString() {
        return name;
}
    
}
