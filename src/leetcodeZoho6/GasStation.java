package leetcodeZoho6;

public class GasStation {

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int totalGas = 0, totalCost = 0;
		int tank = 0, start = 0;

		for (int i = 0; i < gas.length; i++) {
			totalGas += gas[i];
			totalCost += cost[i];

			tank += gas[i] - cost[i];
			if (tank < 0) {
				// Cannot reach station i+1 from current start
				start = i + 1;
				tank = 0;
			}
		}

		return (totalGas >= totalCost) ? start : -1;
	}

	public static void main(String[] args) {
		int[] gas = { 1, 2, 3, 4, 5 };
		int[] cost = { 3, 4, 5, 1, 2 };

		int startIndex = canCompleteCircuit(gas, cost);
		System.out.println("Start at station: " + startIndex); // Output: 3
	}
}
