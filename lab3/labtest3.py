import pandas as pd
from progcourses import *

def main():
    """devmain"""

    objects = []

    xls = pd.read_excel("CourseList.xlsx")
    import csv
    # with open(xls) as csvfile:
    #     reader = csv.DictReader(csvfile, delimiter=';')
    for row in xls:
        new_object = CourseSect(row[1],row[2],row[3],row[4],row[5],row[6],row[7],row[8],row[9],row[10],row[11])
        objects.append(new_object)
# (['CRN', 'subject', 'course', 'section', 'title', 'cretits', 'time', 'type', 'room', 'instructor', 'campus'])
# (row['CRN'],row['subject'],row['course'],row['section'],row['title'],row['cretits'],row['time'],row['type'],row['room'],row['instructor'],row['campus'])
    print()
    print("CRN".ljust(7) + "Course/Sect".ljust(13) + "Course Title".ljust(32) + "Instructor")
    print("---------------------------------------------------------------------")

    for item in objects:
        cousect = item.get_Subject() +"-" + item.get_Course() + '-' + item.get_Section().zfill(0)
        output = item.get_CRN().ljust(7) + cousect.ljust(13) +item.get_Title().ljust(32) +item.get_Instructor()
        print(output)


    print()
    user_input = (input('Enter a CRN numer: '))
    print()


    # if user_input == item.get_CRN():
    found = 0
    for item in objects:
      crn = item.get_CRN()
      if user_input == crn:
        print(f'The details for CRN #{user_input} are:\n')
        print(f'{item.get_Subject()}-{item.get_Course()}-{item.get_Section()} {item.get_Title()}')
        print('Credits:'.rjust(11) + f'\t{item.get_Credit_hours()}')
        print('Time:'.rjust(11) + f'\t{item.get_Meeting_time()}')
        print(f'Type:'.rjust(11) + f'\t{item.get_Course_type()}')
        print(f'Room:'.rjust(11) + f'\t{item.get_Room()}')
        print(f'Instructor:'.rjust(11) + f'\t{item.get_Instructor()}')
        print(f'Campus:'.rjust(11) + f'\t{item.get_Campus()}')
        found = 1
        break
    if found == 0:
        print(f'CRN #{user_input} does not exist')

if __name__ == '__main__' :
    main()
