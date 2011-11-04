/*	Naam:	Joshua Appelman
 *	Ckum:	6329276
 *	Studie:	Informatica
 *
 *	Berekend direct de som van {n,n-1,...,1}
 */

public class Opgave1Direct
{
	public static void main(String[] args)
	{
		try
		{
			int n = Integer.parseInt(args[0]);
			int sum = sum(n);
			if (sum > -1)
				System.out.println(n + "'s som is: " + sum);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("Please enter exactly one integer");
			return; 
		}
	}
/*
 *	Berekend direct de som van {n,n-1,...,1}
 */
	public static int sum(int n)
	{
		if (n < 0)
		{
			System.out.println("int too small");
			return -1;
		}
		if (n > 46340)
		{	
			System.out.println("int too large");
			return -1;
		}
		return n * ++n / 2;
	}
}
