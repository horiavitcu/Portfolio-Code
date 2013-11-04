package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.openqa.selenium.WebElement;

import base.ClassOne;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class ClassOneGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEnterSearch;
	
	static ClassOne classOne;
	static ClassOneGUI frame;
    static String URL1 = "http://www.ebay.co.uk/";
    private JButton btnWriteToFile;
    private List<WebElement> arrayToBeWritten;
    private JButton btnOpenFile;
    private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new ClassOneGUI();   // initialize frame
					 frame.setVisible(true);	  // set frame visible
					 
					classOne = new ClassOne(); 	  //initialize functionality class
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClassOneGUI() {
		setTitle("Title description saver");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Title Description Saver");
		lblNewJgoodiesLabel.setBounds(6, 6, 142, 16);
		contentPane.add(lblNewJgoodiesLabel);
		
		txtEnterSearch = new JTextField();
		txtEnterSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEnterSearch.setText(null);
			}
		});
		txtEnterSearch.setBounds(6, 34, 193, 28);
		txtEnterSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtEnterSearch.setText("Enter Search");
		contentPane.add(txtEnterSearch);
		txtEnterSearch.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(6, 74, 193, 29);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classOne.openSite(URL1);
				classOne.findElementXpath("input", "id", "gh-ac");
				
				classOne.typeInSearch(txtEnterSearch.getText());
				arrayToBeWritten = classOne.readElements("div", "class", "ittl"); 
				
				//classOne.closeSite();
			}
		});
		contentPane.add(btnSubmit);
		
		btnWriteToFile = new JButton("Write to File");
		btnWriteToFile.setBounds(6, 126, 193, 29);
		btnWriteToFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser saveFile = new JFileChooser();
				//saveFile.showSaveDialog(null);
				if (saveFile.showSaveDialog(null) ==  JFileChooser.APPROVE_OPTION) {
					classOne.setFileLocation(saveFile.getSelectedFile());
					classOne.writeFile(arrayToBeWritten);
				}
			}
		});
		
		textArea = new JTextArea();
		textArea.setBounds(216, 16, 217, 256);
		JScrollPane scroll = new JScrollPane(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);
		contentPane.add(textArea);
		contentPane.add(btnWriteToFile);
		
		btnOpenFile = new JButton("Open File");
		btnOpenFile.setBounds(6, 167, 193, 29);
		btnOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					JFileChooser openFile = new JFileChooser();
					
					openFile.showOpenDialog(null);
					FileReader reader;
					try {
						reader = new FileReader(openFile.getSelectedFile());
						textArea.read(reader, openFile.getSelectedFile());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		contentPane.add(btnOpenFile);
	}
}
