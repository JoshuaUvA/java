/*	Naam:	Joshua Appelman
 *	CKNUM:	6329276
 *	STUDIE:	Informatica
 *
 *	Berekend in een loop de som van {n,n-1,...,0}
 */

public class Opgave1Loop
{
	public static void main (String[] args)
	{
		try
		{
			Integer.parseInt( args[0] );
		}
		catch (Exception e)
		{
			System.out.println( e.getMessage() );
			System.out.println( "Please enter exactly one integer" );
			return; 
		}
		int n = Integer.parseInt( args[0] );
		System.out.println( n + "'s som is: " + sum(n) );
	}

	public static int sum (int n)
	{
		if (n < 0)
			return 0;
		int sum = 0;
		while (n > 0)
		{
			sum += n;
			n--;
		}
		return sum;
	}
}
