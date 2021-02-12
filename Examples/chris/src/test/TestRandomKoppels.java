package test;

import model.RandomKoppels;

import java.util.HashSet;
import java.util.Iterator;

public class TestRandomKoppels {
	public static void main(String[] args) {
		String koppel;
		HashSet<String> uniekeKoppels = new HashSet<String>();

		while(uniekeKoppels.isEmpty()||uniekeKoppels.size()<70){
			for (int i = 0; i < RandomKoppels.getLeerlingen().length; i++) {
				if (!uniekeKoppels.isEmpty()) {
					do {
						koppel = RandomKoppels.genereerKoppel(i);
					} while (uniekeKoppels.contains(koppel));
				} else {
					koppel = RandomKoppels.genereerKoppel(i);
				}
				uniekeKoppels.add(koppel);
			}
		}

		Iterator<String> iterator = uniekeKoppels.iterator();
		int keuken = 1;
		int week = 1;
		while (iterator.hasNext()) {
			if (week == 1) {
				System.out.println("keuken " + (keuken++));
			}
			week = (week < 10 ? ++week : 1);
			System.out.printf("%20s%3d%5s\n", "Week", (week), iterator
					.next());
		}

	}

}
