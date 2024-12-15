import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * This class handles the file input and output in the program. This includes reading in the employee and ticket data.
 * Additionally, the class also uses the workOrder ArrayList created in Project3 to create the work order csv file. The logger method
 * is used to log every action the program takes.
 */
public class FileHandler {
	
	/*
	 * This is the method that uses the workOrder ArrayList and writes the necessary data into a new file
	 */
	static void writeData(String workOrderFileName)
	{
		logger("Writing Work Order Data to File");//logging work orders being written in
		try {
			//Initialized Print Writer and specified headers are printed
			PrintWriter output = new PrintWriter(workOrderFileName);
			output.println("customer_id,customer_first_name,customer_last_name,ticket_id,ticket_createdAt,workorder_createdAt,employee_id,employee_first_name,employee_last_name,clocked_in,certification");
			
			//loops through the work order ArrayList to print the elements within it
			for(int i = 0; i < Project3.workOrderList.size() ; i++) 
			{
				output.println(Project3.workOrderList.get(i).getFileData());//the getFileData within workOrder includes all of the data needed
				logger(Project3.workOrderList.get(i).getFileData());//logs each data that is printed within the log.txt
			}
			output.close();
		} catch (FileNotFoundException e) {e.printStackTrace();}
		
	}
	
	/*
	 * This takes the file name as the parameter and reads in the employee data and creates objects of tier 1 or tier 2 employees,
	 * depending on the data read in the employee csv file. Then adds those objects within the static employees ArrayList created in Project3.
	 */
	static void readEmployeeData(String employeeFileName)
	{		
		logger("Loading Employee Data");//logs employee file being read
		
		File employeeData = new File(employeeFileName);//creates a File object for the scanner to read
		
		//The File is wrapped around a scanner that reads in the lines
		Scanner parser = null;
		try {
			parser = new Scanner(employeeData);
		} catch (FileNotFoundException e) {e.printStackTrace();} 
		
		parser.nextLine();//skips the header
		
		//loops through the lines within the file being read until there is no more data
		while(parser.hasNextLine())
		{
			String line[] = parser.nextLine().split(",");//makes an Array with the elements so they can be split to their respective variables
			String employeeID = line[0];
			String firstName = line[1];
			String lastName = line[2];
			String email = line[3];
			String address = line[4];
			String phoneNumber = line[5];
			String clockedIn = line[6]; 
			String dateHired = line[7];
			String tier = line[8];
			
			//checks weather the Employee or Tier2Employee object needs to be created
			if(tier.equals("tier2"))
			{
				//if its tier 2 then all employee data and certification is sent to the class to make a new object
				String certification = line[9];
				Tier2Employee tier2Employee = new Tier2Employee(firstName, lastName, address, phoneNumber, email, employeeID, clockedIn, dateHired, certification);
				Project3.employeeList.add(tier2Employee);//Creted object is added to the Employee ArrayLIst in Project3 file
			}			
			else
			{
				//if its tier 1 then all of the data except the certification(since there is none) is sent to Employee to make a new object
				Employee tier1Employee = new Employee(firstName, lastName, address, phoneNumber, email, employeeID, clockedIn, dateHired);
				Project3.employeeList.add(tier1Employee);//This is sent to the same ArrayList as above
			}
					
		}
				
		parser.close();
	}
	/*
	 * This reads in the ticket data from the file inputted and returns back a LinkedList to be stored within the respective list for the file
	 * specified in Project3. The method is ran 2 times in Project3 for the tier 1 and tier 2 ticket files. The method makes a customer class
	 * and uses that object to also create the tickets object which is stored in the LinkedList.
	 */
	static LinkedList<Ticket> readTicketData(String ticketFileName)
	{
		logger("Loading Ticket Data");//logs every time a ticket data set is read in
		
		LinkedList<Ticket> tickets = new LinkedList<Ticket>();//initializes returned LinkedList
		
		File ticketData = new File(ticketFileName);//creates File object for the scanner to read
		
		//The File is wrapped around a scanner that reads in the lines
		Scanner parser = null;
		try {
			parser = new Scanner(ticketData);
		} catch(FileNotFoundException e) {e.printStackTrace();}
		
		parser.nextLine();//skips the header
		
		//loops through the lines within the file being read until there is no more data
		while(parser.hasNextLine())
		{
			String line[] = parser.nextLine().split(",");//makes an Array with the elements so they can be split to their respective variables
			String customerID = line[0];
			String firstName = line[1];
			String lastName = line[2];
			String email = line[3];
			String address = line[4];
			String phoneNumber = line[5];
			String accountNumber = line[6]; 
			String ticketID = line[7];
			String createdAt = line[8];
			
			//creates an object of the customer requesting the ticket, so that information can be sent to make a customer's ticket object
			Customer customer = new Customer(firstName, lastName, address, phoneNumber, email, customerID, accountNumber);
			Ticket ticket = new Ticket(customer, createdAt, ticketID); 
			tickets.add(ticket); //Adds this ticket object to the tickets LinkedList before returning the list to be stored in its respective queue in Project3
		}
				
		parser.close();
		
		return tickets ;
	}
	
	/*
	 * This is a logger method that creates a log.txt file and writes down every action the program takes. 
	 * Called within every method in FileHandler to log whenever the program processes something.
	 * The FileWriter is used to append the file rather then create a new one every time logger is called.
	 */
	private static void logger(String log)	
	{
		//Finds the current data and time using Date class and SimpleDateFormat
		Date current = new Date();
		SimpleDateFormat newFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String date = newFormat.format(current);
		
		try {
			FileWriter logger = new FileWriter("log.txt", true);//Creates a file writer and the "true" sets is to append the file not delete is everytime
			
			logger.write("log: " + date + " : " +  log + "\n");// write the data using a log format
			
			logger.close();
		} catch (IOException e) {e.printStackTrace();}
		
		
		
	}
}
