package model;

import java.util.Date;

public class Flight implements Comparable<Flight> {
	private int flightid;
	private String flighttype;
	private double flightPrice;

	private String sourceAirport;

	private String destinationAirport;
	private Date flydate;
	
	@Override
	public String toString() {
		return "Flight [flightid=" + flightid + ", flighttype=" + flighttype + ", flightPrice=" + flightPrice
				+ ", sourceAirport=" + sourceAirport + ", destinationAirport=" + destinationAirport + ", flydate="
				+ flydate + "]";
	}


	public int getFlightid() {
		return flightid;
	}


	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}


	public String getFlighttype() {
		return flighttype;
	}


	public void setFlighttype(String flighttype) {
		this.flighttype = flighttype;
	}


	public double getFlightPrice() {
		return flightPrice;
	}


	public void setFlightPrice(double flightPrice) {
		this.flightPrice = flightPrice;
	}


	public String getSourceAirport() {
		return sourceAirport;
	}


	public void setSourceAirport(String sourceAirport) {
		this.sourceAirport = sourceAirport;
	}


	public String getDestinationAirport() {
		return destinationAirport;
	}


	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}


	public Date getFlydate() {
		return flydate;
	}


	public void setFlydate(Date flydate) {
		this.flydate = flydate;
	}


	
	
	
	public Flight(int flightid, String flighttype, double flightPrice, String sourceAirport, String destinationAirport,
			Date flydate) {
		super();
		this.flightid = flightid;
		this.flighttype = flighttype;
		this.flightPrice = flightPrice;
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
		this.flydate = flydate;
	}


	@Override
	public int compareTo(Flight obj) {
		//Flight flight=(Flight)obj;
		if(this.flightid>obj.flightid) {
			return 1;
		}
		// TODO Auto-generated method stub
		return -1;
	}

	

}
