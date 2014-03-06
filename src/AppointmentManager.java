/*  Done by: 	Peh Jun Hao
	Student No.:S8930045B
	Email: 		junhao.peh.2010
*/

import java.util.*;

public class AppointmentManager{
	
	private DoctorManager dMngr;
	private Appointment appointment;
	private ArrayList<Appointment> aList;
	
	
	public AppointmentManager(){
		aList = new ArrayList<Appointment>();
		dMngr = new DoctorManager();
	}
	
	//Getters
	public ArrayList<Appointment> getList(){
		return aList;
	}
	
	//Adds appointment to aList
	public void addAppointment(Appointment a){
		aList.add(a);
	}
	
	//Checks if the doctor have any appointment
	public boolean doesDoctorHaveAppointment(Doctor d){
		boolean hasAppointment = false;
		aList = getList();
		for(int i=0; i<aList.size();i++){
			appointment = aList.get(i);
			if(d.equals(appointment.getDoctor())){
				hasAppointment = true;
			}
		}
		return hasAppointment;
	}
	
	//Method that takes in Doctor object, starting hour and PADate object, and returns true if the specific consultation slot is taken
	public boolean isConsultationTaken(Doctor d, int sHour, PADate date){
		boolean consultationTaken = false;
		aList = getList();
		for(int i=0; i<aList.size();i++){
			appointment = aList.get(i);
			if(d.equals(appointment.getDoctor()) && sHour == appointment.getStartHour() && appointment.getDate().equals(date)){
				consultationTaken = true;
			}
		}
		return consultationTaken;
	}
	
	//Method that checks if appointment chosen coincides with earlier appointments
	public boolean isAppointmentValid(String patientId, int sHour, String dayOfWeek){
		boolean isAppointmentValid = true;
		for(int j=0; j<aList.size();j++){
			Appointment a = aList.get(j);
			PADate d = a.getDate();
			String dOfWeek = d.getDayOfWeek();
			int startHour = a.getStartHour();
			Patient p = a.getPatient();
			String pId = p.getId();
			if(pId.equalsIgnoreCase(patientId) && startHour == sHour && dOfWeek.equals(dayOfWeek)){
				isAppointmentValid = false;
			}
		}	
		return isAppointmentValid;	
	}
	
	public int getEarning(Doctor d){
		aList = getList();
		int earning = 0;
		int count = 0;
		for(int i=0; i<aList.size();i++){
			appointment = aList.get(i);
			if(d.equals(appointment.getDoctor())){
				count++;
			}
		}
		earning = d.getFee() * count;
		return earning;
	}
}