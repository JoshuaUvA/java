/* Naam		Joshua Appelman
 * Snr		6329276
 * Opl		Informatica
 *
 * Summary:
 *		Asks user input for an string
 *		Checks it it's a palindrome		
 */

import java.util.Scanner;
 
public class Opgave4
{
	public static void main(String[] args)
	{
		String potentialPalindrome;
		boolean isPalindrome;
		do
		{
			potentialPalindrome = getString("Please enter the word, sentence or number you want to check for being a palindrome");
			potentialPalindrome = cleanUpString(potentialPalindrome);
			System.out.println("The string to be checked is: "+potentialPalindrome);
			isPalindrome = getBool("Do you want to check recursively?") ? isPalindromeRec(potentialPalindrome) : isPalindrome(potentialPalindrome);
			if (isPalindrome)
				System.out.println(potentialPalindrome+" is a palindrome");
			else
				System.out.println(potentialPalindrome+" is not a palindrome");
		} while (getBool("Do you want to try again?"));
		
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
	
/*	Prints message.
 *	Tries to scan the current line for an int,
 *	if it fails it prints the problem and retries.
 */
	static String getString(String message)
	{
		String s = "";
		Scanner scan = new Scanner(System.in);
		
		while (s.length() < 2)
		{
			System.out.println(message);
			s = scan.nextLine();
			if (s.length() < 2)
				System.out.println("Please enter more then one character");
		}
		return s;
	}
	
/*	Cleans up a potential palindromic string.
 *	-If it has has spaces it's a sentence
 *	-If it has more numbers then letters it's a number
 *	-Else it's a word
 *	Letters get filtered from numbers.
 *	Digits get filered from words and sentences.
 */
	static String cleanUpString(String s)
	{
		s = s.toUpperCase();
		String newString = "";
		boolean isNotNumber = false;
		int digits = 0, index;
		
		for (char c : s.toCharArray())
		{
			index = (int)c;
			if (index == 32)
			{
				isNotNumber = true;
				break;
			}
			else if (index > 47 && index < 58)
				digits++;
		}
		
		if ((float)s.length()/digits > 2.0)
			isNotNumber = true;
		
		for (char c : s.toCharArray())
		{
			index = (int)c;
			if (isNotNumber && index > 64 && index < 91)
				newString += c;
			else if (!isNotNumber && index > 47 && index < 58)
				newString += c;
		}
		return newString;
	}
	
/*	Checks if a string is a palindrome.
 */
	static boolean isPalindrome(String s)
	{
		char[] chars = s.toCharArray();
		for (int i = 0; i < s.length()/2; i++)
		{
			if (chars[i] != chars[s.length() - i - 1])
				return false;
		}
		return true;
	}
	
/*	Recursively checks if a string is a palindrome.
 */
	static boolean isPalindromeRec(String s)
	{
		if (s.length() < 2)
			return true;
		else
			return isPalindromeRec( s.substring(1, s.length()-1));
	}
}









