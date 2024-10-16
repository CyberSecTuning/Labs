"""
FileName: progcourses.py
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

#Create CourseSect Class.
class CourseSect:
    #create __init_ for all data items.
    def __init__(self,CRN, Subject, Course, Section, Title, Credit_hours, Meeting_time, Course_type, Room, Instructor, Campus):
        #
        self.CRN = CRN
        self.Subject = Subject
        self.Course = Course
        self.Section = Section
        self.Title = Title
        self.Credit_hours = Credit_hours
        self.Meeting_time = Meeting_time
        self.Course_type = Course_type
        self.Room = Room
        self.Instructor = Instructor
        self.Campus = Campus

    #create the get_ for each attribute
    def get_CRN(self):
        return self.CRN

    def get_Subject(self):
        return self.Subject

    def get_Course(self):
        return self.Course

    def get_Section(self):
        return self.Section

    def get_Title(self):
        return self.Title

    def get_Credit_hours(self):
        return self.Credit_hours

    def get_Meeting_time(self):
        return self.Meeting_time

    def get_Course_type(self):
        return self.Course_type

    def get_Room(self):
        return self.Room

    def get_Instructor(self):
        return self.Instructor

    def get_Campus(self):
        return self.Campus

