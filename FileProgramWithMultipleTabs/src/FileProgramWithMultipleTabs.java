import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.io.*;
public class FileProgramWithMultipleTabs extends JFrame implements ActionListener
{
	JTextField textField;
	JTextArea textArea;
	JTextArea textArea_1;
	JTabbedPane tabbedPane;
	JButton writeButton,readButton;
	JPanel contentPane,panel,panel_1;
	Font font=new Font("Helvetica",Font.ITALIC,20);
	{
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100,100,654,438);
			contentPane=new JPanel();
			contentPane.setBorder(new EmptyBorder(5,5,5,5));
			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(0,0));
			
			tabbedPane=new JTabbedPane(JTabbedPane.TOP);
			contentPane.add(tabbedPane);
			
			panel=new JPanel();
			tabbedPane.addTab("Insert Data",null,panel,null);
			panel.setLayout(null);
			
			writeButton=new JButton("Save");
			writeButton.addActionListener(this);
			writeButton.setBounds(40,289,89,23);
			panel.add(writeButton);
			textField=new JTextField();
			textField.setBounds(40,320,200,30);
			textField.setEditable(false);
			textArea=new JTextArea();
			textArea.setBounds(28,11,433,267);
			panel.add(textField);
			panel.add(textArea);
			
			panel_1=new JPanel();
			tabbedPane.addTab("Getoutput",null,panel_1,null);
			panel_1.setLayout(null);
			readButton=new JButton("ShowDate");
			readButton.addActionListener(this);
			readButton.setBounds(59,314,100,23);
			panel_1.add(readButton);
			
			textArea_1=new JTextArea();
			textArea_1.setBounds(49,11,484,292);
			textArea_1.setEditable(false);
			panel_1.add(textArea_1);
	}
	public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						FileProgramWithMultipleTabs frame=new FileProgramWithMultipleTabs();
						frame.setVisible(true);	
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
			});
	}
	public void actionPerformed(ActionEvent e) {
			if(e.getSource()==writeButton) {
				String str=textArea.getText();
				try {
					FileWriter obj=new FileWriter("D:\\FileOperationProgram\\sample.txt");
					obj.write(str);
					obj.close();
				}
				catch(IOException i) {
					System.out.println("Exception : Something is Occured so,IOException is Handling");
				}
				String str2="Data inserted Successfully";
				textField.setText(textField.getText()+str2);
			}
			if(e.getSource()==readButton) {
				try{
						File obj=new File("D:\\FileOperationProgram\\sample.txt");
						FileReader fr=new FileReader(obj);
						BufferedReader br=new BufferedReader(fr);
						StringBuffer sb=new StringBuffer();
						String line;
						while((line=br.readLine())!=null) {
								sb.append(line);
								sb.append("\n");
								textArea_1.setText(sb.toString());
						}
						fr.close();
						}
						catch(Exception f) {
							System.out.println("Exception: Something is occured so,FileNotFoundException/IOException is Handling");
						}
			}
	}
}
