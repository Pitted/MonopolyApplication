
public abstract class Property {
	private String name;
	private Group group;
	private int value;
	private Player owner;
	private boolean isMortgaged = false;
	public Property(String n, Group g, int v){
		name=n;
		group=g;
		value=v;
		owner=null;
	}
	public final int mortgage(){
		if(isMortgaged) throw new IllegalStateException();
		isMortgaged = true;
		return value/2;
	}
	public final void unMortgage(){
		if(!isMortgaged) throw new IllegalStateException();
		isMortgaged = false;
	}
	public final Player getOwner(){return owner;}
	public final int getValue(){return value;}
	public abstract int getRent(int i);
	public final String getName(){return name;}
	public final Group getGroup(){return group;}
	public final void setOwner(Player p){owner = p;}
	
}
