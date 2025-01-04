package coursemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CourseManagementSystem extends JFrame {

    private JLabel headingLabel;
    private JLabel[] labels;
    private JTextField[] textFields;
    private JButton submitButton;
    private JTextArea outputArea;
    private JTable table;
    private JScrollPane tableScrollPane;
    private ArrayList<String> labelContent = new ArrayList();

    private int numFields;
    private boolean includeTable;

    public CourseManagementSystem(int numFields, ArrayList<String> string, boolean includeTable) {
        this.numFields = numFields;
        this.includeTable = includeTable;
        string.forEach(x -> {
            labelContent.add(x);
        });

        initializeComponents();
        createLayout();

        setTitle("Course Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeComponents() {
        // Set frame icon
        ImageIcon icon = new ImageIcon("iconsmall.png");
        setIconImage(icon.getImage());
        ImageIcon iconhd = new ImageIcon("icon.png");

        // Create components
        headingLabel = new JLabel();
        headingLabel.setIcon(iconhd);
        labels = new JLabel[numFields];
        textFields = new JTextField[numFields];
        submitButton = new JButton("Submit");
        outputArea = new JTextArea();
        outputArea.setEditable(false);

        if (includeTable) {
            table = new JTable();
            tableScrollPane = new JScrollPane(table);
        }

        submitButton.addActionListener((ActionEvent e) -> {
            try {
                submitButtonClicked();
            } catch (IOException ex) {
                Logger.getLogger(CourseManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        // Set component styles
        submitButton.setForeground(Color.BLACK);
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));

        getContentPane().setBackground(new Color(0xFFFFFF));

    }

    private void createLayout() {
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(headingLabel);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 10, 5, 10); // Set margin for labels and text fields
        for (int i = 0; i < numFields; i++) {
            labels[i] = new JLabel(labelContent.get(i) + ": ");
            textFields[i] = new JTextField(20);
            setTextFieldBackgroundText(textFields[i], "Enter your " + labelContent.get(i));

            gbc.gridx = 0;
            gbc.gridy = i;
            centerPanel.add(labels[i], gbc);

            gbc.gridx = 1;
            gbc.gridy = i;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.weightx = 1.0;
            textFields[i].setPreferredSize(new Dimension(200, 20)); // Set desired height for text fields
            centerPanel.add(textFields[i], gbc);
        }

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(submitButton);
        bottomPanel.add(outputArea);

        if (includeTable) {
            bottomPanel.add(tableScrollPane, BorderLayout.SOUTH);
        }

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void submitButtonClicked() throws IOException {
        // Perform database operations or display output based on user input
        // Replace this with your actual logic

        //      String outputText = "Logged In";
        //      outputArea.setText(outputText);
        //     outputArea.setForeground(Color.black);
        //    outputArea.setBackground(Color.white);
        String username = textFields[0].getText();
        String password = textFields[1].getText();
        boolean isadmin = Filing.verifyPassword(username, password);
        System.out.println(isadmin);
        if (isadmin) {
            outputArea.setText("Login successful!");
            outputArea.setForeground(Color.GREEN);
            textFields[1].setBorder(BorderFactory.createLineBorder(Color.GREEN));
            textFields[0].setBorder(BorderFactory.createLineBorder(Color.GREEN));

            JOptionPane.showMessageDialog(this, "You've Logged in as: " + username);

            EventQueue.invokeLater(() -> {
                new AdminWorkplace("Workplace").setVisible(true);
            });

        } else {
            outputArea.setText("Invalid username or password.");
            outputArea.setForeground(Color.RED);
            textFields[1].setBorder(BorderFactory.createLineBorder(Color.RED));
            textFields[0].setBorder(BorderFactory.createLineBorder(Color.RED));
        }
    }

    private void setTextFieldBackgroundText(JTextField textField, String backgroundText) {

        textField.setBackground(new Color(254, 254, 254));
        textField.setText(backgroundText);
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(backgroundText)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(backgroundText);
                    textField.setForeground(Color.GRAY);
                }
            }
        });
    }

    public CourseManagementSystem() throws HeadlessException {
    }

    public static void main(String[] args) {
        //<editor-fold defaultstate="collapsed" desc="Look and Feel">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("FlatLaf Light".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CourseManagementSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseManagementSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseManagementSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseManagementSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
//</editor-fold>
        EventQueue.invokeLater(() -> {
            // Login Admin
            ArrayList<String> login = new ArrayList();
            login.add("Email or Username");
            login.add("Password");

            JFrame admin = new CourseManagementSystem(2, login, false); // Example usage
            // Menu Admin
        });
    }
}
