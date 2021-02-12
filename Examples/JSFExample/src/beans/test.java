package beans;

import javax.faces.model.SelectItem;
import java.util.ArrayList;

public class test {
private ArrayList<SelectItem> land =null;
private String landje= "";

public void setLand() {
	this.land = new ArrayList<SelectItem>();
	this.land.add(new SelectItem("1","a2"));
	this.land.add(new SelectItem("2","b2"));
	this.land.add(new SelectItem("3","c2"));
	
}

public ArrayList<SelectItem> getLand(){
	return this.land;
}

/**
 * 
 */
public test() {
	this.land = new ArrayList<SelectItem>();
	this.land.add(new SelectItem("1","a2"));
	this.land.add(new SelectItem("2","b2"));
	this.land.add(new SelectItem("3","c2"));
}

public void setLandje(String landje) {
	this.landje = landje;
}

public String getLandje() {
	return landje;
}


}
