package lab12.solution.utility;

import java.util.Enumeration;
import java.util.Vector;

public class SortedVector
{

public void addElement(Sortable s) {
   for (int i = 0; i < rep.size(); i++) {
      Sortable si = (Sortable) rep.elementAt(i);
      if (s.lessThan(si)) {
         rep.insertElementAt(s, i); // add before ith element
         return;
      }
   }
   rep.addElement(s); // add at end
}

public Enumeration elements()
{
  return rep.elements();
}

public int size()
{
  return rep.size();
}

public String toString()
{
  return rep.toString();
}

private Vector rep = new Vector();
}
