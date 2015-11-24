

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SinglePtOrderXOver implements CrossoverFunction {

	@Override
	public Children mate(Tour parent1, Tour parent2) {
		int tourSize = parent1.CityList.size();
		Tour child1 = new Tour(false);
		Tour child2 = new Tour(false);
		Random rand = new Random(20);
		int pos = rand.nextInt(tourSize-1)+1;
		
		List<Integer> p1 = new ArrayList<Integer>(parent1.CityList);
		List<Integer> p2 = new ArrayList<Integer>(parent2.CityList);
		child1.CityList.addAll(p1.subList(0, pos));
		child2.CityList.addAll(p2.subList(0, pos));
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
