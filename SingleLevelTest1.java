import java.time.LocalDate;

public class SingleLevelTest1 {
	public static void main(String[] args) {
		
		AdhaarCard adhaarCard1 = new AdhaarCard();
		adhaarCard1.setAdhaarNumber("1231 2312 3123");
		adhaarCard1.setAddress("C 709, West Avenue, Mumbai 16");
		adhaarCard1.setNameOnAdhaar("Peter Dsouza");
		adhaarCard1.setFatherName("Patrick Dsouza");
		adhaarCard1.setDateOfBirth(LocalDate.of(2002, 3, 25));
		adhaarCard1.setMobileNumber("9870445533");
		
		PanCard panCard1 = new PanCard();
		panCard1.setNameOnPan("Peter Dsouza");
		panCard1.setPanNumber("FMLPP118K");
		
		AdhaarCard adhaarCard2 = new AdhaarCard();
		adhaarCard2.setAdhaarNumber("9820 2312 3123");
		adhaarCard2.setAddress("D 909, East Avenue, Nagpur 16");
		adhaarCard2.setNameOnAdhaar("Dinesh Sawant");
		adhaarCard2.setFatherName("Guru Sawant");
		adhaarCard2.setDateOfBirth(LocalDate.of(2003, 12, 15));
		adhaarCard2.setMobileNumber("8899445533");
		
		PanCard panCard2 = new PanCard();
		panCard2.setNameOnPan("Dinesh Sawant");
		panCard2.setPanNumber("FMLPP119K");


		AdhaarCard adhaarCard3 = new AdhaarCard();
		adhaarCard3.setAdhaarNumber("1231 5312 6123");
		adhaarCard3.setAddress("D22, Ram Mahal, Pune 333");
		adhaarCard3.setNameOnAdhaar("Satish Kulkarni");
		adhaarCard3.setFatherName("Shyam Kulkarni");
		adhaarCard3.setDateOfBirth(LocalDate.of(2000, 7, 29));
		adhaarCard3.setMobileNumber("8870445511");
		
		PanCard panCard3 = new PanCard();
		panCard3.setNameOnPan("Satish Kulkarni");
		panCard3.setPanNumber("FMLPP198K");
		
		
		Person personObj = new Person( 'M',"Peter",24, adhaarCard1);
		personObj.setPanCard(panCard1);
		
		personObj.showPerson();
		System.out.println("-----------------");
		
		
		Student studentObj = new Student('M',"Dinesh Sawant",24,   123,"Bharati Vidyapeeth","Mech Eng",899);
		studentObj.setAdhaarCard(adhaarCard2);
		studentObj.setPanCard(panCard2);
		studentObj.showStudent();	
		
		System.out.println("-----------------");
		
		
		Employee empObj = new Employee('F',"Jane",22,   323,"MIT","IT Eng",999, 1212,"Google Inc","Brain Analyst",9999);
		empObj.setAdhaarCard(adhaarCard3);
		empObj.setPanCard(panCard3);
		empObj.showEmployee();
	}
}

class AdhaarCard
{
	private String adhaarNumber;
	private String nameOnAdhaar;
	private LocalDate dateOfBirth;
	private String address;
	private String mobileNumber;
	private String fatherName;
	
	public String getAdhaarNumber() {
		return adhaarNumber;
	}
	public void setAdhaarNumber(String adhaarNumber) {
		this.adhaarNumber = adhaarNumber;
	}
	public String getNameOnAdhaar() {
		return nameOnAdhaar;
	}
	public void setNameOnAdhaar(String nameOnAdhaar) {
		this.nameOnAdhaar = nameOnAdhaar;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	void printAdhaarCard() {
		System.out.println("-----ADHAAR CARD INFO -----");
		System.out.println("Adhaar Number  : "+adhaarNumber);
		System.out.println("Adhaar Name    : "+nameOnAdhaar);
		System.out.println("Adhaar Address : "+address);
		System.out.println("Birthdate      : "+dateOfBirth);
		System.out.println("Father Name    : "+fatherName);
		System.out.println("Mobile Number  : "+mobileNumber);
		
	}
	
	
}

class PanCard{
	private String nameOnPan;
	private String panNumber;
	
	public String getNameOnPan() {
		return nameOnPan;
	}
	public void setNameOnPan(String nameOnPan) {
		this.nameOnPan = nameOnPan;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	
	void printPanCardDetails() {
		System.out.println("----PAN CARD details----");
		System.out.println("Name on Pan card "+nameOnPan);
		System.out.println("Pan Number "+panNumber);
	}
	
}
class Person {
	private char gender;
	private String name;
	private int age;
	private AdhaarCard adhaarCard; // is it a reference ???YES
	private PanCard panCard;
	
	
	public AdhaarCard getAdhaarCard() {
		return adhaarCard;
	}

	public void setAdhaarCard(AdhaarCard adhaarCard) {
		this.adhaarCard = adhaarCard;
	}
	
	public PanCard getpanCard() {
		return panCard;
	}
	
	public void setPanCard(PanCard panCard) {
		this.panCard = panCard;
	}

	Person() {
		System.out.println("Person() ctor....");
	}
	
	
	Person(int age) {
		this('F',"NONAME",age); //invoking ctor of the same class - reuse
		/*System.out.println("START=> Person(int)");
			this.age = age;
		System.out.println("FINISH=> Person(int)");*/
		
	}
	
	Person(char gender, String name, int age,AdhaarCard adhaarRef) {
		this(gender,name,age);
		System.out.println("START=> Person(char,String,int,AdhaarCard) ctor....");	
		this.adhaarCard = adhaarRef;
	}
	
	Person(char gender, String name, int age) {
		System.out.println("START=> Person(char,String,int) ctor....");		
		
		if(gender=='M' || gender=='F') {
			this.gender = gender;
		}
		else {
			//System.out.println("Invalid Gender...");
			//throw new RuntimeException("Invalid gender.....");
			RuntimeException runtimeGenderEx = new RuntimeException("Invalid gender : "+gender);
			throw runtimeGenderEx;
		}
		
		if(Validator.checkStringWithSpace(name)) {
			this.name = name;
		}
		else {
			RuntimeException runtimeNameEx = new RuntimeException("Invalid name : "+name);
			throw runtimeNameEx;
		}
		
		if(age >=1 && age <=120) {
			this.age = age;
		}
		else {
			RuntimeException runtimeAgeEx = new RuntimeException("Invalid age : "+age);
			throw runtimeAgeEx;	
		}
		System.out.println("FINISH=> Person(char,String,int) ctor....");		

	}
	void showPerson() {
		System.out.println("---- PERSONAL ----");
		System.out.println("GENDER : "+gender);
		System.out.println("NAME   : "+name);
		System.out.println("AGE    : "+age);
		if(adhaarCard!=null) {
			adhaarCard.printAdhaarCard();
		}
		else {
			System.out.println("Adhaar Card NOT set");
		}
		
		if(panCard!=null) {
			panCard.printPanCardDetails();
		}
		else {
			System.out.println("Pan Card NOT set");
		}
	}
 }
class Student extends Person {
	private int rollNumber;
	private String collegeName;
	private String stream;
	private float totalMarks;
		
	Student(char gender, String name, int age, int rollNumber,String collegeName, String stream, float totalMarks) {
		super(gender,name,age); //REUSE THE ctor OF THE PARENT
		System.out.println("Student() ctor...");
		
		if(Validator.checkNumber(rollNumber, 1, 500)) {
			this.rollNumber = rollNumber;			
		}
		else {
			RuntimeException runtimeRollNumberEx = new RuntimeException("Invalid Roll Number : "+rollNumber);
			throw runtimeRollNumberEx;
		}
		
		if(Validator.checkStringWithSpace(collegeName)) {
			this.collegeName = collegeName;
		}
		else {
			RuntimeException runtimeNameEx = new RuntimeException("Invalid collegeName : "+collegeName);
			throw runtimeNameEx;
		}
		
		if(Validator.checkStringWithSpace(stream)) {
			this.stream = stream;
		}
		else {
			RuntimeException runtimeNameEx = new RuntimeException("Invalid stream : "+stream);
			throw runtimeNameEx;
		}
		

		if(Validator.checkNumber(totalMarks, 1, 1000)) {
			this.totalMarks = totalMarks;			
		}
		else {
			RuntimeException runtimeMarksEx = new RuntimeException("Invalid Marks : "+totalMarks);
			throw runtimeMarksEx;
		}
		

	}
	
	void showStudent() {
		super.showPerson(); //super. to invoke super class member/data/function
		System.out.println("---- STUDENT ----");
		System.out.println("ROLLNO : "+rollNumber);
		System.out.println("COLLGE : "+collegeName);
		System.out.println("STREAM : "+stream);
		System.out.println("MARKS  : "+totalMarks);
	}
}
class Employee extends Student {
	private int empno;
	private String companyName;
	private String designation;
	float salary;
	
	Employee(char gender, String name, int age, int rollNumber,String collegeName, String stream, float totalMarks,int empno, String companyName, String designation, float salary) {
		super( gender,  name,  age,  rollNumber, collegeName,  stream,  totalMarks);
		System.out.println("Employee() ctor...");
		
		if(Validator.checkNumber(empno, 100, 2000)) {
			this.empno = empno;			
		}
		else {
			RuntimeException runtimeEmpnoEx = new RuntimeException("Invalid empno : "+empno);
			throw runtimeEmpnoEx;
		}
		
		if(Validator.checkStringWithSpace(companyName)) {
			this.companyName = companyName;
		}
		else {
			RuntimeException runtimeCompanyNameEx = new RuntimeException("Invalid companyName : "+companyName);
			throw runtimeCompanyNameEx;
		}
		
		if(Validator.checkStringWithSpace(designation)) {
			this.designation = designation;
		}
		else {
			RuntimeException runtimeDesignationEx = new RuntimeException("Invalid designation : "+designation);
			throw runtimeDesignationEx;
		}
		

		if(Validator.checkNumber(salary, 5000, 20000)) {
			this.salary = salary;			
		}
		else {
			RuntimeException runtimeSalaryEx = new RuntimeException("Invalid salary : "+salary);
			throw runtimeSalaryEx;
		}
	}
	
	void showEmployee() {
		super.showStudent(); //super. to invoke super class member/data/function
		System.out.println("---- EMPLOYEE ----");
		System.out.println("EMPNO  : "+empno);
		System.out.println("COMPANY: "+companyName);
		System.out.println("DESG   : "+designation);
		System.out.println("SALARY : "+salary);
	}
}