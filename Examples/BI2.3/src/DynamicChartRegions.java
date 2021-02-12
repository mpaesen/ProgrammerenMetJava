import org.eclipse.birt.chart.model.DialChart;
import org.eclipse.birt.chart.model.attribute.ColorDefinition;
import org.eclipse.birt.chart.model.attribute.LineStyle;
import org.eclipse.birt.chart.model.attribute.impl.ColorDefinitionImpl;
import org.eclipse.birt.chart.model.attribute.impl.LineAttributesImpl;
import org.eclipse.birt.chart.model.component.DialRegion;
import org.eclipse.birt.chart.model.component.impl.DialRegionImpl;
import org.eclipse.birt.chart.model.data.*;
import org.eclipse.birt.chart.model.data.impl.NumberDataElementImpl;
import org.eclipse.birt.chart.model.type.DialSeries;
import org.eclipse.birt.report.engine.api.IParameterSelectionChoice;
import org.eclipse.birt.report.engine.api.script.IReportContext;
import org.eclipse.birt.report.engine.api.script.element.ITable;
import org.eclipse.birt.report.engine.api.script.eventadapter.TableEventAdapter;
import org.eclipse.birt.report.engine.api.script.instance.ITableInstance;
import org.eclipse.birt.report.model.api.CellHandle;
import org.eclipse.birt.report.model.api.ExtendedItemHandle;
import org.eclipse.birt.report.model.api.RowHandle;
import org.eclipse.birt.report.model.api.TableHandle;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class DynamicChartRegions extends TableEventAdapter {

@Override
	public void onCreate(ITableInstance table, IReportContext reportContext) {
		// TODO Auto-generated method stub
		super.onCreate(table, reportContext);
	}

	@Override
	public void onPageBreak(ITableInstance table, IReportContext reportContext) {
		// TODO Auto-generated method stub
		super.onPageBreak(table, reportContext);
	}

	@Override
	public void onPrepare(ITable tableHandle, IReportContext reportContext) {
		try{
			
			DialChart dChart = null;
			String RegionName = tableHandle.getNamedExpression("dyn_Regions");
			String RegionStartName = tableHandle.getNamedExpression("dyn_RegionStart");
			String RegionEndName = tableHandle.getNamedExpression("dyn_RegionEnd");
			String PeriodName = tableHandle.getNamedExpression("dyn_Period");
			String RegionColor = tableHandle.getNamedExpression("dyn_RegionColor");
			
			String SelectedPeriod = reportContext.getParameterValue(PeriodName).toString();
			Collection<IParameterSelectionChoice> prmRegions = ParameterUtil.getParameterValues(RegionName, reportContext);
			Collection<IParameterSelectionChoice> prmRegionStart = ParameterUtil.getParameterValues(RegionStartName, reportContext);
			Collection<IParameterSelectionChoice> prmRegionEnd = ParameterUtil.getParameterValues(RegionEndName, reportContext);
			Collection<IParameterSelectionChoice> prmRegionColor = ParameterUtil.getParameterValues(RegionColor, reportContext);
			
			ArrayList<IParameterSelectionChoice> StartValues = new ArrayList<IParameterSelectionChoice>();
			ArrayList<IParameterSelectionChoice> EndValues = new ArrayList<IParameterSelectionChoice>();
			ArrayList<IParameterSelectionChoice> Colors = new ArrayList<IParameterSelectionChoice>();
			
			WriteTextFileExample("Start: " + prmRegionStart.size() + " End: " + prmRegionEnd.size(), "C:\\sizes.txt");
			
			if (prmRegions == null || prmRegions.size() == 0 || prmRegionStart == null || prmRegionStart.size() == 0 || prmRegionEnd == null || prmRegionEnd.size() == 0) {
				return;
			}
			
			//Get right Values
			for (IParameterSelectionChoice Region : prmRegions) {
				if(Region.getLabel().equals(SelectedPeriod))
				{
					for (IParameterSelectionChoice StartRegion : prmRegionStart)
					{
						if(Region.getValue().toString().equals(StartRegion.getValue().toString()))
						{	
							StartValues.add(StartRegion);
						}
					}
					for (IParameterSelectionChoice EndRegion : prmRegionEnd)
					{
						if(Region.getValue().toString().equals(EndRegion.getValue().toString()))
						{						
							EndValues.add(EndRegion);
						}
					}
					for (IParameterSelectionChoice RegColor : prmRegionColor)
					{
						if(Region.getValue().toString().equals(RegColor.getValue().toString()))
						{						
							Colors.add(RegColor);
						}
					}
				}
				
			}	
			
			//Convert values to array
			IParameterSelectionChoice[] arrStartValues = (IParameterSelectionChoice[])StartValues.toArray(new IParameterSelectionChoice[StartValues.size()]);
			IParameterSelectionChoice[] arrEndValues = (IParameterSelectionChoice[])EndValues.toArray(new IParameterSelectionChoice[EndValues.size()]);
			IParameterSelectionChoice[] arrColorValues = (IParameterSelectionChoice[])Colors.toArray(new IParameterSelectionChoice[Colors.size()]);
						
			//GetChartFromTable
			TableHandle th = (TableHandle)ScriptUtil.getDesignElementFromScript(tableHandle);
			List<RowHandle> allRows = th.getHeader().getContents();
	    	
	    	for (RowHandle rowHandle : allRows) 
	    	{
	    		CellHandle cellHandle = (CellHandle) rowHandle.getCells().getContents().get(0);
	    		List<Object> cellItems = cellHandle.getContent().getContents();
				for (Object itemHandle : cellItems) 
				{
					if (itemHandle instanceof ExtendedItemHandle) {
						ExtendedItemHandle eih = (ExtendedItemHandle) itemHandle;
						
						dChart = (DialChart) eih.getReportItem().getProperty("chart.instance"); 

					}
				}
	    		
	    	}
	    	
	
	    	//SeriesDefinitions		
			SeriesDefinition sd = (SeriesDefinition)dChart.getSeriesDefinitions().get(0);
			SeriesDefinition sd2 = (SeriesDefinition)sd.getSeriesDefinitions().get(0);

			
			// DialSeries
			DialSeries seDial2 = (DialSeries) sd2.getSeries().get(0);

			//Set Scale
			seDial2.getDial( ).getScale( ).setMin(NumberDataElementImpl.create( Double.parseDouble(arrStartValues[0].getLabel() ) ));
			seDial2.getDial( ).getScale( ).setMax(NumberDataElementImpl.create( Double.parseDouble(arrEndValues[arrEndValues.length - 1].getLabel() )) );
			seDial2.getDial( ).getScale( ).setStep( Double.parseDouble(arrEndValues[arrEndValues.length - 1].getLabel() )/10 );
			
			
			
			//Create Regions
			int iAantal = 0;
			for(IParameterSelectionChoice param : arrStartValues)
			{
				DialRegion dregion1 = DialRegionImpl.create( );

				dregion1.setFill( getColor(arrColorValues[iAantal].getLabel()) );
				WriteTextFileExample("", "C:\\achter.txt");
				dregion1.setOutline( LineAttributesImpl.create( ColorDefinitionImpl
						.BLACK( )
						.darker( ), LineStyle.SOLID_LITERAL, 1 ) );
				dregion1.setStartValue( NumberDataElementImpl.create( Double.parseDouble(arrStartValues[iAantal].getLabel() ) ) );
				dregion1.setEndValue( NumberDataElementImpl.create( Double.parseDouble(arrEndValues[iAantal].getLabel() ) ) );
				//dregion1.setOuterRadius( 100 );
				seDial2.getDial( ).getDialRegions( ).add( dregion1 );
				iAantal++;
			}
			

		} 
			catch (Exception e) {
				System.out.println("adding columns ERROR");
				e.printStackTrace();
			}
	}

	@Override
	public void onRender(ITableInstance table, IReportContext reportContext) {
		// TODO Auto-generated method stub
		super.onRender(table, reportContext);
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
public ColorDefinition getColor(String hexCode)
{
	
	int R = Integer.parseInt(hexCode.substring(0,2),16);
	int G = Integer.parseInt(hexCode.substring(2,4),16);
	int B = Integer.parseInt(hexCode.substring(4,6),16);
	WriteTextFileExample(""+ R + ","+ G + "," + B , "C:\\RGB.txt");
	return ColorDefinitionImpl.create(R, G, B);
}
}
