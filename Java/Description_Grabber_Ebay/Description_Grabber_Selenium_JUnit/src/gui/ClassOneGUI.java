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
import javax.swing.ScrollPaneConstants;

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
    private List<WebElement> arrayToBeWritten;
    private JButton btnOpenFile;
    private JTextArea txtrEnterSearch;
    private JScrollPane scrollPane;

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
		setBounds(100, 100, 1000, 600);
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
		
		JButton btnSubmit = new JButton("Submit Search");
		btnSubmit.setBounds(6, 74, 193, 29);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classOne.openSite(URL1);
				classOne.findElementXpath("input", "id", "gh-ac");
				
				classOne.typeInSearch(txtEnterSearch.getText());
				arrayToBeWritten = classOne.readElements("div", "class", "ittl"); 
				JFileChooser saveFile = new JFileChooser();
				
				//saveFile.showSaveDialog(null);
				if (saveFile.showSaveDialog(null) ==  JFileChooser.APPROVE_OPTION) {
					classOne.setFileLocation(saveFile.getSelectedFile());
					classOne.writeFile(arrayToBeWritten);
				}
				//classOne.closeSite();
			}
		});
		contentPane.add(btnSubmit);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(211, 6, 783, 566);
		contentPane.add(scrollPane);
		txtrEnterSearch = new JTextArea();
		scrollPane.setViewportView(txtrEnterSearch);
		txtrEnterSearch.setText("1) Enter Search parameters/key words.\n\n2) Hit the Submit Search Button\n- Browser window will open to ebay.com with a search for the keywords\n- It will take ~1 mins. to grab all of the title descriptions from the first page\n- A window dialog asking where a txt file containing the information should be stored\n- Use the open file button to open and display the contents of the saved file in the text area\n");
		
		btnOpenFile = new JButton("Open File");
		btnOpenFile.setBounds(6, 115, 193, 29);
		btnOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					JFileChooser openFile = new JFileChooser();
					
					openFile.showOpenDialog(null);
					FileReader reader;
					try {
						reader = new FileReader(openFile.getSelectedFile());
						txtrEnterSearch.read(reader, openFile.getSelectedFile());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		contentPane.add(btnOpenFile);
	}
}
