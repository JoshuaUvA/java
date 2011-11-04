/* Naam		Joshua Appelman
 * Snr		6329276
 * Opl		Informatica
 *
 * Summary:
 *		System for checking guests in and out of a hotel.
 *		Main menu with options:
 *		[1] Status
 *		[2] Check-in
 *		[3] Check-out
 *		[4] Exit
 */
 
 import java.util.Scanner;
 
 public class Opgave5
 {
 	public static void main(String[] args)
 	{
 		int numberOfRooms;
 		Hotel hotel;
 		
 		numberOfRooms = getIntInRange("Number of rooms: ", 1, 99);
 		hotel = new Hotel(numberOfRooms);
 		
 		menu:
 		while (true)
 		{
 			System.out.println("\nMENU:\t[1] Status");
 			System.out.println("\t[2] Check-in");
 			System.out.println("\t[3] Check-out");
 			System.out.println("\t[4] Exit\n");
 			switch (getIntInRange("Pick an option: ", 1, 5))
 			{
 				case  1: printStatus(hotel,true);	break;
 				case  2: checkIn(hotel);		break;
 				case  3: checkOut(hotel);		break;
 				case  4: break menu;
 			}
 				
 		}
 		
 		System.out.println("Exiting");
 	}
 	
 	static int getIntInRange(String message, int lower, int upper)
 	{
 		int i = 0;
 		Scanner scan = new Scanner(System.in);
 		
 		while (true)
 		{
 			System.out.println(message);
 			try
 			{
 				i = Integer.parseInt(scan.nextLine());
 				if (i < lower || i > upper)
 					System.out.println("Has to be between "
 						+lower+" and "+upper);
 				else
 					break;
 			}
 			catch (NumberFormatException e)
 			{
 				System.out.println("That's not a number");
 			}
 		}
 		
 		return i;
 	}
 	
 	static String getString(String message)
 	{
 		String s;
 		Scanner scan = new Scanner(System.in);
 		
 		do
 		{
 			System.out.println(message);
 			s = scan.nextLine();
 			if (s.length() < 1)
 				System.out.println("Please enter something");
 		}
 		while (s.length() < 1);
 		
 		return s;
 	}
 	
 	static void printStatus(Hotel hotel, boolean alsoEmpty)
 	{
 		System.out.println("");
 		
 		for (int i = 0; i < hotel.rooms.length; i++)
 		{
 			if (hotel.rooms[i].guest != null )
 			{
 				System.out.println( "Room "+i+": "
 					+hotel.rooms[i].guest.name);
 			}
 			else if (alsoEmpty)
 				System.out.println( "Room "+i+": Vacant");
 		}
 	}
 	
 	static void checkIn(Hotel hotel)
 	{
 		String fullName;
 		fullName = getString("Guests full name:");
 		Room vacantRoom = null;
 		int roomNumber = 0;
 		
 		for (int i = 0; i < hotel.rooms.length; i++)
 		{
 			if (hotel.rooms[i].guest == null)
 			{
 				vacantRoom = hotel.rooms[i];
 				roomNumber = i;
 				break;
 			}
 		}
 		
 		if (vacantRoom == null)
 		{
 			System.out.println("No vacant rooms");
 			return;
 		}
 		
 		vacantRoom.guest = new Guest(fullName);
 		System.out.println("Guest "+fullName+" gets room: "+roomNumber);
 	}
 	
 	static void checkOut(Hotel hotel)
 	{
 		int roomToCheckOut = -1;
 		
 		printStatus(hotel, false);
 		do
 		{
 			roomToCheckOut = getIntInRange("Please enter the"+
 				"roomnumber of the room to vacate", 1
 				, hotel.rooms.length);
 		}
 		while (hotel.rooms[roomToCheckOut].guest == null);
 		
 		hotel.rooms[roomToCheckOut].guest = null;
 	}
 }
 
 class Hotel
 {
 	 public Room[] rooms;
 	 public Hotel(int nrOfRooms)
 	 {
 	 	rooms = new Room[nrOfRooms];
 	 	for (int i = 0; i < nrOfRooms; i++)
 	 		rooms[i] = new Room();
 	 }
 	 
 }
 
 class Room
 {
 	 public Guest guest;
 }
 
 class Guest
 {
 	 public String name;
 	 public Guest(String newName)
 	 {
 	 	name = newName;	 
 	 }
 }