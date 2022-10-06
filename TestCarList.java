package com.file_handling.bll;
import java.io.File;
public class TestCarList {

	public static void main(String[] args) {
		try {
			Car c1 = new Car("Audi A5",2014,6000,1700000);
			Car c2 = new Car("BMW",2010,55000,1500000);
			Car c3 = new Car("MG Hector",2022,0,700000);
			Car c4 = new Car("Kia Sonet",2012,35000,850000);
			Car c5 = new Car("Maruti 800",2005,0,30000);
			Car c6 = new Car("Tata Harrier",2010,100000,650000);
			Car c7 = new Car("Rolls Royce",2013,35000,3500000);
			Car c8 = new Car("Honda City",2007,250000,300000);
			Car c9 = new Car("Kia Sonet",2022,0,450000);
			Car c10= new Car("Tata Harriers",2010,356200,400000);
			
		
			//Creating the array to store objects of car class
			Car [] cars1 = new Car[] {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10};
			
			//create new file and delete the file if it already exists.	
			File f = new File("cars.txt");
			f.delete();
			
			//Creating the object of CarList
			CarList carList = new CarList("cars.txt");
			
			for(Car c : cars1) {
				carList.addCar(c);
			}
			
			// Total no. of new cars
			System.out.println("New Cars : " + carList.countNewCars());
			
			//shows most expensive car.
			System.out.println("Most expensive Car : " +carList.mostExpensiveCar());
			
			//removing a car and again counting total number of new cars
			carList.removeCar(c9);
			System.out.println("After removing new Cars: " +carList.countNewCars());
		
			}
			catch(Exception ex) { 
			// for any Exception
				System.out.println(ex.getMessage());
			}

	}
}
