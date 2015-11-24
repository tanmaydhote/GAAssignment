public class LengthOfTourFitness implements FitnessFunction {
	double distanceMatrix[][];

	public LengthOfTourFitness(double distanceMatrix[][]) {
		this.distanceMatrix = distanceMatrix;
	}

	@Override
	public double computeFitness(Tour tour) {
		double tourCost = 0;
		int i;
		for (i = 0; i < tour.CityList.size(); i++) {
			if (i != (tour.CityList.size() - 1)) {
				tourCost += distanceMatrix[tour.CityList.get(i)][tour.CityList
						.get(i + 1)];
			} else
				tourCost += distanceMatrix[tour.CityList.get(i)][tour.CityList
						.get(0)];
		}
		tour.fitness = tourCost;
		return tourCost;
	}

}
