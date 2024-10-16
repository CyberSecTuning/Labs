"""
FileName: lab3.py
Assignment: Lab03: Class Schedules
Author: Frankie Deleon
abc123: tnz168

Program Purpose: Since it is time to start planning for next semester,
write a program that displays information for the programming courses offered by the IS department.
Program Objectives:
• Procedural and Object-Oriented Programming
• Classes
• Working with Instances
• Sequences
• Finding Items in Lists with the in Operator
• List Methods and Useful Built-in Functions
• Processing Lists
Your program will:
1. Create a python file named progcourses.py for the class CourseSect.
2. The CourseSect class will contain set and get functions,
as well as an initializer for the following data items:
o CRN
o Subject
o Course
o Section
o Title
o Credit Hours
o Meeting Time
o Course Type
o Room
o Instructor
o Campus
CourseList.xlsx is provided in the BlackBoard assignment page that includes all data.
3. Initialize a blank list to hold the course objects.
4. Instantiate all CourseSect objects and append them to your list.
5. Print out a brief list of courses that includes CRN, Course/Section, Course Title, and Instructor.
6. Prompt the user to enter a CRN number.
o If the CRN is not present, print an error message and exit the program.
o If the CRN is good, print a header that references the CRN, and prints all of the course details
"""
#import classes from progcourses.py
#import csv
import csv
from progcourses import CourseSect

#define main
def main():
    """devmain"""
    #create list for objects
    objects = []
    #create a file name for csv.
    file_name = "CourseList.csv"
    #use while statement to open file_name as csvfile.
    with open(file_name) as csvfile:
        #create variable reader to use csv.DictReader to read the csvfile and use delimiter=';'
        reader = csv.DictReader(csvfile, delimiter=';')
        #create loop to create objects of the excel files contents and append them to empty list
        for row in reader:
            new_object = CourseSect(row['CRN'],row['subject'],row['course'],row['section'],row['title'],row['cretits'],row['time'],row['type'],row['room'],row['instructor'],row['campus'])
            objects.append(new_object)

    #Print Header
    print()
    print("CRN".ljust(7) + "Course/Sect".ljust(13) + "Course Title".ljust(32) + "Instructor")
    print("---------------------------------------------------------------------")
    #Create the Table of objects using get_ to retrieve the item from the list.
    for item in objects:
        #created a variable to format the subject, course and section.
        cousect = item.get_Subject() +"-" + item.get_Course() + '-' + item.get_Section().zfill(0)
        #create variable for table output. Used ljust to allight text to the left and create room to format text as needed.
        output = item.get_CRN().ljust(7) + cousect.ljust(13) +item.get_Title().ljust(32) +item.get_Instructor()
        #print the output.
        print(output)

    #Create variable for user CRN input.
    print()
    user_input = (input('Enter a CRN numer: '))
    print()


    #Create variable for if statement to test if crn is found in loop
    found = 0
    #Create loop to go through objects list and search item
    for item in objects:
        #create variable crn for item to get_CRN()
        crn = item.get_CRN()
      #create if statement for user input equal to crn
        if user_input == crn:
        #print the correctly formatted outputs as needed calling item.get_
            print(f'The details for CRN #{user_input} are:\n')
            print(f'{item.get_Subject()}-{item.get_Course()}-{item.get_Section()} {item.get_Title()}')
            print('Credits:'.rjust(11) + f'\t{item.get_Credit_hours()}')
            print('Time:'.rjust(11) + f'\t{item.get_Meeting_time()}')
            print('Type:'.rjust(11) + f'\t{item.get_Course_type()}')
            print('Room:'.rjust(11) + f'\t{item.get_Room()}')
            print('Instructor:'.rjust(11) + f'\t{item.get_Instructor()}')
            print('Campus:'.rjust(11) + f'\t{item.get_Campus()}')
            # if user_input == crn +1 to found variable and end the loop
            found = 1
            break
        #if found variable has not changed from 0 then CRN from user input does not exist.
    if found == 0:
            print(f'CRN #{user_input} does not exist')

#call the program.
if __name__ == '__main__' :
    main()
