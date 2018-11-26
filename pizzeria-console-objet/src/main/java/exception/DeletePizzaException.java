package exception;

public class DeletePizzaException extends StockageException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	public String getMessage() {
		// TODO Auto-generated method stub
		return "Erreur Suppression : " + super.getMessage();
	}
}
