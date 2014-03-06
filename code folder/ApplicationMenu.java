/*  Done by: 	Peh Jun Hao
	Student No.:S8930045B
	Email: 		junhao.peh.2010
*/

import java.util.*;

public class ApplicationMenu{

	private PatientManager pMngr;
	private DoctorManager dMngr;
	private AppointmentManager aMngr;
	private Appointment appointment;
	private ArrayList<Appointment> aList;
	private ArrayList<ConsultationHours> cList;
	private ArrayList<Doctor> dList;
	private PADate pDate;
	private Scanner sc;
	
	
	public ApplicationMenu(){
		pMngr = new PatientManager();
		dMngr = new DoctorManager();
		aMngr = new AppointmentManager();
		cList = new ArrayList<ConsultationHours>();
		aList = aMngr.getList();
		dList = dMngr.getListOfDoctors();
		pDate = new PADate();
		sc = new Scanner(System.in);
	}
	
	public void display(){
		System.out.println("== Patient Appointment System :: Main Menu ==");
		System.out.println();
		System.out.println("1. List all patients");
		System.out.println("2. Add a patient");
		System.out.println("3. List all appointments of a doctor");
		System.out.println("4. Make an appointment");
		System.out.println("5. View report");
		System.out.println("6. Quit Application");
		System.out.println();
	}
	
	public void readOption(){
		
		int choice = 0;
		do{
			System.out.print("Enter your choice > ");
			choice = sc.nextInt();
			
			switch(choice){
				case 1: 
					listAllPatients();
					break;
				case 2: 
					addPatient();
					break;	
				case 3:
					listAllAppointment();
					break;
				case 4: 
					makeAnAppointment();
					break;
				case 5:
					viewReport();
					break;
				case 6:
					System.out.println("\nThanks for using the Patient Appointment System! Good-bye!");
					break;
				default:
					System.out.println("\nInvalid input!\n");
			}
			if(choice != 6){
				display();
			}
		}while(choice != 6);
	}
	
	public void listAllPatients(){
		ArrayList<Patient> list = pMngr.getListOfPatients();
		System.out.println("\n== Patient Appointment System :: List all patients ==\n");
		System.out.println("ID   Patient    \tBlood Type");
		System.out.println("----------------------------------");
		for(int i=0; i<list.size();i++){
			Patient p = list.get(i);
			System.out.println(p.toString());
		}
		System.out.println();
	}
	
	public void addPatient(){
		System.out.println("\n== Patient Appointment System :: Add a patient ==\n");
		sc.nextLine();
		
		System.out.print("Enter the patient's name > ");
		String pName = sc.nextLine();
		System.out.print("Enter the patient's blood type > ");
		String pBloodType = sc.nextLine();
		ArrayList<Patient> list = pMngr.getListOfPatients();
		String pId = "P" + (list.size() +1);
		pMngr.addPatient(pId,pName,pBloodType);
		System.out.println("\nThe following patient has been added:\n");
		System.out.println("ID   Patient    \tBlood Type");
		System.out.println("----------------------------------");
		int patientNumber = list.size()-1;
		System.out.println(list.get(patientNumber));
		System.out.println();
	}
	
	public void listAllAppointment(){
		
		System.out.println("\n== Patient Appointment System :: List all appointments of a doctor ==\n");
		System.out.println("ID   Doctor");
		System.out.println("----------------");
		sc.nextLine();
		
		for(int i = 0;i<dList.size();i++){
			Doctor d = dList.get(i);
			System.out.println(d.getDoctorToString());
		}
		
		System.out.print("\nEnter a doctor ID > ");
		String dId = sc.nextLine();
		while(!dMngr.isDoctorValid(dId)){
			System.out.println("Invalid doctor ID!");
			System.out.print("Enter a doctor ID > ");
			dId = sc.nextLine();			
		}
		
		Doctor doctor = dMngr.getDoctor(dId);
		String doctorName = doctor.getName();
		
		ArrayList<Appointment> appointmentList = aMngr.getList();
		
		if(aMngr.doesDoctorHaveAppointment(doctor)){
			System.out.println("\nDr. " + doctorName + " has the following apointments:");
			System.out.println("-----------------------------------------------------");
			for(int i =0; i<appointmentList.size();i++){
				Appointment appointment = appointmentList.get(i);
				PADate date = appointment.getDate();
				String aId = appointment.getId();
				String dayOfWeek = date.getDayOfWeek();
				int dayOfMonth = date.getDayOfMonth();
				int month = date.getMonth();
				int year = date.getYear();
				int startHour = appointment.getStartHour();
				int endHour = startHour + 1;
				Patient patient = appointment.getPatient();
				String pName = patient.getName();
				
				if(appointment.getDoctor().equals(doctor)){
					if(startHour < 10){
						System.out.println(aId + "   " + dayOfWeek + " " + dayOfMonth + "/" + month + "/" + year  + " 0" + 
							startHour + "00-" + endHour + "00\t"+ pName );
					}else{
						System.out.println(aId + "   " + dayOfWeek + " " + dayOfMonth + "/" + month + "/" + year  + " " + 
							startHour + "00-" + endHour + "00\t"+ pName );
					}
				}				
			}
			System.out.println("");
		}else{
			System.out.println("\nDr. " + doctorName + " has no appointment.\n");
		}
	}
	
	public void makeAnAppointment(){
		System.out.println("\n== Patient Appointment System :: Make an appointment ==\n");
		System.out.println("ID   Doctor \t\tHourly Fee \tConsultation Hours");
		System.out.println("-------------------------------------------------------------------------------");
		
		//Prints out Consolidated time slots
		for(int i = 0;i<dList.size();i++){
			Doctor d = dList.get(i);
			ArrayList<ConsultationHours> cList = dMngr.getConsultationList(d);
			System.out.print(d.getDoctorAndFeeToString() + "    \t\t");
			for(int j=0; j< cList.size(); j++){
				ConsultationHours cHour = cList.get(j);
				if(cHour.getStartHour() < 10){
					System.out.print(cHour.getDayOfWeek() + " 0" + cHour.getStartHour() + "00-" + cHour.getEndHour() + "00");
				}else{
					System.out.print(cHour.getDayOfWeek() + " " + cHour.getStartHour() + "00-" + cHour.getEndHour() + "00");
				}
				if(j<cList.size()-1){
					System.out.print(", ");
				}
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.print("Enter a doctor ID > ");
		String doctorId = sc.next();
		while(!dMngr.isDoctorValid(doctorId)){
			System.out.println("Please input the correct Doctor");
			System.out.print("Enter a doctor ID > ");
			doctorId = sc.next();
		}
		
		Doctor doctor = dMngr.getDoctor(doctorId);
		ArrayList<ConsultationHours> cList = dMngr.getListOfSlots(doctor);
		
		//This is my algorithm for pulling the correct Consultation slot to add in the Appointment list
		int[] intList = new int[cList.size()];
		int k = 0;
		
		//Prints out the expanded slots for the specified doctor
		for(int i=0;i<cList.size();i++){
			ConsultationHours cHour = cList.get(i);
			String dayOfWeek = cHour.getDayOfWeek();
			int startHour = cHour.getStartHour();
			int endHour = cHour.getEndHour();
			PADate nextDate = pDate.nextDayOfWeek(dayOfWeek);
			int dayOfMonth = nextDate.getDayOfMonth();
			int month = nextDate.getMonth();
			int year = nextDate.getYear();
			
			intList[i] = k;
			
			if(!aMngr.isConsultationTaken(doctor,startHour,nextDate)){
				if(k == 0){
					System.out.println("\nThe following slots are available:\n");
					System.out.println("ID   Date/Time");
					System.out.println("--------------------------------");
				}
				k++;
				if(startHour < 10){
					System.out.println((k) + "    " + dayOfWeek + " " + dayOfMonth + "/" + month + "/" + year + " 0" + startHour + "00-" + endHour + "00");
				}else{
					System.out.println((k) + "    " + dayOfWeek + " " + dayOfMonth + "/" + month + "/" + year + " " + startHour + "00-" + endHour + "00");
				}
				
			}
		}
		
		if(k == 0){
			System.out.println("\nThe chosen doctor has no free slots available within the next 7 days\n");
		}else{
			boolean isChoiceCorrect = false;
			int choice = 0;
			do{
				System.out.print("\nEnter your choice by ID > ");
				choice = sc.nextInt();
				if(choice <= k && choice > 0){
					isChoiceCorrect = true;
				}else{
					System.out.println("\nChoice not within range");
				}
			}while(!isChoiceCorrect);
			
			sc.nextLine();
			System.out.print("Enter a patient ID > ");
			String pId = sc.nextLine();
			while(!pMngr.isPatientValid(pId)){
				System.out.print("Invalid ID. \nPlease enter correct Patient's ID > ");
				pId = sc.nextLine();
			}
			
			//Pulls the 
			int newChoice = 0;
			for(int i = 0; i<intList.length;i++){
				if(intList[i] == (choice-1)){
					newChoice  = i;
				}
			}
			ConsultationHours chosen = cList.get(newChoice);
			
			//Checks if the appointment is valid and adds to the Appointment List
			if(aMngr.isAppointmentValid(pId,chosen.getStartHour(),chosen.getDayOfWeek())){
				ConsultationHours cHour = cList.get(newChoice);
				String dayOfWeek = cHour.getDayOfWeek();
				int startHour = cHour.getStartHour();
				int endHour = cHour.getEndHour();
				pDate = new PADate();
				PADate nextDate = pDate.nextDayOfWeek(dayOfWeek);
				int dayOfMonth = nextDate.getDayOfMonth();
				int month = nextDate.getMonth();
				int year = nextDate.getYear();
				
				Patient p = pMngr.getPatient(pId);
				
				ArrayList<Appointment> appointmentList = aMngr.getList();
				String aId = "A" + (appointmentList.size() +1);
				
				aMngr.addAppointment(new Appointment(aId,p,doctor,nextDate,startHour));
				
				String doctorName = doctor.getName();
				String patientName = p.getName();
				
				System.out.println("\nThe following new appointment has been made with Dr. " + doctorName + ":\n");
				System.out.println("ID   Date/Time\t\t\tPatient Name");
				System.out.println("--------------------------------------------");
				if(startHour < 10){
					if(aId.length() <3){						
						System.out.println(aId + "   " + dayOfWeek + " " + dayOfMonth + "/" + month + "/" + year + " 0" + startHour + "00-" + 
							endHour + "00" + "\t" + patientName + "\n");
					}else{
						System.out.println(aId + "  " + dayOfWeek + " " + dayOfMonth + "/" + month + "/" + year + " 0" + startHour + "00-" + 
							endHour + "00" + "\t" + patientName + "\n");
					}
				}else{
					if(aId.length() <3){						
						System.out.println(aId + "   " + dayOfWeek + " " + dayOfMonth + "/" + month + "/" + year + " " + startHour + "00-" + 
							endHour + "00" + "\t" + patientName + "\n");
					}else{
						System.out.println(aId + "  " + dayOfWeek + " " + dayOfMonth + "/" + month + "/" + year + " " + startHour + "00-" + 
							endHour + "00" + "\t" + patientName + "\n");
					}
				}
			}else{
				System.out.println("\nThis patient has another appointment made at the same timing\n");
			}
		}
	}
	
	public void viewReport(){
	
		Doctor highestPaidDoctor = null;
		Doctor tempDoctor = new Doctor();
		
		//Gets the highest paid Doctor
		for(int i=0; i< dList.size();i++){
			Doctor d1 = dList.get(i);
			if(aMngr.getEarning(tempDoctor)<aMngr.getEarning(d1)){
				tempDoctor = d1;
			}
			if(aMngr.getEarning(tempDoctor) != 0){
				highestPaidDoctor = tempDoctor;
			}			
		}
		
		//Checks if other Doctors have similar earnings
		if(highestPaidDoctor == null){
			System.out.println("\nNo doctor has any earnings!");
		}else{
			System.out.println("\nThe following doctor has the highest expected earnings:\n");
			System.out.println("Name\t\t\tExpected Earnings");
			System.out.println("----------------------------------------");
			for(int i=0; i< dList.size();i++){
				Doctor d = dList.get(i);
				if(aMngr.getEarning(d) == aMngr.getEarning(highestPaidDoctor)){
					System.out.println(d.getName()+"\t\t$"+ aMngr.getEarning(d));
				}
			}
		}
		System.out.println("");
	}		
}