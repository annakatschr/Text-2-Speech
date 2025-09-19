package view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import java.awt.Font;

public class About extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			About dialog = new About();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public About() {
		setResizable(false);
		setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 14));
		setTitle("About");
		setSize(565,381);
		setBounds(200, 200, 490, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JTextArea text = new JTextArea();
		text.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setEditable(false);
		text.setBackground(contentPanel.getBackground());
		text.setText("The objective of this project is to develop an application that allows to edit and transform documents toaudio."
				+ " The documents may be in various formats. Specifically the application supports at least MicrosoftWord (.docx) and Excel documents (.xlsx). "
				+ "For privacy and security reasons the contents of thedocuments may be encoded with different encoding mechanisms. The target users of the application "
				+ "may be people who have reading problems or visually impaired people. The application consists of agraphical user interface, a back-end that enables "
				+ "the text editing process and the part that transformstext to speech, which will be based on external text to speech "
				+ "libraries.\r\n\r\nAuthors of the project: \rAnna, \rEuaggelia, \rJuulia");

		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(text, GroupLayout.PREFERRED_SIZE, 422, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(text, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);		
	}
}
