/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDpackage;

import DAOClasses.ParameterTypeException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Faculty extends CRUDFrame {

    public Faculty() {
        super("Faculty CRUD Frame");
    }

    @Override
    public void createFrame() {

        headCreatePanel = new javax.swing.JPanel();
        headingCreate = new javax.swing.JLabel();
        iconCreate = new javax.swing.JLabel();
        bodyCreatePanel = new javax.swing.JPanel();
        iidCreate = new javax.swing.JLabel();
        nameCreate = new javax.swing.JLabel();
        submitButtonCreate = new javax.swing.JButton();
        fieldIDCreate = new javax.swing.JTextField();
        fieldNameCreate = new javax.swing.JTextField();

        headCreatePanel.setBackground(new java.awt.Color(0, 0, 0));

        headingCreate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        headingCreate.setForeground(new java.awt.Color(255, 255, 255));
        headingCreate.setText("Faculty Create");

        iconCreate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        iconCreate.setForeground(new java.awt.Color(255, 255, 255));
        iconCreate.setText("+");

        javax.swing.GroupLayout headCreatePanelLayout = new javax.swing.GroupLayout(headCreatePanel);
        headCreatePanel.setLayout(headCreatePanelLayout);
        headCreatePanelLayout.setHorizontalGroup(
                headCreatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headCreatePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headingCreate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(iconCreate)
                                .addGap(19, 19, 19))
        );
        headCreatePanelLayout.setVerticalGroup(
                headCreatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headCreatePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(headCreatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(headingCreate)
                                        .addComponent(iconCreate))
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        bodyCreatePanel.setBackground(new java.awt.Color(204, 204, 204));

        iidCreate.setText("Enter ID");

        nameCreate.setText("Enter Name");

        submitButtonCreate.setText("Submit");
        submitButtonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bodyCreatePanelLayout = new javax.swing.GroupLayout(bodyCreatePanel);
        bodyCreatePanel.setLayout(bodyCreatePanelLayout);
        bodyCreatePanelLayout.setHorizontalGroup(
                bodyCreatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(bodyCreatePanelLayout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addGroup(bodyCreatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(submitButtonCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(bodyCreatePanelLayout.createSequentialGroup()
                                                .addGroup(bodyCreatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(nameCreate)
                                                        .addComponent(iidCreate))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(bodyCreatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(fieldIDCreate)
                                                        .addComponent(fieldNameCreate, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))))
                                .addContainerGap(76, Short.MAX_VALUE))
        );
        bodyCreatePanelLayout.setVerticalGroup(
                bodyCreatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(bodyCreatePanelLayout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addGroup(bodyCreatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(iidCreate)
                                        .addComponent(fieldIDCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(bodyCreatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameCreate)
                                        .addComponent(fieldNameCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(74, 74, 74)
                                .addComponent(submitButtonCreate)
                                .addContainerGap(178, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(headCreatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bodyCreatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(headCreatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bodyCreatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    @Override
    public void readFrame() {
        jScrollPane1 = new javax.swing.JScrollPane();
        facTable = new javax.swing.JTable();
        ReadHeader = new javax.swing.JPanel();
        facLabelHeader = new javax.swing.JLabel();
        subheader = new javax.swing.JPanel();
        refreshButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));

        facTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "Name"
                }
        ));
        jScrollPane1.setViewportView(facTable);

        ReadHeader.setBackground(new java.awt.Color(0, 0, 0));

        facLabelHeader.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        facLabelHeader.setForeground(new java.awt.Color(255, 255, 255));
        facLabelHeader.setText("Faculty INFO                  •");

        subheader.setBackground(new java.awt.Color(153, 153, 153));

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout subheaderLayout = new javax.swing.GroupLayout(subheader);
        subheader.setLayout(subheaderLayout);
        subheaderLayout.setHorizontalGroup(
                subheaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subheaderLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(refreshButton)
                                .addGap(188, 188, 188))
        );
        subheaderLayout.setVerticalGroup(
                subheaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(subheaderLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(refreshButton)
                                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ReadHeaderLayout = new javax.swing.GroupLayout(ReadHeader);
        ReadHeader.setLayout(ReadHeaderLayout);
        ReadHeaderLayout.setHorizontalGroup(
                ReadHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ReadHeaderLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(facLabelHeader)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(subheader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ReadHeaderLayout.setVerticalGroup(
                ReadHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ReadHeaderLayout.createSequentialGroup()
                                .addComponent(facLabelHeader)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(subheader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addComponent(ReadHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(ReadHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }

    @Override
    public void updateFrame() {

        headerUpd = new javax.swing.JPanel();
        headingUpd = new javax.swing.JLabel();
        iconUpd = new javax.swing.JLabel();
        panelUpd = new javax.swing.JPanel();
        idUpdTxt = new javax.swing.JLabel();
        NameUpdTxt = new javax.swing.JLabel();
        fieldUpdID = new javax.swing.JTextField();
        fieldUpdName = new javax.swing.JTextField();
        updButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        headerUpd.setBackground(new java.awt.Color(0, 0, 0));

        headingUpd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        headingUpd.setForeground(new java.awt.Color(255, 255, 255));
        headingUpd.setText("Update Faculty");

        iconUpd.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        iconUpd.setForeground(new java.awt.Color(255, 255, 255));
        iconUpd.setText("↑");

        javax.swing.GroupLayout headerUpdLayout = new javax.swing.GroupLayout(headerUpd);
        headerUpd.setLayout(headerUpdLayout);
        headerUpdLayout.setHorizontalGroup(
                headerUpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerUpdLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headingUpd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(iconUpd)
                                .addContainerGap())
        );
        headerUpdLayout.setVerticalGroup(
                headerUpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerUpdLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(headerUpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(headingUpd)
                                        .addComponent(iconUpd))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelUpd.setBackground(new java.awt.Color(204, 204, 204));

        idUpdTxt.setText("Enter ID:");

        NameUpdTxt.setText("Enter New Name:");

        updButton.setText("Update");
        updButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelUpdLayout = new javax.swing.GroupLayout(panelUpd);
        panelUpd.setLayout(panelUpdLayout);
        panelUpdLayout.setHorizontalGroup(
                panelUpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelUpdLayout.createSequentialGroup()
                                .addGroup(panelUpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelUpdLayout.createSequentialGroup()
                                                .addGap(49, 49, 49)
                                                .addGroup(panelUpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(NameUpdTxt)
                                                        .addComponent(idUpdTxt))
                                                .addGap(18, 18, 18)
                                                .addGroup(panelUpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(fieldUpdName, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                                        .addComponent(fieldUpdID)))
                                        .addGroup(panelUpdLayout.createSequentialGroup()
                                                .addGap(91, 91, 91)
                                                .addComponent(updButton)))
                                .addContainerGap(69, Short.MAX_VALUE))
        );
        panelUpdLayout.setVerticalGroup(
                panelUpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelUpdLayout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(panelUpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(idUpdTxt)
                                        .addComponent(fieldUpdID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelUpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(fieldUpdName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(NameUpdTxt))
                                .addGap(30, 30, 30)
                                .addComponent(updButton)
                                .addContainerGap(96, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(headerUpd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelUpd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(headerUpd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelUpd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    @Override
    public void deleteFrame() {

        headerPanelDelete = new javax.swing.JPanel();
        headerDel = new javax.swing.JLabel();
        iconDelFac = new javax.swing.JLabel();
        bodyPanelDel = new javax.swing.JPanel();
        enterFacID = new javax.swing.JLabel();
        fieldIDDel = new javax.swing.JTextField();
        delButtonFac = new javax.swing.JButton();

         setResizable(false);
         setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        headerPanelDelete.setBackground(new java.awt.Color(0, 0, 0));

        headerDel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        headerDel.setForeground(new java.awt.Color(255, 255, 255));
        headerDel.setText("Delete Faculty");

        iconDelFac.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        iconDelFac.setForeground(new java.awt.Color(255, 255, 255));
        iconDelFac.setText("—");

        javax.swing.GroupLayout headerPanelDeleteLayout = new javax.swing.GroupLayout(headerPanelDelete);
        headerPanelDelete.setLayout(headerPanelDeleteLayout);
        headerPanelDeleteLayout.setHorizontalGroup(
                headerPanelDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerPanelDeleteLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(headerDel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(iconDelFac)
                                .addGap(31, 31, 31))
        );
        headerPanelDeleteLayout.setVerticalGroup(
                headerPanelDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelDeleteLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(headerPanelDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(headerDel)
                                        .addComponent(iconDelFac))
                                .addContainerGap())
        );

        bodyPanelDel.setBackground(new java.awt.Color(204, 204, 204));

        enterFacID.setText("Enter Faculty ID:");

        delButtonFac.setText("Delete");
        delButtonFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delButtonFacActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bodyPanelDelLayout = new javax.swing.GroupLayout(bodyPanelDel);
        bodyPanelDel.setLayout(bodyPanelDelLayout);
        bodyPanelDelLayout.setHorizontalGroup(
                bodyPanelDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(bodyPanelDelLayout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addGroup(bodyPanelDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(bodyPanelDelLayout.createSequentialGroup()
                                                .addComponent(enterFacID)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fieldIDDel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(bodyPanelDelLayout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(delButtonFac)))
                                .addContainerGap(128, Short.MAX_VALUE))
        );
        bodyPanelDelLayout.setVerticalGroup(
                bodyPanelDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(bodyPanelDelLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(bodyPanelDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(enterFacID)
                                        .addComponent(fieldIDDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(delButtonFac)
                                .addContainerGap(154, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(headerPanelDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bodyPanelDel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(headerPanelDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bodyPanelDel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

//<editor-fold defaultstate="collapsed" desc="Read Vars">
    // Read Variables
    private javax.swing.JPanel ReadHeader;
    private javax.swing.JLabel facLabelHeader;
    private javax.swing.JTable facTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshButton;
    private javax.swing.JPanel subheader;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Read Opers">
    // Read Operations
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {

        clearTable();

        try {
            addRowToJTable();
        } catch (ParameterTypeException e) {
            e.printStackTrace();
        }

    }

    public void addRowToJTable() throws ParameterTypeException {
        DefaultTableModel model = (DefaultTableModel) facTable.getModel();
        Object rowData[] = new Object[2];

        DAOClasses.DAO daoFaculty = DAOClasses.DAOFactory.createDAO("Faculty");

        ArrayList<Object> selectedObjs = daoFaculty.select("", "ALL");

        for (int i = 0; i < selectedObjs.size(); i++) {
            rowData[0] = ((POJOClasses.Faculty) selectedObjs.get(i)).getFacultyid();
            rowData[1] = ((POJOClasses.Faculty) selectedObjs.get(i)).getName();
            model.addRow(rowData);
        }
    }

    public void clearTable() {
        DefaultTableModel dm = (DefaultTableModel) facTable.getModel();
        dm.getDataVector().removeAllElements();
        revalidate();
    }

//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Create Vars">
    private javax.swing.JPanel bodyCreatePanel;
    private javax.swing.JTextField fieldIDCreate;
    private javax.swing.JTextField fieldNameCreate;
    private javax.swing.JPanel headCreatePanel;
    private javax.swing.JLabel headingCreate;
    private javax.swing.JLabel iconCreate;
    private javax.swing.JLabel iidCreate;
    private javax.swing.JLabel nameCreate;
    private javax.swing.JButton submitButtonCreate;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Create Operations">
    private void submitButtonCreateActionPerformed(java.awt.event.ActionEvent evt) {
        String name = fieldNameCreate.getText();
        int id = Integer.parseInt(fieldIDCreate.getText());

        POJOClasses.Faculty faculty = new POJOClasses.Faculty(id, name);

        DAOClasses.DAO daoFaculty = DAOClasses.DAOFactory.createDAO("Faculty");

        try {
            daoFaculty.insert(faculty);
            JOptionPane.showMessageDialog(this, "Successfully added Faculty to DB");
        } catch (ParameterTypeException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

        try {
            ArrayList<Object> coursesTaught = DAOClasses.DAOFactory.createDAO("Course").select(id, "Faculty");
            faculty.setCoursesTaught(coursesTaught);
        } catch (ParameterTypeException ex) {
            ex.printStackTrace();
        }
    }

//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Update Operations">
    private void updButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int id = Integer.parseInt(fieldUpdID.getText());
        String newName = fieldUpdName.getText();
        try {
            DAOClasses.DAO daoFac = DAOClasses.DAOFactory.createDAO("Faculty");
            daoFac.update(id, "Name", newName);
            JOptionPane.showMessageDialog(this, "The faculty Info has been updated");
        } catch (DAOClasses.ParameterTypeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Update Vars">
    private javax.swing.JLabel NameUpdTxt;
    private javax.swing.JTextField fieldUpdID;
    private javax.swing.JTextField fieldUpdName;
    private javax.swing.JPanel headerUpd;
    private javax.swing.JLabel headingUpd;
    private javax.swing.JLabel iconUpd;
    private javax.swing.JLabel idUpdTxt;
    private javax.swing.JPanel panelUpd;
    private javax.swing.JButton updButton;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Delete Operations">
    private void delButtonFacActionPerformed(java.awt.event.ActionEvent evt) {
        int id = Integer.parseInt(fieldIDDel.getText());
        try {
            DAOClasses.DAO daoFac = DAOClasses.DAOFactory.createDAO("Faculty");
            ArrayList<Object> selected = daoFac.select(id, "ID");
            daoFac.delete(selected.get(0));
            JOptionPane.showMessageDialog(this, "Successfully deleted faculty:  " + id);
        } catch (DAOClasses.ParameterTypeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Delete Vars">

    private javax.swing.JPanel bodyPanelDel;
    private javax.swing.JButton delButtonFac;
    private javax.swing.JLabel enterFacID;
    private javax.swing.JTextField fieldIDDel;
    private javax.swing.JLabel headerDel;
    private javax.swing.JPanel headerPanelDelete;
    private javax.swing.JLabel iconDelFac;
//</editor-fold>
}
