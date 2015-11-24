import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tour implements Comparable<Tour>{
	List<Integer> CityList;
	double fitness;

	public Tour(boolean initialise) {
		CityList = new ArrayList<Integer>();
		if (initialise) {
			int i;
			for (i = 0; i < TSP.cityCount; i++) {
				CityList.add(i);
			}
			Collections.shuffle(CityList);
			TSP.ga.fitFunc.computeFitness(this);
		}
	}

	@Override
	public int compareTo(Tour other) {
		if (fitness < other.fitness)
			return -1;
		else if (fitness > other.fitness)
			return 1;
		return 0;
	}

	@Override
	public String toString() {
		return "Tour [CityList=" + CityList + ", fitness=" + fitness + "]";
	}
	
	public void printTour() {
		for (int i = 0; i < CityList.size(); i++) {
			int city = CityList.get(i) + 1;
			System.out.print(city + " ");
		}
		System.out.println();
	}
	


}
