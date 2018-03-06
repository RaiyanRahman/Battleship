/** Battleship.java
    This program initiates the classic game of battleship.
    The player will play against the AI and will attempt to destroy all the
    opponent's battleship through shots taken in successive turns.
    @Author: Raiyan Rahman
    @Version: 3.0
    @Date: 28th December, 2015.
    **/
import hsa.Console;
import javax.swing.JOptionPane;
import java.util.Random;
import java.awt.*;


public class Battleship
{
    static Console c;

    public static void MainMenu()   throws InterruptedException
    {
	c.setColor(new Color(58, 70, 88));
	c.fillRect(0, 0, 700, 700);
	c.setColor(Color.white);
	c.setFont(new Font("SansSerif", Font.BOLD, 64));
	c.drawString("BATTLESHIP!", 82, 120);
	c.setColor(new Color(128, 64, 64));
	c.setFont(new Font("SansSerif", Font.BOLD, 63));
	c.drawString("BATTLESHIP!", 84, 123);
	c.setColor(Color.white);
	c.setFont(new Font("SansSerif", Font.BOLD, 18));
	c.drawString("Press Any Key", 180, 300);
	char start = c.getChar();
	c.clear();
    }
    
    public static void info()  //Displays the choices and specifications of the available ships
    {
	c.println ("You are in command of a fleet of 5 ships.");
	String ship[] = {"Aircraft Carrier(A)", "Large Battleship(L)", "Small Battleship(B)", "Patrol Ship(P)  ", "Submarine(S)    "};
	int spaces[] = {5, 4, 3, 2, 1};
	c.println ("Ship\t \t \tSpace(s)");
	for (int counter = 0 ; counter < spaces.length ; counter++)
	{
	    c.println (ship [counter] + "\t" + spaces [counter]);
	}
    }
    
    public static void display(String Grid[][]) //Displays the grid in a table/board
    {
	for(int row = 0;    row < Grid.length; row++)   //cycles through the rows
	{
	    for(int column = 0; column < Grid[row].length; column++)    //cycles through the columns
	    {
		c.setTextBackgroundColor(new Color(2, 165, 253));
		c.print(Grid[row][column] + "  ");  //Prints the rows and the columns
		c.setTextBackgroundColor(Color.white);
	    }
	    c.println();
	}
    }
    public static void displaycrdnts(int Grid[][])
    {
	for(int row = 0;    row < Grid.length; row++)   //cycles through the rows
	{
	    for(int column = 0; column < Grid[row].length; column++)    //cycles through the columns
	    {
		c.print((Grid[row][column] + 1) + "  ");  //Prints the rows and the columns
	    }
	    c.println();
	}
    }
	
    public static int battle() throws InterruptedException
    {
	//Health
	int PlayerHP = 15, CompHP = 15;
	//Ship Placement
	String ship[] = {"Aircraft Carrier(A)", "Large Battleship(L)", "Small Battleship(B)", "Patrol Ship(P)", "Submarine(S)"};   //Array holding ship names
	//Arrays holding ship coordinates
	int AC[][] = new int[2][5];
	int LB[][] = new int[2][4];
	int SB[][] = new int[2][3];
	int PS[][] = new int[2][2];
	int Su[][] = new int[2][1];
	
	String PlayerGrid[][] = {{"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},    //Memory of the players board
				 {"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
				 {"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
				 {"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
				 {"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
				 {"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
				 {"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
				 {"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
				 {"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
				 {"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"}};
	String EnemyGrid[][] = {{"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"}, //Memory of the AI board
				{"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
				{"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
				{"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
				{"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
				{"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
				{"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
				{"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
				{"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
				{"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"}};
	String enemygrid[][] = {{"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"}, //Memory of the AI board
				{"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
				{"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
				{"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
				{"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
				{"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
				{"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
				{"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
				{"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
				{"~", "~", "~", "~", "~", "~", "~", "~", "~", "~"}};
	
	//Ship Positioning for player
	for(int counter = 0;    counter < ship.length;  counter++)
	{
	    c.println(ship[counter] + ":");
	    if(counter == 0)
	    {
		char facing;
		c.println("Place the ship horizontally or vetrically?");
		facing = c.getChar();
		if(facing == 'h' || facing == 'H')
		{
		    int row = Integer.parseInt(JOptionPane.showInputDialog("Please enter the row coordinate for your " + ship[counter] + ".\n(Rows 1-10)"));
		    int column = Integer.parseInt(JOptionPane.showInputDialog("Please enter the column coordinate for your " + ship[counter] + ".\n(Columns 1-10)"));
		    for(int crdnts = 0; crdnts < AC[0].length;  crdnts++)
		    {
			AC[0][crdnts] = (row - 1);
			AC[1][crdnts] = ((column - 1) + crdnts);
			c.println("Row: " + row + ", Column: " + (column + crdnts));
			PlayerGrid[(AC[0][crdnts])][(AC[1][crdnts])] = "A";
		    }
		}
		else
		{
		    int row = Integer.parseInt(JOptionPane.showInputDialog("Please enter the row coordinate for your " + ship[counter] + ".\n(Rows 1-10)"));
		    int column = Integer.parseInt(JOptionPane.showInputDialog("Please enter the column coordinate for your " + ship[counter] + ".\n(Columns 1-10)"));
		    for(int crdnts = 0; crdnts < AC[0].length;  crdnts++)
		    {
			AC[0][crdnts] = ((row - 1) + crdnts);
			AC[1][crdnts] = (column - 1);
			c.println("Row: " + (row + crdnts) + ", Column: " + column);
			PlayerGrid[(AC[0][crdnts])][(AC[1][crdnts])] = "A";
		    }
		}
		/*for(int crdnts = 0; crdnts < AC[0].length; crdnts++)
		{
		    int row = Integer.parseInt(JOptionPane.showInputDialog("Please enter the row coordinate for your " + ship[counter] + ".\n(Rows 1-10)"));
		    int column = Integer.parseInt(JOptionPane.showInputDialog("Please enter the column coordinate for your " + ship[counter] + ".\n(Columns 1-10)"));
		    AC[0][crdnts] = (row - 1);
		    AC[1][crdnts] = (column - 1);
		    c.println("Row: " + row + ", Column: " + column);
		    PlayerGrid[(AC[0][crdnts])][(AC[1][crdnts])] = "A";
		}*/
	    }
	    if(counter == 1)
	    {
		char facing;
		c.println("Place the ship horizontally or vetrically?");
		facing = c.getChar();
		if(facing == 'h' || facing == 'H')
		{
		    int row = Integer.parseInt(JOptionPane.showInputDialog("Please enter the row coordinate for your " + ship[counter] + ".\n(Rows 1-10)"));
		    int column = Integer.parseInt(JOptionPane.showInputDialog("Please enter the column coordinate for your " + ship[counter] + ".\n(Columns 1-10)"));
		    for(int crdnts = 0; crdnts < LB[0].length;  crdnts++)
		    {
			LB[0][crdnts] = (row - 1);
			LB[1][crdnts] = ((column - 1) + crdnts);
			c.println("Row: " + row + ", Column: " + (column + crdnts));
			PlayerGrid[(LB[0][crdnts])][(LB[1][crdnts])] = "L";
		    }
		}
		else
		{
		    int row = Integer.parseInt(JOptionPane.showInputDialog("Please enter the row coordinate for your " + ship[counter] + ".\n(Rows 1-10)"));
		    int column = Integer.parseInt(JOptionPane.showInputDialog("Please enter the column coordinate for your " + ship[counter] + ".\n(Columns 1-10)"));
		    for(int crdnts = 0; crdnts < LB[0].length;  crdnts++)
		    {
			LB[0][crdnts] = ((row - 1) + crdnts);
			LB[1][crdnts] = (column - 1);
			c.println("Row: " + (row + crdnts) + ", Column: " + column);
			PlayerGrid[(LB[0][crdnts])][(LB[1][crdnts])] = "L";
		    }
		}
		/*for(int crdnts = 0; crdnts < LB[0].length; crdnts++)
		{
		    int row = Integer.parseInt(JOptionPane.showInputDialog("Please enter the row coordinate for your " + ship[counter] + ".\n(Rows 1-10)"));
		    int column = Integer.parseInt(JOptionPane.showInputDialog("Please enter the column coordinate for your " + ship[counter] + ".\n(Columns 1-10)"));
		    LB[0][crdnts] = (row - 1);
		    LB[1][crdnts] = (column - 1);
		    c.println("Row: " + row + ", Column: " + column);
		    PlayerGrid[(LB[0][crdnts])][(LB[1][crdnts])] = "L";
		}*/
	    }
	    if(counter == 2)
	    {
		char facing;
		c.println("Place the ship horizontally or vetrically?");
		facing = c.getChar();
		if(facing == 'h' || facing == 'H')
		{
		    int row = Integer.parseInt(JOptionPane.showInputDialog("Please enter the row coordinate for your " + ship[counter] + ".\n(Rows 1-10)"));
		    int column = Integer.parseInt(JOptionPane.showInputDialog("Please enter the column coordinate for your " + ship[counter] + ".\n(Columns 1-10)"));
		    for(int crdnts = 0; crdnts < SB[0].length;  crdnts++)
		    {
			SB[0][crdnts] = (row - 1);
			SB[1][crdnts] = ((column - 1) + crdnts);
			c.println("Row: " + row + ", Column: " + (column + crdnts));
			PlayerGrid[(SB[0][crdnts])][(SB[1][crdnts])] = "B";
		    }
		}
		else
		{
		    int row = Integer.parseInt(JOptionPane.showInputDialog("Please enter the row coordinate for your " + ship[counter] + ".\n(Rows 1-10)"));
		    int column = Integer.parseInt(JOptionPane.showInputDialog("Please enter the column coordinate for your " + ship[counter] + ".\n(Columns 1-10)"));
		    for(int crdnts = 0; crdnts < SB[0].length;  crdnts++)
		    {
			SB[0][crdnts] = ((row - 1) + crdnts);
			SB[1][crdnts] = (column - 1);
			c.println("Row: " + (row + crdnts) + ", Column: " + column);
			PlayerGrid[(SB[0][crdnts])][(SB[1][crdnts])] = "B";
		    }
		}
		/*for(int crdnts = 0; crdnts < SB[0].length; crdnts++)
		{
		    int row = Integer.parseInt(JOptionPane.showInputDialog("Please enter the row coordinate for your " + ship[counter] + ".\n(Rows 1-10)"));
		    int column = Integer.parseInt(JOptionPane.showInputDialog("Please enter the column coordinate for your " + ship[counter] + ".\n(Columns 1-10)"));
		    SB[0][crdnts] = (row - 1);
		    SB[1][crdnts] = (column - 1);
		    c.println("Row: " + row + ", Column: " + column);
		    PlayerGrid[(SB[0][crdnts])][(SB[1][crdnts])] = "B";
		}*/
	    }
	    if(counter == 3)
	    {
		char facing;
		c.println("Place the ship horizontally or vetrically?");
		facing = c.getChar();
		if(facing == 'h' || facing == 'H')
		{
		    int row = Integer.parseInt(JOptionPane.showInputDialog("Please enter the row coordinate for your " + ship[counter] + ".\n(Rows 1-10)"));
		    int column = Integer.parseInt(JOptionPane.showInputDialog("Please enter the column coordinate for your " + ship[counter] + ".\n(Columns 1-10)"));
		    for(int crdnts = 0; crdnts < PS[0].length;  crdnts++)
		    {
			PS[0][crdnts] = (row - 1);
			PS[1][crdnts] = ((column - 1) + crdnts);
			c.println("Row: " + row + ", Column: " + (column + crdnts));
			PlayerGrid[(PS[0][crdnts])][(PS[1][crdnts])] = "P";
		    }
		}
		else
		{
		    int row = Integer.parseInt(JOptionPane.showInputDialog("Please enter the row coordinate for your " + ship[counter] + ".\n(Rows 1-10)"));
		    int column = Integer.parseInt(JOptionPane.showInputDialog("Please enter the column coordinate for your " + ship[counter] + ".\n(Columns 1-10)"));
		    for(int crdnts = 0; crdnts < PS[0].length;  crdnts++)
		    {
			PS[0][crdnts] = ((row - 1) + crdnts);
			PS[1][crdnts] = (column - 1);
			c.println("Row: " + (row + crdnts) + ", Column: " + column);
			PlayerGrid[(PS[0][crdnts])][(PS[1][crdnts])] = "P";
		    }
		}
		/*for(int crdnts = 0; crdnts < PS[0].length; crdnts++)
		{
		    int row = Integer.parseInt(JOptionPane.showInputDialog("Please enter the row coordinate for your " + ship[counter] + ".\n(Rows 1-10)"));
		    int column = Integer.parseInt(JOptionPane.showInputDialog("Please enter the column coordinate for your " + ship[counter] + ".\n(Columns 1-10)"));
		    PS[0][crdnts] = (row - 1);
		    PS[1][crdnts] = (column - 1);
		    c.println("Row: " + row + ", Column: " + column);
		    PlayerGrid[(PS[0][crdnts])][(PS[1][crdnts])] = "P";
		}*/
	    }
	    if(counter == 4)
	    {
		for(int crdnts = 0; crdnts < Su[0].length; crdnts++)
		{
		    int row = Integer.parseInt(JOptionPane.showInputDialog("Please enter the row coordinate for your " + ship[counter] + ".\n(Rows 1-10)"));
		    int column = Integer.parseInt(JOptionPane.showInputDialog("Please enter the column coordinate for your " + ship[counter] + ".\n(Columns 1-10)"));
		    Su[0][crdnts] = (row - 1);
		    Su[1][crdnts] = (column - 1);
		    c.println("Row: " + row + ", Column: " + column);
		    PlayerGrid[(Su[0][crdnts])][(Su[1][crdnts])] = "S";
		}
	    }
	}
	//Arrays holding AI ship coordinates
	int ac[][] = new int[2][5];
	int lb[][] = new int[2][4];
	int sb[][] = new int[2][3];
	int ps[][] = new int[2][2];
	int su[][] = new int[2][1];
	
	for(int counter = 0;    counter < ship.length;  counter++)
	{
	    Random rand = new Random();
	    c.println("AI " + ship[counter] + ":");
	    int ran = rand.nextInt(2) + 1;
	    if(counter == 0)
	    {
		int ax = rand.nextInt(9) + 1;
		int ay = rand.nextInt(9) + 1;
		for(int crdnts = 0; crdnts < ac[0].length; crdnts++)
		{
		    if((ran%2) == 0)
		    {
			if(ay > 5)
			{
			    ac[0][crdnts] = (ax);
			    ac[1][crdnts] = ((ay - 5) + crdnts);
			    Thread.sleep(10);
			    EnemyGrid[(ac[0][crdnts])][(ac[1][crdnts])] = "A";
			}
			else
			{
			    ac[0][crdnts] = (ax);
			    ac[1][crdnts] = (ay + crdnts);
			    Thread.sleep(10);
			    EnemyGrid[(ac[0][crdnts])][(ac[1][crdnts])] = "A";
			}
		    }
		    else
		    {
			if(ax > 5)
			{
			    ac[0][crdnts] = ((ax - 5) + crdnts);
			    ac[1][crdnts] = (ay);
			    Thread.sleep(10);
			    EnemyGrid[(ac[0][crdnts])][(ac[1][crdnts])] = "A";
			}
			else
			{
			    ac[0][crdnts] = (ax + crdnts);
			    ac[1][crdnts] = (ay);
			    Thread.sleep(10);
			    EnemyGrid[(ac[0][crdnts])][(ac[1][crdnts])] = "A";
			}
		    }   
		}
	    }
	    if(counter == 1)
	    {
		int ex = rand.nextInt(9);
		int ey = rand.nextInt(9);
		for(int crdnts = 0; crdnts < lb[0].length; crdnts++)
		{
		    if((ran%2) == 0)
		    {
			if(ey > 6)
			{
			    //if(
			    lb[0][crdnts] = (ex);
			    lb[1][crdnts] = ((ey - 4) + crdnts);
			    Thread.sleep(10);
			    EnemyGrid[(lb[0][crdnts])][(lb[1][crdnts])] = "L";
			}
			else
			{
			    lb[0][crdnts] = (ex);
			    lb[1][crdnts] = (ey + crdnts);
			    Thread.sleep(10);
			    EnemyGrid[(lb[0][crdnts])][(lb[1][crdnts])] = "L";
			}
		    }
		    else
		    {
			if(ex > 6)
			{
			    lb[0][crdnts] = ((ex - 4) + crdnts);
			    lb[1][crdnts] = (ey);
			    Thread.sleep(10);
			    EnemyGrid[(lb[0][crdnts])][(lb[1][crdnts])] = "L";
			}
			else
			{
			    lb[0][crdnts] = (ex + crdnts);
			    lb[1][crdnts] = (ey);
			    Thread.sleep(10);
			    EnemyGrid[(lb[0][crdnts])][(lb[1][crdnts])] = "L";
			}
		    }   
		}
	    }
	    if(counter == 2)
	    {
		int bx = rand.nextInt(5) + 3;
		int by = rand.nextInt(5) + 4;
		for(int crdnts = 0; crdnts < sb[0].length; crdnts++)
		{
		    if((ran%2) == 0)
		    {
			if(by > 7)
			{
			    sb[0][crdnts] = (bx);
			    sb[1][crdnts] = ((by - 3) + crdnts);
			    Thread.sleep(10);
			    EnemyGrid[(sb[0][crdnts])][(sb[1][crdnts])] = "B";
			}
			else
			{
			    sb[0][crdnts] = (bx);
			    sb[1][crdnts] = (by + crdnts);
			    Thread.sleep(10);
			    EnemyGrid[(sb[0][crdnts])][(sb[1][crdnts])] = "B";
			}
		    }
		    else
		    {
			if(bx > 7)
			{
			    sb[0][crdnts] = ((bx - 3) + crdnts);
			    sb[1][crdnts] = (by);
			    Thread.sleep(10);
			    EnemyGrid[(sb[0][crdnts])][(sb[1][crdnts])] = "B";
			}
			else
			{
			    sb[0][crdnts] = (bx + crdnts);
			    sb[1][crdnts] = (by);
			    Thread.sleep(10);
			    EnemyGrid[(sb[0][crdnts])][(sb[1][crdnts])] = "B";
			}
		    }   
		}
	    }
	    if(counter == 3)
	    {
		int cx = rand.nextInt(9);
		int cy = rand.nextInt(9);
		for(int crdnts = 0; crdnts < ps[0].length; crdnts++)
		{
		    if((ran%2) == 0)
		    {
			if(cy > 8)
			{
			    ps[0][crdnts] = (cx);
			    ps[1][crdnts] = ((cy - 2) + crdnts);
			    Thread.sleep(10);
			    EnemyGrid[(ps[0][crdnts])][(ps[1][crdnts])] = "P";
			}
			else
			{
			    ps[0][crdnts] = (cx);
			    ps[1][crdnts] = (cy + crdnts);
			    Thread.sleep(10);
			    EnemyGrid[(ps[0][crdnts])][(ps[1][crdnts])] = "P";
			}
		    }
		    else
		    {
			if(cx > 8)
			{
			    ps[0][crdnts] = ((cx - 2) + crdnts);
			    ps[1][crdnts] = (cy);
			    Thread.sleep(10);
			    EnemyGrid[(ps[0][crdnts])][(ps[1][crdnts])] = "P";
			}
			else
			{
			    ps[0][crdnts] = (cx + crdnts);
			    ps[1][crdnts] = (cy);
			    Thread.sleep(10);
			    EnemyGrid[(ps[0][crdnts])][(ps[1][crdnts])] = "P";
			}
		    }   
		}
	    }
	    if(counter == 4)
	    {
		int dx = rand.nextInt(9);
		int dy = rand.nextInt(9);
		for(int crdnts = 0; crdnts < su[0].length; crdnts++)
		{
		    su[0][crdnts] = (dx);
		    su[1][crdnts] = (dy);
		    Thread.sleep(10);
		    EnemyGrid[(su[0][crdnts])][(su[1][crdnts])] = "S";   
		}
	    }
	}
	c.clear();  //clears the console
	c.println("The coordinates of your ships are as follows:"); //Lists the coordinates
	c.println();
	for(int counter = 0;   counter < ship.length;   counter++)
	{
	    c.println(ship[counter] + ":");
	    if(counter == 0)
	    {
		displaycrdnts(AC);
	    }
	    if(counter == 1)
	    {
		displaycrdnts(LB);
	    }
	    if(counter == 2)
	    {
		displaycrdnts(SB);
	    }
	    if(counter == 3)
	    {
		displaycrdnts(PS);
	    }
	    if(counter == 4)
	    {
		displaycrdnts(Su);
	    }
	}
	Thread.sleep(2000);
	c = new Console(30, 55, "Game");
	Random rand = new Random();
	//Displays the boards
	c.println("Player Board\nPlayer HP:" + PlayerHP);
	c.println();
	display(PlayerGrid);
	c.println();
	c.println("Enemy Board\nEnemy HP:" + CompHP);
	c.println();
	display(enemygrid);
	Thread.sleep(2000);
	//Battle simulation
	do
	{
	    int strikerow = Integer.parseInt(JOptionPane.showInputDialog("Please enter strike row coordinates.\n(Rows 1-10)"));  //Inputs row for shot
	    int strikecolumn = Integer.parseInt(JOptionPane.showInputDialog("Please enter strike column coordinates.\n(Columns 1-10)")); //Inputs column for shot
	    c.println("Row:" + strikerow + ", " + "Column:" + strikecolumn);
	    int cx = rand.nextInt(9) + 1;   //Generates a random number for the AI's row coordinate shot
	    int cy = rand.nextInt(9) + 1;   //Generates a random number for the AI's column coordinate shot
	    
	    if(EnemyGrid[(strikerow - 1)][(strikecolumn - 1)] == "O")
	    {
		enemygrid[(strikerow - 1)][(strikecolumn - 1)] = "O";
	    }
	    else if(EnemyGrid[(strikerow - 1)][(strikecolumn - 1)] == "A")
	    {
		enemygrid[(strikerow - 1)][(strikecolumn - 1)] = "X";
		JOptionPane.showMessageDialog(null, "Your shot hit the enemy's ship!");
		CompHP--;    //A hit on their ship decreases their HP
	    }
	    else if(EnemyGrid[(strikerow - 1)][(strikecolumn - 1)] == "L")
	    {
		enemygrid[(strikerow - 1)][(strikecolumn - 1)] = "X";
		JOptionPane.showMessageDialog(null, "Your shot hit the enemy's ship!");
		CompHP--;    //A hit on their ship decreases their HP
	    }
	    else if(EnemyGrid[(strikerow - 1)][(strikecolumn - 1)] == "B")
	    {
		enemygrid[(strikerow - 1)][(strikecolumn - 1)] = "X";
		JOptionPane.showMessageDialog(null, "Your shot hit the enemy's ship!");
		CompHP--;    //A hit on their ship decreases their HP
	    }
	    else if(EnemyGrid[(strikerow - 1)][(strikecolumn - 1)] == "P")
	    {
		enemygrid[(strikerow - 1)][(strikecolumn - 1)] = "X";
		JOptionPane.showMessageDialog(null, "Your shot hit the enemy's ship!");
		CompHP--;    //A hit on their ship decreases their HP
	    }
	    else if(EnemyGrid[(strikerow - 1)][(strikecolumn - 1)] == "S")
	    {
		enemygrid[(strikerow - 1)][(strikecolumn - 1)] = "X";
		JOptionPane.showMessageDialog(null, "Your shot hit the enemy's ship!");
		CompHP--;    //A hit on their ship decreases their HP
	    }
	    else if(EnemyGrid[(strikerow - 1)][(strikecolumn - 1)] == "X")
	    {
		enemygrid[(strikerow - 1)][(strikecolumn - 1)] = "X";
		JOptionPane.showMessageDialog(null, "Your shot hit the enemy's ship!");
	    }
	    else
	    {
		enemygrid[(strikerow - 1)][(strikecolumn - 1)] = "O";
	    }
	    c.clear();
	    //Displays the grids with players shot added
	    c.println("Player Board\nPlayer HP:" + PlayerHP);
	    c.println();
	    display(PlayerGrid);
	    c.println();
	    c.println("Enemy Board\nEnemy HP:" + CompHP);
	    c.println();
	    display(enemygrid);
	    JOptionPane.showMessageDialog(null, "You shot at:\nRow: " + strikerow + ", Column: " + strikecolumn);   //Displays the player's shot coordinates
	    if(PlayerGrid[cx][cy] == "A")
	    {
		PlayerGrid[cx][cy] = "X";
		JOptionPane.showMessageDialog(null, "The enemy's shot hit your ship!");
		PlayerHP--;    //A hit on the player's ship decreases their HP
	    }
	    if(PlayerGrid[cx][cy] == "L")
	    {
		PlayerGrid[cx][cy] = "X";
		JOptionPane.showMessageDialog(null, "The enemy's shot hit your ship!");
		PlayerHP--;    //A hit on the player's ship decreases their HP
	    }
	    if(PlayerGrid[cx][cy] == "B")
	    {
		PlayerGrid[cx][cy] = "X";
		JOptionPane.showMessageDialog(null, "The enemy's shot hit your ship!");
		PlayerHP--;    //A hit on the player's ship decreases their HP
	    }
	    if(PlayerGrid[cx][cy] == "P")
	    {
		PlayerGrid[cx][cy] = "X";
		JOptionPane.showMessageDialog(null, "The enemy's shot hit your ship!");
		PlayerHP--;    //A hit on the player's ship decreases their HP
	    }
	    if(PlayerGrid[cx][cy] == "S")
	    {
		PlayerGrid[cx][cy] = "X";
		JOptionPane.showMessageDialog(null, "The enemy's shot hit your ship!");
		PlayerHP--;    //A hit on the player's ship decreases their HP
	    }
	    if(PlayerGrid[cx][cy] == "X")
	    {
		PlayerGrid[cx][cy] = "X";
		JOptionPane.showMessageDialog(null, "The enemy's shot hit your ship!");
	    }
	    else
	    {
	       PlayerGrid[cx][cy] = "O";
	    }
	    Thread.sleep(350);
	    c.clear();
	    //Displays the girds with the enemy's shot added
	    c.println("Player Board\nPlayer HP:" + PlayerHP);
	    c.println();
	    display(PlayerGrid);
	    c.println();
	    c.println("Enemy Board\nEnemy HP:" + CompHP);
	    c.println();
	    display(enemygrid);
	    JOptionPane.showMessageDialog(null, "Enemy shot at:\nRow: " + (cx + 1) + ", Column: " + (cy + 1));  //Displays the enemy's shot coordinates
	}
	while(PlayerHP != 0 && CompHP != 0);
	if(PlayerHP == 0)
	{
	    return(1);
	}
	else
	{
	    return(2);
	}
    }
    
    public static void End(int result) throws InterruptedException
    {
	c.clear();
	c.setColor(new Color(58, 70, 88));
	c.fillRect(0, 0, 700, 700);
	c.println("\t\t\t\t Results");
	c.println("\n\n");
	if(result%2 == 0)
	{
	    c.setColor(Color.blue);
	    c.setFont(new Font("SansSerif", Font.BOLD, 35));
	    c.drawString("You Win!", 200, 150);
	    c.setFont(new Font("SansSerif", Font.BOLD, 20));
	    c.drawString("You defeated the enemy!", 140, 200);
	}
	else
	{
	    c.setColor(Color.red);
	    c.setFont(new Font("SansSerif", Font.BOLD, 35));
	    c.drawString("You Lose!", 200, 150);
	    c.setFont(new Font("SansSerif", Font.BOLD, 20));
	    c.drawString("You were defeated by the enemy!", 140, 200);
	}
    }

    public static void main(String[] args)  throws InterruptedException
    {
	c = new Console (20, 70, "Battleship"); //Output Console
	MainMenu();
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
	info(); //shows ship info
	Thread.sleep(550);
	int result = battle();
	End(result);
    }
}
