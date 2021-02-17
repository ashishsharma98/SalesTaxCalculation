package com.nagarro.salestaxcalculation.calculatetax;

import java.util.Scanner;

import com.nagarro.salestaxcalculation.constants.Constants;
import com.nagarro.salestaxcalculation.enums.ItemType;
import com.nagarro.salestaxcalculation.models.Items;

public class UserInput {

	private final Scanner scanner = new Scanner(System.in);

	public void getUserInput() {

		try {

			while (true) {

				/* Check if Name is Alphabet or Not */
				System.out.println(Constants.ITEM_NAME);
				String name = scanner.next().toLowerCase();

				/* Check if Price is Numeric or Not */
				System.out.println(Constants.ITEM_PRICE);
				Double price = scanner.nextDouble();

				/* Check if Quantity is Numeric or Not */
				System.out.println(Constants.ITEM_QUANTITY);
				Integer quantity = scanner.nextInt();

				/* Choose the Item Type */
				System.out.println(Constants.ITEM_TYPE);
				String itemType = scanner.next();
				if (!((ItemType.raw.toString().equalsIgnoreCase(itemType))
						|| (ItemType.manufactured.toString().equalsIgnoreCase(itemType))
						|| (ItemType.imported.toString().equalsIgnoreCase(itemType)))) {
					throw new Exception();
				}

				Items item = new Items(name, price, quantity, itemType);

				/* CalculateTax object for Calculation */
				CalculateTax calculate = new CalculateTax();
				calculate.calculateCost(item);

				/* User Choice for continue */
				System.out.println(Constants.USER_CHOICE);
				String userChoice = scanner.next().toLowerCase();
				if (userChoice.equals(Constants.NO)) {
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
