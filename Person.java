
/*
 * This class allows creating object of info that is common to both employees and customers. They are used within the other supporting class
 * files to call the getFileData method and return the information necessary for the final work order csv file.
 */
public class Person implements Printable {
	
	//Initializes the variables used to make the object of this class
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String email;
	
	/*
	 * Constructor for the person data that is common to both employee and customer. This is a superclass to both Employee and Customer classes.
	 */
	Person(String firstName, String lastName, String address, String phoneNumber, String email)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	
	}
	
	/*
	 * getFileData method used in both employee and customer to return the first and last name of the person.
	 */
	@Override
	public String getFileData()
	{
		String data = getFirstName() + "," + getLastName();
		
		return data;
	}
	
	/*
	 * setter method for the firstName
	 */
	void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	/*
	 * getter method for the firstName, returns the firstName of the respective object.
	 */
	String getFirstName()
	{
		return firstName; 
	}
	
	/*
	 * setter method for the lastName
	 */
	void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	/*
	 * getter method for the lastName, returns the lastName of the respective object.
	 */
	String getLastName()
	{
		return lastName; 
	}
	
	/*
	 * setter method for the address
	 */
	void setAddress(String address)
	{
		this.address = address;
	}
	
	/*
	 * getter method for the address, returns the address of the respective object.
	 */
	String getAddress()
	{
		return address; 
	}
	
	/*
	 * setter method for the phoneNumber
	 */
	void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	/*
	 * getter method for the phoneNumber, returns the phoneNumber of the respective object.
	 */
	String getPhoneNumber()
	{
		return phoneNumber; 
	}
	
	/*
	 * setter method for the email
	 */
	void setEmail(String email)
	{
		this.email = email;
	}
	
	/*
	 * getter method for the email, returns the email of the respective object.
	 */
	String getEmail()
	{
		return email; 
	}
	
	
}
