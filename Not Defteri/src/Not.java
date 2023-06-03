import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.awt.event.*;
import java.awt.Window;

public class Not {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Notepad();
		
	}

	
	
	
	private static void Notepad() {
		
		
		JFrame f = new JFrame("Note");
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JTextArea text = new JTextArea(1270,720);
		JScrollPane scrollpane = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		JMenuBar mbar = new JMenuBar();
		JMenu menu = new JMenu("File");

		JMenuItem i1 = new JMenuItem("New");
		JMenuItem i2 = new JMenuItem("New Window");
		JMenuItem i3 = new JMenuItem("Open...");
		JMenuItem i4 = new JMenuItem("Save");
		JMenuItem i5 = new JMenuItem("Save As...");		
		JMenuItem i7 = new JMenuItem("Print...");
		JMenuItem i8 = new JMenuItem("Exit");

		menu.add(i1);
		menu.add(i2);
		menu.add(i3);
		menu.add(i4);
		menu.add(i5);
		menu.add(i7);
		menu.add(i8);

		i1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				text.setText(null);
			}
		});
		i2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Notepad();
				
			}
		});

		i3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if (e.getSource() == i3) {
					
					JFileChooser chooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
					chooser.setFileFilter(filter);
					int result = chooser.showOpenDialog(null);
					if (result == JFileChooser.APPROVE_OPTION) {
					    File selectedFile = chooser.getSelectedFile();
					    try {
					        BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
					        String line = null;
					        while ((line = reader.readLine()) != null) {
					            text.append(line + "\n");
					        }
					        reader.close();
					    } catch (IOException e1) {
					        e1.printStackTrace();
					    }
					}
					
				}
				
			}
		});
		
		
		i5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String txt = text.getText();
				
				if (e.getSource() == i5) {
					
					JFileChooser choose = new JFileChooser();
					
					int result = choose.showSaveDialog(null);
					
					if (result == JFileChooser.APPROVE_OPTION) {
						
						File file = choose.getSelectedFile();
						String path = file.getAbsolutePath() + ".txt";
						
						
						
						try {
						
							FileWriter writer = new FileWriter(path);
							writer.write(txt);
							writer.close();
							
							JOptionPane.showMessageDialog(null, "The File Has Been Successfully Saved");
							
						} catch (Exception e2) {
							
							e2.printStackTrace();
						}
						
					}
					
				}
				
			}
		});

		
		i8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if (e.getSource() == i8)
				{
					f.dispose();
					
				}
			}
		});

		i7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				try {
					text.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
	
		
		i4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		
				if (e.getSource()== i4) {
					
					
					String textToSave = text.getText();

				      int confirmResult = JOptionPane.showConfirmDialog(null, "Do you want to save the file?", "Save File Example", JOptionPane.YES_NO_OPTION);
				      if (confirmResult == JOptionPane.YES_OPTION) {
				         String filePath = System.getProperty("user.home") + "/Desktop/";
				         String fileName = JOptionPane.showInputDialog(null, "Enter file name:");
				         
				         if (fileName != null && !fileName.isEmpty()) {
				        	 filePath += fileName + ".txt";
				            File fileToSave = new File(filePath);
				            try {
				               FileWriter fileWriter = new FileWriter(fileToSave);
				               BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				               bufferedWriter.write(textToSave);
				               bufferedWriter.close();
				               JOptionPane.showMessageDialog(null, "File saved successfully!");
				            } catch (IOException ex) {
				               ex.printStackTrace();
				            }
				         }
				      }
					
				}
				
			}
		});
		
		scrollpane.getViewport().add(text);

	
		scrollpane.setPreferredSize(new Dimension(1270, 720));
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		
		f.setLayout(new BorderLayout()); 
		
		// JScrollPane'u JFrame'e ekle
		f.add(scrollpane, BorderLayout.CENTER);
		mbar.add(menu);
		f.setJMenuBar(mbar);
		f.setSize(1280, 720);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	
	
}
