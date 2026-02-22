package leetcodeZoho8;

import java.util.*;

public class CoinChange {

	public static void main(String[] args) {

		int[] coins = { 50, 30, 10 }; // Coin array
		int target = 160; // Target amount

		Map<Integer, Integer> result = new LinkedHashMap<>();

		for (int coin : coins) {
			if (target >= coin) {
				int count = target / coin;
				target = target % coin;
				result.put(coin, count);
			}
		}

		if (target != 0) {
			System.out.println("Target amount cannot be formed exactly.");
		} else {
			for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
				System.out.println(entry.getKey() + " - " + entry.getValue());
			}
		}
	}
}