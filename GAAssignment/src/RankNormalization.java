import java.util.Arrays;


public class RankNormalization implements NormalizationFunction {

	@Override
	public double[] normalize(Population pop) {
		GAParams ga = TSP.ga;
		Arrays.sort(pop.tours);
		int rankSum = (ga.populationSize * (ga.populationSize+1)) / 2;
		int i;
		pop.normalizedScores = new double[ga.populationSize];
		for (i = 0; i < ga.populationSize; i++) {
			int rank = (ga.populationSize-i);
			pop.normalizedScores[i] =  rank / rankSum;
		}
		return pop.normalizedScores;
	}

}
