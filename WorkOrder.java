/*
 * The workorder class uses all of the classes that are built on eachother to make a final comma seperated string that can be printed in the 
 * output work order file. This class uses objects of Employee, Tickets, and a new variable representing current time the work order was created.
 * Finally, the getFileData for this class uses the getFileData for employee and ticket classes which have all of the information needed from the 
 * rest of the classes they are built upon.
 */
public class WorkOrder implements Printable{
	
	//Initializes the variables used to make the object of this class.
	//Initializes objects of employee and ticket to combine these data sets before outputing into a new file
	private Employee employee;
	private String createdAt;
	private Ticket ticket;
	
	/*
	 * Constructor for the workorder data that uses the variables initialized above to make objects of the work order class. 
	 * the unique requirements of this class is that it needs objects of the ticket and employee classes to be imported before creating a 
	 * work order. These objects are made in Project3 when tier 1 tickets are paired with tier 1 employees and tier 2 with tier 2 employees. 
	 * This pair of ticket, employee, and createdAt are sent to this constructor to make objects of the WorkOrder class.
	 */
	WorkOrder(Employee employee, Ticket ticket, String createdAt)	
	{
		this.employee = employee;
		this.createdAt = createdAt;
		this.ticket = ticket; 
	}
	
	/*
	 * This getFileData uses the "getFileData" methods in tickets and employee to return a full comma seperated string with all of the values 
	 * necessary to make the final work order csv file. Each of the ticket and employee getFileData are also built on other class's getFileData 
	 * methods so all necessary information can be passed down.
	 */
	@Override
	public String getFileData()
	{
		String data = ticket.getFileData() + "," + getCreatedAt() + "," + employee.getFileData();
		
		return data;
	}
	
	/*
	 * setter method for the employee object
	 */
	void setEmployee(Employee employee)
	{
		this.employee = employee;
	}
	
	/*
	 * getter method for the employee object, returns the employee object of the respective ticket object it was paired with to the calling method.
	 */
	Employee getEmployee()
	{
		return employee;
	}
	
	/*
	 * setter method for the work order createdAt variable
	 */
	void setCreatedAt(String createdAt)
	{
		this.createdAt = createdAt;
	}
	
	/*
	 * getter method for the createdAt variable, returns the time the work order object was created to the calling method.
	 */
	String getCreatedAt()
	{
		return createdAt;
	}
	
	/*
	 * setter method for the ticket object
	 */
	void setTicket(Ticket ticket)
	{
		this.ticket = ticket;
	}
	
	/*
	 * getter method for the ticket object, returns the ticket object of the respective employee object it was paired with to the calling method.
	 */
	Ticket getTicket()
	{
		return ticket;
	}
}
