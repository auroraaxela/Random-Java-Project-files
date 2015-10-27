/*
Created by Christopher Benda
for CS1050, spring 2011
*/

import java.util.Scanner;

public class Fraction
{
  // IV
  int num;
  int den;

  // Constructors:

  public Fraction( int top, int bottom )
  {
    num = top;
    den = bottom;
  }

  public Fraction( Scanner keyboard )
  {
    num = keyboard.nextInt();
    den = keyboard.nextInt();
  }

  public String toString()
  {
    return num + "/" + den;
  }

  public Fraction addTo( Fraction other )
  {
    int top = other.den*num + other.num*den;
    int bot = other.den*den;
    return new Fraction( top, bot );
  }

  public double toDecimal()
  {
    return (double) num/den;
  }

  public static void main(String[] args)
  {
    Fraction a = new Fraction(3,4);
    System.out.print("Enter a fraction: ");
    Scanner keys = new Scanner(System.in);
    Fraction b = new Fraction( keys );

    System.out.println("Got " + a.toString() + " and " +
                        b.toString() );

    Fraction c = a.addTo( b );

    System.out.println("They add up to " + c.toString() );

    System.out.println("Which is " + c.toDecimal() + 
                         " as a decimal");
  }

}
