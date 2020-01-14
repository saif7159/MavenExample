package com.selfmaven.test.jdbcexample;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cars {
private String carname;
private String enginetype;
private String transmissionstyle;
@Override
public String toString() {
	return "Car Name: " + carname + "\nEngine Type:" + enginetype + "\nTransmission Style: " + transmissionstyle;
}


}
