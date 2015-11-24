import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class TSP {
	public static int cityCount;
	public static double[][] distanceMatrix;
	public static GAParams ga;

	public static void inputParams() {
		Scanner in = null, conin = new Scanner(System.in);
		System.out.println("==========TSP Parameters=============");
		System.out.print("Enter parameters manually or from file (1-manual, 2-file): ");
		int op = conin.nextInt();
		System.out.println();
		
		if (op == 1)
			in = new Scanner(System.in);
		else if (op == 2) {
			System.out.print("Enter path to file: ");
			String filename = conin.next();
			try {
				in = new Scanner(new File(filename));
			} catch (FileNotFoundException e) {
				System.err.println("The file " + filename
						+ " could not be opened");
				System.exit(1);
			}
		}
		// System.out.print("Number Of Cities: ");
		cityCount = in.nextInt();
		// System.out.println("City Count " + cityCount);
		distanceMatrix = new double[cityCount][cityCount];
		int i, j;
		for (i = 0; i < cityCount; i++) {
			for (j = 0; j < cityCount; j++) {
				distanceMatrix[i][j] = in.nextFloat();
			}
		}
		ga = new GAParams(distanceMatrix);
		ga.input();
//		ga.populationSize = in.nextInt();
//		ga.mutationRate = in.nextDouble();
//		ga.printAfter = in.nextInt();
		in.close();
		conin.close();
	}
	
	public static void display(Population currPop, int iter) {
		Tour bestTour = currPop.getBestTour();
		double avgFitness = currPop.getAvgFitness();
		System.out.println("Iteration #"+iter);
		System.out.println("Best tour so far ...");
		bestTour.printTour();
		System.out.println("Average fitness = "+avgFitness);
		System.out.println("Best fitness = "+bestTour.fitness);
		System.out.println();
	}

	public static void main(String[] a) {
		inputParams();
		int niter = 0;
		Genetic genetic = new Genetic();
		do {
			if (niter % ga.printAfter == 0)
				display(genetic.currentPopulation, niter+1);
			genetic.createNewPopulation();
			niter++;
		} while(niter < ga.maxIterations);
		display(genetic.currentPopulation, niter);
	}
}