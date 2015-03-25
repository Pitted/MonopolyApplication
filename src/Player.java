
public class Player {
	private int wallet;
	public Player(String name){
		wallet = 1755;
	}
	public int getWallet(){return wallet;}
	public void removeMoney(int r){
		if(wallet-r<0) throw new IllegalArgumentException();
		wallet-=r;
	}
	public void addMoney(int a){
		wallet+=a;
	}
	
}
