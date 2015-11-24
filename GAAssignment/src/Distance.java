import java.util.ArrayList;


public class Distance {
	int i;
	public double calc(ArrayList<Integer> tour,double[][] distanceMatrix)
	{
		double tourCost=0;
		for(i=0;i<tour.size();i++)
		{
			if(i!=(tour.size()-1))
			{
				tourCost += distanceMatrix[tour.get(i)][tour.get(i+1)];
			}
			else tourCost += distanceMatrix[tour.get(i)][tour.get(0)];
		}
		return tourCost;
	}
}
