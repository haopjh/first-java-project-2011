/*  Done by: 	Peh Jun Hao
	Student No.:S8930045B
	Email: 		junhao.peh.2010
*/

import java.util.*;

public class DoctorManager{
	
	//List to store Doctor objects
	private ArrayList<Doctor> doctorList;
	
	//List to store Consultation Hours
	private ArrayList<ConsultationHours> consultationListForJonathan;
	private ArrayList<ConsultationHours> consultationListForIren;
	private ArrayList<ConsultationHours> consultationListForBenjamin;
	private ArrayList<ConsultationHours> consultationListForApple;
	
	//List to store the expanded list of Consultation Hours
	private ArrayList<ConsultationHours> slotsForJonathan;
	private ArrayList<ConsultationHours> slotsForIren;
	private ArrayList<ConsultationHours> slotsForBenjamin;
	private ArrayList<ConsultationHours> slotsForApple;
	
	public DoctorManager(){
		
		consultationListForJonathan = new ArrayList<ConsultationHours>();
		consultationListForJonathan.add(new ConsultationHours("MON",9,12));
		consultationListForJonathan.add(new ConsultationHours("THU",10,13));
		consultationListForJonathan.add(new ConsultationHours("THU",14,17));
		
		consultationListForIren = new ArrayList<ConsultationHours>();
		consultationListForIren.add(new ConsultationHours("TUE",12,16));
		consultationListForIren.add(new ConsultationHours("THU",12,16));
		
		consultationListForBenjamin = new ArrayList<ConsultationHours>();
		consultationListForBenjamin.add(new ConsultationHours("FRI",10,12));
		
		consultationListForApple = new ArrayList<ConsultationHours>();
		consultationListForApple.add(new ConsultationHours("MON",11,12));
		
		doctorList = new ArrayList<Doctor>();
		doctorList.add(new Doctor("D1","Jonathan Ng",40,consultationListForJonathan));
		doctorList.add(new Doctor("D2","Iren Wong",20,consultationListForIren));
		doctorList.add(new Doctor("D3","Benjamin Tan",50,consultationListForBenjamin));
		doctorList.add(new Doctor("D4","Apple Tan",50,consultationListForApple));
		
		slotsForJonathan = expandList(consultationListForJonathan);
		
		slotsForIren = expandList(consultationListForIren);
		
		slotsForBenjamin = expandList(consultationListForBenjamin);
		
		slotsForApple = expandList(consultationListForApple);
		
	}
	
	public ArrayList<Doctor> getListOfDoctors(){
		return doctorList;
	}
	
	public Doctor getDoctor(String dId){
		Doctor doctor = null;
		for(int i = 0; i<doctorList.size();i++){
			Doctor d = doctorList.get(i);
			String doctorId = d.getId();
			if(doctorId.equalsIgnoreCase(dId)){
				doctor = d;
			}	
		}
		return doctor;
	}
	
	//Checks the validity of the doctor
	public boolean isDoctorValid(String dId){
		boolean exist = false;
		for(int i = 0; i<doctorList.size();i++){
			Doctor d = doctorList.get(i);
			String doctorId = d.getId();
			if(doctorId.equalsIgnoreCase(dId)){
				exist = true;
			}
		}
		return exist;
	}
	
	//This method takes in a Doctor object and returns the compacted consultation list
	public ArrayList<ConsultationHours> getConsultationList(Doctor d){
		String dId = d.getId();
		if(dId.equals("D1")){
			return consultationListForJonathan;
		}else if(dId.equalsIgnoreCase("D2")){
			return consultationListForIren;
		}else if(dId.equalsIgnoreCase("D3")){
			return consultationListForBenjamin;
		}else if(dId.equalsIgnoreCase("D4")){
			return consultationListForApple;
		}else{
			return null;
		}
	}
	
	//This method takes in a Doctor object and returns the expanded consultation list
	public ArrayList<ConsultationHours> getListOfSlots(Doctor d){
		String dId = d.getId();
		if(dId.equals("D1")){
			return slotsForJonathan;
		}else if(dId.equalsIgnoreCase("D2")){
			return slotsForIren;
		}else if(dId.equalsIgnoreCase("D3")){
			return slotsForBenjamin;
		}else if(dId.equalsIgnoreCase("D4")){
			return slotsForApple;
		}else{
			return null;
		}
	}
	
	//This method takes in a ConsultationHours list and expands the list to slots of 1 hour each
	public ArrayList<ConsultationHours> expandList(ArrayList<ConsultationHours> cList){
		ArrayList<ConsultationHours> expandedList = new ArrayList<ConsultationHours>();
		for(int i=0; i<cList.size(); i++){
			ConsultationHours cHour = cList.get(i);
			int eHour = cHour.getEndHour();
			int sHour = cHour.getStartHour();
			int endHour = sHour;
			do{
				String day = cHour.getDayOfWeek();
				endHour = sHour + 1;
				expandedList.add(new ConsultationHours(day,sHour,endHour));
				sHour++;
			}while(endHour < eHour);
		}	
		return expandedList;
	}	
}