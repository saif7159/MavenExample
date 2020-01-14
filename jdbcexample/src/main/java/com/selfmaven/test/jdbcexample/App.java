package com.selfmaven.test.jdbcexample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class App 
{
    public static void main( String[] args ) throws NumberFormatException, IOException
    {
    	Service s = new ServiceImpl();
    	int choice;
    	List<Cars> list = new ArrayList<Cars>();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
    	System.out.println("1. Create Car:\n2. See all cars:\n3. Exit:\nEnter Choice ");
        choice = Integer.parseInt(br.readLine());
        switch(choice)
        {
         case 1: System.out.println("Enter car name:");
         		 String name = br.readLine();
         		 System.out.println("Enter engine type:");
         		 String type = br.readLine();
         		 System.out.println("Enter transmission type:");
         		 String trans = br.readLine();
         		 s.createCar(name, type, trans);
         		 break;
         case 2: System.out.println("Displaying car...");
         		 list = s.getAllCars();
         		 Iterator i = list.iterator();
         		 while(i.hasNext())
         		 {
         			 System.out.println(i.next());
         		 }
         		 break;
         case 3: System.exit(0);
 		 		 break;
         		 
         default : break;
        }
        }while(choice!=0);
        
    }
}
