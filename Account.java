/*
Created by Christopher Benda
for CS1050, spring 2011
*/

import java.util.Scanner;

public class Account
{
  // add instance variables, constructor, and instance methods here:

	
	String name;
	Boolean loggedIn;
	int balance, password;

	public Account(String nameIn, int passwordIn)
	{
		name = nameIn;
		password = passwordIn;
		balance = 0;
		loggedIn = false;
	}

// deposit method
	public void deposit(int depositIn)
	{
		if(depositIn > 0)
		{	
			balance+=depositIn;
		}
		else if(depositIn <=0)
		{
			System.out.println("Amount to deposit must be positive");
		}
		
	}

// transferTo method
	public void transferTo(Account other, int amount)
	{
		System.out.println(this.name + " requesting transfer of " + amount + " to " + other.name);
		if(loggedIn == true)
		{
			if(amount <=0 || amount > balance)
			{
				System.out.println("Could not transfer (amount illegal)");
			}
			else if(amount > 0 && amount <= balance )
			{
				other.balance += amount;
				balance -= amount;
			}
		}
		else
		{
			System.out.println("Could not transfer (not logged in)");
		}
	}

// toString method
	public String toString()
	{
		String out= new String("[" +name + " " + balance + " " +loggedIn + "]");
		return out;
	}

// login method
	public void logIn()
	{
		String nameIn;
		int pass1In, pass2In;
		System.out.println("Logging in...");
		Scanner keys = new Scanner(System.in);
		System.out.print("Enter name: ");
		nameIn = keys.nextLine();
		
		if(nameIn.equals(name) )
		{
			System.out.print("Enter first password: ");
			pass1In= keys.nextInt();
			System.out.print("enter second password: ");
			pass2In = keys.nextInt();

			if(pass1In > 1 && pass1In < pass2In)
			{
				if(password == (pass1In*pass2In))
				{
					loggedIn= true;
					System.out.println("Welcome, "+name);
				}
				else
				{
					System.out.println("Incorrect password");
				}
			}
			else
			{
				System.out.println("Incorrect password");
			}
		}
		else
		{
			System.out.println("Unknown account name");
		}
	}


// logout method
	public void logOut()
		{
			loggedIn = false;
		}



 	 public static void main(String[] args)
 	 {
   		 Account a = new Account( "Bill", 794377 );
   		 Account b = new Account( "George", 807661 );

   		 a.deposit( -100 );   // test whether a negative amount can be deposited

   		 a.deposit( 1000 );   // test whether deposits can be made even if not
    		b.deposit( 300 );    // logged in (and prepare for rest of the tests)

    // verify that the accounts have the money in them
   		 System.out.println("At start, first account is    " + a.toString() );
   		 System.out.println("          second account is   " + b.toString() );

    		a.transferTo( b, 500 );  // test can't transfer from a if not logged in
    		a.logIn();               // test refusing login if wrong name
   		a.logIn();               // test refusing login if wrong pass numbers
    		a.logIn();               // test logging in correctly
    		a.transferTo( b, -500 ); // test can't transfer negative amount
    		a.transferTo( b, 1500 ); // test can't transfer more than you have
    		a.transferTo( b, 500 );  // test a legal transfer
    
    // verify correct transfer
    		System.out.println("After transfer, first account is    " + a.toString() );
   		 System.out.println("                second account is   " + b.toString() );

    		a.logOut();

    // verify a logged out
    		System.out.println("At end, first account is    " + a.toString() );
    		System.out.println("        second account is   " + b.toString() );

  	}

}
