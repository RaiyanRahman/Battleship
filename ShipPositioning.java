/*  ShipPositioning.java
    This program asks the user for the coordinates of their ships and initiates the game.
    @Author: Raiyan Rahman
    @Date: 28th Dec, 2015.
    */
import hsa.Console;
import java.awt.*;
public class ShipPositioning
{
    static Console c;

    public static void info ()  //Displays the choices and specifications of the available ships
    {
	c.println ("You are in command of a fleet of 5 ships.");
	String ship[] = {"Aircraft Carrier", "Large Battleship", "Small Battleship", "Patrol Ship     ", "Submarine       "};
	int spaces[] = {5, 4, 3, 2, 1};
	c.println ("Ship\t \t \tSpace(s)");
	for (int counter = 0 ; counter < spaces.length ; counter++)
	{
	    c.println (ship [counter] + "\t" + spaces [counter]);
	}
    }


    public static void placement ()
    {
	String ship[] = {"Aircraft Carrier", "Large Battleship", "Small Battleship", "Patrol Ship", "Submarine"};
	String AirCarrier[] = new String [5];
	String LBattleship[] = new String [4];
	String SBattleship[] = new String [3];
	String PShip[] = new String [2];
	String Sub[] = new String [1];

	for (int counter = 0 ; counter < ship.length ; counter++)   //Receives the coordinates of the ships
	{
	    c.println ("Now please enter the coordinates of your " + ship [counter] + " (ex B4):");
	    if (counter == 0)
	    {
		for (int crdnts = 0 ; crdnts < AirCarrier.length ; crdnts++)
		{
		    AirCarrier [crdnts] = c.readString ();
		}
	    }
	    if (counter == 1)
	    {
		for (int crdnts = 0 ; crdnts < LBattleship.length ; crdnts++)
		{
		    LBattleship [crdnts] = c.readString ();
		}
	    }
	    if (counter == 2)
	    {
		for (int crdnts = 0 ; crdnts < SBattleship.length ; crdnts++)
		{
		    SBattleship [crdnts] = c.readString ();
		}
	    }
	    if (counter == 3)
	    {
		for (int crdnts = 0 ; crdnts < PShip.length ; crdnts++)
		{
		    PShip [crdnts] = c.readString ();
		}
	    }
	    if (counter == 4)
	    {
		for (int crdnts = 0 ; crdnts < Sub.length ; crdnts++)
		{
		    Sub [crdnts] = c.readString ();
		}
	    }
	    c.println();
	    c.println();
	}
	c.clear();  //clears the console
	c.println("The coordinates of your ships are as follows:"); //Lists the coordinates
	c.println();
	for(int counter = 0; counter < ship.length; counter++)
	{
	    c.println(ship[counter] + ":");
	    if (counter == 0)
	    {
		for(int counter1 = 0; counter1 < AirCarrier.length; counter1++)
		{
		    c.print(AirCarrier[counter1] + " ");
		}
		c.println();
	    }
	    if (counter == 1)
	    {
		for(int counter1 = 0; counter1 < LBattleship.length; counter1++)
		{
		    c.print(LBattleship[counter1] + " ");
		}
		c.println();
	    }
	    if (counter == 2)
	    {
		for(int counter1 = 0; counter1 < SBattleship.length; counter1++)
		{
		    c.print(SBattleship[counter1] + " ");
		}
		c.println();
	    }
	    if (counter == 3)
	    {
		for(int counter1 = 0; counter1 < PShip.length; counter1++)
		{
		    c.print(PShip[counter1] + " ");
		}
		c.println();
	    }
	    if (counter == 4)
	    {
		for(int counter1 = 0; counter1 < Sub.length; counter1++)
		{
		    c.print(Sub[counter1] + " ");
		}
		c.println();
	    }
	 }
    }
    
    public static void Begin() throws InterruptedException
    {
	c = new Console(20, 70, "Game");    //Game Console
	c.setColor(Color.BLACK);
	c.fillRect(0, 0, 1000, 1000);   //Background
	c.setColor(Color.RED);
	c.setFont(new Font("Chiller", Font.BOLD, 80));
	c.drawString("3", 250, 220);
	Thread.sleep(350);
	c.clear();
	c.setColor(Color.BLACK);
	c.fillRect(0, 0, 1000, 1000);   //Background
	c.setColor(Color.RED);
	c.setFont(new Font("Chiller", Font.BOLD, 80));
	c.drawString("2", 250, 220);
	Thread.sleep(350);
	c.clear();
	c.setColor(Color.BLACK);
	c.fillRect(0, 0, 1000, 1000);   //Background
	c.setColor(Color.RED);
	c.setFont(new Font("Chiller", Font.BOLD, 80));
	c.drawString("1", 250, 220);
	Thread.sleep(350);
	c.clear();
	c.setColor(Color.BLACK);
	c.fillRect(0, 0, 1000, 1000);   //Background
	c.setColor(Color.RED);
	c.setFont(new Font("Chiller", Font.BOLD, 80));
	c.drawString("START!!", 125, 220);
    }

    public static void main (String[] args) throws InterruptedException
    {
	c = new Console (15, 66, "Setting up"); //Output Console

	//Loading Screen
	for (int counter = 1 ; counter < 5 ; counter++)
	{
	    c.print ("Ship placement initiating");
	    Thread.sleep (250);
	    c.print (".");
	    Thread.sleep (250);
	    c.print (".");
	    Thread.sleep (250);
	    c.print (".");
	    Thread.sleep (250);
	    c.clear ();
	}
	info (); //shows ship info"
	c.println ();
	c.println ();
	placement ();   //initiates the ship placement
	Begin();    //Starts the game
    }
}
