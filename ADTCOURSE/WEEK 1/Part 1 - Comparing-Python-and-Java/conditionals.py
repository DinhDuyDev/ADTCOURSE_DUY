'''
   conditionals.py
   Jeff Ondich, 2013-01-03
   Anna Rafferty

   A tiny illustration of if-statements and console input.

   Intended as the Python half of parallel examples in Python and
   Java. See Conditionals.java.
'''

numberString = input('Number, please: ')
number = int(numberString)

if number > 100:
    print('Gosh, %d is a big number' % number)
elif number == 3:
    print('3 is my lucky number')
elif number >= 0:
    print('%d is pretty little' % number)
else:
    print('%d is negative' % number)
