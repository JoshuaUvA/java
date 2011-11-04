/*․․Naam:․․․Joshua Appelman
 *․․Ckum:․․․6329276
 *․․Studie:․Informatica
 *Berekend recursief de som van {n,n-1,...,1}
 */

public class Opgave1Rec
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
		return n + sum (n-1);
	}
}
