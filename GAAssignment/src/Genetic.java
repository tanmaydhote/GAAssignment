public class Genetic {
	Population currentPopulation;
	Population newPopulation;
	GAParams ga = TSP.ga;

	public Genetic() {
		this.currentPopulation = new Population(true);
	}

	public void createNewPopulation() {
		newPopulation = ga.repFunc.createNewPopulation(currentPopulation);
		this.currentPopulation = newPopulation;
	}
}
