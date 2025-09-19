package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;

import commands.CommandsFactory;
import commands.ReplayManager;

import javax.swing.JSlider;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import java.awt.Scrollbar;

public class Text2SpeechEditorView {

	private JFrame frmTextspeech;
	private JButton btnNewButton;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem itemOpen;
	private JMenuItem itemSave;
	private JMenu itemEncoding;
	private JMenuItem enc1;
	private JMenuItem enc2;
	private JMenu replayOptions;
	private JMenuItem itemStart;
	private JMenuItem itemStop;
	private JMenuItem itemClear;
	private JMenuItem itemReplay;
	private JMenu mnHelp;
	private JMenuItem itemAbout;
	private JMenuItem itemManual;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel;
	private JSlider slider;
	private JSlider slider_1;
	private JSlider slider_2;
	private Font  labelFont;
	private Font  buttonFont;
	private Font  textAreaFont;
	private CommandsFactory commandListener;
	
	private boolean open = false;
	private boolean save = false;;
	
	private int volume;
	private int pitch;
	private int rate;
	
	private String filepath;
	private String form;
	private ReplayManager replayManager = new ReplayManager();
	private String encoding;
	private ArrayList<String> contents;
	private ArrayList<String> line_contents = new ArrayList<String>(); 
	private ArrayList<ActionEvent> commandList;

	private JTextArea textArea;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Text2SpeechEditorView window = new Text2SpeechEditorView();
					window.frmTextspeech.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Text2SpeechEditorView() {
		initialize();
		createEvents();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTextspeech = new JFrame();


//		frmMyAwesomeGui.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/view/logo1.jpg")));

		frmTextspeech.setResizable(false);
		frmTextspeech.setTitle("Text2Speech");
		frmTextspeech.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTextspeech.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		labelFont  = new Font(Font.SANS_SERIF,  Font.BOLD, 18);
		buttonFont  = new Font(Font.SANS_SERIF,  Font.BOLD, 22);
		textAreaFont  = new Font(Font.SANS_SERIF,  Font.BOLD, 16);
		
		lblNewLabel = new JLabel("Input Text: ");
		lblNewLabel.setFont(labelFont);
	
		slider = new JSlider();

		slider.setOpaque(false);
		slider.setMinorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(2);
		slider.setMaximum(10);
		
		slider_1 = new JSlider();

		slider_1.setOpaque(false);
		slider_1.setMinorTickSpacing(50);
		slider_1.setPaintTicks(true);
		slider_1.setPaintLabels(true);
		slider_1.setMajorTickSpacing(100);
		slider_1.setMaximum(500);
		slider_1.setValue(150);
		
		slider_2 = new JSlider();
;
		slider_2.setOpaque(false);
		slider_2.setMinorTickSpacing(5);
		slider_2.setPaintTicks(true);
		slider_2.setPaintLabels(true);
		slider_2.setMajorTickSpacing(10);
		slider_2.setMaximum(50);
		slider_2.setValue(11);
		
		lblNewLabel_1 = new JLabel("@copyright 2021");
		
		lblNewLabel_2 = new JLabel("Volume");
		lblNewLabel_2.setFont(labelFont);
		
		lblNewLabel_3 = new JLabel("Pitch");
		lblNewLabel_3.setFont(labelFont);
		
		lblNewLabel_4 = new JLabel("Rate");
		lblNewLabel_4.setFont(labelFont);
		
		btnNewButton = new JButton("Play");
		btnNewButton.setFont(buttonFont);
		
		textArea = new JTextArea();
		textArea.setTabSize(4);
		textArea.setFont(textAreaFont);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
//		areaScrollPane = new JScrollPane(textArea);
		
		GroupLayout groupLayout = new GroupLayout(frmTextspeech.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(17, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(slider_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(slider_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(72)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)))
					.addGap(29))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(lblNewLabel_3)
							.addGap(18)
							.addComponent(slider_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(45)
							.addComponent(lblNewLabel_4)
							.addGap(18)
							.addComponent(slider_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(63)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addGap(31))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(lblNewLabel_1)
					.addContainerGap())
		);
		frmTextspeech.getContentPane().setLayout(groupLayout);
		frmTextspeech.setBackground(Color.LIGHT_GRAY);
		frmTextspeech.setBounds(100, 100, 600, 580);
		frmTextspeech.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		frmTextspeech.setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		itemOpen = new JMenuItem("Open File");
		mnFile.add(itemOpen);
		
		itemEncoding = new JMenu("Open Encoded File");
		mnFile.add(itemEncoding);
		
		itemSave = new JMenuItem("Save File");
		mnFile.add(itemSave);
		
		enc1 = new JMenuItem("Rot13");
		itemEncoding.add(enc1);
		
		enc2 = new JMenuItem("Atbash");
		itemEncoding.add(enc2);
		
		replayOptions = new JMenu("Replay Options");
		menuBar.add(replayOptions);
		
		itemStart = new JMenuItem("Start Recording");
		replayOptions.add(itemStart);
		
		itemStop = new JMenuItem("Stop Recording");
		replayOptions.add(itemStop);
	
		itemClear = new JMenuItem("Clear");
		replayOptions.add(itemClear);
		
		itemReplay = new JMenuItem("Replay");
		replayOptions.add(itemReplay);
		
		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		itemAbout = new JMenuItem("About");

		mnHelp.add(itemAbout);
		
		itemManual = new JMenuItem("Manual");
		mnHelp.add(itemManual);
	}
	
	

	private void createEvents() {
		

		// OPEN DOCUMENT (NO ENCODING)
		itemOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		            filepath = fc.getSelectedFile().getAbsolutePath();
		            File file = new File(filepath);
		    		Scanner sc = null;
		    		try {
		    			sc = new Scanner(file);
		    		} catch (IOException e1) {
		    			e1.printStackTrace();
		    		}
				}
				form = filepath.substring(filepath.length() - 4, filepath.length());
				commandListener = new CommandsFactory(filepath,null,form,textArea,replayManager);
				ActionListener action = commandListener.createCommand("Open Document");
				action.actionPerformed(e);
				open = true;
				
			}
		});
		
		// PLAY THE DOCUMENT		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(textArea.getText().length() == 0) {
					return;
				}
								
				if(save == false) {
					JOptionPane.showMessageDialog(null, "The document needs to be saved before you can play it\n ");
					return;
				}
				
				volume = slider.getValue();
				pitch = slider_1.getValue();
				rate = slider_2.getValue();
				
				if (textArea.getSelectedText() != null) {
					String lines = textArea.getSelectedText();
					System.out.print("lines: " +lines);

			        String[] line_list = lines.split(" ");
					line_contents.clear();

			        for (String line:line_list) {
			        	line_contents.add(line);
			        }
					commandListener = new CommandsFactory(volume,pitch,rate,line_contents,replayManager);
					ActionListener action = commandListener.createCommand("Document To Speech");
					action.actionPerformed(e);
				}else {
					commandListener = new CommandsFactory(volume,pitch,rate,contents,replayManager);
					ActionListener action = commandListener.createCommand("Document To Speech");
					action.actionPerformed(e);
				}
			}
		});
		
		itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		itemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));		
		
		// SAVE THE EDITED DOCUMENT
		itemSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(open = false) {
					JOptionPane.showMessageDialog(null, "To Save, open a document\n");
					return;
				}

				contents = new ArrayList<String>();
		    	String edited = textArea.getText();
				String [] lines = edited.split(" ");
				
				for(String line: lines) {
					contents.add(line);
				}
				System.out.println(contents.toString());

				commandListener = new CommandsFactory(filepath,null,form,contents,replayManager);
				ActionListener action = commandListener.createCommand("Save Document");
				action.actionPerformed(e);
				save = true;

			}
		});
		
		// START RECORDING
		itemStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (replayManager.isActiveRecording()==true) {
					JOptionPane.showMessageDialog(null, "Error! Recording status is active. Make sure you end the recording session and try again.");
				}else {
					replayManager.startRecording();
					JOptionPane.showMessageDialog(null, "Recording status is active.");
				}	
			}
		});
		
		// STOP RECORDING
		itemStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if (replayManager.isActiveRecording()==false) {
					JOptionPane.showMessageDialog(null,"Error! There is no active recording to end. ");
				}else {
					replayManager.endRecording();
					JOptionPane.showMessageDialog(null, "Recording session has ended. ");
				}
			}
		});
		
		// OPEN ROT13 FILE
		enc1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		            filepath = fc.getSelectedFile().getAbsolutePath();
		            File file = new File(filepath);
		    		Scanner sc = null;
		    		try {
		    			sc = new Scanner(file);
		    		} catch (IOException e1) {
		    			e1.printStackTrace();
		    		}
				}

				String form = filepath.substring(filepath.length() - 4, filepath.length());

				String encoding = "rot13";
				commandListener = new CommandsFactory(filepath,encoding,form,textArea,replayManager);
				ActionListener action = commandListener.createCommand("Open Document");
				action.actionPerformed(e);
				
				open = true;
			}
		});
		
	
		// OPEN ATBASH FILE
		enc2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{
					JFileChooser fc = new JFileChooser();
					if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			            filepath = fc.getSelectedFile().getAbsolutePath();
			            File file = new File(filepath);
			    		Scanner sc = null;
			    		try {
			    			sc = new Scanner(file);
			    		} catch (IOException e1) {
			    			e1.printStackTrace();
			    		}
					}
					
					String form = filepath.substring(filepath.length() - 4, filepath.length());

					String encoding = "atbash";
					commandListener = new CommandsFactory(filepath,encoding,form,textArea,replayManager);
					ActionListener action = commandListener.createCommand("Open Document");
					action.actionPerformed(e);
					
					open = true;
				}
			}
		});
		
		// REPLAY
		itemReplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(replayManager.isActiveRecording() == false) {
					JOptionPane.showMessageDialog(null, "Not able to replay previous commands. There is no active recording session.\n");
					return;
				}

				commandList = replayManager.getList();
				int open = 0;
				int rot13 = 0;
				int atbash = 0;
				int play = 0;
				int save = 0;

				for(int i=0; i<commandList.size(); i++) {
					String command = commandList.get(i).getActionCommand();
					System.out.println(commandList.size());

					if (command.equals("Open File")) {
						if (open>1) {
							return;
						}
						commandListener = new CommandsFactory(filepath,null,form,textArea,replayManager);
						ActionListener action = commandListener.createCommand("Open Document");
						action.actionPerformed(commandList.get(i));
						open = 1;
					}else if (command.equals("Rot13")) {
						if (rot13>1) {
							return;
						}
						encoding = "rot13";
						commandListener = new CommandsFactory(filepath,encoding,form,textArea,replayManager);
						ActionListener action = commandListener.createCommand("Open Document");
						action.actionPerformed(commandList.get(i));
						rot13 = 1;
					}else if(command.equals("Atbash")) {						
						if (atbash>1) {
							return;
						}
						
						encoding = "atbash";
						commandListener = new CommandsFactory(filepath,encoding,form,textArea,replayManager);
						ActionListener action = commandListener.createCommand("Open Document");
						action.actionPerformed(commandList.get(i));
						atbash = 1;
					}else if(command.equals("Save File")) {
						if (save>1) {
							return;
						}

						commandListener = new CommandsFactory(filepath,null,form,contents,replayManager);
						ActionListener action = commandListener.createCommand("Save Document");
						action.actionPerformed(commandList.get(i));
						save = 1;
					}else if(command.equals("Play")) {
						if (play>1) {
							return;
						}
						if (textArea.getSelectedText() != null) {
							commandListener = new CommandsFactory(volume,pitch,rate,line_contents,replayManager);
							ActionListener action = commandListener.createCommand("Document To Speech");
							action.actionPerformed(commandList.get(i));
							play = 1;
						}else {
							commandListener = new CommandsFactory(volume,pitch,rate,contents,replayManager);
							ActionListener action = commandListener.createCommand("Document To Speech");
							action.actionPerformed(commandList.get(i));
							play = 1;

						}
					}
				}

			}
		});
		
		// CLEAR
		itemClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				replayManager.clearList();
				JOptionPane.showMessageDialog(null, "Replay cache had been cleared.\n");
			}
		});

		itemManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manual manual = new Manual();
				manual.setVisible(true);	
			}
		});
		
		itemAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About about = new About();
				about.setVisible(true);
			}
		});
		
	}
}
