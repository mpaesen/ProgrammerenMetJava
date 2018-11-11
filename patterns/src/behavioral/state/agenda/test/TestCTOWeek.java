package behavioral.state.agenda.test;

import behavioral.state.agenda.model.CTO;

public class TestCTOWeek {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CTO cto = new CTO();
		//perform week
		cto.performAgenda();
		cto.changeDay();
		cto.performAgenda();
		cto.changeDay();
		cto.performAgenda();
		cto.changeDay();
		cto.performAgenda();
		cto.changeDay();
		cto.performAgenda();
		cto.changeDay();
		cto.performAgenda();
		cto.changeDay();
		cto.performAgenda();
		cto.changeDay();

	}

}
