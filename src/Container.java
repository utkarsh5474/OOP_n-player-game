class Container {
	   private int stuff;
	   
	   public int count = 0; 
	   
	   public synchronized int get() {
	      while (count==0) {
	         try {
	            wait();
	         } catch (InterruptedException k) {System.out.println(k);}
	      }
	      notifyAll();
	      count -- ; 
	      return stuff;
	   }
	   public synchronized void put(int value) {
	      while (count!=0) {
	         try {
	            wait();
	         } catch (InterruptedException k) {System.out.println(k);} 
	      }
	      stuff = value;
	      count = 2; 
	      notifyAll();
	   }
	}