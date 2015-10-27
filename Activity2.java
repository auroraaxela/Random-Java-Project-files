/*
Created by Christopher Benda
for CS1050, spring 2011
*/

import java.util.Scanner;

public class Activity2
{
	public static void main(String[] args)
	{
		int number1,number2;
		int product;
		Scanner keys;
		keys = new Scanner (System.in);
		System.out.print ("Enter first number: ");
		number1 = keys.nextInt();
		System.out.print ("Enter second number: ");
		number2 = keys.nextInt();
		product = number1*number2;
		System.out.println("The product is: "+product);
	}

}
