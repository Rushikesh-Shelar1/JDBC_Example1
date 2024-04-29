package service;

import java.util.List;
import java.util.Set;

import exception.InvalidIdException;
import model.Flight;

public interface flight_service {
	//this method will add Flight details in DB 
	Flight addFlight(Flight flight);
	Set<Flight> getAllflights()throws Exception;
	Flight getFlightById(int id) throws InvalidIdException;
	List<Flight> searchFlight(String source,String destination);
	int updateFlight(int flight,Flight newFlight);
	List<Flight> listByPriceOrder();

}
