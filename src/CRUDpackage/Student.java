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

/**
 *
 * @author Mustafa
 */
public class Student extends CRUDFrame {

    public Student() {
        super("Student CRUD Frame");
    }

    @Override
    public void createFrame() {
        createHeader = new javax.swing.JPanel();
        headerIconCreate = new javax.swing.JLabel();
        headingCreate = new javax.swing.JLabel();
        createBodyPanel = new javax.swing.JPanel();
        txtId = new javax.swing.JLabel();
        txtName = new javax.swing.JLabel();
        txtSemester = new javax.swing.JLabel();
        txtDept = new javax.swing.JLabel();
        createIDField = new javax.swing.JTextField();
        createNameField = new javax.swing.JTextField();
        createComboBoxSem = new javax.swing.JComboBox<>();
        createComboBoxDept = new javax.swing.JComboBox<>();
        submitInsert = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        createHeader.setBackground(new java.awt.Color(0, 0, 0));
        createHeader.setForeground(new java.awt.Color(255, 255, 255));

        headerIconCreate.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        headerIconCreate.setForeground(new java.awt.Color(255, 255, 255));
        headerIconCreate.setText("+");

        headingCreate.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        headingCreate.setForeground(new java.awt.Color(255, 255, 255));
        headingCreate.setText("Insert Student");

        javax.swing.GroupLayout createHeaderLayout = new javax.swing.GroupLayout(createHeader);
        createHeader.setLayout(createHeaderLayout);
        createHeaderLayout.setHorizontalGroup(
                createHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(createHeaderLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headerIconCreate)
                                .addGap(18, 18, 18)
                                .addComponent(headingCreate)
                                .addContainerGap(132, Short.MAX_VALUE))
        );
        createHeaderLayout.setVerticalGroup(
                createHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(createHeaderLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(createHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(headingCreate)
                                        .addComponent(headerIconCreate))
                                .addGap(23, 23, 23))
        );

        createBodyPanel.setBackground(new java.awt.Color(204, 204, 204));

        txtId.setText("Enter ID");

        txtName.setText("Enter Name:");

        txtSemester.setText("Enter Semester:");

        txtDept.setText("Enter Department: ");

        createComboBoxSem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Semester I", "Semester II", "Semester III", "Semester IV", "Semester V", "Semester VI", "Semester VII", "Semester VIII"}));

        createComboBoxDept.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"BSCS", "BSSE", "BSAI", "IPP", "BBA", "BSIT", "BEE"}));

        submitInsert.setText("Submit");
        submitInsert.setBackground(new java.awt.Color(169, 169, 169));
        submitInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitInsertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout createBodyPanelLayout = new javax.swing.GroupLayout(createBodyPanel);
        createBodyPanel.setLayout(createBodyPanelLayout);
        createBodyPanelLayout.setHorizontalGroup(
                createBodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(createBodyPanelLayout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addGroup(createBodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, createBodyPanelLayout.createSequentialGroup()
                                                .addComponent(txtSemester)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                                .addComponent(createComboBoxSem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(createBodyPanelLayout.createSequentialGroup()
                                                .addComponent(txtDept)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(createComboBoxDept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, createBodyPanelLayout.createSequentialGroup()
                                                .addGroup(createBodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtName)
                                                        .addComponent(txtId))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(createBodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(createNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                                        .addComponent(createIDField)))
                                        .addComponent(submitInsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        createBodyPanelLayout.setVerticalGroup(
                createBodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(createBodyPanelLayout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addGroup(createBodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtId)
                                        .addComponent(createIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(createBodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtName)
                                        .addComponent(createNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(createBodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtSemester)
                                        .addComponent(createComboBoxSem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(createBodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtDept)
                                        .addComponent(createComboBoxDept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addComponent(submitInsert)
                                .addContainerGap(138, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(createHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(createBodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(createHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(createBodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }

    @Override
    public void readFrame() {

        headerPanelRead = new javax.swing.JPanel();
        headerRead = new javax.swing.JLabel();
        iconRead = new javax.swing.JLabel();
        bodyPanelRead = new javax.swing.JPanel();
        scrollRead = new javax.swing.JScrollPane();
        stuReadTable = new javax.swing.JTable();
        refreshButton = new javax.swing.JButton();
        semSort = new javax.swing.JComboBox<>();
        semButtonSort = new javax.swing.JButton();
        deptSort = new javax.swing.JComboBox<>();
        deptSortButton = new javax.swing.JButton();
        
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        headerPanelRead.setBackground(new java.awt.Color(0, 0, 0));

        headerRead.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        headerRead.setForeground(new java.awt.Color(255, 255, 255));
        headerRead.setText("Student Read");

        iconRead.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        iconRead.setForeground(new java.awt.Color(255, 255, 255));
        iconRead.setText("•");

        javax.swing.GroupLayout headerPanelReadLayout = new javax.swing.GroupLayout(headerPanelRead);
        headerPanelRead.setLayout(headerPanelReadLayout);
        headerPanelReadLayout.setHorizontalGroup(
                headerPanelReadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerPanelReadLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headerRead)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(iconRead)
                                .addGap(18, 18, 18))
        );
        headerPanelReadLayout.setVerticalGroup(
                headerPanelReadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelReadLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(headerPanelReadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(headerRead)
                                        .addComponent(iconRead))
                                .addContainerGap())
        );

        bodyPanelRead.setBackground(new java.awt.Color(204, 204, 204));

        stuReadTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "Name", "Semester", "Department"
                }
        ));
        scrollRead.setViewportView(stuReadTable);

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        semSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Semester I", "Semester II", "Semester III", "Semester IV", "Semester V", "Semester VI", "Semester VII", "Semester VIII"}));

        semButtonSort.setText("Go");
        semButtonSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semButtonSortActionPerformed(evt);
            }
        });

        deptSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"BSCS ", "BSSE", "BSAI", "IPP ", "BBA ", "BSIT ", "BEE"}));

        deptSortButton.setText("Go");
        deptSortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptSortButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bodyPanelReadLayout = new javax.swing.GroupLayout(bodyPanelRead);
        bodyPanelRead.setLayout(bodyPanelReadLayout);
        bodyPanelReadLayout.setHorizontalGroup(
                bodyPanelReadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(bodyPanelReadLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(refreshButton)
                                .addGap(71, 71, 71)
                                .addComponent(deptSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deptSortButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(semSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(semButtonSort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addComponent(scrollRead, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        bodyPanelReadLayout.setVerticalGroup(
                bodyPanelReadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyPanelReadLayout.createSequentialGroup()
                                .addGroup(bodyPanelReadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(refreshButton)
                                        .addComponent(semSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(semButtonSort)
                                        .addComponent(deptSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deptSortButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollRead, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(headerPanelRead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bodyPanelRead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(headerPanelRead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bodyPanelRead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    @Override
    public void updateFrame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteFrame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //<editor-fold defaultstate="collapsed" desc="Create Operations">

    private void submitInsertActionPerformed(java.awt.event.ActionEvent evt) {
        String dept = (String) createComboBoxDept.getModel().getSelectedItem();
        Object comboBoxSelected = createComboBoxSem.getModel().getSelectedItem();
        String semester = (comboBoxSelected.equals("Semester I")) ? "1"
                : (comboBoxSelected.equals("Semester II")) ? "2"
                : (comboBoxSelected.equals("Semester III")) ? "3"
                : (comboBoxSelected.equals("Semester IV")) ? "4"
                : (comboBoxSelected.equals("Semester V")) ? "5"
                : (comboBoxSelected.equals("Semester VI")) ? "6"
                : (comboBoxSelected.equals("Semester VII")) ? "7"
                : (comboBoxSelected.equals("Semester VIII")) ? "8" : null;

        String name = createNameField.getText();
        int id = Integer.parseInt(createIDField.getText());

        try {
            DAOClasses.DAOFactory.createDAO("Student").insert(new POJOClasses.Student(id, name, semester, dept));
            JOptionPane.showMessageDialog(this, "Student has been successfully added.");
        } catch (ParameterTypeException e) {
            e.printStackTrace();
        }
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Create Variables">
    private javax.swing.JPanel createBodyPanel;
    private javax.swing.JComboBox<String> createComboBoxDept;
    private javax.swing.JComboBox<String> createComboBoxSem;
    private javax.swing.JPanel createHeader;
    private javax.swing.JTextField createIDField;
    private javax.swing.JTextField createNameField;
    private javax.swing.JLabel headerIconCreate;
    private javax.swing.JLabel headingCreate;
    private javax.swing.JButton submitInsert;
    private javax.swing.JLabel txtDept;
    private javax.swing.JLabel txtId;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtSemester;
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Read Operations">
    public void addRowToJTable() throws ParameterTypeException {
        DefaultTableModel model = (DefaultTableModel) stuReadTable.getModel();
        Object[] rowData = new Object[4];
        DAOClasses.DAO daoStd = DAOClasses.DAOFactory.createDAO("Student");
        ArrayList<Object> selected = daoStd.select("", "ALL");

        for (Object o : selected) {
            rowData[0] = ((POJOClasses.Student) o).getStudentId();
            rowData[1] = ((POJOClasses.Student) o).getName();
            rowData[2] = ((POJOClasses.Student) o).getSemester();
            rowData[3] = ((POJOClasses.Student) o).getDepartment();

            model.addRow(rowData);

        }
    }

    public void addRowToJTable(ArrayList<Object> selected) {
        DefaultTableModel model = (DefaultTableModel) stuReadTable.getModel();
        Object[] rowData = new Object[4];
        for (Object o : selected) {
            rowData[0] = ((POJOClasses.Student) o).getStudentId();
            rowData[1] = ((POJOClasses.Student) o).getName();
            rowData[2] = ((POJOClasses.Student) o).getSemester();
            rowData[3] = ((POJOClasses.Student) o).getDepartment();

            model.addRow(rowData);

        }
    }

    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) stuReadTable.getModel();
        model.getDataVector().removeAllElements();
        revalidate();
    }

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {
        clearTable();
        try {
            addRowToJTable();
        } catch (ParameterTypeException ex) {
            ex.printStackTrace();
        }
    }

    private void deptSortButtonActionPerformed(java.awt.event.ActionEvent evt) {
        clearTable();
        try {
            DAOClasses.DAO daoStd = DAOClasses.DAOFactory.createDAO("Student");
            ArrayList<Object> selected = daoStd.select((String) deptSort.getModel().getSelectedItem(), "DEPARTMENT");
            addRowToJTable(selected);
        } catch (ParameterTypeException e) {
            e.printStackTrace();
        }
    }

    private void semButtonSortActionPerformed(java.awt.event.ActionEvent evt) {
        Object comboBoxSelected = semSort.getModel().getSelectedItem();
        String semester = (comboBoxSelected.equals("Semester I")) ? "1"
                : (comboBoxSelected.equals("Semester II")) ? "2"
                : (comboBoxSelected.equals("Semester III")) ? "3"
                : (comboBoxSelected.equals("Semester IV")) ? "4"
                : (comboBoxSelected.equals("Semester V")) ? "5"
                : (comboBoxSelected.equals("Semester VI")) ? "6"
                : (comboBoxSelected.equals("Semester VII")) ? "7"
                : (comboBoxSelected.equals("Semester VIII")) ? "8" : null;

        clearTable();
        try {
            DAOClasses.DAO daoStd = DAOClasses.DAOFactory.createDAO("Student");
            ArrayList<Object> selected = daoStd.select(semester, "SEMESTER");
            addRowToJTable(selected);
        } catch (ParameterTypeException e) {
            e.printStackTrace();
        }
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Read Vars">
    private javax.swing.JPanel bodyPanelRead;
    private javax.swing.JComboBox<String> deptSort;
    private javax.swing.JButton deptSortButton;
    private javax.swing.JPanel headerPanelRead;
    private javax.swing.JLabel headerRead;
    private javax.swing.JLabel iconRead;
    private javax.swing.JButton refreshButton;
    private javax.swing.JScrollPane scrollRead;
    private javax.swing.JButton semButtonSort;
    private javax.swing.JComboBox<String> semSort;
    private javax.swing.JTable stuReadTable;
//</editor-fold>
}
