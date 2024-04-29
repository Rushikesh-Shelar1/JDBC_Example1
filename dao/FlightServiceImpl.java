package dao;

import service.flight_service;
import utility.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import exception.InvalidIdException;
import model.Flight;

public class FlightServiceImpl implements flight_service {

	private static final Flight Flight = null;
	private model.Flight f1;

	@Override
	public Flight addFlight(Flight flight) {
		Connection con=DBUtil.getConnection();
		try
		{
			final String insertQuery="INSERT INTO FlightInfo VALUES(?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(insertQuery);
			ps.setInt(1, flight.getFlightid());
			ps.setString(2,flight.getFlighttype());
			ps.setDouble(3,flight.getFlightPrice());
			ps.setString(4, flight.getSourceAirport());
			ps.setString(5, flight.getDestinationAirport());
			java.util.Date d1=flight.getFlydate();
			long timesinmillis=d1.getTime();
			java.sql.Date flyDate=new java.sql.Date(timesinmillis);
			ps.setDate(6,flyDate);
			int insertStatus=ps.executeUpdate();
			if(insertStatus>0) {
				return flight;
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Set<Flight> getAllflights() throws Exception{
		
		Set<Flight> setOfFlight=new TreeSet();
		Connection con=DBUtil.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from FlightInfo");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			
			int id=rs.getInt("flight_id");
			String fType=rs.getString(2);
			double fPrice=rs.getDouble(3);
			String source= rs.getString(4);
			String dest=rs.getString(5);
			java.sql.Date d1=rs.getDate(6);
			java.util.Date utilDate=new java.util.Date(d1.getTime());
			
			//we will bind all data with flight object
			Flight f=new Flight(id,fType,fPrice,source,dest,utilDate);
			setOfFlight.add(f);
		}		
		return setOfFlight;
	}

	@Override
	public Flight getFlightById(int id) throws InvalidIdException {
		
		Connection con=DBUtil.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from FlightInfo where flight_id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
			
				
				int id1=rs.getInt("flight_id");
				String fType=rs.getString(2);
				double fPrice=rs.getDouble(3);
				String source1= rs.getString(4);
				String dest=rs.getString(5);
				java.sql.Date d1=rs.getDate(6);
				java.util.Date utilDate=new java.util.Date(d1.getTime());
				
				Flight f1=new Flight(id1, fType, fPrice, source1, dest, utilDate);
//				f1.setFlightid(id1);
//				int k=f1.getFlightid();
				return f1;
			}
		}
//				if(id1==(Integer)null) {
//					throw new InvalidIdException("the id is not available");
//				}
//				else {
//					System.out.println("the id is avilable in the list ");
//				}
//			//}
//			
//		}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		throw new InvalidIdException("the id is not available");
		
		
		
	}

	@Override
	public List<Flight> searchFlight(String source, String destination) {
		// TODO Auto-generated method stub
		List<Flight> listOfFlight=new ArrayList();
		try {
		Connection con=DBUtil.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from FlightInfo where source_airport=? and dest_airport=?");
		ps.setString(1, source);
		ps.setString(2, destination);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			
			int id=rs.getInt("flight_id");
			String fType=rs.getString(2);
			double fPrice=rs.getDouble(3);
			String source1= rs.getString(4);
			String dest=rs.getString(5);
			java.sql.Date d1=rs.getDate(6);
			java.util.Date utilDate=new java.util.Date(d1.getTime());
			
			//we will bind all data with flight object
			Flight f=new Flight(id,fType,fPrice,source1,dest,utilDate);
			listOfFlight.add(f);
		}		
		
	}catch(Exception e) {
		System.out.println(e);
	}
		return listOfFlight;
		
	}

	@Override
	public int updateFlight(int flight, Flight newFlight) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Flight> listByPriceOrder() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
