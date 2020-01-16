package com.selfmaven.test.jdbcexample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.mavencar.customer.Customer;

public class App 
{
    public static void customerOptions(Service s) throws NumberFormatException, IOException
    {	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	List<Cars> list = new ArrayList<Cars>();
    	int choice = 0;
    		do {
    		System.out.println("Customer options\nEnter Choice\n1. View All Cars\n2. Find Car by UID:\n3. Find Car by Name:\n4. Book a car:\n0. Exit Customer portal");
    		choice = Integer.parseInt(br.readLine());
    		switch(choice)
    		{
    		case 1:System.out.println("Displaying Cars...\n");
    		       list = s.getAllCars();
    		       Iterator i = list.iterator();
		    		 while(i.hasNext())
		    		 {
		    			 
		    			 System.out.println(i.next());
		    			 System.out.println("*********************************");
		    		 }
		    		 break;
		    		
    		case 2:System.out.println("Enter the UID for the car:");
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
		    		 
    		case 3:System.out.println("Enter car name: ");
    				String findname = br.readLine();
    				List<Cars> carname;
			   		 carname = s.findByName(findname);
			   		 if(carname==null)
			   		 {
			   			 System.out.println("Invalid car name");
			   		 }else
			   		 {
			   			 Iterator it = carname.iterator();
			   			 while(it.hasNext()) {
			   			 System.out.println("\n"+it.next());}
			   		 }
			   		 break;
    		
    		case 4: System.out.println("Enter car ID to book");
    		 		
			   		 
			    		}
    	}while(choice!=0);
    }
	public static void main( String[] args ) throws NumberFormatException, IOException
    {
    	Service s = new ServiceImpl();
    	int choice = 0;
    	//int customerchoice = 0;
    	List<Cars> list = new ArrayList<Cars>();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
    	System.out.println("Enter Choice:\n1. Customer Portal\n2. Seller's Portal:");
        int portal = Integer.parseInt(br.readLine());
        if(portal == 1)
        {	int custchoice = 0;
        	boolean result = false;
        	System.out.println("Enter choice:\n1. Login:\n2. Create New User:");
        	custchoice = Integer.parseInt(br.readLine());
        	switch(custchoice)
        	{
        	case 1: System.out.println("Enter customer id and password");
        	        String id = br.readLine();
        	        String pass = br.readLine();
        	        result=s.validatePassword(id, pass);
        	        if(result)
        	        {
        	        	customerOptions(s);
        	        }
        	      
        	        break;
        	case 2: System.out.println("Enter customer name:");
        	 		String name = br.readLine();
        	 		System.out.println("Enter password");
        	 		String password = br.readLine();
        	 		String customerId = UUID.randomUUID().toString();
        	 		String carray[]= customerId.split("-");
        	 		String bookingId = null;
        	 		Customer cust = s.createCustomer(name, carray[0], bookingId, password);
        	 		break;
        	}
        }
        else if(portal == 2){
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
         		 System.out.println("Enter the production units");
         		 int units = Integer.parseInt(br.readLine());
         		 s.createCar(name, type, trans, id[0]+id[1], units,0);
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
          		 List<Cars> carname;
        		 carname = s.findByName(findname);
        		 if(carname==null)
        		 {
        			 System.out.println("Invalid car name");
        		 }else
        		 {
        			 Iterator it = carname.iterator();
        			 while(it.hasNext()) {
        			 System.out.println("\n"+it.next());}
        		 }
        		 break;
          		 
         case 0: 
		 	     break;	 
          		 
         		 
         default : break;
        }
        System.out.println("");
        }
        else {
        	System.out.println("Invalid input");
        }
        }while(choice!=0);
        
    }
}
