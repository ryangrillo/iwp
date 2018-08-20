
- This project was created in Eclipse with Maven dependencies. In order to 
  compile it needs to run in an IDE so that these external depencies can be 
  installed.

- In order to start the program:
	run StartApp.java in the app package. It has the main method
	
- The input will be read in from jobs.txt in the src folder. 
  It is in JSON format
  
- Fees such as base margins, salesTax and extra margins are read in from 
  a yaml file called feeAmounts.  
  
- When the program runs it will save to a file called invoice.txt in the
  invoice folder at the program level.  The program needs to be refreshed (F5)
  in order for the saved file to appear





Problem Statement:

At InnerWorkings a "job" is a group of print items.  For example,
a job can be a run of business cards, envelopes, and letterhead together.

Some items qualify as being sales tax free, whereas, by default, others 
are not.  Sales tax is 7%.

InnerWorkings also applies a margin, which is the percentage above printing 
cost that is charged to the customer.  For example, an item that costs $100 
to print that has a margin of 11% will cost:

item: $100 -> $7 sales tax = $107
job:  $100 -> $11 margin
total: $100 + $7 + $11 = $118

The base margin is 11% for all jobs this problem.  Some jobs have an
"extra margin" of 5%.  These jobs that are flagged as extra margin have
an additional 5% margin (16% total) applied.

The final cost is rounded to the nearest even cent.  Individual items are 
rounded to the nearest cent.

Write a program that calculates the total charge to a customer
for a job (Bonus: Try to read the input from a file and output the invoice to a file).  
The program should accept the inputs below and output the 
total bill for the customer.  

Use Java/J2EE for the solution.

Include this problem statement with your solution.



Job 1:

extra-margin

envelopes 520.00

letterhead 1983.37 exempt



should output:

envelopes: $556.40

letterhead: $1983.37

total: $2940.30



Job 2:

t-shirts 294.04



output:

t-shirts: $314.62

total: $346.96



Job 3:

extra-margin

frisbees 19385.38 exempt

yo-yos 1829 exempt



output:

frisbees: $19385.38

yo-yos: $1829.00

total: $24608.68
