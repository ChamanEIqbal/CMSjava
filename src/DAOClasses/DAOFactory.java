/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

/**
 *
 * @author Mustafa
 */
public class DAOFactory {

    /**
     * 
     * @param option
     * @return data-access-objects for each entity upcasted according to parameter option
     */
    public static DAO createDAO(String option) {

        if (option.equalsIgnoreCase("Course")) {
            DAO dao = new Course();
            return dao;
        } else if (option.equalsIgnoreCase("Faculty")) {
            DAO dao = new Faculty();
            return dao;
        } else if (option.equalsIgnoreCase("Student")) {
            DAO dao = new Student();
            return dao;
        }
        return null;
    }

}
