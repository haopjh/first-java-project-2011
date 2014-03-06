/*  Done by: 	Peh Jun Hao
	Student No.:S8930045B
	Email: 		junhao.peh.2010
*/

import java.util.*;

public class PatientManager{
		
	private ArrayList<Patient> list;
	
	public PatientManager(){
		list = new ArrayList<Patient>();
		list.add(new Patient("P1","Paul Lim","O"));
		list.add(new Patient("P2","Wilson Goh","AB"));
		list.add(new Patient("P3","Elaine Lee","A"));
		list.add(new Patient("P4","Erica Teo","B"));
	}
	
	//Returns list of Patients
	public ArrayList<Patient> getListOfPatients(){
		return list;
	}
	
	//Method to Add Patients
	public void addPatient(String pId, String pName, String pBloodType){
		list.add(new Patient(pId,pName,pBloodType));
	}
	
	//Checks if the id input is valid
	public boolean isPatientValid(String pId){
		boolean valid = false;
		for(int i=0; i<list.size();i++){
			Patient p = list.get(i);
			String patientId = p.getId();
			if(patientId.equalsIgnoreCase(pId)){
				valid = true;
			}
		}
		return valid;
	}
	
	//Takes in Patient id and return Patient object
	public Patient getPatient(String pId){
		Patient p = null;
		for(int i=0; i <list.size(); i++){
			Patient patient = list.get(i);
			String patientId = patient.getId();
			if(patientId.equalsIgnoreCase(pId)){
				p = patient;
			}
		}
		return p;
	}
	
}