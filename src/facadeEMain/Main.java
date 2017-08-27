package facadeEMain;

import easyaccept.EasyAccept;
import exceptionsComplementares.StringInvalidaException;
import exceptionsComplementares.UsuarioCadastradoException;

/**
 * 
 *
 */
public class Main {

	public static void main(String[] args) throws StringInvalidaException, UsuarioCadastradoException {
		args = new String[] { "facadeEMain.Facade", "us/us1_test.txt", "us/us2_test.txt", "us/us3_test.txt",
				"us/us4_test.txt", "us/us5_test.txt", "us/us6_test.txt", "us/us7_test.txt", "us/us8_test.txt" };
		EasyAccept.main(args);
		
	}
}
