import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

//Створити клас ПАЦІЄНТ. Визначити для класу не менше 10 найважливіших методів,
//включаючи два конструктори. Створити масив об’єктів цього класу і написати програму, яка
//демонструє роботу з об’єктами ПАЦІЄНТ (створення, редагування, перегляд, а також пошук
//об’єктів ПАЦІЄНТ за заданим критерієм).


public class Patient{
	String name;
	String surname;
	HashMap<String, String> address = new HashMap<>();
	String diagnose;
	
	// Create a test patient if no parameters supplied
	public Patient(){
		this.name = "Ivan";
		this.surname = "Ivanov";
		
		this.address.put("Town", "Lviv");
		this.address.put("Street", "Horodotska");
		this.address.put("Building", "1");
		this.address.put("Flat", "1");
		
		this.diagnose = "Hepatitis B";
	}
	
	// Create a healthy patient if no diagnose passed
	public Patient(String name, String surname, HashMap<String, String> address){
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.diagnose = "The patient has no recorded diagnoses";
	}
	
	// Create a patient with all supplied arguments
	public Patient(String name, String surname, HashMap<String, String> address, String diagnose){
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.diagnose = diagnose;
	}
	
	// Print an appropriate doctor by patient's address
	public String getDoctorByAddress(Boolean verbose) {
		String msg  = String.format("The doctor serving %s street is ", this.address.get("Street"));
		String doc = "";
		if (this.address.get("Street") == "Horodotska") {doc = "M.D. Sidorov H.V.";}
		else if (this.address.get("Street") == "Kopernika") {doc = "M.D. Hodorov P.S.";}
		else {doc = "M.D. Popova A.F.";}
		if (verbose == true) {
			System.out.printf("%s%s", msg, doc);
		}
		return doc;
	}
	
	 // Overload method with verbose=false if not supplied
	public String getDoctorByAddress() {
		return this.getDoctorByAddress(false);
	}
	
	// Print an appropriate doctor by patient's diagnose
	public String getDoctorByDiagnose(Boolean verbose) {
		String msg = String.format("The doctor for healing %s is ", this.diagnose);
		String doc = "";
		if (this.diagnose == "Hepatitis B") {doc = "M.D. Portnov H.V.";}
		else if (this.diagnose == "Heart attack") {doc = "M.D. Gobrov A.S.";}
		else {doc = "M.D. Popova A.F.";}
		if (verbose == true) {
			System.out.printf("%s%s", msg, doc);
		}
		return doc;
	}
	
	// Overload method with verbose=false if not supplied
		public String getDoctorByDiagnose() {
			return this.getDoctorByDiagnose(false);
		}
	
	// Schedule a doctor appointment
	public void scheduleAppointment(String doctor) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Calendar cal = Calendar.getInstance();
		Date currentDate  = new Date();
		cal.setTime(currentDate);
		
		// Generate random day increment from 1 to 10
		int inc_day = (int) (1 + Math.random() * 9);
		cal.add(Calendar.DATE, inc_day);		

		// Generate random hour from 8 to 16
		int set_time = (int) (8 + Math.random() * 8);		
		cal.set(Calendar.HOUR, set_time);
		
		System.out.printf(
			"\nAn appointment has been scheduled for patient %s to the doctor %s on: ",
			this.getNameSurname(), doctor				
		);
		System.out.println(dateFormat.format(cal.getTime()));
	}
	
	// Print patient's info
	public void printPatientInfo() {
		System.out.printf(
			"\nPatient %s %s"
			+ "\nAddress: %s, %s street, building #%s, Flat #%s"
			+ "\nDiagnose: %s\n",
			this.name, this.surname,
			this.address.get("Town"), this.address.get("Street"), 
			this.address.get("Building"), this.address.get("Flat"),
			this.diagnose
		);
	}
	
	//Get patients's Name and Surname
	public String getNameSurname() {
		String id = String.format("%s %s", this.name, this.surname);
		return id;
	}
	
	// Get prescription based on diagnose
	public String getPrescription() {
		HashMap<String, String> medicine = new HashMap<>();
		medicine.put("Heart attack", "Aspirin, Thrombolytics, Beta blockers");		
		medicine.put("Hepatitis B", "Antiviral medications, Interferon alfa-2b (Intron A)");
		String outString;
		if (this.diagnose == "The patient has no recorded diagnoses") {
			outString = "No prescription needed: the patient has no recorded diagnoses\n";
		}	
		else if (medicine.get(this.diagnose) == null) {
			outString = String.format(
				"The appropriate medicine for %s treatment not found in data base\n", this.diagnose
			);		
		}
		else {
			outString = String.format(
				"The appropriate medicine for %s treatment: %s\n", this.diagnose, medicine.get(this.diagnose)
			);		
		}
		System.out.printf(outString);
		return outString;
	}
	
	public void callDoctorToHome() {
		System.out.printf(
			"Thank you for you call %s. The doctor %s is going to visit you during the day\n", 
			this.getNameSurname(), this.getDoctorByAddress()
		);
	}
}
