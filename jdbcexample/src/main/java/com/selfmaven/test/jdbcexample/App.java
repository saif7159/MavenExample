package com.selfmaven.test.jdbcexample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class App 
{
    public static void main( String[] args ) throws NumberFormatException, IOException
    {
    	Service s = new ServiceImpl();
    	int choice;
    	List<Cars> list = new ArrayList<Cars>();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
    	System.out.println("Enter Choice\n1. Create Car:\n2. See all cars:\n3. Find Car by ID:\n4. Delete car entry by ID\n5. Exit:");
        choice = Integer.parseInt(br.readLine());
        switch(choice)
        {
         case 1: System.out.println("Enter car name:");
         		 String name = br.readLine();
         		 System.out.println("Enter engine type:");
         		 String type = br.readLine();
         		 System.out.println("Enter transmission type:");
         		 String trans = br.readLine();
         		 String uid = UUID.randomUUID().toString();
         		 String[] id = uid.split("-");
         		 s.createCar(name, type, trans, id[0]+id[1]);
         		 break;
         		 
         case 2: System.out.println("Displaying car...\n");
         		 list = s.getAllCars();
         		 Iterator i = list.iterator();
         		 while(i.hasNext())
         		 {
         			 System.out.println(i.next());
         		 }
         		 break;
         		 
         case 3: System.out.println("Enter the UID for the car:");
         		 String newid = br.readLine();
         		 Cars c = null;
         		 c = s.findById(newid);
         		 if(c==null)
         		 {
         			 System.out.println("Invalid uid");
         		 }else
         		 {
         		 System.out.println("\n"+c);
         		 }
         		 break;
         		 
         case 4: System.out.println("Enter ID to delete car entry");
          		 String delid = br.readLine();
          		 s.deleteById(delid);
          		 break;
          		 
         case 5: System.exit(0);
 		 		 break;
         		 
         default : break;
        }
        System.out.println("");
        }while(choice!=0);
        
    }
}
