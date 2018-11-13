package myMath;
import java.util.Comparator;

/**
 * this class use as a comperator between two monoms
 *@author Netanel Ben-Isahar 204478150
 *@author Daniel Abargel 315660712
 * 
 * 
 *
 */
public class Monom_Comperator implements Comparator<Monom> {
	/**
	 * this function use as a comperator between two monoms.
	 * @param arg_0 represents the first monom.
	 * @param arg_1 represents the second monom.
	 * @return -1 if the first monom's power is higher than the second's,
	 *  1 if the first monom's power is smaller than the second's    
	 *   and 0 if both monom's power are equal.
	 */
	public int compare(Monom arg_0, Monom arg_1) {
		if (arg_0.get_power() > arg_1.get_power()) {
			return -1;
		} else if (arg_0.get_power() < arg_1.get_power()) {
			return 1;
		} else {
			return 0;
		}

	}
}
