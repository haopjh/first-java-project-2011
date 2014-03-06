/*  Done by: 	Peh Jun Hao
	Student No.:S8930045B
	Email: 		junhao.peh.2010
*/

public class Patient{

	private String patentId;
	private String patientName;
	private String bloodType;
	
	public Patient(){
	}
	
	public Patient(String pId, String pName, String pBloodType){
		patentId = pId;
		patientName = pName;
		bloodType = pBloodType;
	}
	
	//Getters
	public String getId(){
		return patentId;
	}
	public String getName(){
		return patientName;
	}
	public String getBloodType(){
		return bloodType;
	}
	
	public String toString(){
		return patentId + "   " + patientName + "   \t" + bloodType;
	}
	
	//Setters
	public void setId(String pId){
		patentId = pId;
	}
	public void setPatientName(String pName){
		patientName = pName;
	}
	public void setBloodType(String pBloodType){
		bloodType = pBloodType;
	}
	
}