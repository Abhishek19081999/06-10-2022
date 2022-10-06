/*
We want to realize a program for handling new and used cars to sell.

For each car to sell, the information about the car is stored on a text file.

Realize a class Car, to handle a single car.
 
Each car is characterized by the following information: 
	model,
	manufacturing year, 
	driven kilometers, 
	and price. 
	
New cars can be distinguished by the fact that the driven kilometers are 0.

The class Car should export the following methods:

• a constructor to construct a car object, given all the data about the car as parameters;

• suitable get-methods to obtain the data about the car;

• a toString method, which does overriding of the toString method inherited from Object, and returns a string containing the data about the car;

• boolean equalTo(Car c) : that returns true if the car coincides with the car c in all of its data, and false otherwise.

• public static Car read(BufferedReader br) throws IOException : that returns a Car object reading from the file.
*/


package com.file_handling.bll;

import java.io.*;

public class Car {
	
	 private String model;
	  private int year;
	  private int km;
	  private double price;
	  
	  //parameterized constructor for car with model,year,kilometer and price as parameters.
	  public Car(String model, int year, int km, double price) {
	    this.model = model;
	    this.year = year;
	    this.km=km;
	    this.price = price;
	  }
	  
	  //getting model name
	  public String getModel() {
	    return model;
	  }

	  //getting year of model
	  public int getYear() {
	    return year;
	  }

	  //getting kilometers driven
	  public int getKm() {
	    return km;
	  }

	  ///getting price of the car
	  public double getPrice() {
	    return price;
	  }
	  
	  @Override
	  public String toString() {
	    return "Car[model="+model + ", year: " + year + ", km: " + km + ", price: " + price+"]";
	  }

	  
	  public boolean equalTo(Car c) {
	    return this.model.equals(c.model) &&
	      this.year == c.year &&
	      this.km == c.km &&
	      this.price == c.price;
	  }

	  public static Car read(BufferedReader br) throws IOException {
	    String str = br.readLine();
	    if (str == null)
	      return null;
	    else
	      return new Car(str, Integer.parseInt(br.readLine()),
	                     Integer.parseInt(br.readLine()),
	                     Double.parseDouble(br.readLine()));
	  }

}
