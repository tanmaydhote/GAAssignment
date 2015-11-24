import java.util.ArrayList;
import java.util.List;


public class RouletteSelection implements SelectionFunction {

	@Override
	public List<Tour> getSelection(Population pop) {
		List<Tour> selection = new ArrayList<>();
		GAParams ga = TSP.ga;

		double selectionValue, currentSum;
		boolean added;
		int numtoSelect = (ga.populationSize-ga.eliteCount);
		for (int i=0; i < numtoSelect; i++) {
			selectionValue = Math.random();
			currentSum = 0;
			added = false;
			for (int j = 0; j < ga.populationSize; j++) {
				currentSum += pop.normalizedScores[j];
				if (selectionValue <= currentSum) {
					selection.add(pop.tours[j]);
					added = true;
					break;
				}
			}
			if (added == false)
				selection.add(pop.tours[ga.populationSize-1]);
		}
		return selection;
	}
}
