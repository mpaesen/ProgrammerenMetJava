import beans.MuntBean;

import javax.faces.model.SelectItem;


public class testMuntBean {
	
public static void main(String[] args){
	
	MuntBean muntb = new MuntBean();
	
	for(SelectItem str : muntb.getMuntBenamingen()){
		System.out.println(str.toString());
	}
	
}

}
