package project_1;

import java.io.IOException;

/**
 * Login Class로 main method 이동 (0208)
 * login 객체 받기위해 추가 (0208)
 * @author user
 */
public class UserLogString {
	@SuppressWarnings("unused")
	private Login login; //0208

	public UserLogString(String[] args,Login login ) { //0208
		this.login = login; //0208
		
		try {
			new UserLog(login); //0208
			
//			int fileLineLength = Integer.valueOf(ul.getFileString().size()); //파일안의 줄의 개수

			
		} catch (IOException e) {
			e.printStackTrace();
		} // end catch
	}

}// class
