package model;

import model.days.Dag;
import model.days.Friday;
import model.days.Monday;
import model.days.Saturday;
import model.days.Sunday;
import model.days.Thursday;
import model.days.Tuesday;
import model.days.Wednesday;


public class CTO {

	private Dag day;
	public CTO() {
		// TODO Auto-generated constructor stub
		day = new Monday();
	}
	
	public void performAgenda(){
		System.out.printf("%s", day);
		
	}
	
	public void changeDay(){
		switch(day.getWeekDay()){
		case "Monday": day = new Tuesday(); break;
		case "Tuesday": day = new Wednesday(); break;
		case "Wednesday": day = new Thursday(); break;
		case "Thursday": day = new Friday(); break;
		case "Friday": day = new Saturday(); break;
		case "Saturday": day = new Sunday(); break;
		default:  break;
		}
	}

}
