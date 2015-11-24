import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TwoOptMutation implements MutationFunction {
	@Override
	public Tour mutate(Tour tour) {
		Random rand = new Random();
		
		// choose two random cities
		int pos1 = rand.nextInt(tour.CityList.size());
		int pos2;
		do {
			pos2 = rand.nextInt(tour.CityList.size());
		} while (pos1 == pos2);
		
		// ensure the city given by pos1 occurs first in the tour
		int temp;
		if (pos1 > pos2) {
			temp = pos1;
			pos1 = pos2;
			pos2 = temp;
		}
		
		// invert the intermediate tour portion
		Tour ret = new Tour(false);
		ret.CityList = new ArrayList<>(tour.CityList);
		Collections.reverse(ret.CityList.subList(pos1, pos2));
		TSP.ga.fitFunc.computeFitness(ret);
		return ret;
	}
}
