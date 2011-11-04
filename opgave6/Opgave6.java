/* Naam		Joshua Appelman
 * Snr		6329276
 * Opl		Informatica
 *
 * Summary:
 *		Defines a class 'Set'
 *		A set consist of n numbers
 *		Every element in the set is unique
 *
 *		Operations on the set are:
 *		- boolean A.isSub((B)
 *		- Set A.intersect(B)
 *		- Set A.union(B)
 *		- Set A.complement()
 *		- String A.toString()
 */
 
 import java.util.Random;
 
 public class Opgave6
 {
 	public static void main(String[] args)
 	{
 		for (int i = 0; i < 10; i++)
 		{
 			Set A = new Set(4, i);
 			Set B = new Set(8, 2*i);
 			System.out.println(A);
 			System.out.println(B);
 			System.out.println(A.isSub(B));
 			System.out.println(A.union(B));
 		}
 	}
 }
 
 class Set
 {
 	int[] elements;
 	static int UNIVERSE = 10;
 	
 	Set(int size, int seed)
 	{
 		Random randomGenerator = new Random(seed);
 		elements = new int[size];
 		
 		for (int i = 0; i < size; i++)
 		{
 			int newElement = randomGenerator.nextInt(UNIVERSE);
 			boolean foundMatch = false;
 			
 			for (int element : elements)
 			{
 				if (element == newElement)
 				{
 					foundMatch = true;
 					break;
 				}
 			}
 			
 			if (foundMatch)
 				i--;
 		 	 else
 		 	 	 elements[i] = newElement; 			
 		}
 	}
 	
 	Set(int[] elements)
 	{
 		//add input validation
 		this.elements = elements;		
 	}
 	
 	public String toString()
 	{
 		String s = "{";
 		for (int i = 0; i < elements.length; i++)
 		{
 			s += elements[i];
 			if (i < elements.length - 1)
 				s += ", ";
 		}
 		return s + "}";
 	}
 	
 	public boolean isSub(Set otherSet)
 	{
 		if (elements.length > otherSet.elements.length)
 			return false;
 		
 		for (int element : elements)
 		{
 			boolean foundMatch = false;
 			for (int otherElement : otherSet.elements)
 			{
 				foundMatch |= element == otherElement;
 				if (foundMatch)
 					break;
 			}
 			if (!foundMatch)
 				return false;
 		}
 		
 		return true;	
 	}
 	
 	public Set union(Set otherSet)
 	{
 		int duplicates = 0;
 		int[] newElements;
 		
 		
  		for (int element : elements)
 		{
 			boolean foundMatch = false;
 			for (int otherElement : otherSet.elements)
 			{
 				foundMatch |= element == otherElement;
 				if (foundMatch)
 					break;
 			}
 			if (!foundMatch)
 				duplicates++;
 		}
 
 		newElements = new int[elements.length+otherSet.elements.length
 			- duplicates];
 		
 		for (int i = 0; i < elements.length; i++)
 			newElements[i] = elements[i];
 		
 		for (int i = elements.length; i < newElements.length; i++)
 		{
 			boolean foundMatch = false;
 			for (int newElement : newElements)
 			{
 				foundMatch |= otherSet.elements[i] == newElement;
 				if (foundMatch)
 					break;
 			}
 			if (!foundMatch)
 				newElements[i] = otherSet.elements[i];
 		}
 		
 		return new Set(newElements);
 	}

 }
