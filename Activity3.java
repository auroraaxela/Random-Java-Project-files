/*
Created by Christopher Benda
for CS1050, spring 2011
*/

import javax.swing.JOptionPane;
import java.math.BigInteger;

public class Activity3
{
	public static void main(String[] args)
	{
		BigInteger number1,number2;
		BigInteger product;
		
		JOptionPane.showMessageDialog(null, "This program will multiply two numbers that you provide. " +
		"Press enter to continue..." );
		
		String s = JOptionPane.showInputDialog("Enter first number: ");
		number1 = new BigInteger( s );
		
		s = JOptionPane.showInputDialog("Enter second number: ");
		number2 = new BigInteger( s );

		
		product = number1.multiply( number2 );
		JOptionPane.showMessageDialog(null, "The product is: "+product);
	}

}
