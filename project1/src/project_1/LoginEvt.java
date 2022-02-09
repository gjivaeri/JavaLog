package project_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;


/**
 * Login Event ó��
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


	//X������ dispose() ��Ű��
	@Override
	public void windowClosing(WindowEvent e) {
		login.dispose();
	}
	
	/**
	 *�α��� ��ư
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String id = login.getJtfId().getText();
		String pw = String.valueOf(login.getJpfPw().getPassword());
		
		if(new Authority().loginAuthenticate(id, pw)) {
			login.setVisible(false);
			new UserLogString(args,login);
		} else {
			JOptionPane.showMessageDialog(login, "���̵� �Ǵ� ��й�ȣ�� �߸��Է��ϼ̽��ϴ�.");
			System.err.println("Not Valid ID or Password");
		}
		
	}

}
