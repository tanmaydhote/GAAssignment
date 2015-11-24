import java.util.Arrays;
import java.util.Collections;

public class Population {
	Tour[] tours;
	double[] normalizedScores;

	public Population(boolean initialise) {
		tours = new Tour[TSP.ga.populationSize];
		if (initialise == true) {
			for (int i = 0; i < TSP.ga.populationSize; i++)
				tours[i] = new Tour(true);
		}
	}

	public Tour getBestTour() {
		return Collections.min(Arrays.asList(tours));
	}
	
	public double getAvgFitness() {
		double avgFitness = 0;
		for (int i=0; i < TSP.ga.populationSize; i++)
			avgFitness += tours[i].fitness;
		avgFitness /= TSP.ga.populationSize;
		return avgFitness;
	}
	
	
}
