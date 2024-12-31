package com.parkingsystem;
import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		Scanner sc = new Scanner(System.in);
		int query;
		System.out.println("-------- Welcome to Parking System --------");
		ParkingHandler park = new ParkingHandler();
		while(true) {
			
			System.out.println("1.Add New Car\n2.Remove Car\n3.Get Reg Numbers using car color\n4.Get Slot No of Car\n5.Get Slot Numbers using car color\n6.Exit\nEnter Input:");
			query = sc.nextInt();
			
			switch(query) {
			case 1:
				park.addCar(Car.getDetails());
				break;
			case 2:
				park.removeCar();
				break;
			case 3:
				park.regNosUsingColor();
				break;
			case 4:
				park.getSlotNo();
				break;
			case 5:
				park.getSlotnosUsingColor();
				break;
			case 6:
				return;
			default:
				System.out.println("Enter a valid input");
				break;
			}
		}
		
	}

}
