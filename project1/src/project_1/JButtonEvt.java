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
 * 버튼 이벤트 처리 클래스
 * @author user
 */
public class JButtonEvt implements ActionListener{

	private UserLog ul;
	private Login login;//0208 추가 - login 객체 받아오기

	public JButtonEvt(UserLog ul) {
		this.ul = ul;
	}// ButtonEvt
	
	//0208 추가 - login 객체 받아오기
	public JButtonEvt(UserLog ul,Login login) {
		this.ul = ul;
		this.login = login;
	}// ButtonEvt
	
	

	@Override
	public void actionPerformed(ActionEvent ae)  {
		
		// view 버튼 이벤트 처리
		if (ae.getSource() == ul.getViewJbtn()) {
			new ViewDialog(ul);
			
		} else if ((ae.getSource() == ul.getReportJbtn()) 
				//0208 추가 - report권한 검증
				&& new Authority().reportAuthenticate(login.getJtfId().getText())) {
			
			try {
				new JButtonEvt(ul).creatFile();
			} catch (IOException e) {
				e.printStackTrace();
			}	
			
		} else {
			JOptionPane.showMessageDialog(ul, "Report 생성 권한이 없는 유저입니다.");
			System.err.println("NOT VALID USER");
		}

	}// actionPerformed

	/**
	 * view버튼의 Dialog를 생성하는 메소드
	 * @throws IOException
	 */
	public void creatDialog() throws IOException {
		
		System.out.println("createDialog");
		//Dialog 생성
		JDialog jd = new JDialog(ul, "view", true);
		
		//1~7번 출력 위한 Dialog안 textArea 생성
		JTextArea jta =  new JTextArea(ul.printFileAnalysis()); ;
		JScrollPane jsp = new JScrollPane(jta);

		//TextArea 안 폰트 설정
		jta.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		jd.add(jsp);

		jd.setSize(500, 500);
		jd.setVisible(true);


		jd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
	
	
	
	public void creatFile() throws IOException {
		
		//폴더 생성
		File dir_C = new File("c:/dev/report");
		dir_C.mkdirs();

		Date date = new Date();
		String longDate = Long.toString(date.getTime()); //생성날짜
		//0208추가
		JOptionPane.showMessageDialog(ul,dir_C.getAbsolutePath() + "report_" + longDate + ".dat" + " 생성");
		
		//파일 생성
		FileWriter fw = new FileWriter(new File(dir_C, "report_" + longDate + ".dat"));
		//fw.write(ul.printReport());
		fw.write(ul.printFileAnalysis());
		fw.flush();
		fw.close();
			
		
	} // creatFile
	
	

}// class
