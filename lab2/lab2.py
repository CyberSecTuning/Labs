"""
FileName: lab2.py
Assignment: Fun with numbers!
Author: Frankie Deleon
abc123: tnz168

Program Purpose: Write a program that creates a text file (randnums.txt) that stores a user-defined amount of random numbers.
The program would then open randnums.txt and read its contents. As each number is read from the file,
the program should check to see if the number is divisible by 2, divisible by 3, divisible by 5, and divisible by 10.
The results should be printed line-by-line, as shown in the example below.
"""
#imort random library.
import random

#Use the global constants RAND_LO = 0 and RAND_HI = 999 to hold the lower and upper boundaries for the random numbers to be generated.
RAND_LO=0
RAND_HI=999
num=0

def main():
    """devmain"""

#Define div_by_2-10 functions to be used later in the code. 
#Define a function named div_by_2 that accepts an integer and returns the Boolean value True if the integer is divisible by 2, otherwise False.
def div_by_2(num):
    if num%2==0:
        return True
    else:
        return False
#Define a function named div_by_3 that accepts an integer and returns the Boolean value True if the integer is divisible by 3, otherwise False.
def div_by_3(num):
    if num%3==0:
        return True
    else:
        return False
#Define a function named div_by_5 that accepts an integer and returns the Boolean value True if the integer is divisible by 5, otherwise False.
def div_by_5(num):
    if num%5==0:
        return True
    else:
        return False
#Define a function named div_by_10 that accepts an integer and returns the Boolean value True if the integer is divisible by 10, otherwise False.
def div_by_10(num):
    if num%10==0:
        return True
    else:
        return False

#Define a function named print_line with the parameters of num_in and num_ln.
def print_line(num_ln,num_in):
    #The function prints one line each time it is called with the following specifications
    # print(f'|  {num_ln:>1}  | {num_in:<1}',"|",div_by_2(num_in)," |",div_by_3(num_in)," |",div_by_5(num_in)," |",div_by_10(num_in)," |")
    print(f'|  {num_ln:<3}| {num_in:<4}| {div_by_2(num_in)}  | {div_by_3(num_in)}  | {div_by_5(num_in)}  | {div_by_10(num_in)}  |')
#Prompt the user to enter a number between 1 and 100 using an input validation while loop 
# to ensure the number entered is between 1 and 100. The prompt should continue until an acceptable number is entered.
print('How many random integers should be written to the file?')
while True:
    num=int(input("Please enter a number between 1 and 100: "))
    if num>=1 and num<=100:
        break
#Open (create) randnums.txt for writing.    
file=open("randnums.txt","w")
#Use a for loop to write the user-defined amount of random numbers to the output file.
for i in range(num):
    file.write(str(random.randint(RAND_LO,RAND_HI))+"\n")
#Close the output file.
file.close()

#Utilize a Try/Except block with exceptions for IOError and ValueError.
try:
    #Open randnums.txt for reading.
    file = open("randnums.txt", "r")
    infile = file.readlines()
    #create a list to append the data
    lt = []
    # Variable to keep running total of lines
    total = 0
    #Variable to keep running total of num
    sum = 0
    #Print a header and footer for the table
    print('')
    print("-------------------------------------------------")
    print("|Line | Num | Div/2  | Div/3  | Div/5  | Div/10 |")
    print("-------------------------------------------------")

    #Create loop to generate total and average. 
    for i in infile:
        lt.append(int(i))
        total += 1
        sum += int(i)
        print_line(total,int(i))
    print("-------------------------------------------------")
    #Print the value of the running total and the average
    print(f'Total: {sum:,}',' ','Average:',f'{sum/total:.2f}')
except IOError:
    print('An error occurred while trying to read the file.')
except ValueError:
    print('Non-numeric data is found in the file.')
file.close()



if __name__ == '__main__' :
    main()
    