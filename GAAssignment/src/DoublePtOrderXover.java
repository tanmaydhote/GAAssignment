

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DoublePtOrderXover implements CrossoverFunction {

	@Override
	public Children mate(Tour parent1, Tour parent2) {
		int tourSize = parent1.CityList.size();
		Tour child1 = new Tour(false);
		Tour child2 = new Tour(false);
		Random rand = new Random();
		int pos1 = rand.nextInt(tourSize-1)+1;
		int pos2;
		do {
			pos2 = rand.nextInt(tourSize-1)+1;
		} while (pos1 == pos2);
		
		// ensure the city given by pos1 occurs first in the tour
		int temp;
		if (pos1 > pos2) {
			temp = pos1;
			pos1 = pos2;
			pos2 = temp;
		}
		
		List<Integer> p1 = new ArrayList<Integer>(parent1.CityList);
		List<Integer> p2 = new ArrayList<Integer>(parent2.CityList);
		child1.CityList.addAll(p1.subList(pos1, pos2));
		child2.CityList.addAll(p2.subList(pos1, pos2));
		p2.removeAll(child1.CityList);
		p1.removeAll(child2.CityList);
		child1.CityList.addAll(p2);
		child2.CityList.addAll(p1);
		
		TSP.ga.fitFunc.computeFitness(child1);
		TSP.ga.fitFunc.computeFitness(child2);
		Children children = new Children();
		children.first = child1;
		children.second = child2;
		return children;
	}
}
