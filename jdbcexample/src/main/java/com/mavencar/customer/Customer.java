package com.mavencar.customer;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Customer implements Serializable{
/**
	 * 
	 */
private static final long serialVersionUID = -2617027633917609836L;
private String customerName;
private String customerId;
private String bookingId;
private String password;


}
