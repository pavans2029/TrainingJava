import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RocketTest {
	public static void main(String[] args) {
		// Creating a list to store rockets
		List<Rocket> rocketList = new ArrayList<>();

		// Adding a Falcon 9 rocket to the list
		Rocket rocket1 = new Falcon9("rocket1", 550000, 7600000, 10000);
		rocketList.add(rocket1);

		// Adding a Saturn V rocket to the list
//		Rocket rocket2 = new SaturnV("rocket2", 2800000, 34000000, 30000);
//		rocketList.add(rocket2);

		// Adding 5 more rockets to the list
		Rocket rocket3 = new Falcon9("rocket3", 600000, 8000000, 12000);
		rocketList.add(rocket3);

//		Rocket rocket4 = new SaturnV("rocket4", 3500000, 38000000, 25000);
//		rocketList.add(rocket4);

		Rocket rocket5 = new Falcon9("rocket5", 580000, 7800000, 11000);
		rocketList.add(rocket5);

//		Rocket rocket6 = new SaturnV("rocket6", 3200000, 36000000, 28000);
//		rocketList.add(rocket6);

		Rocket rocket7 = new Falcon9("rocket7", 620000, 8200000, 13000);
		rocketList.add(rocket7);
		
		
		for (Rocket rocket : rocketList) {
			try {
				FileOutputStream fileOutputStream = new FileOutputStream("rocket.txt", true); //true means append to the file

				System.out.println("File is ready to write...");

				String str1="\n\nName of Rocket : "+rocket.getName();
				String str2= " \nMass of Rocket : "+ rocket.getMass();
				String str3= " \nThrust of Rocket : "+ rocket.getThrust();
				String str4= " \nPayload of Rocket : "+ rocket.getPayloadMass();
				String str = str1 + str2 + str3 + str4 ;
				
				byte array[] = str.getBytes(); //converts the string into a byte array
				fileOutputStream.write(array);
				System.out.println("String is written to the file");

				fileOutputStream.close();
				System.out.println("File is closed now...");
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}

		// Launching each rocket in the list
		for (Rocket rocket : rocketList) {
			RocketThread rocketThread = new RocketThread(rocket);
			rocketThread.start();
		}
	}
}

//exception
class LaunchFailureException extends Exception {
	LaunchFailureException(String msg) {
		super(msg);
	}
}

class EngineFailureException extends Exception {
	EngineFailureException(String msg) {
		super(msg);
	}
}

class PayloadEjectionException extends RuntimeException {
	PayloadEjectionException(String msg) {
		super(msg);
	}
}

interface Rocket {
	void launch() throws LaunchFailureException;

	void igniteEngines() throws EngineFailureException; // Start the rocket engines.

	void shutdownEngines(); // Stop the rocket engines.

	void ejectPayload(); // Eject any payload (e.g., satellite) carried by the rocket.

	void deployParachute(); // Deploy a parachute for landing (for reusable rockets).
	
	String getName();

	double getMass(); // Get the mass of the rocket.

	double getThrust(); // Get the thrust produced by the rocket engines.

	double getPayloadMass();// Get the mass of the payload (if any).

	boolean isLanded(); // Check if the rocket has landed (for reusable rockets).
}

class Falcon9 implements Rocket {
	// Rocket properties
	private String name;
	private double mass; // Mass of the rocket (in kg).
	private double thrust; // Thrust produced by the rocket engines (in Newton).
	private double payloadMass; // Mass of the payload (in kg).
	private boolean enginesOn; // Flag to indicate if the rocket engines are on.
	private boolean landed; // Flag to indicate if the rocket has landed (for reusable rockets).

	// Constructor
	public Falcon9(String name, double mass, double thrust, double payloadMass) {
		this.name = name;
		this.mass = mass;
		this.thrust = thrust;
		this.payloadMass = payloadMass;
		this.enginesOn = false;
		this.landed = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public void setThrust(double thrust) {
		this.thrust = thrust;
	}

	public void setPayloadMass(double payloadMass) {
		this.payloadMass = payloadMass;
	}

	// Rocket interface methods
	@Override
	synchronized public void launch() throws LaunchFailureException {

		if (!enginesOn) {
			double value = Math.random() % 10;
			if (value >= 0.5) {
				System.out.println(name + " : Falcon9 launch.");

			} else {
				throw new LaunchFailureException(name + " : Falcon9 launch failure");
			}

		}
	}

//	@Override
//	public void checklaunch() throws LaunchFailureException {
//		if (!enginesOn) {
//			double value = Math.random() % 10;
//			if (value >= 0.5) {
//				System.out.println("Falcon9 launch.");
////                enginesOn = true;
//			} else {
//				throw new LaunchFailureException(name + " :Falcon9 launch failure");
//			}
//
//		}
//	}

	@Override
	public void igniteEngines() throws EngineFailureException {
		if (!enginesOn) {
			double value = Math.random() % 10;
			if (value >= 0.5) {
				System.out.println(name + " : Falcon9 engines ignited.");
				enginesOn = true;
			} else {
				throw new EngineFailureException(name + " : Falcon9 engine failure");
			}

		}
	}

	@Override
	public void shutdownEngines() {
		if (enginesOn) {
			System.out.println(name + " : Falcon9 Engines shutdown.");
			enginesOn = false;
		}
	}

	@Override
	public void ejectPayload() throws PayloadEjectionException {
		double value = Math.random() % 10;
		if (value >= 0.5) {
			if (payloadMass > 0) {

				System.out.println(name + " : Falcon9 Payload ejected.");
				payloadMass = 0;
			}
		} else {
			throw new PayloadEjectionException(name + " : Payload failure");
		}

	}

	@Override
	public void deployParachute() {
		if (enginesOn && landed) {
			System.out.println(name + " : Falcon9 Parachute deployed for landing.");
		}
	}

	@Override
	public double getMass() {
		return mass;
	}

	@Override
	public double getThrust() {
		return thrust;
	}

	@Override
	public double getPayloadMass() {
		return payloadMass;
	}

	@Override
	public boolean isLanded() {
		return landed;
	}

	// Additional methods specific to Falcon 9 class
	public void land() {
		if (enginesOn) {
			System.out.println(name + " : Falcon9 Cannot land with engines on. Shut down the engines first.");
		} else {
			System.out.println(name + " : Falcon9 Rocket landed successfully.");
			landed = true;
		}
	}

}

class SaturnV implements Rocket {
	// Saturn V rocket properties
	private String name;
	private double mass;
	private double thrust;
	private double payloadMass;
	private boolean enginesOn;
	private boolean landed;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public void setThrust(double thrust) {
		this.thrust = thrust;
	}

	public void setPayloadMass(double payloadMass) {
		this.payloadMass = payloadMass;
	}

	// Constructor
	public SaturnV(String name, double mass, double thrust, double payloadMass) {
		this.name = name;
		this.mass = mass;
		this.thrust = thrust;
		this.payloadMass = payloadMass;
		this.enginesOn = false;
		this.landed = false;
	}

	// Implement Rocket interface methods (same as Falcon9 class)
	// ... (Ignite engines, Shutdown engines, Eject payload, Deploy parachute, etc.)

	// Additional methods specific to Saturn V class
	public void performMoonMission() {
		System.out.println(name + " : Performing a moon mission with Saturn V rocket.");
		// Additional code for moon mission specific to Saturn V.
	}

	// Rocket interface methods
	@Override
	public void launch() {
		if (!enginesOn) {
			System.out.println(name + " : SaturnV launch.");
			enginesOn = true;
		}
	}

	@Override
	public void igniteEngines() {
		if (!enginesOn) {
			System.out.println(name + " : SaturnV Engines ignited.");
			enginesOn = true;
		}
	}

	@Override
	public void shutdownEngines() {
		if (enginesOn) {
			System.out.println(name + " : SaturnV Engines shutdown.");
			enginesOn = false;
		}
	}

	@Override
	public void ejectPayload() {
		if (payloadMass > 0) {
			System.out.println(name + " : SaturnV Payload ejected.");
			payloadMass = 0;
		}
	}

	@Override
	public void deployParachute() {
		if (enginesOn && landed) {
			System.out.println(name + " : SaturnV Parachute deployed for landing.");
		}
	}

	@Override
	public double getMass() {
		return mass;
	}

	@Override
	public double getThrust() {
		return thrust;
	}

	@Override
	public double getPayloadMass() {
		return payloadMass;
	}

	@Override
	public boolean isLanded() {
		return landed;
	}

}

class RocketThread extends Thread {
	private Rocket rocket;

	public RocketThread(Rocket rocket) {
		this.rocket = rocket;
	}

	@Override
	public void run() {

		synchronized (rocket) {

			try {

				rocket.launch();
				rocket.igniteEngines();
				// Thread.sleep(1000); // Introduce a delay for engine ignition simulation
				rocket.ejectPayload();
				// Thread.sleep(1000); // Introduce a delay for payload ejection simulation
				rocket.deployParachute();
				// Thread.sleep(1000); // Introduce a delay for parachute deployment simulation
				if (rocket instanceof SaturnV) {
					((SaturnV) rocket).performMoonMission();
				}

			} catch (LaunchFailureException e) {
				System.out.println(e);
			} catch (EngineFailureException e) {
				System.out.println(e);
			} catch (PayloadEjectionException e) {
				System.out.println(e);
			}

		}

	}
}
