package project_1;

import java.io.IOException;

/**
 * Login Class�� main method �̵� (0208)
 * login ��ü �ޱ����� �߰� (0208)
 * @author user
 */
public class UserLogString {
	@SuppressWarnings("unused")
	private Login login; //0208

	public UserLogString(String[] args,Login login ) { //0208
		this.login = login; //0208
		
		try {
			new UserLog(login); //0208
			
//			int fileLineLength = Integer.valueOf(ul.getFileString().size()); //���Ͼ��� ���� ����

			
		} catch (IOException e) {
			e.printStackTrace();
		} // end catch
	}

}// class
