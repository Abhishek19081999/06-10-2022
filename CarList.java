/*
 Realize a class CarList, each of whose objects represents a list of cars to sell. 

A CarList object does not directly store the data about the cars to sell, but maintains the name of a text file in which such data are stored, according to the following format:

model
manufacturing year (year)
driven kilometers (km)
price

The class CarList should export the following methods:

• CarList(String filename) : constructor with a parameter of type String, representing the name of the file in which the data about the cars to sell are stored;

• int countNewCars() : that returns the number of new cars in the list of cars to sell;

• Car mostExpensiveCar() : that returns the Car object corresponding to the most expensive car in the list of cars to sell.

• void addCar(Car c) : that adds the car c to the end of the list of cars to sell.

• void remove(Car c) : that removes from the list of cars to sell the car whose data coincides with that of c, if such a car is present, and leaves the list unchanged otherwise.

 */


package com.file_handling.bll;

import java.io.*;

public class CarList {
	
	 private String filename;
	 
	//Single parameter constructor with file's name as a parameter
	  public CarList (String filename) {
	    this.filename = filename;
	  }
	  
	  //count of total cars 
	  public int countNewCars()  throws IOException {
	    FileReader fr = new FileReader(filename);
	    BufferedReader br = new BufferedReader(fr);

	    int count = 0;
	    Car c = Car.read(br);
	    while (c != null) {
	      if (c.getKm() == 0)
	        count++;
	      c = Car.read(br);
	    }
	    br.close();
	    return count;
	  }
	  
	  //method for finding most expensive car
	  public Car mostExpensiveCar() throws IOException {

	    FileInputStream is = new FileInputStream(filename);
	    InputStreamReader isr = new InputStreamReader(is);
	    BufferedReader br = new BufferedReader(isr);

	    double max = 0;
	    Car cmax = null;
	    Car c = Car.read(br);
	    while (c != null) {
	      if (c.getPrice() > max) {
	        max = c.getPrice();
	        cmax = c;
	      }
	      c = Car.read(br);
	    }
	    br.close();
	    return cmax;
	  }
	  
	  //method for adding a car
	  public void addCar(Car c) throws IOException {
	    FileWriter fw = new FileWriter(filename, true); 
	    PrintWriter pw = new PrintWriter(fw);

	    pw.println(c.getModel());
	    pw.println(c.getYear());
	    pw.println(c.getKm());
	    pw.println(c.getPrice());
	    pw.close();
	  }
	  
	  //method for removing a car
	  public void removeCar(Car c) throws IOException {
	    File f = new File(filename);
	    FileInputStream is = new FileInputStream(f);
	    InputStreamReader isr = new InputStreamReader(is);
	    BufferedReader br = new BufferedReader(isr);

	   
	    File ftemp = new File("new cars.txt");
	    FileOutputStream os = new FileOutputStream(ftemp);
	    PrintWriter pw = new PrintWriter(os);

	    Car curr = Car.read(br);
	    while (curr != null) {
	      if (!curr.equalTo(c)) {
	        pw.println(curr.getModel());
	        pw.println(curr.getYear());
	        pw.println(curr.getKm());
	        pw.println(curr.getPrice());
	      }
	      curr = Car.read(br);
	    }
	    br.close();
	    pw.close();

	    ftemp.renameTo(f);
	  }

	

}
