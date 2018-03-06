/** Battleship.java
    This program initiates the classic game of battleship.
    The player will play against the AI and will attempt to destroy all the
    opponent's battleship through shots taken in successive turns.
    @Author: Raiyan Rahman
    @Version: 1.0
    @Date: 27th December, 2015.
    **/
/*
Log 1:
27th Dec, 2015.
Added Main Window.
*/
import hsa.Console;
import java.awt.*;
import javax.swing.*;

public class Battleship
{
    public static void frame()
    {
	JFrame MMenu = new JFrame("Battleship");
	MMenu.setVisible(true);
	MMenu.setSize(600,450);
	MMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	MMenu.setResizable(false);
    }
    public static void main (String[] args ) throws InterruptedException
    {
	frame();
    }
}
