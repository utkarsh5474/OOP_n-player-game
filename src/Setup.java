
public class Setup {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		 
		Container c = new Container();
		Host hh = Host.getInstance(c);
		Participants p1 = new Participants(c, 1, hh);
		Participants p2 = new Participants(c, 2, hh);
		hh.start();
		
		try {
			hh.join();
			p1.join();
			p2.join();
		}
		catch(Exception e) {
			System.out.println("Main Interrupted");
		}
		int hit1 = 10 - p1.set.size();
		int hit2 = 10 - p2.set.size();
		
		System.out.println("The no. of matches for Participant "+ p1.number+" is "+ hit1 );
		System.out.println("The no. of matches for Participant "+ p2.number+" is "+ hit2 );
		System.out.println("Game ends in a draw");
	}
}


	
	 