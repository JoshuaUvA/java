/* Naam		Joshua Appelman
 * Snr		6329276
 * Opl		Informatica
 *
 * Summary:
 *		Asks user input for an integer n
 *		Prints the first n Lucas numbers
 *		
 *		Asks the user input for integers a and n
 *		Prints a^m
 */

import java.util.Scanner;
 
public class Opgave3
{
	public static void main(String[] args)
	{
		long lucasIndex;
		double base, exponent, answer;
		
		do
		{
			lucasIndex = (long)getDouble("Please enter howmany Lucas numbers you'd like to see.", true);
			lucasSequence(lucasIndex);
		} while (getBool("Do you want to retry? [Y/N]"));
			
		do{	
			base = getDouble("Please enter the base value", false);
			exponent = getDouble("Please enter the exponent", false);
			if ( exponent <= 0 && base == 0)
				System.out.println("Exponentiating is non-defined for e is smaller then 0 and b is 0");
			try
			{
				answer = power(base, exponent);
				System.out.println(base+" tot the power "+exponent+" is: "+answer);
			}
			catch (StackOverflowError e)
			{
				System.out.println("The answer is too large. Caused a stack overflow"); 
			}
		} while (getBool("Do you want to retry? [Y/N]"));
	}

/*	Prints message.
 *	Tries to scan the current line for an int,
 *	if it fails it prints the problem and retries.
 */
	static double getDouble(String message, boolean onlyPositive)
	{
		double i = 0.0;
		boolean success = false;
		Scanner scan = new Scanner(System.in);
		
		while (!success)
		{
			System.out.println(message);
			try
			{
				i = Double.parseDouble(scan.nextLine());
				if (onlyPositive && i < 0)
					System.out.println("The number has to be positive.");
				else
					success = true;
			}
			catch (NumberFormatException e)
			{
				System.out.println("That's not an integer.");	
			}
		}
		return i;
	}
	
 /*	Prints message.
 *	Tries to scan the current line for an boolean,
 *	if it fails it prints the problem and retries.
 */
 	static boolean getBool(String message)
	{
		boolean answer = false, success = false;
		String input;
		Scanner scan = new Scanner(System.in);
		
		while (!success)
		{
			System.out.println(message);
			input = scan.nextLine().toUpperCase();
			
			if (input.equals("Y") || input.equals("YES") || input.equals("TRUE") || input.equals("1"))
			{
				answer = true;
				success = true;
			}
			else if (input.equals("N") || input.equals("NO") || input.equals("FALSE") || input.equals("0"))
			{
				answer = false;
				success = true;
			}
			else
				System.out.println("That's not a valid answer!");
		}
		return answer;
	}
 	
/*	Prints the first n Lucas numbers
 */
	static void lucasSequence(long n)
	{
		long 	current = 2,
			next = 1,
			i = 0;
			
		while (i < n)
		{
			System.out.println("The " + i + "th Lucas number is: " + current);
			if (next > next+current)
			{
				System.out.println("Early exit due to overflow");
				break;
			}
			next += current;
			current = next - current;
			i++;
		}
	}
	
/*	Takes base to the power exponent
 */
 	static double power(double base, double exponent)
 	{
 		if (exponent > 0)
 			return base * power(base, exponent-1);
 		else if (exponent < 0 && base != 0)
 			return 1.0/power(base,-exponent);
 		else if (exponent == 0 && base != 0)
 			return 1.0;
 		else
 			return 0.0;
 	}
		
}
