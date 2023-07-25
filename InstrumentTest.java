
public class InstrumentTest {
	public static void main(String[] args) {
		
	Flute flute = new Flute();
	flute.blowAir();
		
	Dhol dhol = new Dhol();
	dhol.strike();
	
	SurgicalCutter surgicalCutter = new SurgicalCutter();
	surgicalCutter.incise();
	
	Glucometer glucometer = new Glucometer();
	glucometer.measureGlucoseLevel();
	
	}
}

interface Instrument
{
	void use(); //by default method is public and abstract
}
abstract class MusicalInstrument implements Instrument
{
	abstract void play();
}
abstract class StringBasedMusicalInstrument extends MusicalInstrument
{
	abstract void tuneStrings();
}
class Guitar extends StringBasedMusicalInstrument
{
	public void use() {
		System.out.println("Using Guitar...");
	}
	void play() {
		System.out.println("Playing Guitar...");

	}
	void tuneStrings() {
		System.out.println("Tuning Strings of Guitar...");

	}
	void pluck() {
		System.out.println("Plucking Strings of Guitar...");

	}
}


class Violin extends StringBasedMusicalInstrument
{
	public void use() {
		System.out.println("Using Violin...");
	}
	void play() {
		System.out.println("Playing Violin...");

	}
	void tuneStrings() {
		System.out.println("Tuning Strings of Violin...");

	}
	void bow() {
		System.out.println("Bowing Strings of Violin...");

	}
}

abstract class AirBasedMusicalInstrument extends MusicalInstrument{
	abstract void blowAir();
}

class Flute extends AirBasedMusicalInstrument{
	public void use() {
		System.out.println("Using Flute...");
	}
	public void play() {
		System.out.println("Playing Flute...");
	}
	public void blowAir() {
		System.out.println("Blowing Flute");
	}
	public void tongue() {
		System.out.println("Tongue Flute");
	}
}

class Harmonium extends AirBasedMusicalInstrument{
	public void use() {
		System.out.println("Using Harmonium...");
	}
	public void play() {
		System.out.println("Playing Harmonium...");
	}
	public void blowAir() {
		System.out.println("Blowing Harmonium..");
	}
	public void press() {
		System.out.println("Press Harmonium");
	}
}

abstract class DrumBasedMusicalInstrument extends MusicalInstrument{
	abstract void tuneSurface();
}

class Tabla extends DrumBasedMusicalInstrument{
	public void use() {
		System.out.println("Using Tabla...");
	}
	public void play() {
		System.out.println("Playing Tabla...");
	}
	public void tuneSurface() {
		System.out.println("Blowing Tabla..");
	}
	public void hit() {
		System.out.println("hitting Tabla");
	}
}

class Dhol extends DrumBasedMusicalInstrument{
	public void use() {
		System.out.println("Using Dhol...");
	}
	public void play() {
		System.out.println("Playing Dhol...");
	}
	public void tuneSurface() {
		System.out.println("Blowing Dhol..");
	}
	public void strike() {
		System.out.println("strike Dhol");
	}
}

// medical instruments

abstract class MedicalInstrument implements Instrument{
	abstract void operate();
}

abstract class SurgicalInstrument extends MedicalInstrument{
	abstract void sterile();
}

class SurgicalCutter extends SurgicalInstrument{
	public void use() {
		System.out.println("Using SurgicalCutter...");
	}
	public void operate() {
		System.out.println("operate SurgicalCutter...");
	}
	public void sterile() {
		System.out.println("sterilize SurgicalCutter...");
	}
	public void incise() {
		System.out.println("incise using SurgicalCutter...");
	}
}

class SurgicalNeedle extends SurgicalInstrument{
	public void use() {
		System.out.println("Using SurgicalNeedle...");
	}
	public void operate() {
		System.out.println("operate SurgicalNeedle...");
	}
	public void sterile() {
		System.out.println("sterilize SurgicalNeedle...");
	}
	public void suture() {
		System.out.println("Suturing using SurgicalNeedle...");
	}
}

abstract class PathologicalInstrument extends MedicalInstrument{
	abstract void reader();
}

class Glucometer extends PathologicalInstrument{
	public void use() {
		System.out.println("Using Glucometer...");
	}
	public void operate() {
		System.out.println("operate Glucometer...");
	}
	public void reader() {
		System.out.println("reader Glucometer...");
	}
	public void measureGlucoseLevel() {
		System.out.println("incise using Glucometer...");
	}
}

class ECGMachine extends PathologicalInstrument{
	public void use() {
		System.out.println("Using ECGMachine...");
	}
	public void operate() {
		System.out.println("operate ECGMachine...");
	}
	public void reader() {
		System.out.println("reader ECGMachine...");
	}
	public void monitorHeartActivity() {
		System.out.println("Monitor Heart Activity ECGMachine...");
	}
}

