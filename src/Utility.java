
public class Utility extends Property{
	private int rent[] = {4, 10};
	
	public Utility(String n){
		super(n, Group.One, 150);
	}
	public int getRent(int i){return rent[i];}
}
