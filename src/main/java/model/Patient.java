package model;

import java.time.LocalTime;

public class Patient implements Comparable<Patient>{
	
	public enum ColorCode{
		NEW, //in triage
		WHITE, YELLOW, RED, BLACK, //in sala d'attesa
		TREATING, //dentro studio medico
		OUT //a casa (abbandonato o curato)
	};
	
	private int num;
	private LocalTime arrivalTime;
	private ColorCode color;
	
	public Patient(int num, LocalTime arrivalTime, ColorCode color) {
		super();
		this.num = num;
		this.arrivalTime = arrivalTime;
		this.color = color;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public ColorCode getColor() {
		return color;
	}

	public void setColor(ColorCode color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Patient " + num + ", " + arrivalTime + ", " + color ;
	}

	@Override
	public int compareTo(Patient o) {
		
		if(this.color.equals(o.color))
			return this.arrivalTime.compareTo(o.arrivalTime);
		else if(this.color.equals(Patient.ColorCode.RED))
			return -1;
		else if(o.color.equals(Patient.ColorCode.RED))
			return 1;
		else if(this.color.equals(Patient.ColorCode.YELLOW)) //Y -W
			return -1;
		else // W - Y
			return 1;
		
	}
}
