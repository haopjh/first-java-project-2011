/*  Done by: 	Peh Jun Hao
	Student No.:S8930045B
	Email: 		junhao.peh.2010
*/

import java.util.*;

public class ConsultationHours{
	
	String dayOfWeek;
	int startHour;
	int endHour;
	
	public ConsultationHours(String day, int sHour, int eHour){
		dayOfWeek = day;
		startHour = sHour;
		endHour = eHour;
	}
	
	//Getters
	public String getDayOfWeek(){
		return dayOfWeek;
	}
	public int getStartHour(){
		return startHour;
	}
	public int getEndHour(){
		return endHour;
	}
	
	//Setters
	public void setDayOfWeek(String day){
		dayOfWeek = day;
	}
	public void setStartHour(int sHour){
		startHour = sHour;
	}
	public void setEndHour(int eHour){
		endHour = eHour;
	}
	
	public String toString(){
		return dayOfWeek + " " + startHour + "00-" + endHour + "00";
	}
	
}