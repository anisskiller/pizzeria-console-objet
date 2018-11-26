package exception;

public class SavePizzaException extends StockageException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void AddPizzaException() {
		
		// TODO Auto-generated constructor stub
	}



	public void AddPizzaException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		
		// TODO Auto-generated constructor stub
	}




	public void AddPizzaException(String arg0, Throwable arg1) {
		
		// TODO Auto-generated constructor stub
	}
 


	public void AddPizzaException(String arg0) {
		
		// TODO Auto-generated constructor stub
	}




	public void AddPizzaException(Throwable arg0) {
		
		// TODO Auto-generated constructor stub
	}



	public String getMessage() {
		// TODO Auto-generated method stub
		return "Erreur Ajout : "+super.getMessage();
	}
	
}
