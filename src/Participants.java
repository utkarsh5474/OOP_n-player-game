import java.util.ArrayList;
import java.util.Random;

public class Participants extends Thread {
	
		protected Host host; 
	
	   private Container container;
	   public int number;
	   
	   public ArrayList<Integer> set = new ArrayList<Integer>(); 
	   
	   public Participants(Container c, int number, Host host) {
	      container = c;
	      this.number = number;
	      Random rr = new Random(); 
	      for(int i=0; i<10; i++)
	      {
	    	  int temp = rr.nextInt(51);
	    	  set.add(temp);
	      }
	      this.host = host;
	      this.host.attach(this);
	   }
	   public void run() {
		   
	      int value = 0;
	      for (int i = 0; i < 10; i++) {
	         value = container.get();
	         boolean flag = false; 
	         for(int index=0; index<set.size(); index++)    
	         {
	        	 int temp = set.get(index);
	        	 if(value==temp)
	        	 {
	        		 set.remove(index);
	        		 flag = true; break;
	        	 }
	         }
	         if(flag)
	         {
	        	 System.out.println("Participant " + this.number + " strikes: " + value);
	         }
	         if(set.size()==7)
	         {
	        	 
	        	 for(Participants p:host.par_list)
	        	 {
	        		 int left = 10-p.set.size(); 
	        		 System.out.println("The no. of matches for Participant "+p.number+" is "+left);
	        	 }
	        	 System.out.println("Winner is Participant "+this.number);
	        	 System.exit(0);
	         }
	         
	         try {
		            sleep(100);
		         } catch (InterruptedException e) { }
	      }
	   }
	}