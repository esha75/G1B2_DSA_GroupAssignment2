package Asignment1;

import java.util.Scanner;

public class Driver {

		// TODO Auto-generated method stub
		 public static void main(String[] args) {
		        System.out.println("Enter the total number of floors in the building: ");
		        Scanner sc = new Scanner(System.in) ;
		        int days = sc.nextInt();
		        int []floors = new int[days];
		        for(int i =0; i< days; i++) {
		            System.out.println("Enter the size of floor on day:"+ (i+1));
		            int floorSize = sc.nextInt();
		            floors[i] = floorSize;
		        }
		        AssembleFloor.calculateFloors(floors);

				sc.close();
		    }

}
