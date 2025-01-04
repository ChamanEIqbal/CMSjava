package DAOClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Course extends DAO {

    @Override
    public void insert(Object o) throws ParameterTypeException {

        if (o instanceof POJOClasses.Course) {
            Connection connection = null;
            PreparedStatement preparedStatement = null;

            try {

                // connection
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                // Prepared statement
                String insertQuery = "INSERT INTO  COURSE (`ID`, `Title`, `FacultyID`, `Semester`) VALUES (?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(insertQuery);

                // give value from parameter to ? ?
                preparedStatement.setInt(1, ((POJOClasses.Course) o).getCourseid());
                preparedStatement.setString(2, ((POJOClasses.Course) o).getTitle());
                preparedStatement.setInt(3, ((POJOClasses.Course) o).getFaculty().getFacultyid());
                preparedStatement.setString(4, ((POJOClasses.Course) o).getSemester());

                // Executing
                preparedStatement.execute();

            } catch (SQLException e) {
                System.out.println("Error executing insert statement: " + e.getMessage());
            } finally {
                // Closing if not null
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            // throw exception if instaceof condiiton returns false
            throw new ParameterTypeException();
        }
    }

    @Override
    public void delete(Object o) throws ParameterTypeException {
        if (o instanceof POJOClasses.Course) {
            Connection con = null;
            PreparedStatement prepState = null;

            try {
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                // Prepare the SQL query to delete a course based on its ID
                String query = "DELETE FROM `course` WHERE `ID` = ?";

                // Create a prepared statement and set the parameter to the course ID
                prepState = con.prepareStatement(query);
                prepState.setInt(1, ((POJOClasses.Course) o).getCourseid());
                // Execute the delete statement
                prepState.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (prepState != null && con != null) {
                    try {
                        // Close the prepared statement and the connection
                        prepState.close();
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            // Throw an exception if the input parameter is not of type POJOClasses.Course
            throw new ParameterTypeException();
        }
    }

    @Override
    public ArrayList<Object> select(Object o1, Object o2) throws ParameterTypeException {
        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;
        String query = null;

        // Check the conditions for different query types
        boolean whereSemester = o2 instanceof String && ((String) o2).equalsIgnoreCase("SEMESTER") && o1 instanceof String;
        boolean whereTitle = o2 instanceof String && ((String) o2).equalsIgnoreCase("TITLE") && o1 instanceof String;
        boolean whereAll = o2 instanceof String && ((String) o2).equalsIgnoreCase("ALL") && o1 instanceof String;
        boolean whereFacultyId = o2 instanceof String && ((String) o2).equalsIgnoreCase("FACULTY") && o1 instanceof Integer;
        boolean whereID = o2 instanceof String && ((String) o2).equalsIgnoreCase("ID") && o1 instanceof Integer;

        // Generate the query based on the conditions
        if (whereSemester) {
            query = "SELECT * FROM COURSE WHERE SEMESTER = '" + o1 + "'";
        } else if (whereTitle) {
            query = "SELECT * FROM COURSE WHERE TITLE = '" + o1 + "'";
        } else if (whereAll) {
            query = "SELECT * FROM COURSE";
        } else if (whereFacultyId) {
            query = "SELECT * FROM COURSE WHERE FacultyID = '" + o1 + "'";
        } else if (whereID) {
            query = "SELECT * FROM COURSE WHERE ID = '" + o1 + "'";
        } else {
            // Throw an exception if none of the conditions are met
            throw new ParameterTypeException();
        }

        ArrayList<Object> courseList = new ArrayList<>();
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            statement = con.createStatement();

            // Execute the query and retrieve the result set & Shorthanding null, if query is null
            rs = (query != null) ? statement.executeQuery(query) : null;

            while (rs.next()) {
                // Create a new Course object from the result set and add it to the courseList
                Object course = new POJOClasses.Course(rs.getInt(1), rs.getString(2), DAOClasses.Faculty.getFaculty(rs.getInt(3)), rs.getString(4));
                courseList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (courseList != null) {
                // Return the courseList if it is not null
                return courseList;
            }
        }

        // Return null if courseList is null
        return null;
    }

    @Override
    public void update(Object key, Object column, Object newValue) throws ParameterTypeException {
        Connection con = null;
        Statement statement = null;
        String query = null;

        boolean changeFaculty = column instanceof String && ((String) column).equalsIgnoreCase("FACULTY") && key instanceof Integer && newValue instanceof Integer;
        boolean changeTitle = column instanceof String && ((String) column).equalsIgnoreCase("Title") && key instanceof Integer && newValue instanceof String;

        query = (changeFaculty) ? "UPDATE COURSE SET FacultyID = '" + newValue + "'" + "WHERE ID = '" + key + "'"
                : (changeTitle) ? "UPDATE COURSE SET TITLE = '" + newValue + "'" + "WHERE ID = '" + key + "'" : null;
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = con.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null && statement != null) {
                    con.close();
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
