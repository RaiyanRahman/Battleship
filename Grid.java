import hsa.Console;
import java.awt.*;

public class Grid
{
    static Console c;
    
    public static void PlayGrid()
    {
	//Player Board
	c.setColor(Color.BLUE);
	c.setFont(new Font("Georgia", Font.BOLD, 28));
	c.drawString("BATTLESHIP!", 15, 20);
	int x1, y1;
	c.drawRect(250, 0, 650, 599);
	for(x1 = 250;  x1 < 900;    x1+=59)
	{
	    c.drawLine(x1, 0, x1, 599);
	}
	for(y1 = 0;  y1 < 599;    y1+=54)
	{
	    c.drawLine(250, y1, 900, y1);
	}
	c.setColor(Color.BLACK);
	c.setFont(new Font("Verdanna", Font.BOLD, 32));
	c.drawString("A  \t  B  \t  C  \t  D  \t  E  \t  F  \t  G  \t  H  \t  I  \t  J", 325, 42);
	int a = 92;
	for(int counter = 1;  counter < 11; counter++)
	{
	    c.drawString("" + counter, 266, a);
	    a = a + 55;
	}
    }
    public static void main(String[] args) throws InterruptedException
    {
	c = new Console(30, 115, "Player Board");
	PlayGrid();
    }
}
