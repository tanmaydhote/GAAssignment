import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SwapMutation implements MutationFunction {
	
	@Override
	public Tour mutate(Tour tour) {
		Random rand = new Random();
		
		// choose two random cities
		int pos1 = rand.nextInt(tour.CityList.size());
		int pos2;
		do {
			pos2 = rand.nextInt(tour.CityList.size());
		} while (pos1 == pos2);
		
		// swap their locations in the tour
		Tour ret = new Tour(false);
		ret.CityList = new ArrayList<>(tour.CityList);
		Collections.swap(ret.CityList, pos1, pos2);
		TSP.ga.fitFunc.computeFitness(ret);
		
		return ret;
	}
}
