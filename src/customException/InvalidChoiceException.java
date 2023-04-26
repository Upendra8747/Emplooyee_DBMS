package customException;

public class InvalidChoiceException extends RuntimeException{
	String message;
	public InvalidChoiceException(String messaString) {
		this.message=messaString;
	}
	@Override
	public String getMessage() {
		return message;
	}
}
