package jcu.util;

public class JCUUtil {

	public static double weRound(double num, int n) {

		int ten = 1;
		for (int i = 0; i < n; i++) {
			ten *= 10;

		}

		num = num * ten;
		long temp = Math.round(num);

		double result = (double) temp / ten;
		return result;
	}

}
