/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Mustafa
 */
public class Student extends DAO {

    @Override
    public void insert(Object o) throws ParameterTypeException {
        if (o instanceof POJOClasses.Student) {
            Connection con = null;
            PreparedStatement prepState = null;

            try {
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                String query = "INSERT INTO Student (`ID`, `NAME`, `SEMESTER`, `DEPARTMENT`) VALUES (?, ?, ?, ?)";
                prepState = con.prepareStatement(query);

                prepState.setInt(1, ((POJOClasses.Student) o).getStudentId());
                prepState.setString(2, ((POJOClasses.Student) o).getName());
                prepState.setString(3, ((POJOClasses.Student) o).getSemester());
                prepState.setString(4, ((POJOClasses.Student) o).getDepartment());

                prepState.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (con != null) {
                    try {
                        con.close();
                        prepState.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            throw new ParameterTypeException();
        }

    }

    @Override
    public void delete(Object o) throws ParameterTypeException {
        Connection con = null;
        PreparedStatement prepState = null;
        if (o instanceof POJOClasses.Student) {
            try {
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                String query = "DELETE FROM Student WHERE `ID` = '" + ((POJOClasses.Student) o).getStudentId() + "'";
                prepState = con.prepareStatement(query);
                prepState.execute();

            } catch (SQLException e) {

            }
        } else {
            throw new ParameterTypeException();
        }
    }

    @Override
    public ArrayList<Object> select(Object o1, Object o2) throws ParameterTypeException {
        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;
        String query = null;
        ArrayList<Object> studentList = new ArrayList<>();
        boolean whereSemester = o2 instanceof String && ((String) o2).equalsIgnoreCase("SEMESTER") && o1 instanceof String;
        boolean whereDepartment = o2 instanceof String && ((String) o2).equalsIgnoreCase("DEPARTMENT") && o1 instanceof String;
        boolean whereID = o2 instanceof String && ((String) o2).equalsIgnoreCase("ID") && o1 instanceof Integer;
        boolean whereAll = o2 instanceof String && ((String) o2).equalsIgnoreCase("ALL") && o1 instanceof String;
        if (whereSemester) {
            query = "SELECT * FROM Student WHERE SEMESTER = '" + o1 + "'";
        } else if (whereDepartment) {
            query = "SELECT * FROM Student WHERE Department = '" + o1 + "'";
        } else if (whereID) {
            query = "SELECT * FROM Student WHERE ID = '" + o1 + "'";
        } else if (whereAll) {
            query = "SELECT * FROM Student";
        } else {
            throw new ParameterTypeException();
        }

        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = con.createStatement();

            rs = statement.executeQuery(query);

            while (rs.next()) {
                Object std = new POJOClasses.Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                studentList.add(std);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (studentList != null) {
            return studentList;
        }
        return null;
    }

    @Override
    public void update(Object key, Object column, Object newValue) throws ParameterTypeException {
        Connection con = null;
        Statement statement = null;
        String query = null;

        boolean updateSemester = column instanceof String && ((String) column).equalsIgnoreCase("Semester") && key instanceof Integer && newValue instanceof String;
        boolean updateName = column instanceof String && ((String) column).equalsIgnoreCase("Name") && key instanceof Integer && newValue instanceof String;

        if (updateSemester) {
            query = "UPDATE STUDENT SET `Semester` = '" + newValue + "'" + "WHERE ID = " + "'" + key + "'";
        } else if (updateName) {
            query = "UPDATE  STUDENT SET `NAME` = '" + newValue + "'" + "WHERE ID = '" + key + "'";
        } else {
            throw new ParameterTypeException();
        }

        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = con.createStatement();
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
