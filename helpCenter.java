import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class helpCenter extends MouseAdapter {

	static Point leftTop;
	static Point rightBottom;
	static int timesClicked = 0;

	@Override
	public void mouseClicked(MouseEvent e) {
		Point p = MouseInfo.getPointerInfo().getLocation();
		System.out.println(p);
		if(timesClicked == 0)
		{
			leftTop = p;
			System.out.println("Now click the right-bottom side of the area.");
		}
		else if(timesClicked == 1)
		{
			rightBottom = p;
			System.out.println("All necessary location data aquired..)");
		}
		timesClicked++;
	}

	public static Point getLeftTop()
	{
		return leftTop;
	}
	public static Point getRightBottom()
	{
		return rightBottom;
	}
	public static int getTimesClicked()
	{
		return timesClicked;
	}
}