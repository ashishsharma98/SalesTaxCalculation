package com.nagarro.salestaxcalculation;

import com.nagarro.salestaxcalculation.calculatetax.UserInput;

public class TaxApplication {

	public static void main(String[] args) {

		/* ItemDetails object to enter details and display result */
		UserInput userInput = new UserInput();
		userInput.getUserInput();
	}

}
