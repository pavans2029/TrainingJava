public class RocketTest {
    public static void main(String[] args) {
        Rocket spacexRocket = new SpaceXRocket("Falcon 9", 70.0, 22000);
        Rocket nasaRocket = new NASAProbeRocket("Voyager 1", 4.9, "Jupiter");

        spacexRocket.displayDetails();
        spacexRocket.launch();

        System.out.println();

        nasaRocket.displayDetails();
        nasaRocket.launch();

        // Additional feature for NASAProbeRocket
        if (nasaRocket.isLaunched()) {
            System.out.println("Destination: " + ((NASAProbeRocket) nasaRocket).getTargetPlanet());
        }
    }
}

abstract class Rocket {
    final static int MAX_SPEED = 20000; // meters per second

    private String name;
    private double height;
    private boolean isLaunched;

    public Rocket(String name, double height) {
        this.name = name;
        this.height = height;
        this.isLaunched = false;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public boolean isLaunched() {
        return isLaunched;
    }

    public void setLaunched(boolean launched) {
        isLaunched = launched;
    }

    public abstract void launch();

    public void displayDetails() {
        System.out.println("Rocket details:");
        System.out.println("Name: " + name);
        System.out.println("Height: " + height + " meters");
        System.out.println("Maximum Speed: " + MAX_SPEED + " m/s");
        System.out.println("Status: " + (isLaunched ? "Launched" : "Not Launched"));
    }
}

class SpaceXRocket extends Rocket {
    private int payloadCapacity;

    public SpaceXRocket(String name, double height, int payloadCapacity) {
        super(name, height);
        this.payloadCapacity = payloadCapacity;
    }

    @Override
    public void launch() {
        System.out.println("SpaceX Rocket " + getName() + " is launching...");
        System.out.println("3... 2... 1... Liftoff!");
        setLaunched(true);
    }
}

class NASAProbeRocket extends Rocket {
    private String targetPlanet;

    public NASAProbeRocket(String name, double height, String targetPlanet) {
        super(name, height);
        this.targetPlanet = targetPlanet;
    }

    @Override
    public void launch() {
        System.out.println("NASA Probe Rocket " + getName() + " is launching...");
        System.out.println("Preparing for launch...");
        System.out.println("Engines activated. Lift-off achieved!");
        setLaunched(true);
    }

    public String getTargetPlanet() {
        return targetPlanet;
    }
}


