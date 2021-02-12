package samples;



// SalesReport Lab - Sales by Region
// Java Applet to explore drawArc, fillOval, dialog box, font, color
//                                                       PDB 2/14/97
// This class provides the data which is displayed by the SalesReport class.
// Why would a class be used to provide data, rather than a disk file on
// the server, or HTML parms?


class SalesReportData
{
String[] regionNames = new String[5];
int[]    regionSales = new int[5];
String   month       = "February 1997";
String   password    = "Java";

 public SalesReportData() // The constructor
 {
 regionNames[0] = "North East";
 regionNames[1] = "South East";
 regionNames[2] = "Mid-West  ";
 regionNames[3] = "North West";
 regionNames[4] = "South West";

 regionSales[0] = 1072; // in K$
 regionSales[1] =  928; // in K$
 regionSales[2] = 1745; // in K$
 regionSales[3] =  258; // in K$
 regionSales[4] =  825; // in K$
 }  
 public String getMonth()
 { return month; }  
 public String getPassWord()
 { return password; }  
 public String[] getRegionNames()
 { return regionNames; }  
 public int[]    getRegionSales()
 { return regionSales; }  
} // end of SalesReportData class