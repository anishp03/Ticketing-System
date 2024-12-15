/*
 * This is an interface with the abstract method getFileData which is common in all of the supporting classes in this program. These supporting
 * supporting classes use their respective getFileData methods to build on eachother and create a complete string in the final WorkOrder Class that 
 * the PrintWriter can print on to a csv file.
 */
public interface Printable {

	String getFileData(); //This method in the classes, returns a comma seperated string in ech of the classes
	
}
