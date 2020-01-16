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
    	System.out.println("Enter Choice\n1. Create Car:\n2. See all Cars:\n3. Find Car by ID:\n4. Delete Car entry by ID:\n5. Update Car details:\n6. Find Car by Name:\n0. Exit:");
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
         		 
         case 2: System.out.println("Displaying Cars...\n");
         		 list = s.getAllCars();
         		 Iterator i = list.iterator();
         		 while(i.hasNext())
         		 {
         			 
         			 System.out.println(i.next());
         			 System.out.println("*********************************");
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
          		 
         case 5: System.out.println("Enter ID to update");
        	     String upid = br.readLine();
        	     String cname = null;
        	     String engine = null;
        	     String transt = null;
 		 		 int upchoice = 0;
        	     do {
 		 			 System.out.println("Enter Choice\n1. Update Car name\n2. Update Engine Type\n3. Update transmission type\n0. Exit update");
 		 			 upchoice = Integer.parseInt(br.readLine());
 		 			 switch(upchoice)
 		 			 {
 		 			 case 1: System.out.println("Enter car name");
 		 			      	 cname = br.readLine();
 		 			      	 break;
 		 			 case 2: System.out.println("Enter engine type");
 			      	         engine = br.readLine();
 			      	         break;
 		 			 case 3: System.out.println("Enter transmission type");
 			      	         transt = br.readLine();
 			      	         break;
 		 			 default: break;
 		 			 }
 		 			 System.out.println("Updated\n"+s.updateById(upid, cname, engine, transt, upchoice));
 		 		  	}while(upchoice!=0);
        	      break;
         
         case 6: System.out.println("Enter car name: ");
          		 String findname = br.readLine();
          		 Cars carname = null;
        		 carname = s.findByName(findname);
        		 if(carname==null)
        		 {
        			 System.out.println("Invalid car name");
        		 }else
        		 {
        		 System.out.println("\n"+carname);
        		 }
        		 break;
          		 
         case 0: 
		 	     break;	 
          		 
         		 
         default : break;
        }
        System.out.println("");
        }while(choice!=0);
        
    }
}
