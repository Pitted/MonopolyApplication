
public class Street extends Property {
	
	private int[] rent = new int[6];
	private int houses;
	
	public Street(String n, Group g, int v, int[] r){
		super(n, g, v);
		rent = r;
		houses=0;
	}
	public int getRent(int i){
		return rent[i];
	}
	public int getHouses(){return houses;}
	
}
