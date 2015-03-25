import java.awt.Color;


public enum Group {
	One(Color.WHITE, 1),
	Two(Color.BLACK, 2),
	Three(Color.MAGENTA, 3),
	Four(Color.LIGHT_GRAY, 4),
	Five(Color.PINK, 5),
	Six(Color.ORANGE, 6),
	Seven(Color.RED, 7),
	Eight(Color.YELLOW, 8),
	Nine(Color.GREEN, 9),
	Ten(Color.BLUE, 10);
	private Color color;
	private int value;
	private Group(Color c, int i){color=c; value =i;}
	public int Compare(Group g){
		if(this.value>g.value)return 1;
		else if(this.value<g.value)return -1;
		else return 0;
	}
}
