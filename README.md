# Customer Database Project

This is a Java project I created up for a class to practice creating a database mangement system. This code is equipped to track names, addresses, service requests, deposits, etc,. 

## What It Does
- Lets you add new customers with their details (ID, name, address, etc.).
- Updates service requests or deposits if something changes.
- Deletes records that are over a year old.
- Shows all the customers in the list upon request.
- Provides a text file (`procedures.txt`) with basic instructions on how to use it.

The program is pretty simplistic but its fuctionality is useful. I built it to practice some Java basics like classes, lists, and file writing.

## How to Run It
1. **Grab the Files:** Download `Customer.java` and `CustomerDatabase.java` from this repo.
2. **Set It Up:** Open them in something like Eclipse, IntelliJ, or whatever Java IDE you’ve got. (Or just use a text editor and compile with `javac` if you’re old-school.)
3. **Run It:** Start `CustomerDatabase.java`—that’s the main one. It’ll pop up a menu in the console.
4. **Play Around:** Pick options like `1` to add a customer, `2` to update one, etc. Just follow the prompts!

You’ll need Java installed (like JDK 8 or newer). If it doesn’t work, double-check you’ve got both files in the same folder.

## Example
Here’s what the program looks like when you run it:

Pick something: 1=Add, 2=Update, 3=Purge, 4=Display, 5=Make Manual, 6=QuitWhat do you want to do? 1
ID: 1
Name: John Doe
Address: 123 Main St, Lansing, MI
Service Request: New Service
Deposit: 50.0Added: 
ID: 1, Name: John Doe, Address: 123 Main St, Lansing, MI, Status: Active, Request: New Service, Deposit: $50.0, Last Update: 2025-03-17


## Files Here
- `Customer.java`: The blueprint for what a customer looks like (ID, name, all that).
- `CustomerDatabase.java`: The main to run the program and perform functionalities
- `procedures.txt`: Gets made when you pick option 5. It’s just a quick guide I threw together.

## Why I Made It
I’m a sophomore majoring Computer Science at Central Michigan University, and this was a way to practice coding something useful.
