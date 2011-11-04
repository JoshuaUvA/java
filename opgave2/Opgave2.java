/*
 * Naam		Joshua Appelman
 * Snr		6329276
 * Opl		Informatica
 *
 * Summary:
 *		vraagt gebruiker om een aantal seconden in te voeren
 *		print tijd in h/m/s
 *
 *		vraagt gebruiker om een getal in te voeren
 *		print corresponderende ASCII symbool
 *		
 *		vraagt de gebruiker om de straal van een bol in te voeren.
 *		print het oppervlakte en het volume van deze bol (4*PI*(r*r) en (4/3*PI*(r*r*r))
 *
 *		print een op drie decimalen afgeronde versie van het oppervlakte en het volume
 */

import java.util.Scanner;

public class Opgave2
{	
	public static void main(String[] args)
	{
		int	time = 0,
			character = 0;
		double	radius = 0.0,
			area,
			volume;
		Scanner scan = new Scanner(System.in);
/*
 *		vraagt gebruiker om een aantal seconden in te voeren
 *		print tijd in h/m/s
 */
		while (time == 0)
		{
			System.out.println("Enter time in seconds:"); 
			try
			{
				time = Integer.parseInt(scan.nextLine());
			}
			catch (Exception e)
			{
				System.out.println("it has to be a single integer");
			}
		}
		printTime(time);	
/*
 *		vraagt gebruiker om een getal in te voeren
 *		print corresponderende ASCII symbool
 */
		while (character == 0)
		{
			System.out.println("enter the int value of an ASCII character");
			try
			{
				character = Integer.parseInt(scan.nextLine());
			}
			catch (Exception e)
			{
				System.out.println("it has to be a single int");
			}
			if (character < 0 || character > 128)
			{
				character = 0;
				System.out.println( "value has to be between 0 and 128" );
			}
		}
		System.out.println( (char)character );
/*		
 *		Vraagt de gebruiker om de straal van een bol in te voeren.
 *		print het oppervlakte en het volume van deze bol (4*PI*(r*r) en (4/3*PI*(r*r*r))
 */
		while (radius == 0)
		{
			System.out.println("enter the value (a double) of the radius of a sphere");
			try
			{
				radius = Double.parseDouble(scan.nextLine());
			}
			catch (Exception e)
			{
				System.out.println("it has to be a single double");
			}
		}
		area = 4*Math.PI*radius*radius;
		volume = 4.0/3.0*Math.PI*radius*radius*radius;
		System.out.println("the surface area of the sphere is: " + area);
		System.out.println("the volume of the sphere is: " + volume);
/*
 *		print een op drie decimalen afgeronde versie van het oppervlakte en het volume
 */
		System.out.println("three decimal representation of both would be");
		System.out.println("surface area: "+roundThreeDecimals(area));
		System.out.println("volume: "+roundThreeDecimals(volume));
	}
	
	public static void printTime (int time)
	{
		int hours, minutes, seconds;
		hours = time / 3600;
		minutes = time % 3600 / 60;
		seconds = time % 60;
		System.out.println( hours + ":" + minutes + ":" + seconds );
	}

	public static String roundThreeDecimals(double d) 
	{
		return new java.text.DecimalFormat("0.000").format(d);
	}
}
