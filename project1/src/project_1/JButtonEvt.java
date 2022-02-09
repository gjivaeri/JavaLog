package project_1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * ��ư �̺�Ʈ ó�� Ŭ����
 * @author user
 */
public class JButtonEvt implements ActionListener{

	private UserLog ul;
	private Login login;//0208 �߰� - login ��ü �޾ƿ���

	public JButtonEvt(UserLog ul) {
		this.ul = ul;
	}// ButtonEvt
	
	//0208 �߰� - login ��ü �޾ƿ���
	public JButtonEvt(UserLog ul,Login login) {
		this.ul = ul;
		this.login = login;
	}// ButtonEvt
	
	

	@Override
	public void actionPerformed(ActionEvent ae)  {
		
		// view ��ư �̺�Ʈ ó��
		if (ae.getSource() == ul.getViewJbtn()) {
			new ViewDialog(ul);
			
		} else if ((ae.getSource() == ul.getReportJbtn()) 
				//0208 �߰� - report���� ����
				&& new Authority().reportAuthenticate(login.getJtfId().getText())) {
			
			try {
				new JButtonEvt(ul).creatFile();
			} catch (IOException e) {
				e.printStackTrace();
			}	
			
		} else {
			JOptionPane.showMessageDialog(ul, "Report ���� ������ ���� �����Դϴ�.");
			System.err.println("NOT VALID USER");
		}

	}// actionPerformed

	/**
	 * view��ư�� Dialog�� �����ϴ� �޼ҵ�
	 * @throws IOException
	 */
	public void creatDialog() throws IOException {
		
		System.out.println("createDialog");
		//Dialog ����
		JDialog jd = new JDialog(ul, "view", true);
		
		//1~7�� ��� ���� Dialog�� textArea ����
		JTextArea jta =  new JTextArea(ul.printFileAnalysis()); ;
		JScrollPane jsp = new JScrollPane(jta);

		//TextArea �� ��Ʈ ����
		jta.setFont(new Font("���� ���", Font.BOLD, 15));
		jd.add(jsp);

		jd.setSize(500, 500);
		jd.setVisible(true);


		jd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
	
	
	
	public void creatFile() throws IOException {
		
		//���� ����
		File dir_C = new File("c:/dev/report");
		dir_C.mkdirs();

		Date date = new Date();
		String longDate = Long.toString(date.getTime()); //������¥
		//0208�߰�
		JOptionPane.showMessageDialog(ul,dir_C.getAbsolutePath() + "report_" + longDate + ".dat" + " ����");
		
		//���� ����
		FileWriter fw = new FileWriter(new File(dir_C, "report_" + longDate + ".dat"));
		//fw.write(ul.printReport());
		fw.write(ul.printFileAnalysis());
		fw.flush();
		fw.close();
			
		
	} // creatFile
	
	

}// class
