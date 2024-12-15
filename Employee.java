/*
 * This class is a subclass of the person class and uses common data of each person plus unique varibles to each employee such as ID, clockedIn, 
 * and hireDate to make instances of the Employee Class. The method has getter and setter method for each variable unique to each employee.
 * Additionally, the getFileData method returns the necessary employee data needed for the work order csv file.
 */
public class Employee extends Person{
	
	//Initializes the variablies used to make the object of this class
	private String employeeID;
	private String clockedIn;
	private String hiredDate;
	
	/*
	 * Constructor for the Employee data that uses its supeclass's data plus adds in the employeeID, clockedIn, and hireDate needed to make an
	 * Employee object
	 */
	Employee(String firstName, String lastName, String address, String phoneNumber, String email, String employeeID, String clockedIn, String hiredDate)
	{
		super(firstName, lastName, address, phoneNumber, email);
		this.employeeID = employeeID;
		this.clockedIn = clockedIn;
		this.hiredDate = hiredDate;
		
	}
	
	/*
	 * this getFileData uses the person class's getFileData method to access the first and last name of the customer. This data is necessary
	 * to make the final work order csv file. The Employee getFileData is unique because it adds in the employeeID, and clockedIn time to the string returned to the calling method.
	 */
	@Override
	public String getFileData()
	{
		
		String data = getEmployeeID() + "," + super.getFileData() + "," + getClockedIn();
		return data; 
	}
	
	/*
	 * setter method for the employeeID variable
	 */
	void setEmployeeID(String employeeID)
	{
		this.employeeID = employeeID;
	}
	
	/*
	 * getter method for the employeeID, returns the employeeID of the respective object to the calling method.
	 */
	String getEmployeeID()
	{
		return employeeID; 
	}
	
	/*
	 * setter method for clockedIn variable
	 */
	void setClockedIn(String clockedIn)
	{
		this.clockedIn = clockedIn;
	}
	
	/*
	 * getter method for the clockedIn variable, returns the clockedIn value of the respective object to the calling method.
	 */
	String getClockedIn()
	{
		return clockedIn;  
	}
	
	/*
	 * setter method for hiredDate variable
	 */
	void setHiredDate(String hiredDate)
	{
		this.hiredDate = hiredDate; 
	}
	
	/*
	 * getter method for the hiredDate, returns the hiredDate of the respective object to the calling method.
	 */
	String getHiredDate()
	{
		return hiredDate; 
	}
}
