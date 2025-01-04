/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.ArrayList;

/**
 * parent class of all DAOs
 * @author Mustafa
 */

public abstract class DAO {

    static final String URL = "jdbc:mysql://localhost:3306/coursemanagementsystem";
    static final String USERNAME = "root";
    static final String PASSWORD = "";
/**
 * insert into entity
 * @param o
 * @throws ParameterTypeException 
 * 
 */
    public abstract void insert(Object o) throws ParameterTypeException;
/**
 *  delete from entity by primary key (id)
 * @param o
 * @throws ParameterTypeException 
 */
    public abstract void delete(Object o) throws ParameterTypeException; 
/**
 * select ("","ALL") for selecting ALL data without condition.
 * Some over-ridden select functions [of entities] are not that dynamic to handle different parameter types
 * @param value
 * @param column
 * @return list of up-casted objects, upcasting occurs differently in different entities, each entity upcasts it to its corresponding POJO
 * @throws ParameterTypeException 
 */
    public abstract ArrayList<Object> select(Object value, Object column) throws ParameterTypeException;
    
/**
 * 
 * @param key
 * @param column
 * @param newValue
 * @throws ParameterTypeException 
 */
    public abstract void update(Object key, Object column, Object newValue) throws ParameterTypeException;

}
