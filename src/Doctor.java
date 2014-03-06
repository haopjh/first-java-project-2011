/*  Done by: 	Peh Jun Hao
	Student No.:S8930045B
	Email: 		junhao.peh.2010
*/

import java.util.*;

public class Doctor{
	
	private String doctorId;
	private String doctorName;
	private int fee;
	private ArrayList<ConsultationHours> consultationList;
	
	public Doctor(String dId, String dName, int dFee, ArrayList<ConsultationHours> cList){
		doctorId = dId;
		doctorName = dName;
		fee = dFee;
		consultationList = cList;
	}
	
	//A simple constructor used in comparing earnings
	public Doctor(){
		fee = 0;
	}
	
	//Getters
	public String getId(){
		return doctorId;
	}
	public String getName(){
		return doctorName;
	}
	public int getFee(){
		return fee;
	}
	public ArrayList<ConsultationHours> getList(){
		return consultationList;
	}

	public String getDoctorToString(){
		return doctorId + "   " + doctorName;
	}
	
	public String getDoctorAndFeeToString(){
		return doctorId + "   " + doctorName + "   \t$" + fee;
	}
	
		
	//Setters
	public void setId(String dId){
		doctorId = dId;
	}
	public void setName(String dName){
		doctorName = dName;
	}


}