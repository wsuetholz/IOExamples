/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author wsuetholz
 */
public class ReadMailList {

    public static void main(String[] args) {
	String fileName = File.separatorChar + "tmp" + File.separatorChar + "lab1" + File.separatorChar + "maillist.txt";
	boolean append = true;

	String fullName = null;
	String firstName = null;
	String lastName = null;
	String address = null;
	String cityStateZip = null;
	String city = null;
	String state = null;
	String zip = null;

	String[] nameParts = null;
	String[] cszParts = null;
	String[] szParts = null;

	BufferedReader fileReader = null;
	try {
	    fileReader = new BufferedReader(new FileReader(fileName));

	    do {
		fullName = fileReader.readLine();
		if (fullName == null) {
		    continue;
		}
		address = fileReader.readLine();
		cityStateZip = fileReader.readLine();

		nameParts = fullName.split(" ");
		if (nameParts != null && nameParts.length > 1) {
		    firstName = nameParts[0];
		    lastName = nameParts[1];
		}
		cszParts = cityStateZip.split(",");
		if (cszParts != null) {
		    city = cszParts[0];
		    if (cszParts.length > 1) {
			szParts = cszParts[1].trim().split(" ");
			if (szParts != null) {
			    state = szParts[0];
			    if (szParts.length > 1) {
				zip = szParts[1];
			    }
			}
		    }
		}
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Address: " + address);
		System.out.println("City: " + city);
		System.out.println("State: " + state);
		System.out.println("Zip: " + zip);
		firstName = null;
		lastName = null;
		address = null;
		city = null;
		state = null;
		zip = null;
	    } while (fullName != null);
	} catch (IOException ioe) {
	    System.out.println("Problem reading or opening file");
	    ioe.printStackTrace();
	} finally {
	    try {
		fileReader.close();
	    } catch (IOException ioe) {
		System.out.println("Problem closing file");
		ioe.printStackTrace();
	    }
	}

	PrintWriter fileWriter = null;
	File data = new File(fileName);

	try {
	    fileWriter = new PrintWriter(
		    new BufferedWriter(
			    new FileWriter(data, append)));
	    fileWriter.println("Mary Jones");
	    fileWriter.println("1 First Street");
	    fileWriter.println("Milwaukee, WI 53333");
	} catch (IOException ioe) {
	    System.out.println("Problem writing or opening file");
	    ioe.printStackTrace();
	} finally {
	    fileWriter.close();
	}

    }

}
