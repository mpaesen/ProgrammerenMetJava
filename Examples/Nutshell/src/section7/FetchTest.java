package section7;

import java.awt.*;

public class FetchTest extends Frame
{
	private Image i;

	@Override
	public void paint(final Graphics g)
	{
		g.drawImage(i, 0, 0, this);
	}

	public static void main(final String[] args) throws Exception
	{
		final FetchTest f = new FetchTest();
		f.i = Fetch.fetchimage(args[0], f);
		f.resize(300, 300);
		f.show();
	}
}
