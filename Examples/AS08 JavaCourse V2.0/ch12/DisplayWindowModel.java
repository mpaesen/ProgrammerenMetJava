package ch12;

import ch12.cars.Car;
import ch12.cars.CarLot;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class DisplayWindowModel extends AbstractTableModel
{
    private String[] columnHeadings = {"Plate", "Class", "Make", "Color", "When"};
    private Vector data = new Vector();

    // all these methods are overrides of parent methods...

    public String getColumnName(int col)
    {
        return columnHeadings[col];
    }
    public int getRowCount()
    {
        return data.size();
    }
    public int getColumnCount()
    {
       return columnHeadings.length;
    }
    public Object getValueAt(int row, int col)
    {
        Car car = (Car)data.elementAt(row);
        switch(col)
        {
           case 0:
               return car.getPlate();
           case 1:
               return car.getClassification();
           case 2:
               return car.getMake();
           case 3:
               return car.getColor();
           default:
               return car.getRentalDate();
        }
    }

    public boolean isCellEditable(int row, int col)
    {
        return false;
    }

    // this is our own method
    public void populate(CarLot carlot)
    {
        data.removeAllElements();
        int totalCount = carlot.getRentedCarCount();
        int pos = -1;
        for (int count = 0; count < totalCount; count++)
        {
           pos = carlot.nextRentedCar(pos);
           data.addElement(carlot.getCarAt(pos));
        }
        fireTableDataChanged();
    }

    // this is our own method
    public Car getCarAt(int pos)
    {
        return (Car)data.elementAt(pos);
    }
}