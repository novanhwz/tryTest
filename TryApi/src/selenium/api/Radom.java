package selenium.api;

import java.util.Random;

import org.junit.Test;

public class Radom {

	// get 10 data from 14
	@Test
	public void getRadom() {

		Random rand = new Random();
		int a[] = new int[10];
		a[0] = rand.nextInt(14) + 1;
		for (int i = 0; i < a.length; i++) {

			a[i] = rand.nextInt(14) + 1;
			for (int j = 0; j < i; j++) {
				if (a[i] == a[j]) {
					i--;
				}
			}

		}

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);

		}

	}

}
