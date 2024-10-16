/***********************************************************************************************
  * Author: Frankie Deleon & John Olsen
  * Course Section: IS-2063-ON2
  * Date: 03/26/2023
  *********************************************************************************************/
  import java.util.Calendar; // By Frankie Deleon: Import Calendar
  import java.util.Scanner; // By Frankie Deleon: Import Scanner


  /*By Frankie Deleon:
   * Public class DeleonOlsenON1PA2:
   * a program that computes annual sales revenue to-date to determine
   * the status of the company’s sales revenue and whether a year-end bonus is in store for the
   * employees. Sales revenue is captured by month within a quarter; therefore, the user can enter as
   * many quarters as needed as long as the quarters are not less than 1 or greater than 4. If sales
   * revenue is on target by 50% or more for a sales rep, an encouraging message is sent; otherwise,
   * a warning is sent. If sales revenue to date for the company is greater than or equal to 100% of
   * projected annual sales, then employees qualify for a 2-5% year-end bonus; otherwise, no yearend bonus can be expected. Use printf() with format specifiers where needed.
   */

  public class DeleonOlsenON1PA2
  {

    private static Scanner input = new Scanner(System.in); // By Frankie Deleon: Declare private static field Scanner input variable
    private static String monthNo; //By Frankie Deleon: Declare private static field String variable monthNo.
    private static String salesRep; //By Frankie Deleon: Declare private static field String variable salesRep.
    private static String quarter; //By Frankie Deleon: Declare private static field String variable quarter.
    private static double quarterlySales; //By Frankie Deleon: Declare private static field double variable quarterlySales.
    private static int qtrCounter; //By Frankie Deleon: Declare private static field int variable qtrCounter.
    private static int noOfQtrs; //By Frankie Deleon: Declare private static field int variable noOfQtrs.

 /*By Frankie Deleon:
   * Main method for the program DeleonOlsenON1PA2.
   * Captures inputs and validation loops for annual sales, and number of sales reps.
   * Calls all the methods in the program using a do-while loop if salesRepCtr is less than noSalesReps.
   * Then prints prints encouraging message or warning.
   */
    public static void main(String[] args)
    {

      double salesRevenue = 0.0; //By Frankie Deleon: declare double salesRevenue
      double annualSales = 0.0; //By Frankie Deleon: declare double annualSales
      double projectedSales = 0.0; //By Frankie Deleon: declare double projectedSales
      double percOfTargetCo = 0.0; //By Frankie Deleon: declare double percOfTargetCo
      double percOfTargetRep = 0.0; //By Frankie Deleon: declare double percOfTargetRep
      int qtrChoice = 0; //By Frankie Deleon: declare int qtrChoice
      int monthCounter = 0; //By Frankie Deleon: declare int monthCounter
      int noOfMonths = 3; //By Frankie Deleon: declare int noOfMonths to 3.
      int noSalesReps = 0; //By Frankie Deleon: declare int noSalesReps
      int salesRepCtr = 0; //By Frankie Deleon: declare int salesRepCtr



      System.out.printf("%nWhat is the projected annual sales for Tandem? "); // By Frankie Deleon: Prompt 1 asking for projected annual sales.


      while (!input.hasNextDouble()) //By Frankie Deleon:  validate for a floating point using a while loop.
      {
        input.next(); //By Frankie Deleon: Gather input
        System.out.printf("%nNOT a valid floating-point! Please re-enter the projected sales for Tandem: "); //By Frankie Deleon: Advise not a valid floating-point.
      }
      projectedSales = input.nextDouble(); //By Frankie Deleon:  gather input for projectedSales



    System.out.printf("%nHow many sales reps work for Tandem? "); //By Frankie Deleon: Prompt 2 asking how many sales reps work for Tandem.


    while (!input.hasNextInt()) //By Frankie Deleon:  validate for a integer using a while loop.
    {
      input.next(); //By Frankie Deleon: Gather input
      System.out.printf("%nNOT a valid integer! Please re-enter the projected sales reps for Tandem: "); //By Frankie Deleon: Advise not a valid integer.
    }
    noSalesReps = input.nextInt(); //By Frankie Deleon:  gather input for number of sales reps.


      do //By Frankie Deleon:  begin the do-while loop.
      {
        qtrCounter = 1; //By Frankie Deleon:  Reinitialize qtrCounter to 1.
        quarterlySales = 0.0; // By Frankie Deleon: Zero out quarterlySales.
        salesRepCtr++; //By Frankie Deleon: Post-increment salesRepCtr.

        promptSalesRep(salesRepCtr); //By Frankie Deleon: Call promptSalesRep().
        promptNoQtrs(); //By Frankie Deleon:  Call  promptNoQtrs().


        while(qtrCounter <= noOfQtrs) //By Frankie Deleon: Nested while loop to control the number of quarters.
        {

          monthCounter = 1; //By Frankie Deleon: Initialize monthCounter to 1.
          qtrChoice = chooseQtr(); //By Frankie Deleon: Call chooseQtr().

          //
          while(monthCounter <= noOfMonths)//By Frankie Deleon: Nested, nested while loop controls the number of months within a quarter.
          {
            determineMonthNo(monthCounter); //By Frankie Deleon: Call determineMonthNo().

            salesRevenue = promptSalesRevenue(); //By Frankie Deleon: Call promptSalesRevenue().

            quarterlySales += salesRevenue; //By Frankie Deleon: Use combined assignment operator to add salesRevenue to quarterlySales.

            ++monthCounter;//By Frankie Deleon: Pre-increment monthCounter.

          } //By Frankie Deleon: end of nested while loop
          annualSales += quarterlySales; //By Frankie Deleon: Use combined assignment operator to add quarterlySales to annualSales.
          ++qtrCounter; //By Frankie Deleon:  Pre-increment qtrCounter.
        } //By Frankie Deleon: end of nested while loop



         printSalesRepRevReport(); //By Frankie Deleon: Call printSalesRepRevReport().

         percOfTargetRep = quarterlySales / (projectedSales/noSalesReps)* 100; //By Frankie Deleon: Calculate the percOfTargetRep which determines whether the sales rep is on target for their portion of the projected sales.

       if(noOfQtrs < 4) //By Frankie Deleon: if statement testing if the noOfQtrs is less than 4
       {
          /**
          * By John Olsen
          * ternary operation to test if percOfTargetRep is greater than or equal to 50,
         if so print where the substring() grabs the first name and uppercases the first letter.
         Use the following message as the first value which will have no semicolon at the end.
         */
         System.out.printf(percOfTargetRep >= 50 ? String.format( "%nKeep up the GOOD work, %s. "
                             + "There is a possible year-end bonus!%n", salesRep.substring(0, salesRep.indexOf(' ')).substring(0, 1).toUpperCase()
                             + salesRep.substring(1, salesRep.indexOf(' ')))
                             : "%nSo far sales are lagging behind projections.%n");


       }//By Frankie Deleon: end if scope



      }//By Frankie Deleon: End do Scope
      while (salesRepCtr < noSalesReps);//By Frankie Deleon: end do-while

    percOfTargetCo = (annualSales/projectedSales)* 100;
    /*By John Olsen Calculate the percOfTargetCo which determines whether or not the company is on track to hit projections or not
    */

    //By Frankie Deleon: print 4
    System.out.printf("CORPORATE SALES PERFORMANCE%n%n");

    //By Frankie Deleon: ternary operation to test if percOfTargetCo is greater than or equal to 100, if true bring 'good year' message, if false print 'sales are lagging' message.
    System.out.printf(percOfTargetCo >= 100
                        ? "It's been a GOOD year so far. There could be a year-end bonus of about 2-5%% if we can keep on top of our sales goals. Thank you all and please continue your excellent effort!\n"
                        : "Sales are lagging projections. A year-end bonus may not be possible");

    System.exit(0); //By Frankie Deleon:  Exit program
    }

    //======================================================================================
    /*By Frankie Deleon:
     * Static void method which returns nothing and accepts salesRepCtr as a parameter.
     * the promptSalesRep method asks the user to Enter the name of a, or the next sales rep using
     * a ternary operation in a print statement.
     * A for loop is used to count the number of blank spaces.
     * Then the StringBuilder object was created to properly capitalize the sales rep's name.
     */
    public static void promptSalesRep(int salesRepCtr) //By John Olsen Static void method that accepts salesRepCtr as a parameter
    {
      int index; // By Frankie Deleon: initialize int index.
      int spaceCount = 0; // By John Olsen initalize int spaceCount
      input.nextLine();
      System.out.printf("%nEnter the name of %s sales rep: ", salesRepCtr == 1 ? "a" : "the next"); // By John Olsen Enter the name of the salesRep
      salesRep = input.nextLine();

        for(char blank : salesRep.toCharArray()) // By John Olsen for loop to store number of spaces in salesRep
        {
          if(blank ==' ') // By John Olsen, if statement to check whether a variable named blank is equal to a space character
          {

            spaceCount++; // By John Olsen increment operator for spaceCount
            }
        }
        StringBuilder rep = new StringBuilder(salesRep); //By John Olsen creates a new String Builder named rep and intializes it
                                                        // with the contents of a String variable named salesRep
        rep.setCharAt(0, salesRep.toUpperCase().charAt(0)); // By John Olsen Capitilize the the first letter of the salesRep name
        index = salesRep.indexOf(' '); // By John Olsen returns index of the first character in salesRep

        for(int i = 1; i <= spaceCount; i++) // By John Olsen for loop to iterate through space characters in salesRep
        {// By Frankie Deleon: begin for loop

          rep.setCharAt(++index, salesRep.toUpperCase().charAt(index));
          index = salesRep.indexOf(' ', index);

        } //By Frankie Deleon: End for loop.

        salesRep = rep.toString(); //By Frankie Deleon: sales rep is equal to rep.toString().

      }
      //=============================================================================================
      /*By Frankie Deleon:
       * Static void method which returns nothing with no parameters.
       * The promptNoQtrs method asks the user to Enter the number of quarters worked.
       * The input will be tested using a while validation loop to test if the value is an integer.
       */
      public static void promptNoQtrs()
      {

       //By Frankie Deleon: prompt for number of quarters worked.
        System.out.printf("%nEnter the number of quarters worked (no less than 1 or greater than 4): ");


        while(!input.hasNextInt()) { //By Frankie Deleon: while loop input validation for next integer.
          input.next(); //By Frankie Deleon: Gather input
          System.out.printf("%nNOT a valid integer! Please re-enter the number of quarters worked (1-4): "); //By Frankie Deleon: prompt user the input was not a valid integer.
        }

        noOfQtrs = input.nextInt(); //By Frankie Deleon: noOfQtrs is equal to the next int input.
      }
      //======================================================================================

     /*By Frankie Deleon:
      * Static integer type method which accepts no parameters and returns qtrChosen.
      * The chooseQtr method will prompt the user with the quarters to choose from then ask to select
      * the quarter in which sales were earned.
      * A while input validation will be used to determine if the value was an integer, if not the prompt will be asked again.
      * The method will return the qtrChosen.
      */
      public static int chooseQtr()
      {

        // By Frankie Deleon: declare local qtrChosen varibale
        int qtrChosen = 0;

        // By Frankie Deleon: prompt user for first-fourth quarter choices.
        System.out.printf("%n1. First Quarter");
        System.out.printf("%n2. Second Quarter");
        System.out.printf("%n3. Third Quarter");
        System.out.printf("%n4. Fourth Quarter");

        //By Frankie Deleon: Ternary operation used to prompt user to select current or next quarter in which sales were earnned if qtrCounter is greater than 1.
        System.out.printf("%n%nChoose the %squarter in which sales were earned: ", qtrCounter > 1 ? "next" : "");

        while(!input.hasNextInt()) ////By Frankie Deleon: while loop input validation for next int.
        {

          input.next(); //By Frankie Deleon: gather input

          //By Frankie Deleon:  Prompt user that input was not a valid integer and re enter the quarter which sales were earned.
          System.out.printf("%nNOT a valid integer! Please re-enter the quarter.%n");
          System.out.printf("%n1. First Quarter");
          System.out.printf("%n2. Second Quarter");
          System.out.printf("%n3. Third Quarter");
          System.out.printf("%n4. Fourth Quarter");
          System.out.printf("%n%nChoose the %squarter in which sales were earned: ", qtrCounter > 1 ? "next " : "");
        }
        qtrChosen= input.nextInt(); //By Frankie Deleon:  qtrchosen is equal to the correct int input from the user.

        //By Frankie Deleon:  quarter ternary operation if qtrChosen is equal to 1-4 select the corresponding quarter.
        quarter =(qtrChosen == 1) ? "First Quarter" : (qtrChosen == 2) ? "Second Quarter" : (qtrChosen == 3) ? "Third Quarter" : "Fourth Quarter";


        return qtrChosen;//By Frankie Deleon: return qtrChosen
      }

      //======================================================================================

     /*By Frankie Deleon:
      * Static void methods which returns nothing and accepts int monthCounter as a parameter.
      * This method uses a switch statement with monthCounter as its argument.
      * The switch will determine the month number using the monthCounter argument.
      */
      public static void determineMonthNo(int monthCounter)
      {

        //By Frankie Deleon: Switch statement with monthCounter as an argument.
        switch(monthCounter)
        {
          //By Frankie Deleon: The switch will determine the month number using the monthCounter argument.
          case 1:
            monthNo = "1st";
            break;
          case 2:
            monthNo = "2nd";
            break;
          case 3:
            monthNo = "3rd";
            break;
        }
      }
      //======================================================================================
      /*By Frankie Deleon:
       * Static double type method with no parameters, which will return salesRev.
       * The method promptSalesRevenue will ask the user to enter the sales revenue for the month and quarter.
       * A While validation loop is used to test whether the input is a valid floating-point.
       * If false the user will be prompted again.
       * The salesRev input gathered is returned.
       */
      public static double promptSalesRevenue()
      {

        double salesRev = 0.0; // By John Olsen declare salesRev variable


        System.out.printf("%nEnter the sales revenue for the %s month of the %s: ", monthNo, quarter);// By John Olsen ask user to input sales revenue for month and quarter

        while(!input.hasNextDouble()) { // By John Olsen while loop to validate if the input is a valid floating point
          input.next();
          System.out.printf("%nNOT a valid floating-point!%n"); // By John Olsen inform the user their input was not valid
          System.out.printf("%nPlease re-enter the sales revenue for the %s month of the %s: ", monthNo, quarter); // By John Olsen prompt user again

        }

        salesRev = input.nextDouble(); // By John Olsen gather input for salesRevenue double.
        return salesRev; // By Frankie Deleon: return salesRev.
      }
      //======================================================================================
      /* By Frankie Deleon:
       * void method which returns nothing, print SalesRepRevReport
       * will print the final output which includes the header, Sales revenue,
       * the sales rep, and Total Year-To-Date sales.
       */
      public static void printSalesRepRevReport()
      {

        Calendar dateTime = Calendar.getInstance(); //By Frankie Deleon: declare dateTime variable to get calendar instance.

        //By Frankie Deleon: print final output
        System.out.printf("%n%nTANDEM ENTERPRISES%n");
        System.out.printf("SALES REVENUE FOR %d QUARTER(S) OF %s", noOfQtrs, dateTime.get(Calendar.YEAR));
        System.out.printf("%nSALES REP:  %s%n", salesRep);
        System.out.printf("%nTotal Year-To-Date:            $%,.2f%n",quarterlySales);
      }
    }

  /* By Frankie Deleon:
   * Output 1:
   *
   * What is the projected annual sales for Tandem? 5OO000
   *
   * NOT a valid floating-point! Please re-enter the projected sales for Tandem: 500000
   *
   * How many sales reps work for Tandem? @
   *
   * NOT a valid integer! Please re-enter the projected sales reps for Tandem: 2
   *
   * Enter the name of a sales rep: julian caesar
   *
   * Enter the number of quarters worked (no less than 1 or greater than 4): I
   *
   * NOT a valid integer! Please re-enter the number of quarters worked (1-4): 1
   *
   * 1. First Quarter
   * 2. Second Quarter
   * 3. Third Quarter
   * 4. Fourth Quarter
   *
   * Choose the quarter in which sales were earned: W
   *
   * NOT a valid integer! Please re-enter the quarter.
   *
   * 1. First Quarter
   * 2. Second Quarter
   * 3. Third Quarter
   * 4. Fourth Quarter
   *
   * Choose the quarter in which sales were earned: 2
   *
   * Enter the sales revenue for the 1st month of the Second Quarter: !00000
   *
   * NOT a valid floating-point!
   *
   * Please re-enter the sales revenue for the 1st month of the Second Quarter: 100000
   *
   * Enter the sales revenue for the 2nd month of the Second Quarter: 50000
   *
   * Enter the sales revenue for the 3rd month of the Second Quarter: 100000
   *
   *
   * TANDEM ENTERPRISES
   * SALES REVENUE FOR 1 QUARTER(S) OF 2023
   * SALES REP:  Julian Caesar
   *
   * Total Year-To-Date:            $250,000.00
   *
   * Keep up the GOOD work, Julian. There is a possible year-end bonus!
   *
   * Enter the name of the next sales rep: Monique La Femme
   *
   * Enter the number of quarters worked (no less than 1 or greater than 4): 2
   *
   * 1. First Quarter
   * 2. Second Quarter
   * 3. Third Quarter
   * 4. Fourth Quarter
   *
   * Choose the quarter in which sales were earned: 1
   *
   * Enter the sales revenue for the 1st month of the First Quarter: 5000
   *
   * Enter the sales revenue for the 2nd month of the First Quarter: 6000
   *
   * Enter the sales revenue for the 3rd month of the First Quarter: 5000
   *
   * 1. First Quarter
   * 2. Second Quarter
   * 3. Third Quarter
   * 4. Fourth Quarter
   *
   * Choose the nextquarter in which sales were earned: 2
   *
   * Enter the sales revenue for the 1st month of the Second Quarter: 5000
   *
   * Enter the sales revenue for the 2nd month of the Second Quarter: 6000
   *
   * Enter the sales revenue for the 3rd month of the Second Quarter: 5000
   *
   *
   * TANDEM ENTERPRISES
   * SALES REVENUE FOR 2 QUARTER(S) OF 2023
   * SALES REP:  Monique La Femme
   *
   * Total Year-To-Date:            $32,000.00
   *
   * So far sales are lagging behind projections.
   *
   * CORPORATE SALES PERFORMANCE
   *
   * Sales are lagging projections. A year-end bonus may not be possible
   *
   * Output 2:
   *
   * What is the projected annual sales for Tandem? 500000
   *
   * How many sales reps work for Tandem? 2
   *
   * Enter the name of a sales rep: Julian Caesar
   *
   * Enter the number of quarters worked (no less than 1 or greater than 4): 1
   *
   * 1. First Quarter
   * 2. Second Quarter
   * 3. Third Quarter
   * 4. Fourth Quarter
   *
   * Choose the quarter in which sales were earned: 2
   *
   * Enter the sales revenue for the 1st month of the Second Quarter: 100000
   *
   * Enter the sales revenue for the 2nd month of the Second Quarter: 50000
   *
   * Enter the sales revenue for the 3rd month of the Second Quarter: 100000
   *
   *
   * TANDEM ENTERPRISES
   * SALES REVENUE FOR 1 QUARTER(S) OF 2023
   * SALES REP:  Julian Caesar
   *
   * Total Year-To-Date:            $250,000.00
   *
   * Keep up the GOOD work, Julian. There is a possible year-end bonus!
   *
   * Enter the name of the next sales rep: Monique La Femme
   *
   * Enter the number of quarters worked (no less than 1 or greater than 4): 2
   *
   * 1. First Quarter
   * 2. Second Quarter
   * 3. Third Quarter
   * 4. Fourth Quarter
   *
   * Choose the quarter in which sales were earned: 1
   *
   * Enter the sales revenue for the 1st month of the First Quarter: 25000
   *
   * Enter the sales revenue for the 2nd month of the First Quarter: 75000
   *
   * Enter the sales revenue for the 3rd month of the First Quarter: 25000
   *
   * 1. First Quarter
   * 2. Second Quarter
   * 3. Third Quarter
   * 4. Fourth Quarter
   *
   * Choose the nextquarter in which sales were earned: 2
   *
   * Enter the sales revenue for the 1st month of the Second Quarter: 10000
   *
   * Enter the sales revenue for the 2nd month of the Second Quarter: 25000
   *
   * Enter the sales revenue for the 3rd month of the Second Quarter: 30000
   *
   *
   * TANDEM ENTERPRISES
   * SALES REVENUE FOR 2 QUARTER(S) OF 2023
   * SALES REP:  Monique La Femme
   *
   * Total Year-To-Date:            $190,000.00
   *
   * Keep up the GOOD work, Monique. There is a possible year-end bonus!
   *
   * CORPORATE SALES PERFORMANCE
   *
   * It's been a GOOD year so far. There could be a year-end bonus of about 2-5% if we can keep on top of our sales goals. Thank you all and please continue your excellent effort!
   */