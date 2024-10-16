/***********************************************************************************************
  * Author: Frankie Deleon & John Olsen
  * Course Section: IS-2063-ON2
  * Date: 04/23/2023
  *********************************************************************************************/
/* PROGRAM PURPOSE:
 * By: Frankie Deleon
 * The SalesSystem program generate sales reports for Tandem Enterprises. 
 * It prompts the user to enter the sales system and, if the input is 'Y', calls methods to process
 * a sales report, write the sales report data to a file, and check the input file. The program uses 
 * methods processSalesReport where A new SalesReport object is created, and its setProjectedSales() method
 * is called to set the projected sales. The setNoSalesReps() method is then called to set the number of
 * sales representatives, and the reports array is initialized with the size variable. 
 * A for loop is used to iterate through each sales representative, set their sales data for each
 * quarter and month, and calculate their annual sales. The getSalesRepRevReport() and getRepTargetMsg()
 * methods are called to retrieve the sales representative's revenue report and their target message,
 * respectively. The revenue report and target message are added to the aSalesReport variable,
 * and the variable is added to the salesReports ArrayList. Finally, the for loop prints each report 
 * using System.out.printf(), and the getCompanyTargetMsg() method is called to retrieve the company's
 * target message.The writeSalesRepData method writes the sales report data to a file. It prompts the user to enter a filename,
 * opens the file in a PrintWriter, then uses a for-loop to retrieve the sales data from the SalesReport array 
 * and format it into a string with specific format specifiers. It then writes this string to the file using the 
 * PrintWriter object. If an IOException is thrown, it sets fileError to true and prints an error message.
 * If no file error is present, the method closes the PrintWriter object and prints a success message stating
 * the data has been written to the file. The checkInputFile method  checks for the existence of a file, reads its 
 * contents, and prints them out. It uses a try-catch block to handle potential exceptions 
 * such as file not found or null pointer exceptions when trying to access or read a record.
 */
import java.util.Scanner; // import scanner By: Frankie Deleon
import java.util.Calendar; // import calendar By: Frankie Deleon
import java.util.ArrayList; // import arraylist By: Frankie Deleon
import java.io.File; // import file By: Frankie Deleon
import java.io.PrintWriter; // import printWriter By: Frankie Deleon
import java.io.IOException; //import IOException By: Frankie Deleon
 
/*By: Frankie Deleon
 * SalesSystem class declares the the global variables for the program. 
 */

public class SalesSystem
{ //begin SalesSystem class By: Frankie Deleon
  private SalesReport[] reports; // declare private SalesReport array reports By: Frankie Deleon
  private Scanner input = new Scanner(System.in); // declare input scanner variable By: Frankie Deleon
  private Calendar dateTime; //declare dateTime calendar variable By: Frankie Deleon
  private ArrayList<String> salesReports = new ArrayList<String>(); // declare salesReports Arraylist String By: Frankie Deleon
  private String fileName = ""; // declare fileName String By: Frankie Deleon
  private char count; // declare char count. By: Frankie Deleon 
  
  /*
 * SalesSystem constructor, returns nothing.   By: Frankie Deleon 
 */
  
  public void SalesStystem() 
  { // begin SalesSystm By: Frankie Deleon
  } // end SalesSystem By: Frankie Deleon
  
 /*By: Frankie Deleon
 * start method prompts users to enter the sales system, Tandem Enterprises to begin the process
 * of starting a sales report, if the input is 'Y' call the following methods,  processSalesReport();, 
 * writeSalesRepData();, and checkInputFile();
 */
  
  public void start()
  { // begin start By: Frankie Deleon
    /*By: Frankie Deleon
     * prompt user  Priming read to enter the sales system.
     * TANDEM ENTERPRISES
     * Begin the processing of a sales report? Enter 'Y' or 'N':
     * 
     * If the answer is N, call exitMessage() to print an exit message 
     */
  
    System.out.printf("%nPriming read to enter the sales system.%n");
    System.out.printf("%nTANDEM ENTERPRISES%n");
    System.out.printf("%nBegi1n the processing of a sales report? Enter 'Y' or 'N': ");
    count = input.nextLine().toUpperCase().charAt(0); 
    
    if(count == 'Y') // if statement, if count is equal to Y call the following methods By: Frankie Deleon
    {
      processSalesReport();
      writeSalesRepData();
      checkInputFile();
    } // end if By: Frankie Deleon
    
    exitMessage(); // exit message By: Frankie Deleon
    
  }// end start method By: Frankie Deleon
  
  
 /*By: Frankie Deleon
 * processSalesReport method initializes three local variables, namely size,
 * qtrCounter, and monthCounter, to zero and declares a String variable aSalesReport
 * and initializes it with a header. A new SalesReport object is created, and its setProjectedSales() method
 * is called to set the projected sales. The setNoSalesReps() method is then called to set the number of
 * sales representatives, and the reports array is initialized with the size variable. 
 * A for loop is used to iterate through each sales representative, set their sales data for each
 * quarter and month, and calculate their annual sales. The getSalesRepRevReport() and getRepTargetMsg()
 * methods are called to retrieve the sales representative's revenue report and their target message,
 * respectively. The revenue report and target message are added to the aSalesReport variable,
 * and the variable is added to the salesReports ArrayList. Finally, the for loop prints each report 
 * using System.out.printf(), and the getCompanyTargetMsg() method is called to retrieve the company's
 * target message.
 */
  
  public void processSalesReport() 
  {// begin processSalesReport method By: Frankie Deleon
    int size = 0; // declare local size variable and initalize to 0. By: Frankie Deleon
    int qtrCounter = 0; // declare local qtrCounter variable and initalize to 0. By: Frankie Deleon
    int monthCounter = 0; // declare local monthCounter variable and initalize to 0. By: Frankie Deleon
    String aSalesReport = "%n%nTANDEM ENTERPRISES"; // declare aSalesReport string and initialize to "\n\nTANDEM ENTERPRISES" By: Frankie Deleon
    
    SalesReport anotherObj = new SalesReport(); // declare new SalesReport object anotherObj. By: Frankie Deleon
    

    anotherObj.setProjectedSales(); //call setProjectedSales() with new SalesReport object. By: Frankie Deleon
    
    size = anotherObj.setNoSalesReps(); // gather the size and call the setNoSalesReps() method. By: Frankie Deleon
    
    reports = new SalesReport[size]; // array initialized with the size variable By: Frankie Deleon
    
    for(int i = 0; i < size; i++) // 
    {
      qtrCounter = 1; // re-initalize qtrCounter to 1. By: Frankie Deleon
      reports[i] = new SalesReport(); //// Create a new SalesReport object and assign it to the current index of the arrayBy: Frankie Deleon
      reports[i].setSalesRep(i + 1); // call setSalesRep() by sending it the sum of i + 1  By: Frankie Deleon
      reports[i].setNoQtrs(); // call setNoQtrs() By: Frankie Deleon
      while(qtrCounter <= reports[i].getNoQtrs()) // while qtrCounter is less than or equal to the call to getNoQtrs()By: Frankie Deleon
      {
        monthCounter = 1; // reinitialize monthCounter to 1 By: Frankie Deleon
        reports[i].chooseQtr(qtrCounter); // call chooseQtr by sending it qtrCounterBy: Frankie Deleon
        while(monthCounter <= reports[i].getNoMonths()) //while monthCounter is less than or equal to the call of getNoMonths()By: Frankie Deleon
        {
          reports[i].determineMonthNo(monthCounter); // Call determineMonthNo() by sending it monthCounterBy: Frankie Deleon
          reports[i].setSalesRevenue(); // Call setSalesRevenue().By: Frankie Deleon
          reports[i].calculateQtrlySales();// Call calculateQtrlySales()By: Frankie Deleon
          ++monthCounter;// Pre-increment monthCounter.By: Frankie Deleon
        }
        ++qtrCounter; // Pre-increment qtrCounter.By: Frankie Deleon
      }
      reports[i].calculateAnnualSales(); //Call calculateAnnualSales(). By: Frankie Deleon
      aSalesReport += reports[i].getSalesRepRevReport(); //Add to aSalesReport the call to getSalesRepRevReport().By: Frankie Deleon
      aSalesReport += reports[i].getRepTargetMsg(); //Add to aSalesReport the call to getRepTargetMsg().By: Frankie Deleon
      salesReports.add(aSalesReport); //add() to the ArrayList salesReports, aSalesReport.By: Frankie Deleon
      /*Re-initialize aSalesReport to the a String literal formatted with 2 line advances at the beginning:
       * “TANDEM ENTERPRISES”.By: Frankie Deleon
       */
      aSalesReport = "%n%n TANDEM ENTERPRISES"; 
    }
    /*enhanced for-loop assign each String object from salesReports to eachReport.By: Frankie Deleon
     */
    for(String eachReport : salesReports) 
    {
      System.out.printf("%n%s", eachReport); // print eachReport By: Frankie Deleon
    }
    /*Call getCompanyTargetMsg() using the non-array object for SalesReport By: Frankie Deleon
     */
    anotherObj.getCompanyTargetMsg();
  } //// end processSalesReport method By: Frankie Deleon
  
 /*By: Frankie Deleon
 * writeSalesRepData method writes the sales report data to a file. It prompts the user to enter a filename,
 * opens the file in a PrintWriter, then uses a for-loop to retrieve the sales data from the SalesReport array 
 * and format it into a string with specific format specifiers. It then writes this string to the file using the 
 * PrintWriter object. If an IOException is thrown, it sets fileError to true and prints an error message.
 * If no file error is present, the method closes the PrintWriter object and prints a success message stating
 * the data has been written to the file.
 */
  
  public void writeSalesRepData()
  { // begin writeSalesRepData method By: Frankie Deleon
    String record; // declare and initialize record String. By: Frankie Deleon
    PrintWriter outputFile = null; //declare and initialize PrintWriter outputFile to null. By: Frankie Deleon
    boolean fileError = false; // declare and initalize boolean test variable fileError to false. By: Frankie Deleon
    
    try { // start try block By: Frankie Deleon
      /* By: Frankie Deleon
       * prompt user to Enter the file name for sales report (WARNING: This will erase a pre-existing file!):
       */
      System.out.printf("%nEnter the file name for sales report (WARNING: This will erase a pre-existing file!): ");
      fileName = input.next(); //capture user input to fileName variable. By: Frankie Deleon
      outputFile = new PrintWriter(fileName); //Open the file in PrintWriter. By: Frankie Deleon
      
      /*By: Frankie Deleon
       * for-loop to get the data from the array into the record variable using
       * these format specifiers: "%s, %d, %s, %.2f%n" in the order of the get
       * methods for the date, number of quarters, sales rep, and quarterly sales. 
       */
      for(int i = 0; i < reports.length; i++)
      {
        record = String.format("%s, %d, %s, %.2f%n",
                                      reports[i].getDate(),
                                      reports[i].getNoQtrs(),
                                      reports[i].getSalesRep(),                           
                                      reports[i].getQuarterlySales());
        outputFile.printf(record);
      }
    } catch(IOException e) //catch block that catches an IOException into e. By: Frankie Deleon
    {
      /*Use the err object from System to call printf() by sending it this message: File cannot be created. 
       */
      System.err.printf("%nFile cannot be created.%n"); 
      fileError = true; //Re-initialize fileError to true. By: Frankie Deleon
    }
    if(!fileError) //a single-selection if, test for there is no fileError. By: Frankie Deleon
    {
      outputFile.close(); //Close the outputFile By: Frankie Deleon
      /*Print the message: Data written to the Xxxxxxxxxxx file. where the x’s is the name of the file.
       * By: Frankie Deleon
       */
      System.out.printf("Data written to the %s file.%n", fileName); 
    }
  } // End writeSalesRepData method. By: Frankie Deleon
  
 /*By: Frankie Deleon
 * checkInputFile method that checks for the existence of a file, reads its contents, and prints them
 * out. It uses a try-catch block to handle potential exceptions such as file not found 
 * or null pointer exceptions when trying to access or read a record. 
 */
  public void checkInputFile()
  { // begin checkInputFile method By: Frankie 
    String fileName = ""; // declare fileName String varibale. By: Frankie Deleon
    File file = null; // declare File variable file. By: Frankie Deleon
    String fileRecord = ""; //declare String variable fileRecord.  By: Frankie Deleon
    boolean fileNotFound = false; // declare boolean variable fileNotFound.  By: Frankie Deleon
    Scanner inputFile = null; // declare inputFile Scanner.  By: Frankie Deleon
    
    try { // being try block By: Frankie Deleon
      
      /*By: Frankie Deleon
       * Enter SalesReports.txt as the name of the file for this prompt.
       * Enter the name for the sales report file: 
       */
      System.out.printf("%nEnter the name for the sales report file: ");
      input.nextLine(); //Gather user input.  By: Frankie Deleon
      fileName = input.nextLine(); // Create the filename with user input. By: Frankie Deleon 
      file = new File(fileName); // Finish creating the File object with fileName. By: Frankie Deleon
      inputFile = new Scanner(file); // Finish creating the Scanner object with file. By: Frankie Deleon
      
      while(inputFile.hasNext()) //Use a while-loop by testing inputFile.hasNext() By: Frankie Deleon
      {
        fileRecord = inputFile.nextLine(); //read the next line from the inputFile into fileRecord. By: Frankie Deleon
        /*print what was just read. Use a format specifier with a line advance at the beginning. By: Frankie Deleon
         */
        System.out.printf("%n%s", fileRecord); 
      }
      System.out.println(); //Print a blank line using println(). By: Frankie Deleon
      
    }catch(IOException e) { //catch block that catches IOException into e By: Frankie Deleon
      /*err object using printf() sending it this message: File not found! By: Frankie Deleon
       */
      System.err.printf("File not found!%n"); 
      fileNotFound = true; //fileNotFound equals true if catch. By: Frankie Deleon
      
    }catch(NullPointerException e) { // a catch block that catches NullPointerException into e By: Frankie Deleon
      
      /*err object using printf()sending it this message: Record couldn’t be accessed or read. By: Frankie Deleon
       */
      System.err.printf("Record couldn't be accessed or read.%n"); 
      fileNotFound = true; //fileNotFound equals true if catch. By: Frankie Deleon
    }
    
    if(!fileNotFound) //g a single-selection if, test for there is no fileNotFound.  By: Frankie Deleon
    {
      inputFile.close(); // close inputFile. By: Frankie Deleon
    }
  } // // End checkInputFile method By: Frankie
 /* By: Frankie Deleon
 * exitMessage method prints the exit message "Exiting Sales System."
 */
  public void exitMessage()
  { // begin exitMessage method By: Frankie
    System.out.printf("%nExiting Sales System.%n"); //print the exit message Exiting Sales System. By: Frankie Deleon
  }  // End exitMessage method By: Frankie
} //End SalesSystem class By: Frankie Deleon