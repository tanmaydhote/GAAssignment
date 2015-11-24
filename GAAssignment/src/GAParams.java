import java.util.Scanner;

public class GAParams {
	int populationSize;
	FitnessFunction fitFunc;
	SelectionFunction selFunc;
	MutationFunction mutFunc;
	CrossoverFunction xoverFunc;
	NormalizationFunction normFunc;
	ReproductionFunction repFunc;
	double mutationRate;
	double xoverFraction;
	int eliteCount;
	int printAfter;
	int maxIterations;
	
	public GAParams(double[][] distanceMatrix) {
		populationSize = 2000;
		fitFunc = new LengthOfTourFitness(distanceMatrix);
		selFunc = new RouletteSelection();
		mutFunc = new TwoOptMutation();
		xoverFunc = new SinglePtOrderXOver();
		normFunc = new ProportionalNormalization();
		repFunc = new WithMutationRateReproduction();
		mutationRate = 0.4;
		xoverFraction = 0.7;
		eliteCount = 100;
		printAfter = 10;
		maxIterations = 10000;
	}
	
	public void input() {
		Scanner conin = new Scanner(System.in);
		System.out.println();
		System.out.println("==========Parameters for the Genetic Algorithm==========");
		
		System.out.print("Enter parameters manually, from file or go with the defualt (0-default, 1-manual, 2-file): ");
		int op1 = conin.nextInt(), op2;
		boolean valid;
		System.out.println();
		
		if (op1 == 1) {

			valid = true;
			do {
				System.out.print("Population size: ");
				populationSize = conin.nextInt();
				if (populationSize < 0) {
					valid = false;
					System.out.println("Invalid input. Try again....");
				}				
			} while (!valid);
			System.out.println();
			
			valid = true;
			do {
				System.out.print("Mutation rate: ");
				mutationRate = conin.nextDouble();
				if (mutationRate < 0 || mutationRate > 1) {
					valid = false;
					System.out.println("Invalid input. Try again....");
				}				
			} while (!valid);
			System.out.println();
			
			valid = true;
			do {
				System.out.print("Crossover Fraction: ");
				xoverFraction = conin.nextDouble();
				if (xoverFraction < 0 || xoverFraction > 1) {
					valid = false;
					System.out.println("Invalid input. Try again....");
				}				
			} while (!valid);
			System.out.println();
			
			valid = true;
			do {
				System.out.print("Elite Count: ");
				eliteCount = conin.nextInt();
				if (eliteCount < 0) {
					valid = false;
					System.out.println("Invalid input. Try again....");
				}				
			} while (!valid);
			System.out.println();
			
			valid = true;
			do {
				System.out.print("Display timer: ");
				printAfter = conin.nextInt();
				if (printAfter < 0) {
					valid = false;
					System.out.println("Invalid input. Try again....");
				}				
			} while (!valid);
			System.out.println();
			
			valid = true;
			do {
				System.out.print("Maximum iterations: ");
				maxIterations = conin.nextInt();
				if (maxIterations < 0) {
					valid = false;
					System.out.println("Invalid input. Try again....");
				}				
			} while (!valid);
			System.out.println();
			
			System.out.println("Fitness function:-");
			System.out.println("0 - default (tour length)");
			System.out.print("Enter choice: ");
			op2 = conin.nextInt();
			valid = true;
			do {
				switch (op2) {
				case 0:
					break;
				default:
					valid = false;
					System.out.println("Invalid input. Try again....");
				}
			} while (!valid);
			System.out.println();
			
			System.out.println("Selection operator:-");
			System.out.println("0 - default (roulette)");
			System.out.print("Enter choice: ");
			op2 = conin.nextInt();
			valid = true;
			do {
				switch (op2) {
				case 0:
					break;
				default:
					valid = false;
					System.out.println("Invalid input. Try again....");
				}
			} while (!valid);
			System.out.println();
			
			System.out.println("Crossover operator:-");
			System.out.println("0 - default (single point order)");
			System.out.println("1 - double point order");
			System.out.print("Enter choice: ");
			op2 = conin.nextInt();
			valid = true;
			do {
				switch (op2) {
				case 0:
					break;
				case 1:
					xoverFunc = new DoublePtOrderXover();
					break;
				default:
					valid = false;
					System.out.println("Invalid input. Try again....");
				}
			} while (!valid);
			System.out.println();
			
			System.out.println("Mutation operator:-");
			System.out.println("0 - default (2-opt)");
			System.out.println("1 - 3-opt");
			System.out.println("2 - swap");
			System.out.print("Enter choice: ");
			op2 = conin.nextInt();
			valid = true;
			do {
				switch (op2) {
				case 0:
					break;
				case 1:
					mutFunc = new ThreeOptMutation();
					break;
				case 2:
					mutFunc = new SwapMutation();
					break;
				default:
					valid = false;
					System.out.println("Invalid input. Try again....");
				}
			} while (!valid);
			System.out.println();
			
			System.out.println("Score Normalization Function:-");
			System.out.println("0 - default (proportional to fitness)");
			System.out.println("1 - based on rank");
			System.out.print("Enter choice: ");
			op2 = conin.nextInt();
			valid = true;
			do {
				switch (op2) {
				case 0:
					break;
				case 1:
					normFunc = new RankNormalization();
					break;
				default:
					valid = false;
					System.out.println("Invalid input. Try again....");
				}
			} while (!valid);
			System.out.println();
			
			System.out.println("Reproduction Strategy:-");
			System.out.println("0 - default (fixed proportion of crossover and mutation)");
			System.out.println("1 - mutation in new generation determined by mutation rate");
			System.out.print("Enter choice: ");
			op2 = conin.nextInt();
			valid = true;
			do {
				switch (op2) {
				case 0:
					break;
				case 1:
					repFunc = new WithMutationRateReproduction();
					break;
				default:
					valid = false;
					System.out.println("Invalid input. Try again....");
				}
			} while (!valid);
			System.out.println();
		}
		conin.close();
	}
}
