'''
   linereader.py
   Jeff Ondich, 2013-01-04
   Anna Rafferty

   Reads lines from a file, prints them in upper-case, and prints
   a count of the lines at the end.
   
   Intended as the Python half of parallel examples in Python and
   Java. See LineReader.java.
'''
import sys

inputFilePath = 'somelines.txt'
try:
    inputFile = open(inputFilePath)
except Exception as e:
    print('Cannot open', inputFilePath, file=sys.stderr)
    exit()

numberOfLines = 0
for line in inputFile:
    print(line.upper(), end='')
    numberOfLines += 1
print('\nNumber of lines:', numberOfLines)