import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JTextField;

public class DatabaseGui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatabaseGui window = new DatabaseGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DatabaseGui() {
		initialize();
	}
	
	JdbcStudentDao dao = new JdbcStudentDao(); // initializes the dao used to call all the functions in JdbcStudentDao
	JdbcInstructorDao instDao = new JdbcInstructorDao(); 	// same for an instructor
	Object[] rowAdd = new Object[6]; // an empty array used to add the values entered into the text files into the database
	private JTable table;
	private JScrollPane scrollPane;
	private JButton createStud;
	private JButton updateStud;
	private JButton deleteStud;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(148, 192, 216));
		frame.setBackground(new Color(240, 240, 240));
		frame.setForeground(new Color(128, 128, 192));
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.getContentPane().setLayout(null);
		
		JButton allStudents = new JButton("Get Students"); 	// the "Get Students" button runs the code below
		allStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel)table.getModel(); // new model to add rows to the GUI display
				for (int i = 0; i<dao.allStudents().size(); i++) { // for all students get the info below
					rowAdd[0] = dao.allStudents().get(i).id;
					rowAdd[1] = dao.allStudents().get(i).name;
					rowAdd[2] = dao.allStudents().get(i).major;
					rowAdd[3] = dao.allStudents().get(i).credits;
					rowAdd[4] = dao.getInst(dao.allStudents().get(i)).getName();
					rowAdd[5] = dao.getGpa(dao.allStudents().get(i));
					
					model.addRow(rowAdd); // and add it to the GUI
				} 
			}
		});
		allStudents.setBounds(41, 243, 149, 61);
		frame.getContentPane().add(allStudents);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(225, 11, 483, 500);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Name", "Major", "Credits", "Advisor", "GPA"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Integer.class, Object.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		createStud = new JButton("Create Student"); 	// the "create student" button runs the code below
		createStud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") || textField_3.getText().equals("") || textField_4.getText().equals("") || textField_5.getText().equals("")) {
					JOptionPane.showMessageDialog(null,  "Please fill out all fields"); 	// if any of the textfields are empty, dont allow and send a message
				} else { 	//if all fields are filled, run
					Student s = new Student(); 	// temp student that will be added to the db
					s.setId(Integer.valueOf(textField.getText())); 	// set their data to what was inputed in the text fields
					s.setName(textField_1.getText());
					s.setMajor(textField_2.getText());
					s.setCredits(Integer.valueOf(textField_3.getText()));
					s.setGpa(Double.parseDouble(textField_5.getText()));
					
					Instructor i = new Instructor(); // create a new instructor and set them as the students advisor based on the text field
					i.setName(textField_4.getText());
					instDao.createInst(i); 	// and creates the instructor in the database
					
					s.setAdvisor(i);
					
					dao.createStudent(s); 	// create the student in the db
					
					DefaultTableModel model = (DefaultTableModel)table.getModel(); 	// add the student to the display
					rowAdd[0] = s.getId();
					rowAdd[1] = s.getName();
					rowAdd[2] = s.getMajor();
					rowAdd[3] = s.getCredits();
					rowAdd[4] = s.getAdvisor().getName();
					rowAdd[5] = s.getGpa();
					
					model.addRow(rowAdd);
					
					textField.setText(""); 	// blank the textfields
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					
					System.out.println("Successfully added");
					
				}
				
			}
		});
		createStud.setBounds(41, 660, 149, 61);
		frame.getContentPane().add(createStud);
		
		updateStud = new JButton("Update Student"); 	// the "update student" button runs the code below
		updateStud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") || textField_3.getText().equals("") || textField_4.getText().equals("") || textField_5.getText().equals("")) {
					JOptionPane.showMessageDialog(null,  "Please fill out all fields"); 	// if any of the text fields are empty, dont allow and throw message
				} else {
					
					Student s = new Student(); 	// temp student
					s = dao.getStudent(Integer.valueOf(textField.getText())); // get the student with the inputed id
					
					s.setName(textField_1.getText()); 	// set these values
					s.setMajor(textField_2.getText());
					s.setCredits(Integer.valueOf(textField_3.getText()));
					s.setGpa(Double.parseDouble(textField_5.getText()));
					
					Instructor i = new Instructor(); 	// set this new instructor to the student
					i.setName(textField_4.getText());
					
					s.setAdvisor(i);
					
					dao.updateStudent(s);
					
					System.out.println("Updated. Please select Get Students again to show changes");
					
					textField.setText(""); 		// empty the text fields
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
				}
			}
		});
		updateStud.setBounds(635, 660, 149, 61);
		frame.getContentPane().add(updateStud);
		
		// the delete student function is not running. action listener is broken
		deleteStud = new JButton("Delete Student"); 	// the "delete student" button runs the code below
		deleteStud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,  "Please input an ID"); 	// if the ID text field is empty, dont allow and throw message
				} else {
					
					dao.deleteStudent(Integer.valueOf(textField.getText())); // delete the student with the inputed id
					
					textField.setText(""); 	// blank the text fields
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					
					System.out.println("Deleted. Select Get Students to see new data");
				}
			}
		});
			
		deleteStud.setBounds(341, 660, 149, 61);
		frame.getContentPane().add(deleteStud);
		
		JLabel studInfo = new JLabel("Please enter the student information below to create, delete, or update a student in the database");
		studInfo.setBackground(Color.WHITE);
		studInfo.setForeground(new Color(0, 0, 0));
		studInfo.setBounds(158, 541, 483, 33);
		frame.getContentPane().add(studInfo);
		
		// the text fields stopped working when I changed the names, so i left them with their default
		// I realize text field 0-4 is horrible naming and it definitely messed me up a couple times
		// I tried fixing it to no avail
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setBounds(41, 588, 49, 14);
		frame.getContentPane().add(idLabel);
		
		textField = new JTextField();
		textField.setBounds(94, 585, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(41, 635, 49, 14);
		frame.getContentPane().add(nameLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(94, 629, 96, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel majorLabel = new JLabel("Major");
		majorLabel.setBounds(288, 588, 49, 14);
		frame.getContentPane().add(majorLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(341, 585, 96, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel credLabel = new JLabel("Credits");
		credLabel.setBounds(288, 635, 49, 14);
		frame.getContentPane().add(credLabel);
		
		textField_3 = new JTextField();
		textField_3.setBounds(341, 632, 96, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel advisorLabel = new JLabel("Advisor");
		advisorLabel.setBounds(582, 588, 49, 14);
		frame.getContentPane().add(advisorLabel);
		
		textField_4 = new JTextField();
		textField_4.setBounds(641, 585, 96, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel gpaLabel = new JLabel("GPA");
		gpaLabel.setBounds(582, 635, 49, 14);
		frame.getContentPane().add(gpaLabel);
		
		textField_5 = new JTextField();
		textField_5.setBounds(641, 632, 96, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		frame.setBounds(100, 100, 808, 769);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}