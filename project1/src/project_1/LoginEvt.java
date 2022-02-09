package project_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;


/**
 * Login Event 처리
 * @author user
 *
 */
public class LoginEvt extends WindowAdapter implements ActionListener {
	private Login login;
	private String[] args;


	
	public LoginEvt(Login login,String[] args) {
		this.login = login;
		this.args = args;
		
	}


	//X눌리면 dispose() 시키기
	@Override
	public void windowClosing(WindowEvent e) {
		login.dispose();
	}
	
	/**
	 *로그인 버튼
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String id = login.getJtfId().getText();
		String pw = String.valueOf(login.getJpfPw().getPassword());
		
		if(new Authority().loginAuthenticate(id, pw)) {
			login.setVisible(false);
			new UserLogString(args,login);
		} else {
			JOptionPane.showMessageDialog(login, "아이디 또는 비밀번호를 잘못입력하셨습니다.");
			System.err.println("Not Valid ID or Password");
		}
		
	}

}
