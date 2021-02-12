
package ch12;

import ch12.cars.Car;
import ch12.cars.CarLot;

import javax.swing.*;
import java.awt.*;

public class DisplayList extends JTable
{
    private DisplayWindowModel model = new DisplayWindowModel();

    public DisplayList()
    {
        super();
        setModel(model);
    }

    public void setData(CarLot carlot)
    {
       model.populate(carlot);
    }

    // we added the following methods because they exist in JList and we like
    // to write similar code for both JList and JTable.

    /**
     * Public helper method to return selected item value. Mimics method in JList
     */
    public Car getSelectedValue()
    {
        Car selObj = null;
        int index = getSelectedRow();
        if (index != -1)
          selObj = model.getCarAt(index);
        return selObj;
    }
    /**
     * Public helper method to return selected item index. Mimics method in JList
     */
    public int getSelectedIndex()
    {
        return getSelectedRow();
    }
    /**
     * Public helper method to return true/false if list item selected. Mimics method in JList
     */
    public boolean isSelectionEmpty()
    {
        int index = getSelectedRow();
        return (index == -1);
    }
    /**
     * Public helper method to set the selected row by index number. Mimics method in JList
     */
    public void setSelectedIndex(int index)
    {
        setRowSelectionInterval(index,index);
    }
    /**
     * Public helper method to scroll to make the given row visible, if necessary.
     *  The row is identified by index number. Mimics method in JList
     */
    public void ensureIndexIsVisible(int index)
    {
        Rectangle cellRect = getCellRect(index, 0, true);
        scrollRectToVisible(cellRect);
    }
    /**
     * Public helper method to set how many rows to make visible at once.
     *  Mimics method in JList
     */
    public void setVisibleRowCount(int rows)
    {
        int rowHeight = getRowHeight() + getRowMargin();
        Dimension size = getPreferredScrollableViewportSize();
        size.height = rowHeight*rows;
        setPreferredScrollableViewportSize(size);
    }

}