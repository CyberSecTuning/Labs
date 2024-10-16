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
2. The CourseSect class will contain set and get functions, as well as an initializer for the following data items:
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
from progcourses import *
import pandas as pd
# import openpyxl

def main():
    """devmain"""
    objects = []
    # file_name = openpyxl.load_workbook("CourseList.xlsx")
    xls = pd.read_excel("CourseList.xlsx")

    # df = pd.DataFrame(xls, columns=['CRN', 'subject', 'course', 'section', 'title', 'cretits', 'time', 'type', 'room', 'instructor', 'campus'])

    print(xls) #1 is the row number...


    # with open(file_name) as xlsx:
    #     reader = xlsx.DictReader(xlsx, delimiter=';')
    # for row in reader:
    # for line in file_name:

        # line = line.rstrip('\n')
#         # data = line.split(';')
#         new_object = CourseSect(line['CRN'],line['subject'],line['course'],line['section'],line['title'],line['cretits'],line['time'],line['type'],line['room'],line['instructor'],line['campus'])
#         objects.append(new_object)


#     print()
#     print("CRN".ljust(7) + "Course/Sect".ljust(13) + "Course Title".ljust(32) + "Instructor")
#     print("---------------------------------------------------------------------")

#     for item in objects:
#         cousect = item.get_Subject() +"-" + item.get_Course() + '-' + item.get_Section().zfill(0)
#         output = item.get_CRN().ljust(7) + cousect.ljust(13) +item.get_Title().ljust(32) +item.get_Instructor()
#         print(output)


#     print()
#     user_input = (input('Enter a CRN numer: '))
#     print()


#     # if user_input == item.get_CRN():
#     found = 0
#     for item in objects:
#       crn = item.get_CRN()
#       if user_input == crn:
#         print(f'The details for CRN #{user_input} are:\n')
#         print(f'{item.get_Subject()}-{item.get_Course()}-{item.get_Section()} {item.get_Title()}')
#         print('Credits:'.rjust(11) + f'\t{item.get_Credit_hours()}')
#         print('Time:'.rjust(11) + f'\t{item.get_Meeting_time()}')
#         print(f'Type:'.rjust(11) + f'\t{item.get_Course_type()}')
#         print(f'Room:'.rjust(11) + f'\t{item.get_Room()}')
#         print(f'Instructor:'.rjust(11) + f'\t{item.get_Instructor()}')
#         print(f'Campus:'.rjust(11) + f'\t{item.get_Campus()}')
#         found = 1
#         break
#     if found == 0:
#         print(f'CRN #{user_input} does not exist')

if __name__ == '__main__' :
    main()

