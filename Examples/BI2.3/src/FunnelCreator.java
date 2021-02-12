import org.eclipse.birt.report.engine.api.IParameterSelectionChoice;
import org.eclipse.birt.report.engine.api.script.IReportContext;
import org.eclipse.birt.report.engine.api.script.element.ITable;
import org.eclipse.birt.report.engine.api.script.eventadapter.TableEventAdapter;
import org.eclipse.birt.report.model.api.CellHandle;
import org.eclipse.birt.report.model.api.ImageHandle;
import org.eclipse.birt.report.model.api.RowHandle;
import org.eclipse.birt.report.model.api.TableHandle;
import org.eclipse.birt.report.model.api.activity.SemanticException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Collection;
import java.util.List;
import java.util.Random;



public class FunnelCreator extends TableEventAdapter {

	@Override
	public void onPrepare(ITable tableHandle, IReportContext reportContext) {
		
		//Parameter waarden ophalen.. maw dataset inlezen
		try{
		//is de report parameternaam ophalen die is weggeschreven 
		//in NamedExpression van de table
		String paramName = tableHandle.getNamedExpression("dyn_parameter");
		
		//gegevens ophalen en in een collection steken
		Collection<IParameterSelectionChoice> colValues = ParameterUtil.getParameterValues(paramName, reportContext);
		//kijken of deze niet leeg is.. zoja, gebeurt er niets
		if (colValues == null || colValues.size() == 0) {
			return;
		}
		
		//Omdat het verder in de code nodig is om een tablehandle 
		//te hebben en geen ITable, wordt deze hier gemaakt van de
		//ITable die wordt meegegeven aan deze methode
		TableHandle th = (TableHandle)ScriptUtil.getDesignElementFromScript(tableHandle);

		//Funnel methode oproepen
		createFunnel(colValues, th);
		} 
		catch (Exception e) {
			System.out.println("adding columns ERROR");
			e.printStackTrace();
		}
	}
    public void WriteTextFileExample(String stekst, String sFilename){
	try {
		Writer output = null;
		String text = stekst;
		File file = new File(sFilename);
		output = new BufferedWriter(new FileWriter(file));
		output.write(text);
		output.close();
		System.out.println("Your file has been written");   
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
    public void createFunnel(Collection<IParameterSelectionChoice> cDataSet, TableHandle tableHandle)
	{
    	//Doordat het niet mogelijk is om een index mee te geven aan een 
    	//Collection en dit mogelijk moet zijn om een bepaalde waarde
    	//op te halen wordt deze omgezet naar een Array waar dit wel
    	//mogelijk is
    	
		IParameterSelectionChoice[] arrDataSet = (IParameterSelectionChoice[])cDataSet.toArray(new IParameterSelectionChoice[cDataSet.size()]);
		
		//width en height van de afbeelding
		int width = 650, height = 500;
		//de hoogte van 1 laag bereken door de hoogte / de lengte van de
		//array + 1 omdat er maar 3 waarden inzitten maar dit wordt 
		//in 4 lagen weergegeven
		double heightlayer = height/(arrDataSet.length + 1);
		double widthlayer, widthlayer2, x, y;
		
		//Om de afbeelding te vullen in de breedte en 
		//te zorgen dat alles proportioneel is werkt ik met een factor.
		//deze wordt gemaakt door de width te delen door de bovenste waarde
		//van de dataset.. bij de width neem ik er 150 pixels van
		//om plaats te reserveren voor de tekst.
		double factor = (width-150)/Integer.parseInt(arrDataSet[0].getLabel());
		
		//omdat het niet werkt als de bovenste waarde groter is dan de width
		//kijk ik hier of deze groter is dan de width en tergelijkertijd
		//weet ik dan ook hoeveel keer hij te groot is
		int control = Integer.parseInt(arrDataSet[0].getLabel())/(width-150);
		String sLabel;
		Point p1, p2, p3, p4;
		
		//Aanmaken van de afbeelding
		BufferedImage afbeelding = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		
		//aanmaken van de graphics (deze tekent op de afbeelding)
		Graphics2D g = afbeelding.createGraphics();
		
		//font instellen
		Font font = new Font("TimesRoman", Font.PLAIN, 15);
		g.setFont(font);
		//zorgen dat de afbeelding mooie afrondingen heeft
		//en geen gekartelde rondingen
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//achtergrond van de afbeelding wit maken
		g.setPaint(Color.white);
		g.fillRect(0, 0, width, height);
		
		//alle lagen overlopen om deze te tekenen
		for(int i = arrDataSet.length; i>0; i--)
		{
			//label ophalen
			sLabel = arrDataSet[i-1].getValue().toString() + ": " + arrDataSet[i-1].getLabel();
			
			//de kleur van de laag random laten genereren
			Random rand = new Random();
			Color c = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
			g.setPaint(c);
			
			//hier maken we het onderscheid tussen de onderste laag 
			//de bovenste laag en de lagen ertussen doordat er voor die 3
			//lagen andere tekenopdrachten zijn
			
			//als de laag de onderste is..
			if(i==arrDataSet.length)
			{
				//kijken of de control die erjuist werd berekend groter
				//is dan 0.. als dat effectief zo is dan wordt de factor
				//opnieuw berekend aan de hand met de waarde van
				//control..
				//ook de widthlayer moet hiervoor dan aangepast worden.
				if(control>0)
				{
					factor = (width-150)/(Integer.parseInt(arrDataSet[0].getLabel())/(control*2));
					widthlayer = Integer.parseInt(arrDataSet[i-1].getLabel())/(control*2) * factor;		
				}
				else
				{
					widthlayer = Integer.parseInt(arrDataSet[i-1].getLabel()) * factor;			
				}
				
				//berekenen van de punten voor de onderste laag
				x = ((width-150)/2) - (widthlayer / 2);
				y = heightlayer * (i);
				
				//tekenen van de ovaal, de rechthoek voor de onderste laag
				//en het label
				g.fillOval((int)x, (int)(y+((heightlayer/4)+(((heightlayer/2)-20)/2))), (int)widthlayer, (int)20);
				g.fillRect((int)x, (int)(y-(heightlayer/2)), (int)widthlayer, (int)heightlayer);
				g.drawString(sLabel, (int)(((x+widthlayer)+30)), (int)(y+(heightlayer/2)));
			}
			//als het niets de onderste laag is..
			else
			{
				//weer kijken of of de control groter is dan 0
				//hier wordt de factor niet opnieuw berekend
				//omdat deze enkel van toepassing is op de bovenste laag
				//en moest deze te groot geweest zijn dan werd de factor
				//hierboven al terug berekend. De widthlayer van de startlaag
				//en de eindlaag moeten wel aanpast worden
				if(control>0)
				{
					widthlayer = (Integer.parseInt(arrDataSet[i].getLabel())/(control*2)) * factor;
					widthlayer2 = (Integer.parseInt(arrDataSet[i-1].getLabel())/(control*2)) * factor;
				}
				else
				{
					widthlayer = (Integer.parseInt(arrDataSet[i].getLabel())) * factor;
					widthlayer2 = (Integer.parseInt(arrDataSet[i-1].getLabel())) * factor;
				}
				
				//berekenen en tekenen van de punten
				x = ((width-150)/2) - (widthlayer / 2);

				y = heightlayer * (i);
				
				g.fillOval((int)x, (int)(y+(heightlayer/4)+(((heightlayer/2)-20)/2)), (int)widthlayer, (int)20);
				
				
				
				p1 = new Point((int)x,(int)(y+(heightlayer/2)));
				p2 = new Point((int)(x+widthlayer),(int)(y+(heightlayer/2)));
				p3 = new Point((int)((x+widthlayer)+((widthlayer2-widthlayer)/2)),(int)(y-(heightlayer/2)));
				p4 = new Point((int)(x-((widthlayer2-widthlayer)/2)),(int)(y-(heightlayer/2)));
				
				Polygon p = new Polygon();
		    	p.addPoint(p4.x, p4.y);
		    	p.addPoint(p3.x, p3.y);
		    	p.addPoint(p2.x, p2.y);
		    	p.addPoint(p1.x, p1.y);
		    	
		    	g.fill(p);
		    	
		    	
		    	//als i gelijk is aan 1 betekend dit dat hij bezig is met de
		    	//bovenste laag.. in dit geval moet er nog een ovaal bovenop
		    	//de polygon komen
		    	if(i==1)
		    	{
		    		//om een beter 3D effect te bekomen maak ik de kleur
		    		//voor de bovenste ovaal een beetje lichter dan
		    		//de kleur van de bovenste laag
		    		g.setPaint(c.brighter());
		    		g.fillOval((int)(x-((widthlayer2-widthlayer)/2)), (int)((y-heightlayer)+(heightlayer/4)+(((heightlayer/2)-20)/2)), (int)widthlayer2, (int)20);
		    	}
		    	
		    	
			}
			//tekenen van het label.. ik denk dat dit boven het
			//haakje moet staan maar ik heb momenteel niet echt zin om
			//het te testen.. omdat het toch werkt :)
			g.setPaint(Color.BLACK);
	    	g.drawString(sLabel, (int)(((x+widthlayer)+30)), (int)(y+(heightlayer/2)));
			
		}	
		//hierna hebben de de graphic niet meer nodig dus doen we deze weg
		g.dispose();
		
		
		try {
			//hier slaan we de afbeelding dit in de buffer stond op
			//en gebruiken we de bestandnaam om deze in het rapport te
			//plaatsen
			String sFilename = "C://test.png";
			ImageIO.write(afbeelding, "png", new File(sFilename));
			InsertFunnel(sFilename,tableHandle);
		    } 
		catch (IOException e) 
		{
		    e.printStackTrace();
		}
		catch (SemanticException se)
		{
			se.printStackTrace();
		}
		    	
	}
    private void InsertFunnel(String sFileName,TableHandle tableHandle) throws SemanticException {
    	//Hier hebben we dus die tableHandle nodig die we in de eerste
    	//methode hebben moeten omvormen van een ITable naar een
    	//TableHandle
    	
    	//we maken een lijst met alle rijen uit de header
    	List<RowHandle> allRows = tableHandle.getHeader().getContents();
    	
    	//we overlopen alle rijen en kijken in de cell om alle objecten
    	//die eventueel in de cell staan terug in een lijst te plaatsen.
    	for (RowHandle rowHandle : allRows) 
    	{
    		CellHandle cellHandle = (CellHandle) rowHandle.getCells().getContents().get(0);
    		List<Object> cellItems = cellHandle.getContent().getContents();
			
    		//we overlopen alle objecten in de lijst en kijken of deze 
    		//van het type afbeelding zijn
    		for (Object itemHandle : cellItems) 
			{
				if (itemHandle instanceof ImageHandle) {
					
					//als die het geval is dan maken we van het object
					//een ImageHandle en stellen we de bestandsnaam in..
					ImageHandle ih = (ImageHandle) itemHandle;
					ih.setFile(sFileName);
					
					
					
					///////////////////////////////////////
					// And That's how we make a funnel!  //
					///////////////////////////////////////
				}
			}
    		
    	}
    }
}