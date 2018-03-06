import hsa.Console;
import javax.swing.JOptionPane;
public class placementdemo
{
    static Console c;
    public static void main(String[] args) throws InterruptedException
    {
	String ship[] = {"Aircraft Carrier", "Large Battleship", "Small Battleship", "Patrol Ship", "Submarine"};
	int AC[][] = new int[2][5];
	int LB[][] = new int[2][4];
	int SB[][] = new int[2][3];
	int PS[][] = new int[2][2];
	int Su[][] = new int[2][1];
	
	c = new Console();
	
	for(int counter = 0;    counter < ship.length;  counter++)
	{
	    if(counter == 0)
	    {
		for(int crdnts = 0; crdnts < AC[0].length; crdnts++)
		{
		    int row = Integer.parseInt(JOptionPane.showInputDialog("Please enter the row coordinate for your " + ship[counter] + ".\n(Rows 1-10)"));
		    int column = Integer.parseInt(JOptionPane.showInputDialog("Please enter the column coordinate for your " + ship[counter] + ".\n(Columns 1-10)"));
		    AC[0][crdnts] = (row - 1);
		    AC[1][crdnts] = (column - 1);
		    c.println("Row: " + row + ", Column: " + column);
		}
	    }
	    if(counter == 1)
	    {
		for(int crdnts = 0; crdnts < LB[0].length; crdnts++)
		{
		    int row = Integer.parseInt(JOptionPane.showInputDialog("Please enter the row coordinate for your " + ship[counter] + ".\n(Rows 1-10)"));
		    int column = Integer.parseInt(JOptionPane.showInputDialog("Please enter the column coordinate for your " + ship[counter] + ".\n(Columns 1-10)"));
		    LB[0][crdnts] = (row - 1);
		    LB[1][crdnts] = (column - 1);
		    c.println("Row: " + row + ", Column: " + column);
		}
	    }
	    if(counter == 2)
	    {
		for(int crdnts = 0; crdnts < SB[0].length; crdnts++)
		{
		    int row = Integer.parseInt(JOptionPane.showInputDialog("Please enter the row coordinate for your " + ship[counter] + ".\n(Rows 1-10)"));
		    int column = Integer.parseInt(JOptionPane.showInputDialog("Please enter the column coordinate for your " + ship[counter] + ".\n(Columns 1-10)"));
		    SB[0][crdnts] = (row - 1);
		    SB[1][crdnts] = (column - 1);
		    c.println("Row: " + row + ", Column: " + column);
		}
	    }
	    if(counter == 3)
	    {
		for(int crdnts = 0; crdnts < PS[0].length; crdnts++)
		{
		    int row = Integer.parseInt(JOptionPane.showInputDialog("Please enter the row coordinate for your " + ship[counter] + ".\n(Rows 1-10)"));
		    int column = Integer.parseInt(JOptionPane.showInputDialog("Please enter the column coordinate for your " + ship[counter] + ".\n(Columns 1-10)"));
		    PS[0][crdnts] = (row - 1);
		    PS[1][crdnts] = (column - 1);
		    c.println("Row: " + row + ", Column: " + column);
		}
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
		}
	    }
	}
    }
}
