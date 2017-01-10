package lab.epam.olavr.service;

public class PasswordService {

	public static String createPassword() {
		StringBuffer password=new StringBuffer();
	for (int i=0;i<7;i++){
		int code=(int)(Math.random()*52);
		if (code<26) {
			password.append(Character.toString ((char) (65+code)));
		}
		else {
			password.append(Character.toString ((char) (71+code)));
		}
	}
		return password.toString();
	}

}
