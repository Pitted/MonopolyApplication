import java.util.HashSet;
import java.util.Set;


public class PropertyDeck {

	private class PropGroup{
		private class PropNode{
			private Property prop;
			private PropNode next;
			private PropNode(Property p){
				prop = p;
				next = null;
			}
			private void add(Property p){
				next  = new PropNode(p);
			}
			private Property getProperty(){ return prop;}
		}


		private Group group;
		private PropNode initProp;
		private PropGroup left;
		private PropGroup right;

		private PropGroup(Group g){
			group = g; 
			initProp = null;
		}
		private void add(Property p){
			if(initProp == null)
				initProp = new PropNode(p);
			PropNode current = initProp;
			while(current.next != null)
				current = current.next;
			current.next = new PropNode(p);
		}

	}
	private static PropGroup root;
	/*
	 * Deck Creation
	 */
	private PropertyDeck(){
		PropGroup current = root;
		//root and left side
		current = new PropGroup(Group.Six); current.add(new Street("St. James Place", Group.Six, 180, new int[]{14,70,200,550,750,950}));
		current.add(new Street("Tennessee Avenue", Group.Six, 180, new int[]{14,70,200,550,750,950}));
		current.add(new Street("New York Avenue", Group.Six, 200, new int[]{16,80,220,600,800,1000}));
		
		current.left = new PropGroup(Group.Four); current = current.left;
		current.add(new Street("Oriental Avenue", Group.Four, 100, new int[]{6,30,90,270,400,550}));
		current.add(new Street("Vermont Avenue", Group.Four, 100, new int[]{6,30,90,270,400,550}));
		current.add(new Street("Conneticut Avenue", Group.Four, 120, new int[]{8,40,100,300,450,600}));
		
		current.right = new PropGroup(Group.Five); current.right.add(new Street("St. Charles Place", Group.Five, 140, new int[]{10,50,150,450,625,750}));
		current.right.add(new Street("States Avenue", Group.Five, 140, new int[]{10,50,150,450,625,750}));
		current.right.add(new Street("Virginia Avenue", Group.Five, 160, new int[]{12,60,180,500,700,900}));
		
		current.left = new PropGroup(Group.Three); current = current.left;
		current.add(new Street("Mediteranean Avenue", Group.Three, 60, new int[]{2,10,30,90,160,250}));
		current.add(new Street("Baltic Avenue", Group.Three, 60, new int[]{4,20,60,180,320,450}));
		
		current.right = new PropGroup(Group.Two); current.right.add(new RailRoad("Reading RailRoad"));
		current.right.add(new RailRoad("Pennsylvania RailRoad")); current.right.add(new RailRoad("B & O RailRoad"));
		current.right.add(new RailRoad("Short Line"));
		
		current.left = new PropGroup(Group.One); current.left.add(new Utility("Electric Company")); current.left.add(new Utility("Water Works"));
		// right side
		current = root; current.right = new PropGroup(Group.Eight); current = current.right;
		current.add(new Street("Atlantic Avenue", Group.Eight, 260, new int[]{22,110,330,800,975,1150}));
		current.add(new Street("Ventor Avenue", Group.Eight, 260, new int[]{22,110,330,800,975,1150}));
		current.add(new Street("Marvin Gardens", Group.Eight, 280, new int[]{24,120,360,850,1025,1200}));
		current.left = new PropGroup(Group.Seven); 
		current.left.add(new Street("Kentucky Avenue", Group.Seven, 220, new int[]{18,90,250,700,875,1050}));
		current.left.add(new Street("Indiana Avenue", Group.Seven, 220, new int[]{18,90,250,700,875,1050}));
		current.left.add(new Street("Illinois Avenue", Group.Seven, 240, new int[]{20,100,300,750,925,1100}));
		current.right = new PropGroup(Group.Nine); current = current.right;
		current.add(new Street("Pacific Avenue", Group.Nine, 300, new int[]{26,130,390,900,1100,1275}));
		current.add(new Street("North Carolina Avenue", Group.Nine, 300, new int[]{26,130,390,900,1100,1275}));
		current.add(new Street("Pensylvania Avenue", Group.Nine, 320, new int[]{28,150,450,1000,1200,1400}));
		current.right = new PropGroup(Group.Ten); current = current.right;
		current.add(new Street("Park Place", Group.Ten, 350, new int[]{35,175,500,1100,1300,1500}));
		current.add(new Street("BoardWald", Group.Ten, 400, new int[]{50,200,600,1400,1700,2000}));
		
	}
	
	private void searchGroup(PropGroup pg, Set<Property> hs, Player p){
		PropertyDeck.PropGroup.PropNode current = pg.initProp;
		while(current != null){
			if(current.prop.getOwner().equals(p))
				hs.add(current.prop);
			current = current.next;
		}
	}
	
	private Set<Property> gppHelper(Player p, PropGroup pg, Set<Property> hs){
		if(pg == null) return hs;
		searchGroup(pg, hs, p);
		gppHelper(p, pg.left, hs);
		gppHelper(p, pg.right, hs);
		return hs;
		
		
	}
	public Set<Property> getPLayerProperties(Player p){
		Set<Property> set = new HashSet<Property>();
		return gppHelper(p, root, set);
	}

	private PropGroup findGroup(Group g, PropGroup pg){
		if(pg == null) return null;
		if(g.equals(pg.group)) return pg;
		if(g.Compare(pg.group)<0) return findGroup(g,pg.left);
		else if(g.Compare(pg.group)>0) return findGroup(g, pg.right);
		else return pg;
	}
	
	public boolean ownsMonopoly(Player p, Group g){
		PropGroup monop = findGroup(g, root);
		PropertyDeck.PropGroup.PropNode current = monop.initProp;
		while(current != null){
			if(!current.prop.getOwner().equals(p)) return false;
			current = current.next;
		}
		return true;
	}

	///////////////////////////////////
}
