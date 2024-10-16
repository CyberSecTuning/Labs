/***********************************************************************************************
  * Author: Frankie Deleon & John Olsen
  * Course Section: IS-2063-ON2
  * Date: 04/23/2023
  *********************************************************************************************/
/*
 * 
 * PROGRAM PURPOSE:main class for the program. It creates a SalesSystem object named sales, calls the start() method of the 
 * sales object to begin the sales system, and then exits the program with a status code of 0.
 */
public class DeleonOlsenON1PA3 // main class DeleonOlsenON1PA3. By: Frankie Deleon
{
  /*Main method for DeleonOlsenON1PA3 class. By: Frankie Deleon
   */
  public static void main(String[] args)
  {
    SalesSystem sales = new SalesSystem(); // Create SalesSystem object named sales. By: Frankie Deleon
    sales.start(); // Call start() from SalesSystem object sales. By: Frankie Deleon
    System.exit(0); //Exit statement. By: Frankie Deleon
  }
}

/* Output 1:
 **SALES ON TRACK**
TANDEM ENTERPRISES

Begi1n the processing of a sales report? Enter 'Y' or 'N': n

Exiting Sales System.

TANDEM ENTERPRISES

Begi1n the processing of a sales report? Enter 'Y' or 'N': y

What is the projected annual sales for Tandem?  5OO000

Warning:  You entered an invalid integer or floating-point value.

What is the projected annual sales for Tandem?  500000

How many sales reps work for Tandem?  @

Warning:  You entered an invalid integer or floating-point value.

How many sales reps work for Tandem?  2

Enter the name of a sales rep:  ju!ian caesar

Invalid name!  Please re-enter:  julian caesar

Sales Rep Name:  julian caesar

Is this name correct?  'Y' or 'N':  y

Enter the number of quarters worked (no less than 1 or greater than 4):  l

Warning:  You entered an invalid integer or floating-point value.

OUT OF RANGE!  Re-enter the number of quarters worked (no less than 1 or greater than 4):  0

OUT OF RANGE!  Re-enter the number of quarters worked (no less than 1 or greater than 4):  5

OUT OF RANGE!  Re-enter the number of quarters worked (no less than 1 or greater than 4):  1

1.  First Quarter
2.  Second Quarter
3.  Third Quarter
4.  Fourth Quarter

Choose the quarter in which sales were earned:  !

Warning:  You entered an invalid integer or floating-point value.

OUT OF RANGE!

1.  First Quarter
2.  Second Quarter
3.  Third Quarter
4.  Fourth Quarter

Choose the quarter in which sales were earned:  0

OUT OF RANGE!

1.  First Quarter
2.  Second Quarter
3.  Third Quarter
4.  Fourth Quarter

Choose the quarter in which sales were earned:  5

OUT OF RANGE!

1.  First Quarter
2.  Second Quarter
3.  Third Quarter
4.  Fourth Quarter

Choose the quarter in which sales were earned:  1

Enter the sales revenue for the 1st month of the First Quarter:  !00000

Warning:  You entered an invalid integer or floating-point value.

Enter the sales revenue for the 1st month of the First Quarter:  100000

Enter the sales revenue for the 2nd month of the First Quarter:  50000

Enter the sales revenue for the 3rd month of the First Quarter:  100000

Enter the name of the next sales rep:  monique La femme

Sales Rep Name:  monique La femme

Is this name correct?  'Y' or 'N':  y

Enter the number of quarters worked (no less than 1 or greater than 4):  2

1.  First Quarter
2.  Second Quarter
3.  Third Quarter
4.  Fourth Quarter

Choose the quarter in which sales were earned:  1

Enter the sales revenue for the 1st month of the First Quarter:  100000

Enter the sales revenue for the 2nd month of the First Quarter:  75000

Enter the sales revenue for the 3rd month of the First Quarter:  25000

1.  First Quarter
2.  Second Quarter
3.  Third Quarter
4.  Fourth Quarter

Choose the next quarter in which sales were earned:  2

Enter the sales revenue for the 1st month of the Second Quarter:  10000

Enter the sales revenue for the 2nd month of the Second Quarter:  25000

Enter the sales revenue for the 3rd month of the Second Quarter:  30000

%n%nTANDEM ENTERPRISES
SALES REVENUE FOR 1 QUARTER(S) OF 2023
SALES REP:  Julian Caesar

Total Year-To-Date:      $         250,000.00

Keep up the GOOD work, Julian.  There is a possible year-end bonus!

%n%n TANDEM ENTERPRISES
SALES REVENUE FOR 2 QUARTER(S) OF 2023
SALES REP:  Monique La femme

Total Year-To-Date:      $         265,000.00

Keep up the GOOD work, Monique.  There is a possible year-end bonus!

CORPORATE SALES PERFORMANCE

It's been a GOOD year so far.  There could be a year-end bonus of 
about 2-5% if we can keep on top of our sales goals.  Thank you all 
and please continue your excellent effort!

Enter the file name for sales report (WARNING: This will erase a pre-existing file!): SalesReports.txt
Data written to the SalesReports.txt file.

Enter the name for the sales report file: salesreports.txt

04/23/23, 1, Julian Caesar, 250000.00
04/23/23, 2, Monique La femme, 265000.00

Exiting Sales System.

 
 * Output 2: 
 ***SALES NOT ON TRACK***
TANDEM ENTERPRISES

Begi1n the processing of a sales report? Enter 'Y' or 'N': Y

What is the projected annual sales for Tandem?  500000

How many sales reps work for Tandem?  1

Enter the name of a sales rep:  stella brown

Sales Rep Name:  stella brown

Is this name correct?  'Y' or 'N':  y

Enter the number of quarters worked (no less than 1 or greater than 4):  1

1.  First Quarter
2.  Second Quarter
3.  Third Quarter
4.  Fourth Quarter

Choose the quarter in which sales were earned:  3

Enter the sales revenue for the 1st month of the Third Quarter:  150000

Enter the sales revenue for the 2nd month of the Third Quarter:  55000

Enter the sales revenue for the 3rd month of the Third Quarter:  80000

%n%nTANDEM ENTERPRISES
SALES REVENUE FOR 1 QUARTER(S) OF 2023
SALES REP:  Stella Brown

Total Year-To-Date:      $         285,000.00

Keep up the GOOD work, Stella.  There is a possible year-end bonus!

CORPORATE SALES PERFORMANCE

Sales are lagging projections.  A year-end bonus may not be possible.

Enter the file name for sales report (WARNING: This will erase a pre-existing file!): SalesReport.txt
Data written to the SalesReport.txt file.

Enter the name for the sales report file: SalesReport.txt

04/23/23, 1, Stella Brown, 285000.00

Exiting Sales System.

 
 */