/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

/**
 * custom exception (unbased)
 * @author Mustafa
 */
public class ParameterTypeException extends Exception {

    public ParameterTypeException() {
        super("Wrong parameter type! Check the parameter passed at the Upcasted DAO");
    }
}
