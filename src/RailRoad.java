
public class RailRoad extends Property{
	private int rent[] = {25, 50, 100, 200};
	
	public RailRoad(String n){
		super(n, Group.Two, 200);
	}
	public int getRent(int i){return rent[i];}
	
}
