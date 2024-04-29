package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import dao.FlightServiceImpl;
import exception.InvalidIdException;
import model.Flight;
import service.flight_service;

public class FlightApp {

	public static void main(String[] args) throws ParseException {
		flight_service service =new FlightServiceImpl();
		
		Scanner sc=new Scanner (System.in);
		/*System.out.println("enter unique flight id");
		int fid=sc.nextInt();
		System.out.println("enter flight bus type");
		String fbus=sc.next();
		System.out.println("enter price of the flight id");
		double fprice=sc.nextDouble();
		System.out.println("enter the flight source");
		String src=sc.next();
		System.out.println("enter flight destination ");
		String dest=sc.next();
		System.out.println("enter fly date");
		String fDate1=sc.next();
		
		//now converting the String data type into util data type
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		Date flyDate=sdf.parse(fDate1);

		
		Flight flight=new Flight(fid,fbus,fprice,src,dest,flyDate);
		System.out.println(flight);
		
		//calling the addFlight() method
		Flight fobj=service.addFlight(flight);
		if(fobj!=null) {
			System.out.println("data has been inserted");
		}
		else
		{
			System.out.println("not able to store the data");
		}
		*/
		
		
		// call getAllFlight() method
		
		/*
		try {
			service.getAllflights().forEach(f->System.out.println(f));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//search 
		System.out.println("enter the source and distination of flight");
		String src=sc.next();
		String dest=sc.next();
		service.searchFlight(src, dest).forEach(f1->System.out.println(f1));;
		*/
		
		//getFlightId
		System.out.println("enter the flight id");
		int id=sc.nextInt();
		try {
			
			Flight fobj=service.getFlightById(id);
			System.out.println(fobj);
		} catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			((Iterable<Flight>) service.getFlightById(id)).forEach(f1->System.out.println(f1));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		

	}

}
