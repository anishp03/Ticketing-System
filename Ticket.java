/*
 * The ticket class is its own class without inheritings any values from other classes, however it uses the objects of Customer 
 * to make its own objects so it can pair each customer to their respective tickets. The getFileData method for tickets returns the necessary 
 * information needed to make the final work order csv file.
 */
public class Ticket implements Printable {
	
	//Initializes the variables used to make the object of this class.
	//The unique variable is the customer object, it uses the customer object to link objects of tickets to their respective customers
	private String createdAt;
	private String ticketID;
	private Customer customer;

	/*
	 * Constructor for the ticket data that uses the variables initialized above to make objects of the ticket class. A unique reauriement
	 * to make an object of ticket is an object of customer.
	 */
	Ticket(Customer customer, String createdAt, String ticketID)
	{
		this.customer = customer;
		this.createdAt = createdAt;
		this.ticketID = ticketID;
	}
	
	/*
	 * This getFileData uses the customer class's getFileData method to access the customer information and adds the ticket information of the
	 * respeective customer to the string returnd to the calling method. However, this class is not a subclass of the customer class, it only uses
	 * the object of customer class to get each cusomer's data that made the ticket.
	 */
	@Override
	public String getFileData()
	{
		String data = customer.getFileData()+ "," + getTicketID() + "," + getCreatedAt();
		
		return data;
	}
	
	/*
	 * setter method for the customer object
	 */
	void setCustomer(Customer customer)
	{
		this.customer = customer;
	}
	
	/*
	 * getter method for the customer object, returns the customer object of the respective ticket object to the calling method.
	 */
	Customer getCustomer()
	{
		return customer;
	}
	
	/*
	 * setter method for when the ticket was created
	 */
	void setCreatedAt(String createdAt)
	{
		this.createdAt = createdAt;
	}
	
	/*
	 * getter method for the ticket createdAt time, returns the time the ticket was created of the respective ticket object to the calling method.
	 */
	String getCreatedAt()
	{
		return createdAt;
	}
	
	/*
	 * setter method for the ticketID
	 */
	void setTicketID(String ticketID	)
	{
		this.ticketID = ticketID;
	}
	
	/*
	 * getter method for the ticketID, returns the ticketID of the respective ticket object to the calling method.
	 */
	String getTicketID()
	{
		return ticketID;
	}
}
