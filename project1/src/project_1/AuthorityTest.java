package project_1;

public class AuthorityTest {
	Authority a = new Authority();
	public AuthorityTest() {
		System.out.println(a.loginAuthenticate("admin", "1234"));
		System.out.println(a.loginAuthenticate("root", "1111"));
		System.out.println(a.loginAuthenticate("adminstrator", "12345"));
		System.out.println(a.loginAuthenticate("admin", "123234"));
		System.out.println(a.loginAuthenticate("123", "1234"));
		
		System.out.println("------report authority------");
		System.out.println(a.reportAuthenticate("admin"));
		System.out.println(a.reportAuthenticate("root"));
		System.out.println(a.reportAuthenticate("1a2"));
		
	}//AuthorityTest
	

	public static void main(String[] args) {
		new AuthorityTest();

	}//main

}//class 