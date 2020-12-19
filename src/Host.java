import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Host extends Thread {

	   private Container container;
	   
	public ArrayList<Integer> host_list = new ArrayList<Integer>(); 	
	private static Host instance = null; 
	private Host(Container c) 
	{
		this.container = c;  
	}
	public static synchronized Host getInstance(Container c)
	{
		if(instance==null)
		{
			instance = new Host(c); 
		}
		return instance;
	}
	
	protected Object clone() throws CloneNotSupportedException
	{
		throw new CloneNotSupportedException("Sorry, clone can't be made");
	}

	   public List<Participants> par_list = new ArrayList<Participants>();
	   public void attach(Participants par){
		      par_list.add(par);		
		   }
	
	   
	   private <T> void printlist(List<T> list)      {
	         System.out.println(list);
	    }

	   
	   public void run() {
		   
		  System.out.println("Host started");
		  
		  for(Participants p:this.par_list)
		  {
			   System.out.print("Participant "+p.number+" tokens are: "); 
			   printlist(p.set);
		  }
		  notifyAllObservers();
		  Random ro = new Random();
	    	
	      for (int i = 0; i < 10; i++) {
	       
	  			int temp = ro.nextInt(51);
	  			host_list.add(temp);
	  			
	         container.put(temp); 
	         System.out.println("Host generated: " + temp);
	         try {
	            sleep(1000);
	         } catch (InterruptedException e) { }

	      } 
	   }
	   
	   public void notifyAllObservers(){
		      for (Participants par : par_list) {
		    	  par.start(); 
		      }
		   }
	}