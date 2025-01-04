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
public class Faculty extends DAO {

    // static DAO methods are used to avoid instantiation, and achieve correlation in between classes
    public static POJOClasses.Faculty getFaculty(int facultyID) {
        Connection connection = null;
        PreparedStatement prepState = null;
        int id = 0;
        String name = null;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String query = "SELECT * FROM Faculty WHERE FacultyID = ?";

            prepState = connection.prepareStatement(query);
            prepState.setInt(1, facultyID);
            ResultSet rSet = prepState.executeQuery();

            while (rSet.next()) {
                id = rSet.getInt(1);
                name = rSet.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        POJOClasses.Faculty faculty = new POJOClasses.Faculty(id, name);

        if (id != 0 && name != null) {
            return faculty;
        }
        return null;
    }

    @Override
    public void insert(Object o) throws ParameterTypeException {
        if (o instanceof POJOClasses.Faculty) {
            Connection connection = null;
            PreparedStatement prepState = null;

            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                String query = "INSERT INTO Faculty (`FacultyID`, `Name`) VALUES (?,?)";

                prepState = connection.prepareStatement(query);

                prepState.setInt(1, ((POJOClasses.Faculty) o).getFacultyid());
                prepState.setString(2, ((POJOClasses.Faculty) o).getName());

                prepState.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (prepState != null && connection != null) {
                        prepState.close();
                        connection.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } else {
            throw new ParameterTypeException();
        }
    }

    @Override
    public void delete(Object o) throws ParameterTypeException {
        Connection con = null;
        Statement statement = null;
        if (o instanceof POJOClasses.Faculty) {
            try {
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                String query = "DELETE FROM Faculty WHERE facultyID = " + ((POJOClasses.Faculty) o).getFacultyid();
                statement = con.createStatement();
                statement.execute(query);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    con.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            throw new ParameterTypeException();
        }
    }

    @Override
    public ArrayList<Object> select(Object o1, Object o2) throws ParameterTypeException {
        boolean selectAll = o2 instanceof String && ((String) o2).equalsIgnoreCase("ALL") && o1 instanceof String;
        boolean selectID = o2 instanceof String && ((String) o2).equalsIgnoreCase("ID") && o1 instanceof Integer;
        String query = null;
        Connection con = null;
        Statement statement = null;
        ArrayList<Object> facultyList = new ArrayList<>();

        if (selectAll) {
            query = "SELECT * FROM FACULTY";
        } else if (selectID) {
            query = "SELECT * FROM FACULTY WHERE facultyID = '" + o1 + "'";
        } else {
            throw new ParameterTypeException();
        }
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            statement = con.createStatement();

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                Object faculty = new POJOClasses.Faculty(rs.getInt(1), rs.getString(2));
                facultyList.add(faculty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (query != null) {
                return facultyList;
            }
        }
        return null;
    }

    @Override
    public void update(Object key, Object column, Object newValue) throws ParameterTypeException {
        Connection con = null;
        Statement statement = null;
        String query = null;
        if (column instanceof String && ((String) column).equalsIgnoreCase("Name") && key instanceof Integer && newValue instanceof String) {
            query = "UPDATE FACULTY SET `Name` = '" + newValue + "' WHERE facultyID = '" + key + "'";
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
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
