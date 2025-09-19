package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.awt.Color;

public class Manual extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Manual dialog = new Manual();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Manual() {
		setResizable(false);
		setTitle("Manual");
		setBounds(200, 130, 743, 461);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		scrollPane.setBorder(null);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
					.addGap(20))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JTextArea text = new JTextArea();
		text.setLineWrap(true);
		text.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		text.setWrapStyleWord(true);
		text.setEditable(false);
		
		text.setBorder(null);
		text.setTabSize(4);
		text.setBackground(contentPanel.getBackground());
		text.setText("STEP 1: Open a File by ckicking on the menu item <File>(or Ctrl+O)\n"
				+ "	1.1 To open a non encoded word or excel file, click on <Open File> and the File selection menu will appear\n"
				+ "	1.2 To open an encoded file select <Open encoded file> and select the encryption type(rot13 or atbash)\n"
				+ "STEP 2: You can edit the contents of the file in the text area provided by the GUI.\n"
				+ "STEP 3: To save the updated file click on <File> and then <Save FIle>\n"
				+ "STEP 4: Press the <Play> button and hear the audio. Make sure you saved the file beforehand\n\n"
				+ "The Replay Fuction allows you to listen to the audio created as many times as you want\n"
				+ "STEP 1: The <Start Recording> enables the recording of the commands that you use while its activated/n"
				+ "STEP 2: Press Replay to execute the precioys commands again\n"
				+ "STEP 3: End the recording session by pressing the <Stop Recording> command");
		scrollPane.setViewportView(text);

		contentPanel.setLayout(gl_contentPanel);
	}
}
