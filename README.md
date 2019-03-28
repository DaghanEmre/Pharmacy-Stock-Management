# Pharmacy-Stock-Management
dealing with variables, loops, string operations and file read operations.

In this experiment, we are expected to implement a Pharmacy Stock Management System.
We will read prescriptions and price list from input files. For reading data from input files,
we can use the code given in Appendix A. My task is to calculate total cost of a
prescription based on the price list. While developing my program, i am also supposed
document it. To achieve this, i will use Javadoc.

1) INTRODUCTION
In this assignment, it is expected from us to develop a program that holds
some medicines with their information, controls the price for same medics,
and invoicing the prescription.
2) PROBLEM AND SOLUTION
I have faced some problems while implementing the code. First one is,
making an Medicament Class Arraylist that is called medicList in code, as
an attiribute of Prescription class. First, i just put description of medicList
without allocating space(Writing “new”). But it always threw exception
like “indexoutofbound”. Then i add “new” keyword in attribute part of
Prescription class. That worked properly.
3) DATA STRUCTURE
I used an arraylist for holding mediciments with their informations. I chose
that option, because it gives the program flexibility to add and search in
array. And also, i use a prescription object to hold patient information and
date. It gives me an advantage to transfer these info’s in order. Another
data structere that i used is also an Arraylist for holding medic info’s of
prescription.
4) ALGORITHMS
I controled the validity dates when making Medicement objects. İf a medic
was expired, then i didn’t make an object it. It gave me a chance to avoid
from searching whole arraylist for validity date control, and it means
getting an advantage as O(N). My operations has O(N^2) complexity in
total.
