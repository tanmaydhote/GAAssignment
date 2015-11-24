import java.util.Arrays;


public class ProportionalNormalization implements NormalizationFunction {

	@Override
	public double[] normalize(Population pop) {
		GAParams ga = TSP.ga;
		Arrays.sort(pop.tours);
		double sum = 0;
		int i;
		for (i = 0; i < ga.populationSize; i++) {
			sum += pop.tours[i].fitness;
		}
		pop.normalizedScores = new double[ga.populationSize];
		for (i = 0; i < ga.populationSize; i++) {
			pop.normalizedScores[i] = pop.tours[i].fitness / sum;
		}
		return pop.normalizedScores;
	}

}
