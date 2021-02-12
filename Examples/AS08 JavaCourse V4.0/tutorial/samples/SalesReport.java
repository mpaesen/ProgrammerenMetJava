package samples;



// SalesReport Lab - Sales by Region
// Java Applet to explore drawArc, fillOval, dialog box, font, color
//                                                       PDB 2/14/97

import java.applet.Applet;
import java.awt.*;

public class SalesReport extends Applet
{
SalesReportData regionData  = new SalesReportData();//input data-provider class
String[]     regionNames = regionData.getRegionNames();
int[]        regionSales = regionData.getRegionSales();
String       regionMonth = regionData.getMonth();
String       regionTitle = "Acme Sales By Region";

Font         bigPrint    = new Font("Times Roman", Font.BOLD, 36);
Font         mediumPrint = new Font("Times Roman", Font.BOLD, 18);
int[]        arcStop     = new int[regionSales.length + 1];
int[]        arcStart    = new int[regionSales.length + 1];
int[]        arcLength   = new int[regionSales.length + 1];
int          totalSales;
final int    titleX      = 50;
final int    titleY      = 40;
final int    monthX      = 100;
final int    monthY      = 70;
final int    pieX        = 100;
final int    pieY        = 100;
final int    pieWidth    = 300;
final int    pieHeight   = 200;
final int    legendX     = pieX + 100;
final int    legendY     = pieY + pieHeight + 20;
final int    legendWidth = 10; // color code dot size in legend
final int    legendHeight= legendWidth; // make the dot a circle 
Color[] colors = 
 {Color.white, Color.red, Color.yellow, Color.blue, Color.black, Color.green};


 public void init()
 {
 for (int i = 0; i < regionSales.length; i++)  // sum to total sales
	 totalSales += regionSales[i];
 for (int i = 1; i <= regionSales.length; i++) // figure region percent of sales
	 {
	 arcLength[i] = (regionSales[i-1] * 360) / totalSales;
	 arcStart[i]  = arcStop[i-1];
	 arcStop[i] = arcStart[i] + arcLength[i];
	 // System.out.println("i = " + i +
	 //                   ", arcStart = " + arcStart[i] +
	 //                   ", arcLength = " + arcLength[i] +
	 //                   ", arcStop = " + arcStop[i]);
	 if (i == regionSales.length)    // if this is the last loop...
		{                            // then
		int fill = 360 - arcStop[i]; // how much to complete the circle?
		arcLength[i] += fill;        // bump last arc to make it go full circle
		}
	 }
 } // end of method init()  
 public void paint(Graphics g)
 {
 for (int i = 1; i <= regionSales.length; i++) // figure region percent of sales
	 {
	 g.setColor(colors[i]);
	 g.fillArc(pieX, pieY, pieWidth, pieHeight, arcStart[i], arcLength[i]);
	 g.fillOval(legendX, legendY + 10*i, legendWidth, legendHeight);
	 g.setColor(Color.black); // for name and sales print
	 g.drawString(regionNames[i-1] + "   " + regionSales[i-1],
				  legendX + 20, legendY + 10*i + 10);
	 }
 g.setColor(Color.black);
 g.setFont(bigPrint);
 g.drawString(regionTitle, titleX, titleY);
 g.setFont(mediumPrint);
 g.drawString(regionMonth + "  Total Sales: $" + totalSales + "K",
			  monthX, monthY);

 } // end of method paint.  
} // end of class SalesReport