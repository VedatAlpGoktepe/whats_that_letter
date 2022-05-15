import javax.swing.JFrame;
import java.util.Scanner;
import java.lang.Thread;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class LetterFinder
{
	public static void main(String[] args)
	{
		computerControl robot = new computerControl();
		int highest = -1;
		int lowest = -1000000;
		boolean nou = false;

		Point leftTop;
		Point rightBottom;
		int clickTimes;
		int delay;
		int whitePixels = 0;
		Scanner in = new Scanner(System.in);
        JFrame frame = new JFrame("Position Setter");
        frame.getContentPane().addMouseListener(new helpCenter());
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setOpacity((float) 0.8);
        frame.setVisible(true);
        JFrame exit = new JFrame("Close To End Code");
        exit.setSize(200, 100);
        exit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        exit.setVisible(true);

        System.out.println("===HOW TO USE===");
        System.out.println("1. Align the area ingame with the window titled 'Position Setter'.");
        System.out.println("2. Click on the requested locations on your screen in 'Position Setter'.");
        System.out.println("3. Close the window titled 'Close To End Code' when you want to end the code.");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Click the top-left corner of the letter area.");

        while(true)
        {
        	try
        	{
        		Thread.sleep(10);
        	} catch(Exception e){}

        	clickTimes = helpCenter.getTimesClicked();
        	while(clickTimes >= 2)
        	{
        		leftTop = helpCenter.getLeftTop();
        		rightBottom = helpCenter.getRightBottom();
        		frame.dispose();

				System.out.print("Enter the delay time: ");
				delay = in.nextInt();
				robot.setDelay(delay);

				System.out.println("Program will start in 3 seconds");

				try
				{
					Thread.sleep(3000);
				} catch(Exception e){}

				while(nou == false)
		        {
					BufferedImage screen = robot.screenShot();
					System.out.println("Starting.");
    		        for(int x = leftTop.x; x < rightBottom.x; x++)
    		        {
    		            for(int y = leftTop.y; y < rightBottom.y; y++)
    		            {
    		                int current = screen.getRGB(x, y);
    		                if(current >= lowest && current <= highest)
    		                {
    		                    whitePixels++;
    		                }
    		            }
    		        }
    		        System.out.println("Number of pixels: " + whitePixels);
    		        if(whitePixels >= 682 && whitePixels <= 688)
    		        {
    		        	robot.tapKey(KeyEvent.VK_E);
    		        }
    		        else if(whitePixels >= 415 && whitePixels <= 422)
    		        {
    		        	robot.tapKey(KeyEvent.VK_R);
    		        }
    		        else if(whitePixels >= 640 && whitePixels <= 647)
    		        {
    		        	robot.tapKey(KeyEvent.VK_Y);
    		        }
    		        else if(whitePixels >= 689 && whitePixels <= 695)
    		        {
    		        	robot.tapKey(KeyEvent.VK_U);
    		        }
    		        else if(whitePixels >= 560 && whitePixels <= 570)
    		        {
    		        	robot.tapKey(KeyEvent.VK_F);
    		        }
    		        else if(whitePixels >= 858 && whitePixels <= 866)
    		        {
    		        	robot.tapKey(KeyEvent.VK_H);
    		        }
    		        else if(whitePixels >= 494 && whitePixels <= 502)
    		        {
    		        	robot.tapKey(KeyEvent.VK_J);
    		        }
    		        else if(whitePixels >= 818 && whitePixels <= 826)
    		        {
    		        	robot.tapKey(KeyEvent.VK_K);
    		        }
    		        else if(whitePixels >= 539 && whitePixels <= 547)
    		        {
    		        	robot.tapKey(KeyEvent.VK_Z);
    		        }
    		        else if(whitePixels >= 571 && whitePixels <= 578)
    		        {
    		        	robot.tapKey(KeyEvent.VK_X);
    		        }
    		        else if(whitePixels >= 505 && whitePixels <= 513)
    		        {
    		        	robot.tapKey(KeyEvent.VK_C);
    		        }
    		        else if(whitePixels >= 473 && whitePixels <= 481)
    		        {
    		        	robot.tapKey(KeyEvent.VK_V);
    		        }
    		        else if(whitePixels >= 868 && whitePixels <= 876)
    		        {
    		        	robot.tapKey(KeyEvent.VK_B);
    		        }
    		        else if(whitePixels >= 709 && whitePixels <= 718)
    		        {
    		        	robot.tapKey(KeyEvent.VK_N);
    		        }
    		        else
    		        {
    		        	robot.tapKey(KeyEvent.VK_J);
    		        }
    		        System.out.println("Number of pixels: " + whitePixels);
    		        whitePixels = 0;
        		}

				if(true)
				{
					break;
				}
        	}
        	if(clickTimes >= 2)
        	{
        		break;
        	}
        }
        exit.dispose();
	}
}