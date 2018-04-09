package com.algo.dp;

public class Knapsack {

	static public int[][] maximumSatasfactionMatrix;

	public Knapsack() {
	}

	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public static int compute(int weight, Integer[] weights, Integer[] values) {

		int n = values.length;
		maximumSatasfactionMatrix = new int[n + 1][weight + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= weight; j++) {

				if (i == 0 || j == 0) {
					maximumSatasfactionMatrix[i][j] = 0;
				} else if (weights[i - 1] <= j) {
					maximumSatasfactionMatrix[i][j] = max(values[i - 1] + maximumSatasfactionMatrix[i - 1][j - weights[i - 1]], maximumSatasfactionMatrix[i - 1][j]);

				} else {
					maximumSatasfactionMatrix[i][j] = maximumSatasfactionMatrix[i - 1][j];
				}

			}
		}

	 return maximumSatasfactionMatrix[n][weight];
	}

}
