/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDpackage;

import DAOClasses.DAO;
import DAOClasses.DAOFactory;
import DAOClasses.ParameterTypeException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mustafa
 */
public class Course extends CRUDFrame {

    public Course() {
        super("Course CRUD Frame");
    }

    @Override
    public void createFrame() {
        HeaderPanelCreate = new javax.swing.JPanel();
        iconLabel = new javax.swing.JLabel();
        headingTxt = new javax.swing.JLabel();
        mainPanelCreate = new javax.swing.JPanel();
        idTxtCreate = new javax.swing.JLabel();
        nameTxtCreate = new javax.swing.JLabel();
        semesterTxtCreate = new javax.swing.JLabel();
        facTxtCreate = new javax.swing.JLabel();
        comboBoxSemester = new javax.swing.JComboBox<>();
        fieldId = new javax.swing.JTextField();
        fieldName = new javax.swing.JTextField();
        fieldFacId = new javax.swing.JTextField();
        submitCreateButton = new javax.swing.JButton();

        setResizable(false);

        HeaderPanelCreate.setBackground(new java.awt.Color(0, 0, 0));

        iconLabel.setFont(new java.awt.Font("Tahoma", 0, 64)); // NOI18N
        iconLabel.setForeground(new java.awt.Color(255, 255, 255));
        iconLabel.setText("+");

        headingTxt.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        headingTxt.setForeground(new java.awt.Color(255, 255, 255));
        headingTxt.setText("Insert Course");

        javax.swing.GroupLayout HeaderPanelCreateLayout = new javax.swing.GroupLayout(HeaderPanelCreate);
        HeaderPanelCreate.setLayout(HeaderPanelCreateLayout);
        HeaderPanelCreateLayout.setHorizontalGroup(
                HeaderPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HeaderPanelCreateLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(iconLabel)
                                .addGap(18, 18, 18)
                                .addComponent(headingTxt)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HeaderPanelCreateLayout.setVerticalGroup(
                HeaderPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HeaderPanelCreateLayout.createSequentialGroup()
                                .addGroup(HeaderPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(HeaderPanelCreateLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(headingTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 10, Short.MAX_VALUE))
        );

        mainPanelCreate.setBackground(new java.awt.Color(153, 153, 153));

        idTxtCreate.setForeground(new java.awt.Color(255, 255, 255));
        idTxtCreate.setText("Enter ID:");

        nameTxtCreate.setForeground(new java.awt.Color(255, 255, 255));
        nameTxtCreate.setText("Enter Name:");

        semesterTxtCreate.setForeground(new java.awt.Color(255, 255, 255));
        semesterTxtCreate.setText("Semester:");

        facTxtCreate.setForeground(new java.awt.Color(255, 255, 255));
        facTxtCreate.setText("Assign Faculty ID:");

        comboBoxSemester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Semester I", "Semester II", "Semester III", "Semester IV", "Semester V", "Semester VI", "Semester VII", "Semester VIII"}));

        submitCreateButton.setText("Submit");
        submitCreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitCreateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelCreateLayout = new javax.swing.GroupLayout(mainPanelCreate);
        mainPanelCreate.setLayout(mainPanelCreateLayout);
        mainPanelCreateLayout.setHorizontalGroup(
                mainPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelCreateLayout.createSequentialGroup()
                                .addGroup(mainPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelCreateLayout.createSequentialGroup()
                                                .addGap(117, 117, 117)
                                                .addGroup(mainPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(mainPanelCreateLayout.createSequentialGroup()
                                                                .addGroup(mainPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(idTxtCreate)
                                                                        .addComponent(nameTxtCreate))
                                                                .addGap(22, 22, 22)
                                                                .addGroup(mainPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(fieldId)
                                                                        .addComponent(fieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)))
                                                        .addGroup(mainPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(mainPanelCreateLayout.createSequentialGroup()
                                                                        .addComponent(facTxtCreate)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(fieldFacId))
                                                                .addGroup(mainPanelCreateLayout.createSequentialGroup()
                                                                        .addComponent(semesterTxtCreate)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(comboBoxSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(mainPanelCreateLayout.createSequentialGroup()
                                                .addGap(158, 158, 158)
                                                .addComponent(submitCreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(126, Short.MAX_VALUE))
        );
        mainPanelCreateLayout.setVerticalGroup(
                mainPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelCreateLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(mainPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(idTxtCreate)
                                        .addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(mainPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameTxtCreate)
                                        .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(mainPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(semesterTxtCreate)
                                        .addComponent(comboBoxSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(mainPanelCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(facTxtCreate)
                                        .addComponent(fieldFacId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                                .addComponent(submitCreateButton)
                                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(HeaderPanelCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mainPanelCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(HeaderPanelCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mainPanelCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }

    @Override
    public void readFrame() {
        scrollCreate = new javax.swing.JScrollPane();
        courseTable = new javax.swing.JTable();
        headingCreate = new javax.swing.JPanel();
        courseHeading = new javax.swing.JLabel();
        IconCreateCourse = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        refreshButton = new javax.swing.JButton();
        sortFacButton = new javax.swing.JButton();
        facFieldSort = new javax.swing.JTextField();
        sortSemButton = new javax.swing.JButton();
        sortSemField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        courseTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "Title", "FacultyID", "Semester"
                }
        ));
        scrollCreate.setViewportView(courseTable);

        headingCreate.setBackground(new java.awt.Color(0, 0, 0));

        courseHeading.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        courseHeading.setForeground(new java.awt.Color(255, 255, 255));
        courseHeading.setText("Course");

        IconCreateCourse.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        IconCreateCourse.setForeground(new java.awt.Color(255, 255, 255));
        IconCreateCourse.setText("•");

        javax.swing.GroupLayout headingCreateLayout = new javax.swing.GroupLayout(headingCreate);
        headingCreate.setLayout(headingCreateLayout);
        headingCreateLayout.setHorizontalGroup(
                headingCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headingCreateLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(courseHeading)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(IconCreateCourse)
                                .addGap(28, 28, 28))
        );
        headingCreateLayout.setVerticalGroup(
                headingCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headingCreateLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(headingCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(IconCreateCourse)
                                        .addComponent(courseHeading))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        sortFacButton.setText("BY FacultyID:");
        sortFacButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortFacButtonActionPerformed(evt);
            }
        });

        sortSemButton.setText("BY Semester:");
        sortSemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortSemButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(refreshButton)
                                .addGap(103, 103, 103)
                                .addComponent(sortFacButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(facFieldSort, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(sortSemButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sortSemField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(refreshButton)
                                        .addComponent(sortFacButton)
                                        .addComponent(facFieldSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sortSemButton)
                                        .addComponent(sortSemField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scrollCreate)
                        .addComponent(headingCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(headingCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollCreate, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
        );

        pack();
    }

    @Override
    public void updateFrame() {

        jSeparator1 = new javax.swing.JSeparator();
        headerPanelUpdate = new javax.swing.JPanel();
        headingUpd = new javax.swing.JLabel();
        iconUpd = new javax.swing.JLabel();
        bodyPanelUpdate = new javax.swing.JPanel();
        txtUpd1 = new javax.swing.JLabel();
        txtUpd2 = new javax.swing.JLabel();
        comboBoxUpdate = new javax.swing.JComboBox<>();
        IDFieldUpdate = new javax.swing.JTextField();
        facFieldUpdate = new javax.swing.JTextField();
        txtUpd3 = new javax.swing.JLabel();
        titleFieldUpdate = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        headerPanelUpdate.setBackground(new java.awt.Color(0, 0, 0));

        headingUpd.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        headingUpd.setForeground(new java.awt.Color(255, 255, 255));
        headingUpd.setText("Course");

        iconUpd.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        iconUpd.setForeground(new java.awt.Color(255, 255, 255));
        iconUpd.setText("↑");

        javax.swing.GroupLayout headerPanelUpdateLayout = new javax.swing.GroupLayout(headerPanelUpdate);
        headerPanelUpdate.setLayout(headerPanelUpdateLayout);
        headerPanelUpdateLayout.setHorizontalGroup(
                headerPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerPanelUpdateLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(headingUpd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(iconUpd)
                                .addGap(34, 34, 34))
        );
        headerPanelUpdateLayout.setVerticalGroup(
                headerPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerPanelUpdateLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(headerPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(headingUpd)
                                        .addComponent(iconUpd))
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        bodyPanelUpdate.setBackground(new java.awt.Color(204, 204, 204));

        txtUpd1.setText("Enter ID");

        txtUpd2.setText("Enter new FacultyID ");

        comboBoxUpdate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"FacultyID", "Title"}));

        txtUpd3.setText("Enter new Title");

        updateButton.setText("Update!");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bodyPanelUpdateLayout = new javax.swing.GroupLayout(bodyPanelUpdate);
        bodyPanelUpdate.setLayout(bodyPanelUpdateLayout);
        bodyPanelUpdateLayout.setHorizontalGroup(
                bodyPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyPanelUpdateLayout.createSequentialGroup()
                                .addContainerGap(253, Short.MAX_VALUE)
                                .addComponent(comboBoxUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(236, 236, 236))
                        .addGroup(bodyPanelUpdateLayout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addGroup(bodyPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtUpd2)
                                        .addComponent(txtUpd3)
                                        .addComponent(txtUpd1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(bodyPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(updateButton)
                                        .addGroup(bodyPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(titleFieldUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                                .addComponent(facFieldUpdate)
                                                .addComponent(IDFieldUpdate)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bodyPanelUpdateLayout.setVerticalGroup(
                bodyPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(bodyPanelUpdateLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(bodyPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtUpd1)
                                        .addComponent(IDFieldUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(bodyPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtUpd2)
                                        .addComponent(facFieldUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(bodyPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtUpd3)
                                        .addComponent(titleFieldUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(comboBoxUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(updateButton)
                                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(headerPanelUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bodyPanelUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(headerPanelUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bodyPanelUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    @Override
    public void deleteFrame() {
        
        HeaderDelete = new javax.swing.JPanel();
        headerDelete = new javax.swing.JLabel();
        headerDeleteIcon = new javax.swing.JLabel();
        bodyPanelDelete = new javax.swing.JPanel();
        enterIdDelete = new javax.swing.JLabel();
        idFieldDelete = new javax.swing.JTextField();
        deleteButtonSubmit = new javax.swing.JButton();
        goldSeperator = new javax.swing.JPanel();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        HeaderDelete.setBackground(new java.awt.Color(0, 0, 0));

        headerDelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        headerDelete.setForeground(new java.awt.Color(255, 255, 255));
        headerDelete.setText("Delete Course");

        headerDeleteIcon.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        headerDeleteIcon.setForeground(new java.awt.Color(255, 255, 255));
        headerDeleteIcon.setText("—");

        javax.swing.GroupLayout HeaderDeleteLayout = new javax.swing.GroupLayout(HeaderDelete);
        HeaderDelete.setLayout(HeaderDeleteLayout);
        HeaderDeleteLayout.setHorizontalGroup(
            HeaderDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderDeleteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headerDeleteIcon)
                .addGap(23, 23, 23))
        );
        HeaderDeleteLayout.setVerticalGroup(
            HeaderDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderDeleteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(HeaderDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(headerDelete)
                    .addComponent(headerDeleteIcon))
                .addContainerGap())
        );

        bodyPanelDelete.setBackground(new java.awt.Color(204, 204, 204));

        enterIdDelete.setBackground(new java.awt.Color(51, 51, 51));
        enterIdDelete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        enterIdDelete.setText("Enter ID:");
        enterIdDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        deleteButtonSubmit.setText("Delete");
        deleteButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bodyPanelDeleteLayout = new javax.swing.GroupLayout(bodyPanelDelete);
        bodyPanelDelete.setLayout(bodyPanelDeleteLayout);
        bodyPanelDeleteLayout.setHorizontalGroup(
            bodyPanelDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelDeleteLayout.createSequentialGroup()
                .addGroup(bodyPanelDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyPanelDeleteLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(enterIdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idFieldDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bodyPanelDeleteLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(deleteButtonSubmit)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        bodyPanelDeleteLayout.setVerticalGroup(
            bodyPanelDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelDeleteLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(bodyPanelDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterIdDelete)
                    .addComponent(idFieldDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(deleteButtonSubmit)
                .addGap(58, 58, 58))
        );

        goldSeperator.setBackground(new java.awt.Color(255, 255, 102));
        goldSeperator.setForeground(new java.awt.Color(255, 255, 102));

        javax.swing.GroupLayout goldSeperatorLayout = new javax.swing.GroupLayout(goldSeperator);
        goldSeperator.setLayout(goldSeperatorLayout);
        goldSeperatorLayout.setHorizontalGroup(
            goldSeperatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        goldSeperatorLayout.setVerticalGroup(
            goldSeperatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HeaderDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bodyPanelDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(goldSeperator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(HeaderDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(goldSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(bodyPanelDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

//<editor-fold defaultstate="collapsed" desc="Create Variables">
    // Create Variables
    private javax.swing.JPanel HeaderPanelCreate;
    private javax.swing.JComboBox<String> comboBoxSemester;
    private javax.swing.JLabel facTxtCreate;
    private javax.swing.JTextField fieldFacId;
    private javax.swing.JTextField fieldId;
    private javax.swing.JTextField fieldName;
    private javax.swing.JLabel headingTxt;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JLabel idTxtCreate;
    private javax.swing.JPanel mainPanelCreate;
    private javax.swing.JLabel nameTxtCreate;
    private javax.swing.JLabel semesterTxtCreate;
    private javax.swing.JButton submitCreateButton;
    // End of variables declaration
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Create Operations">

    // Create Operations:
    private void submitCreateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Object comboBoxSelected = comboBoxSemester.getModel().getSelectedItem();
        String semester = (comboBoxSelected.equals("Semester I")) ? "1"
                : (comboBoxSelected.equals("Semester II")) ? "2"
                : (comboBoxSelected.equals("Semester III")) ? "3"
                : (comboBoxSelected.equals("Semester IV")) ? "4"
                : (comboBoxSelected.equals("Semester V")) ? "5"
                : (comboBoxSelected.equals("Semester VI")) ? "6"
                : (comboBoxSelected.equals("Semester VII")) ? "7"
                : (comboBoxSelected.equals("Semester VIII")) ? "8" : null;

        POJOClasses.Course course = new POJOClasses.Course(Integer.parseInt(fieldId.getText()), fieldName.getText(), DAOClasses.Faculty.getFaculty(Integer.parseInt(fieldFacId.getText())), semester);

        try {
            DAOClasses.DAOFactory.createDAO("COURSE").insert(course);
            JOptionPane.showMessageDialog(this, "Successfully added the course.");

        } catch (ParameterTypeException e) {
            e.printStackTrace();
        }

    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Read Vars">
    private javax.swing.JLabel IconCreateCourse;
    private javax.swing.JLabel courseHeading;
    private javax.swing.JTable courseTable;
    private javax.swing.JTextField facFieldSort;
    private javax.swing.JPanel headingCreate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton refreshButton;
    private javax.swing.JScrollPane scrollCreate;
    private javax.swing.JButton sortFacButton;
    private javax.swing.JButton sortSemButton;
    private javax.swing.JTextField sortSemField;
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Read Operations">
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {
        clearTable();

        try {
            addRowToJTable();
        } catch (ParameterTypeException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param objectList
     * @throws ParameterTypeException
     * used for sorted tables, the parameter comes from a select query based DAO
     */
    public void addRowToJTable(ArrayList<Object> objectList) throws ParameterTypeException {
        DefaultTableModel model = (DefaultTableModel) courseTable.getModel();
        Object[] rowData = new Object[4];
        for (int i = 0; i < objectList.size(); i++) {
            rowData[0] = ((POJOClasses.Course) objectList.get(i)).getCourseid();
            rowData[1] = ((POJOClasses.Course) objectList.get(i)).getTitle();
            rowData[2] = ((POJOClasses.Course) objectList.get(i)).getFaculty().getFacultyid();
            rowData[3] = ((POJOClasses.Course) objectList.get(i)).getSemester();
            model.addRow(rowData);
        }
    }

    /**
     *
     * @throws ParameterTypeException
     * gets All data from db using DAO and assigns to the table model
     */
    public void addRowToJTable() throws ParameterTypeException {
        DefaultTableModel model = (DefaultTableModel) courseTable.getModel();
        Object[] rowData = new Object[4];
        DAO daoCourses = DAOClasses.DAOFactory.createDAO("Course");
        try {
            ArrayList<Object> coursesObj = daoCourses.select("", "ALL");
            for (int i = 0; i < coursesObj.size(); i++) {
                rowData[0] = ((POJOClasses.Course) coursesObj.get(i)).getCourseid();
                rowData[1] = ((POJOClasses.Course) coursesObj.get(i)).getTitle();
                rowData[2] = ((POJOClasses.Course) coursesObj.get(i)).getFaculty().getFacultyid();
                rowData[3] = ((POJOClasses.Course) coursesObj.get(i)).getSemester();
                model.addRow(rowData);
            }

        } catch (ParameterTypeException ex) {
            ex.printStackTrace();
        }

    }

    public void clearTable() {
        DefaultTableModel dm = (DefaultTableModel) courseTable.getModel();
        dm.getDataVector().removeAllElements();
        revalidate();
    }

    private void sortFacButtonActionPerformed(java.awt.event.ActionEvent evt) {
        clearTable();
        int id = Integer.parseInt(facFieldSort.getText());

        try {
            DAO daoCourses = DAOClasses.DAOFactory.createDAO("Course");
            addRowToJTable(daoCourses.select(id, "Faculty"));

        } catch (ParameterTypeException e) {
            e.printStackTrace();
        }
    }

    private void sortSemButtonActionPerformed(java.awt.event.ActionEvent evt) {
        clearTable();
        String semester = sortSemField.getText();

        try {
            DAO daoCourses = DAOClasses.DAOFactory.createDAO("Course");
            addRowToJTable(daoCourses.select(semester, "SEMESTER"));

        } catch (ParameterTypeException e) {
            e.printStackTrace();
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Update Vars">
    private javax.swing.JTextField IDFieldUpdate;
    private javax.swing.JPanel bodyPanelUpdate;
    private javax.swing.JComboBox<String> comboBoxUpdate;
    private javax.swing.JTextField facFieldUpdate;
    private javax.swing.JPanel headerPanelUpdate;
    private javax.swing.JLabel headingUpd;
    private javax.swing.JLabel iconUpd;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField titleFieldUpdate;
    private javax.swing.JLabel txtUpd1;
    private javax.swing.JLabel txtUpd2;
    private javax.swing.JLabel txtUpd3;
    private javax.swing.JButton updateButton;
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Update Operations">

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int id = Integer.parseInt(IDFieldUpdate.getText());
        DAO daoCourses = DAOClasses.DAOFactory.createDAO("COURSE");

        if (comboBoxUpdate.getModel().getSelectedItem().equals("FacultyID")) {

            String COLUMN = "FACULTY";
            int newId = Integer.parseInt(facFieldUpdate.getText());

            try {
                daoCourses.update(id, COLUMN, newId);
                JOptionPane.showMessageDialog(this, "You have successfully changed the FacultyID!");
            } catch (ParameterTypeException ex) {
                ex.printStackTrace();
            }
        } else {
            String COLUMN = "TITLE";
            String newTitle = titleFieldUpdate.getText();

            try {
                daoCourses.update(id, COLUMN, newTitle);
                JOptionPane.showMessageDialog(this, "You have successfully changed the TITLE!");
            } catch (ParameterTypeException e) {
                e.printStackTrace();
            }
        }
    }

//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Delete Operations">
    
    private void deleteButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
            int id = Integer.parseInt(idFieldDelete.getText());
            DAOClasses.DAO daoCourses = DAOClasses.DAOFactory.createDAO("Course");
            ArrayList<Object> selected = daoCourses.select(id, "ID");
            daoCourses.delete(selected.get(0));
            JOptionPane.showMessageDialog(this, "Successfully deleted course at ID:" + id);
        } catch (ParameterTypeException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Delete Vars">
    private javax.swing.JPanel HeaderDelete;
    private javax.swing.JPanel bodyPanelDelete;
    private javax.swing.JButton deleteButtonSubmit;
    private javax.swing.JLabel enterIdDelete;
    private javax.swing.JPanel goldSeperator;
    private javax.swing.JLabel headerDelete;
    private javax.swing.JLabel headerDeleteIcon;
    private javax.swing.JTextField idFieldDelete;
//</editor-fold>
}
