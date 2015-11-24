


public interface CrossoverFunction {
	class Children {
		Tour first;
		Tour second;	
		public Tour first() {
			return first;
		}
		public Tour second() {
			return second;
		}
	}
	public Children mate(Tour parent1, Tour parent2);
}
