
public class ThreadTest {

	public static void main(String[] args) {
		Bike bike = new Bike("Royal Enfield",10);
		Flight flight = new Flight("\tIndigo",10);
		Truck truck = new Truck("\t\tAshok Leyland",10);
		
		bike.start();
		flight.start();
		truck.start();


	}

}

class Bike extends Thread{
	
	String model;
	int delay;
	
	
	public Bike(String model, int delay) {
		super();
		this.model = model;
		this.delay = delay;
	}


	public void run() {
		for(int i=1; i<=200;i++) {
			System.out.println(model+" is running..."+i);
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Flight extends Thread{
	
	String model;
	int delay;
	
	
	public Flight(String model, int delay) {
		super();
		this.model = model;
		this.delay = delay;
	}


	public void run() {
		for(int i=1; i<=200;i++) {
			System.out.println(model+" is running..."+i);
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Truck extends Thread{
	
	String model;
	int delay;
	
	
	public Truck(String model, int delay) {
		super();
		this.model = model;
		this.delay = delay;
	}


	public void run() {
		for(int i=1; i<=200;i++) {
			System.out.println(model+" is running..."+i);
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}