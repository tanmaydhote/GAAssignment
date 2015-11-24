import java.util.List;
import java.util.Random;



public class WithMutationRateReproduction implements ReproductionFunction {

	@Override
	public Population createNewPopulation(Population currentPopulation) {
		GAParams ga = TSP.ga;
		Population newPopulation = new Population(false);
		ga.normFunc.normalize(currentPopulation);
		Random rand = new Random();
		int i;
		for (i = 0; i < ga.eliteCount; i++)
			newPopulation.tours[i] = currentPopulation.tours[i];
		List<Tour> parents = ga.selFunc.getSelection(currentPopulation);
		CrossoverFunction.Children childTours;

		for(int j=0; j < parents.size()-1;) {
			childTours = ga.xoverFunc.mate(parents.get(j++), parents.get(j++));
			newPopulation.tours[i] = childTours.first();
			if (rand.nextDouble() < ga.mutationRate)
				newPopulation.tours[i] = ga.mutFunc.mutate(newPopulation.tours[i]);
			i++;
			newPopulation.tours[i] = childTours.second();
			if (rand.nextDouble() < ga.mutationRate)
				newPopulation.tours[i] = ga.mutFunc.mutate(newPopulation.tours[i]);
			i++;
		}
		int pos;
		for(; i < ga.populationSize; i++) {
			pos = rand.nextInt(ga.populationSize);
			newPopulation.tours[i] = ga.mutFunc.mutate(currentPopulation.tours[pos]);
		}
		return newPopulation;
	}
}
