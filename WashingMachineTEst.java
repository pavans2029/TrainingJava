import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WashingMachineTEst {
	public static void main(String[] args) {
		
		WashingPowder washPowder = new WashingPowder(100, "Nirma", "Front Load", true, 10.0f);
		Water water = new Water("soft", 20, "Cold");
		try {
			water.setQuantity(10);
		}
		catch(WaterNotSufficientException ex1) {
			System.out.println("Water Issue : "+ex1);
		}
		try {
			water.checkType();
		}
		catch(HardWaterException ex2) {
			System.out.println("Water Issue : "+ex2);
		}
        Electricity electricity = new Electricity("AC", 220.0f, 8, 2, "PowerCo");
        try {
        	electricity.checkVoltage();
		}
		catch(LowVoltageException ex3) {
			System.out.println("Voltage Issue : "+ex3);
		}
        
        Cloth[] clothes = new Cloth[5];
        clothes[0] = new Cloth("Cotton", "White", 5.0f, "Shirt", true);
        clothes[1] = new Cloth("Denim", "Blue", 8.0f, "Jeans", true);
        clothes[2] = new Cloth("Polyester", "Red", 6.0f, "T-Shirt", true);
        clothes[3] = new Cloth("Silk", "Black", 12.0f, "Dress", true);
        clothes[4] = new Cloth("Wool", "Grey", 10.0f, "Sweater", true);

       
        WashingMachine washingMachine1 = new WashingMachine("washing machine 1");

        try {
        	Laundry laundryResult = washingMachine1.wash(washPowder, water, electricity, clothes);
		}
		catch(ClothesOverloadException ex4) {
			System.out.println("Overload Issue : "+ex4);
		}
        
        WashingMachine washingMachine2 = new WashingMachine("washing machine 2");

        try {
        	Laundry laundryResult = washingMachine2.wash(washPowder, water, electricity, clothes);
		}
		catch(ClothesOverloadException ex4) {
			System.out.println("Overload Issue : "+ex4);
		}
        
        WashingMachine washingMachine3 = new WashingMachine("washing machine 3");

        try {
        	Laundry laundryResult = washingMachine3.wash(washPowder, water, electricity, clothes);
		}
		catch(ClothesOverloadException ex4) {
			System.out.println("Overload Issue : "+ex4);
		}
        
//        System.out.println("Laundry Details:");
//        System.out.println("Number of clothes: " + laundryResult.getNumberOfCloths());
//        System.out.println("Time required: " + laundryResult.getTimeRequired() + " hours");
//        System.out.println("Total cost: $" + laundryResult.getTotalCost());
//        System.out.println("Water used: " + laundryResult.getWaterUsed() + " liters");
//        System.out.println("Electricity used: " + laundryResult.getElectricityUsed() + " watts");
//        System.out.println("Cost of washing powder: $" + laundryResult.getCostOfWashingPowder());
		
		
	}
}

class WaterNotSufficientException extends Exception //checked
{
	WaterNotSufficientException(String msg) {
		super(msg);
	}
}
class HardWaterException extends Exception //checked
{
	HardWaterException(String msg) {
		super(msg);
	}
}
class LowVoltageException extends Exception{
	LowVoltageException(String msg){
		super(msg);
	}
}
class ClothesOverloadException extends Exception{
	ClothesOverloadException(String msg){
		super(msg);
	}
}

class Machine extends Thread{
	
}
class WashingMachine extends Machine { //isA
	private String washingMachineName;
	
	
	
	public WashingMachine(String washingMachineName) {
	super();
	this.washingMachineName = washingMachineName;
}
	WashingTub washTub = new WashingTub(100,"steel"); //hasA

		public void run() {
			for(int i=1; i<=100; i++) {
				System.out.println(washingMachineName +" progress : "+i+"%");
			}
		}
		Laundry wash(WashingPowder washPowder, Water water, Electricity elect, Cloth cloth[])throws  ClothesOverloadException{
			
			int numberOfCloths = cloth.length;
			if(numberOfCloths > 5) {
				throw new ClothesOverloadException("More number of clothes");
			}
	        float waterUsed = water.getQuantity(); 
	        float electricityUsed = elect.getUnitUsed() * elect.getVoltage(); 

	        
	        float costOfWashingPowder = washPowder.getPrice() * washPowder.getQuantity();

	        
	        float totalCost = numberOfCloths * cloth[0].getCost(); 

	       
	        float timeRequired = 1.5f; 
	        this.start();

	        Laundry laundryResult = new Laundry(numberOfCloths, timeRequired, totalCost, waterUsed, electricityUsed, costOfWashingPowder);
	        return laundryResult;
		}
		
}

class Laundry {
	private int numberOfCloths; //cloth.length
	private float timeRequired;
	private float totalCost ;// cloth.length * price per cloth
	private float waterUsed;
	private float electricityUsed;
	private float costOfWashingPowder; //
	
	public Laundry(int numberOfCloths, float timeRequired, float totalCost, float waterUsed, float electricityUsed,
			float costOfWashingPowder) {
		super();
		this.numberOfCloths = numberOfCloths;
		this.timeRequired = timeRequired;
		this.totalCost = totalCost;
		this.waterUsed = waterUsed;
		this.electricityUsed = electricityUsed;
		this.costOfWashingPowder = costOfWashingPowder;
	}

	@Override
	public String toString() {
		return "Laundry [numberOfCloths=" + numberOfCloths + ", timeRequired=" + timeRequired + ", totalCost="
				+ totalCost + ", waterUsed=" + waterUsed + ", electricityUsed=" + electricityUsed
				+ ", costOfWashingPowder=" + costOfWashingPowder + "]";
	}

	public int getNumberOfCloths() {
		return numberOfCloths;
	}

	public void setNumberOfCloths(int numberOfCloths) {
		this.numberOfCloths = numberOfCloths;
	}

	public float getTimeRequired() {
		return timeRequired;
	}

	public void setTimeRequired(float timeRequired) {
		this.timeRequired = timeRequired;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public float getWaterUsed() {
		return waterUsed;
	}

	public void setWaterUsed(float waterUsed) {
		this.waterUsed = waterUsed;
	}

	public float getElectricityUsed() {
		return electricityUsed;
	}

	public void setElectricityUsed(float electricityUsed) {
		this.electricityUsed = electricityUsed;
	}

	public float getCostOfWashingPowder() {
		return costOfWashingPowder;
	}

	public void setCostOfWashingPowder(float costOfWashingPowder) {
		this.costOfWashingPowder = costOfWashingPowder;
	}
	
	
	
	
	
}

class Tub {
	
}

class WashingTub  extends Tub {
	private int capacity;
	private String type; //
	public WashingTub(int capacity, String type) {
		super();
		this.capacity = capacity;
		this.type = type;
	}
	@Override
	public String toString() {
		return "WashingTub [capacity=" + capacity + ", type=" + type + "]";
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}

class Powder {
	
}

class WashingPowder extends Powder { // isA

	private int quantity;
	private String brand;
	private String type;
	private boolean scented;
	private float price;
	
	public WashingPowder(int quantity, String brand, String type, boolean scented, float price) {
		super();
		this.quantity = quantity;
		this.brand = brand;
		this.type = type;
		this.scented = scented;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "WashingPowder [quantity=" + quantity + ", brand=" + brand + ", type=" + type + ", scented=" + scented
				+ ", price=" + price + "]";
	}
	/*public String toString() {
		String str = (scented) ? "Scented" :"Not Scented";
		return str+ " "+brand+" Washing Powder of "+type+ " type quantity used "+quantity+ " grams ";
	}*/

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isScented() {
		return scented;
	}

	public void setScented(boolean scented) {
		this.scented = scented;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
}

class Water {
	private String type;
	private int quantity;
	private String temperature;
	
	public Water(String type, int quantity, String temperature) {
		super();
		this.type = type;
		this.quantity = quantity;
		this.temperature = temperature;
		
		
	}
	@Override
	public String toString() {
		return "Water [type=" + type + ", quantity=" + quantity + ", temperature=" + temperature + "]";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void checkType() throws HardWaterException{
		String input = type;

        // Regular expression to check if the word "hard" is present
        String regex = "\\bhard\\b";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(input);

        // Check if the word "hard" is found in the input string
        if (matcher.find()) {
        	throw new HardWaterException("Hard water found");
            
        } else {
            System.out.println("The water is suitable for washing");
        }
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity)throws  WaterNotSufficientException {
		if(quantity > 5 ) {
			this.quantity = quantity;
		}
		else {
			 WaterNotSufficientException ex = new WaterNotSufficientException("Water quantity less than 5 cubic units");
			 throw ex;
		}
		
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

}

class Electricity {
	private String type; //ac dc
	private float voltage; 
	private int costPerUnit;
	private int unitUsed;
	private String supplier;
	public Electricity(String type, float voltage, int costPerUnit, int unitUsed, String supplier) {
		super();
		this.type = type;
		this.voltage = voltage;
		this.costPerUnit = costPerUnit;
		this.unitUsed = unitUsed;
		this.supplier = supplier;
	}
	@Override
	public String toString() {
		return "Electricity [type=" + type + ", voltage=" + voltage + ", costPerUnit=" + costPerUnit + ", unitUsed="
				+ unitUsed + ", supplier=" + supplier + "]";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getVoltage() {
		return voltage;
	}
	public void setVoltage(float voltage) {
		this.voltage = voltage;
	}
	public int getCostPerUnit() {
		return costPerUnit;
	}
	public void setCostPerUnit(int costPerUnit) {
		this.costPerUnit = costPerUnit;
	}
	public int getUnitUsed() {
		return unitUsed;
	}
	public void setUnitUsed(int unitUsed) {
		this.unitUsed = unitUsed;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public void checkVoltage() throws LowVoltageException {
		if(voltage<200) {
			throw new LowVoltageException("Low Voltage");
		}
	}
	
	
}

class Cloth {
	private String material; //
	private String color;
	private float cost;
	private String type;
	private boolean clean; //
	
	public Cloth(String material, String color, float cost, String type, boolean clean) {
		super();
		this.material = material;
		this.color = color;
		this.cost = cost;
		this.type = type;
		this.clean = clean;
	}
	@Override
	public String toString() {
		return "Cloth [material=" + material + ", color=" + color + ", cost=" + cost + ", type=" + type + ", clean="
				+ clean + "]";
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isClean() {
		return clean;
	}
	public void setClean(boolean clean) {
		this.clean = clean;
	}
	

	
}