/*
 * This class is a subclass of the employee class and uses common data of each employee plus the certification variable that only tier 2 
 * employee's have. The method has getter and setter method for the certification variable.
 * Additionally, the getFileData method returns the necessary tier 2 employee data needed for the work order csv file.
 */
public class Tier2Employee extends Employee implements Printable{

	//Initializes the variables used to make the object of this class
	private String certification;
	
	/*
	 * Constructor for the Employee data that uses its supeclass's data plus adds in the certification data to make a tier 2 employee object
	 */
	Tier2Employee(String firstName, String lastName, String address, String phoneNumber, String email, String employeeID, String clockedIn, String hiredDate, String certification)
	{
		super(firstName, lastName, address, phoneNumber, email, employeeID, clockedIn, hiredDate);
		this.certification = certification;
	}
	
	/*
	 * This getFileData uses the Employee class's getFileData method to access the basic information of every employee plus the certification uniue
	 * to tier 2 employees. This data is necessary to make the final work order csv file. The tier 2 employee getFileData is unique because it adds 
	 * in the certification to the string returned to the calling method.
	 */
	@Override
	public String getFileData()
	{
		String data = super.getFileData() + "," + getCertification();
		return data;
	}
	
	/*
	 * setter method for the certification variable
	 */
	void setCertification(String certification )
	{
		this.certification = certification; 
	}
	
	/*
	 * getter method for the certification variable, returns the certification of the respective object to the calling method.
	 */
	String getCertification()
	{
		return certification; 
	}
}
