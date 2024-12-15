/*
 * The customer class is a subclass of the Person class, this class uses common values of all people plus unique values of each customer such 
 * as customerID and accountNumber to make objects of each customer. The class inclued getter and setter methods for the 2 new unique values for 
 * customers. Additionally, the getFieData method for this class returns the necessary customer information needed to make the final 
 * work order csv file.
 */
public class Customer extends Person implements Printable{

	//Initializes the variables used to make the object of this class
	private String customerID;
	private String accountNumber;
	
	/*
	 * Constructor for the customer data that uses its supeclass's data plus adds in the customerID and account ID needed to make a customer object
	 */
	Customer(String firstName, String lastName, String address, String phoneNumber, String email, String customerID, String accountNumber)
	{
		super(firstName, lastName, address, phoneNumber, email); 
		this.customerID = customerID;
		this.accountNumber = accountNumber;
	}
	
	/*
	 * this getFileData uses the person class's getFileData method to access the first and last name of the customer. This data is necessary
	 * to make the final work order csv file. The customer getFIleData is unique because it adds in the customerID to the string returned to the calling method.
	 */
	@Override
	public String getFileData()
	{
		String data = getCustomerID() + "," + super.getFileData(); 
		
		return data;
	}
	
	/*
	 * setter method for the customerID
	 */
	void setCustomerID(String customerID)
	{
		this.customerID = customerID;
	}
	
	/*
	 * getter method for the customerID, returns the customerID of the respective object to the calling method.
	 */
	String getCustomerID()
	{
		return customerID; 
	}
	
	/*
	 * setter method for the accountNumber
	 */
	void setAccountNumber(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}
	
	/*
	 * getter method for the accountNumber, returns the accountNumber of the respective object to the calling method.
	 */
	String getAccountNumber()
	{
		return accountNumber; 
	}
	
}
