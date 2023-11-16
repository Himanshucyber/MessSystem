package custom.exception;

public class InvalidInput extends Exception {
	public InvalidInput(String mesg) {
//		super(mesg);
		System.out.println(mesg);
	}

}
