package com.parkingsystem;
import java.util.*;
public class ParkingHandler {
	
	public static int totSlots = 10;
	public static Map<String,List<Car>> colors = new HashMap<>();
	public static Car[] slots = new Car[totSlots];
	public static Map<String,Car> cars = new HashMap<>();
	public static Scanner sc = new Scanner(System.in);
	public static int filledSlots = 0;
	
	
	public void addCar(Car car) {
		
		if( slots.length == filledSlots ) 
		{
			System.out.println("Sorry, Parking is Full !!");
			return;
		}
		
		//adding in cars
		if(cars.containsKey(car.regNo)) {
			System.out.println("This Register no's Car is already inside the Parking !!\n Please check your register no and try again\n");
			return;
		}
		cars.put(car.regNo,car);
		
		int allocatedSlot = -1;
		
		//adding in slot
		for( int i = 0; i < totSlots; i++) {
			if(slots[i] == null) {
		       slots[i] = car;
		       allocatedSlot=i+1;
		       break;
			}
		}
		
		//adding in colors
		if( colors.containsKey(car.color)) colors.get(car.color).add(car);
		else colors.put(car.color, new ArrayList<>(Arrays.asList(car)));
		
	
		filledSlots++;
		
		System.out.println("--------------------- TICKET ---------------------");
		System.out.println("        Registration No : "+car.regNo.toUpperCase()+"    ");
		System.out.println("        Car No : "+car.color.toUpperCase()+"    ");
		System.out.println("        Allocated Slot No is "+allocatedSlot+"      ");
		System.out.println("---------------------------------------------------");
	}
	public void removeCar() {
		
		System.out.println("Enter Car Reg No: ");
		
		//removing from slot
		Car car = cars.remove(sc.next());
		
		if( car == null) {
			System.out.println("Car with this reg no doesn't exist!!");
			return;
		}
		//remove in colors
		
		if(colors.get(car.color).remove(car) ) {
			for( int i = 0; i < totSlots; i++) {
				if(slots[i]!= null && slots[i].regNo == car.regNo) {
			       slots[i] = null;
			       break;
				}
			}
			
			filledSlots--;
			System.out.println("Successfully Removed the Car!");
				
		}
		
	}
    public void regNosUsingColor() {
    	
    	
    	System.out.println("Enter Car Color : ");
    	String color = sc.next();
    	
    	if(colors.containsKey(color)) {
    		System.out.println("_____________________________________");
    		List<Car> cars = colors.get(color);
    		System.out.println("Cars with this color are :");
    		cars.forEach(val->{System.out.println(val.regNo);});
    		System.out.println("_____________________________________");
    	}
    	else {
    		System.out.println("Car with this color doesn't exist!!");
    	}
    }
    public void getSlotNo() {
    	System.out.println("Enter Register No :");
    	String regno = sc.next();
    	
    	if(!cars.containsKey(regno)) {
    		System.out.println("Car with this register number doesn't exist!!");
    		return;
    	}
    	
    	
    			System.out.println("Car is Parked in Slot No :"+getSlotNo(regno));
    		
    	
    }
    private int getSlotNo(String regno) {
    	
    	
    	for(int i = 0; i < totSlots;i++) {
    		if( slots[i]!= null && slots[i].regNo.equals(regno)) {
    			
    			return i+1;
    		}
    	}
    	
    	return -1;
    }
    public void getSlotnosUsingColor() {
    	System.out.println("Enter car color : ");
    	
    	String color = sc.next();
    	
    	if(!colors.containsKey(color)) {
    		System.out.println("Cars with this color doesn't exist!!");
    		return;
    	}
    	System.out.println("----------------------------------------------");
    	colors.get(color).forEach(car->{System.out.println("At Slot No : "+getSlotNo(car.regNo));});
    	System.out.println("----------------------------------------------");
    }
}

