/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDpackage;

import javax.swing.WindowConstants;

/**
 *
 * @author Mustafa
 */
public abstract class CRUDFrame extends javax.swing.JFrame {

    /**
     * parent class of all CRUDFrames i.e entities
     * @param title
     * String
     */
    public CRUDFrame(String title) {
        super(title);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    /**
     *  For All Entities, Abstract Function for "Create" type frames
     */
    public abstract void createFrame();

    /**
     *  For All Entities, Abstract Function for "Read" type frames
     */
    public abstract void readFrame();

    /**
     * For All Entities, Abstract Function for "Update" type frames
     */
    public abstract void updateFrame();

    /**
     * For All Entities, Abstract Function for "Delete" type frames
     */
    public abstract void deleteFrame();

}
