/**
 * Anish Patel
 * COP3503
 * Project Objects & Classes
 * 11/17/24
 * 
 * This program reads in a list of employees containing tier 2 exprienced employees and tier 1 beginner employees.
 * Then the program reads in ticket data from 2 csv files where one is tier 1 tickets that are paired with beginner employees,
 * and tier 2 which are paired with tier 2 employees. Finally, the data is combined within a output workorder file that lists all of the
 * assignments for each emloyee, along with the current date and time that the workorder was created.
 * 
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Date;
import java.text.SimpleDateFormat;

/*
 * First, this class initializes the ArrayLists and Queues that are made static so the FileHander class is able to add and remove objects.
 * This class has the main method that runs the project with one method being the method caller from the rest of the supporting class files.
 * Finally, the other method within this class is the one that actually links the tickets and workorders together to their respective assignments.
 */
public class Project3 {

	/*
	 * Initializes the static variables needed to add the data read in teh FileHandler, along with using the variables within this class
	 * to make instances of the WorkOrder Class.
	 */
	static String employeeFileName = "employee_data.csv";
	static String tier1TicketFileName = "tier1_ticket_data.csv";
	static String tier2TicketFileName = "tier2_ticket_data.csv"; 
	static String workOrderFileName = "workorder_data.csv";
	static ArrayList<Employee> employeeList = new ArrayList<Employee>();
	static Queue<Ticket> tier1TicketFile = new LinkedList<Ticket>(); 
	static Queue<Ticket> tier2TicketFile = new LinkedList<Ticket>();
	static ArrayList<WorkOrder> workOrderList = new ArrayList<WorkOrder>();
	
	
	public static void main(String[] args) 
	{
		System.out.println("Project 3 Work Order Generator\n");
		
		System.out.println("Loading Employee Data");
		FileHandler.readEmployeeData(employeeFileName); //Reads Employee Data
		
		System.out.println("Loading Ticket Data");
		tier1TicketFile = FileHandler.readTicketData(tier1TicketFileName);//Reads Tier 1 Ticket Data
		tier2TicketFile = FileHandler.readTicketData(tier2TicketFileName);//Reads Tier 2 Ticket Data
		
		System.out.println("Creating Work Orders");
		createWorkOrders();//Uses the method in this class to create instances of the WorkOrder class using files read in above
		
		System.out.println("Writing Work Order Data to File");
		FileHandler.writeData(workOrderFileName);//Writes the Data into a new csv file containing all of the necessary data
				
		System.out.println("Work Orders Created. Program Exiting");
	}
	
	/*
	 * This method links the tickets to their respective tier employees and created an instance of the WorkOrder class that
	 * contains all of the information needed to print out the resulting csv file. There is no input parameter within this because it
	 * uses the static variable lists initialized in the beginning of the class.
	 */
	public static void createWorkOrders() 
	{
		//Traverses the entire tier 2 ticket queue taking the first input and removing it until the queue is empty
		while(!tier2TicketFile.isEmpty())
		{
			//loops through the employeelist
			for(int i = 0; i < employeeList.size(); i++)
			{
				if(employeeList.get(i).getClass() == Tier2Employee.class)//looks for employees that are tier2 with certification to work on tier 2 tickets
				{
					//Gets the current time to use for when the workorder was created
					Date current = new Date();
					SimpleDateFormat newFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
					String date = newFormat.format(current); 
					
					Tier2Employee employee = (Tier2Employee) employeeList.get(i); //gets the instance of the tier 2 employee object when there is a match found within the ArrayList

					//Makes a new WorkOrder object using the matching employee with the first ticket in teh queue
					WorkOrder workOrder = new WorkOrder(employee, tier2TicketFile.remove(), date);
					workOrderList.add(workOrder);
				}
			}
		}
		
		//Does the same as above for the tier 1 tickets and pairs it with tier 1 employees
		while(!tier1TicketFile.isEmpty())
		{
			for(int i = 0; i < employeeList.size(); i++)
			{
				if (tier1TicketFile.isEmpty()) break; 
				if(employeeList.get(i).getClass() == Employee.class)
				{
					Date current = new Date();
					SimpleDateFormat newFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
					String date = newFormat.format(current);
					
					Employee employee = (Employee) employeeList.get(i);
					
					WorkOrder workOrder = new WorkOrder(employee, tier1TicketFile.remove(), date);
					workOrderList.add(workOrder);
				}
			}
		}
	}
}
