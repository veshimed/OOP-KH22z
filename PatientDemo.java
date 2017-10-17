import java.util.HashMap;

// Demonstrate work with Patient class
public class PatientDemo {
	
	// Get a patient with provided diagnose
	public static Patient getPatientByDiagnose(Patient[] patientList, String diagnose) {
		for(int i=0; i < patientList.length; i++) {
			if(patientList[i].diagnose == diagnose) {return patientList[i];}			
		}
		return null;
	}
	// Get a patient from provided street
	public static Patient getPatientByStreet(Patient[] patientList, String street) {
		for(int i=0; i < patientList.length; i++) {
			if(patientList[i].address.get("Street") == street) {return patientList[i];}			
		}
		return null;
	}

	public static void main(String[] args) {
		//Creating patient with default parameters and use different methods
		Patient defaultPatient = new Patient();
		defaultPatient.printPatientInfo();
		String doc = defaultPatient.getDoctorByDiagnose();
		defaultPatient.scheduleAppointment(doc);
		defaultPatient.getPrescription();
		defaultPatient.callDoctorToHome();
		
		//Create patient 1 and use different methods
		HashMap<String, String> addr1 = new HashMap<>();
		addr1.put("Town", "Lviv");
		addr1.put("Street", "Kopernika");
		addr1.put("Building", "25");
		addr1.put("Flat", "12");		
		Patient patient1 = new Patient("Petro", "Holovko", addr1);
		patient1.printPatientInfo();
		String doc1 = patient1.getDoctorByAddress();
		patient1.scheduleAppointment(doc1);
		patient1.getPrescription();
		patient1.callDoctorToHome();

		//Create patient 2 and use different methods
		HashMap<String, String> addr2 = new HashMap<>();
		addr2.put("Town", "Lviv");
		addr2.put("Street", "Bandery");
		addr2.put("Building", "65");
		addr2.put("Flat", "34");		
		Patient patient2 = new Patient("Larisa", "Sydorko", addr2, "Heart attack");
		patient2.printPatientInfo();
		String doc2 = patient2.getDoctorByDiagnose();
		patient2.scheduleAppointment(doc2);
		patient2.getPrescription();
		patient2.callDoctorToHome();

		//Create patient 3 and use different methods
		Patient patient3 = new Patient("Ivanna", "Sydorko", addr2, "Hematoma");
		patient3.printPatientInfo();		
		String doc3 = patient3.getDoctorByAddress();
		patient3.scheduleAppointment(doc3);		
		
		//Change name for patient 3
		String newName = "Ivan";
		System.out.printf(
			"Changing name of patient %s to %s %s",
			patient3.getNameSurname(), newName, patient3.surname
		);
		patient3.name = newName;
		patient3.printPatientInfo();
		patient3.getPrescription();
		patient3.callDoctorToHome();
		
		// Create an array of all patients and set search variables
		Patient[] patientList = {defaultPatient, patient1, patient2, patient3};
		String illness = "Hematoma";
		String street = "Kopernika";
		
		//Find a patient with diagnose Hematoma
		Patient withHematoma = getPatientByDiagnose(patientList, illness);
		if(withHematoma != null) {
			System.out.printf("\nPatient with %s is %s", illness, withHematoma.getNameSurname());
		}
		else {System.out.printf("\nNo patient with %s found", illness);}
		
		//Find a patient from Kopernika street
		Patient fromKopernika = getPatientByStreet(patientList, street);
		if(fromKopernika != null) {
			System.out.printf("\nPatient from %s street is %s", street, fromKopernika.getNameSurname());
		}
		else {System.out.printf("\nNo patient from %s street found", street);}		
	}	
}
