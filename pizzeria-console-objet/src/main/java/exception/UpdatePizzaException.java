package exception;

public class UpdatePizzaException extends StockageException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		// TODO Auto-generated method stub
		return "Update Exception : " + super.getMessage();
	}
}
