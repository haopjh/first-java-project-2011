/*  Done by: 	Peh Jun Hao
	Student No.:S8930045B
	Email: 		junhao.peh.2010
*/

public class Appointment{

	private String aId;
	private Patient patient;
	private Doctor doctor;
	private PADate date;
	private int startHour;
	
	public Appointment(String appointmentId, Patient p,Doctor doc, PADate d, int sHour){
		aId = appointmentId;
		patient = p;
		doctor = doc;
		date = d;
		startHour = sHour;
	
	}
	
	//Getters
	public String getId(){
		return aId;
	}
	public Patient getPatient(){
		return patient;
	}
	public Doctor getDoctor(){
		return doctor;
	}
	public PADate getDate(){
		return date;
	}
	public int getStartHour(){
		return startHour;
	}
	
	//Setters
	public void setId(String appointmentId){
		aId = appointmentId;
	}
	public void setPatient(Patient p){
		patient = p;
	}
	public void setDoctor(Doctor doc){
		doctor = doc;
	}
	public void setDate(PADate d){
		date = d;
	}
	public void setStartHour(int sHour){
		startHour = sHour;
	}
}