
class TestPlanet {
	private String name;
	private int position;
	private float size;
	private float mass;
	
	
	TestPlanet(String name, int position, float size,float mass){
		this.name = name;
		this.position = position;
		this.size = size;
		this.mass = mass;
		
	}
	
	TestPlanet(String name, int position, float size){
		this.name = name;
		this.position = position;
		this.size = size;
		
	}
	
	// no arg and no return
	
	public void getPlanetDetails() {
	System.out.println("\nname of planet " + name);
	System.out.println("position of planet " + position);
	System.out.println("size of planet " + size);
	System.out.println("mass of planet " + mass);
	}
	
	// arg and no return
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	// no arg and return
	
	public float getDensity() {
		float density;
		density = mass/size;
		return density;
	}
	
	// arg and return
	
	public float getTravelTime(float distance, float speed) {
		float travelTime = distance/speed;
		return travelTime;
	}
	
	// function overloading
	
	public void movement() {
		System.out.println("movement() : Planet is rotating and revolving");
	}
	
	public void movement(int rotationTime) {
		System.out.println("movement(int) : Planet is rotating " + rotationTime + " is rotation time taken");
	}
	
	public void movement(float rotationTime) {
		System.out.println("movement(float) : Planet is rotating " + rotationTime + " is rotation time taken");
	}
	public void movement(int rotationTime, float revolutiontime) {
		System.out.println("rotate(int,float) : Planet is rotating " + rotationTime + " is rotation time " + revolutiontime + "is revolution time");
	}
	
	public void movement(float rotationTime, int revolutiontime) {
		System.out.println("rotate(float,int) : Planet is rotating " + rotationTime + " is rotation time " + revolutiontime + "is revolution time");
	}
	
	
}

class Planet {
	public static void main(String[] args) {
		TestPlanet planet1 = new TestPlanet("earth",4,100,200);
		
		planet1.setPosition(3);
		float density = planet1.getDensity();
		float travelTime = planet1.getTravelTime(100, 200);
		planet1.getPlanetDetails();
		System.out.println("Density of planet "+ density);
		System.out.println("Travel time "+ travelTime);
		
		//function overloading
		planet1.movement();
		planet1.movement(10);
		planet1.movement(111.11f);
		planet1.movement(10,11.11f);
		planet1.movement(11.11f,10);
		
		//inheritance
		Planets planet = new Planets("milkyway","solar system",100,"earth") ;
		planet.showDetails();
	}
}

class Galaxy{
	String nameGalaxy;
	
	Galaxy(String nameGalaxy){
		this.nameGalaxy = nameGalaxy;
		
	}
	void showDetails() {
		System.out.println(nameGalaxy + " is the galaxy ");
	}
}

class PlanetarySystem extends Galaxy{
	String namePlanetarySystem;
	float sizePlanetarySystem;
	
	PlanetarySystem(String nameGalaxy, String namePlanetarySystem,float sizePlanetarySystem){
		super(nameGalaxy);
		this.namePlanetarySystem = namePlanetarySystem;
		this.sizePlanetarySystem = sizePlanetarySystem;
	}
	void showDetails() {
		super.showDetails();
		System.out.println(namePlanetarySystem + " is name of Planetary System");
		System.out.println(sizePlanetarySystem + " is size of Planetary System");
	}
	
}

class Planets extends PlanetarySystem{
	String planetName;
	
	Planets(String nameGalaxy, String namePlanetarySystem,float sizePlanetarySystem,String planetName){
		super(nameGalaxy,namePlanetarySystem,sizePlanetarySystem);
		this.planetName = planetName;
	}
	
	void showDetails() {
		super.showDetails();
		System.out.println(planetName + " is the planet Name");
	}
}
