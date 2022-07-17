public class NegativeCurrencyException extends Exception {

	private static final long serialVersionUID = 1L;

	public NegativeCurrencyException(String message) {
		super(message);
	}
}