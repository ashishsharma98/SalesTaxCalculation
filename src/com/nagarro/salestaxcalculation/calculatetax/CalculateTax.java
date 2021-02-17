package com.nagarro.salestaxcalculation.calculatetax;

import com.nagarro.salestaxcalculation.constants.Constants;
import com.nagarro.salestaxcalculation.enums.ItemType;
import com.nagarro.salestaxcalculation.models.Items;

public class CalculateTax {

	public void calculateCost(Items items) {

		double salesTax = 0;
		double perItemTax = 0;
		double allTotal = 0;
		double finalCost = 0;
		double importedCost = 0;
		double totalTax = 0;

		/* Calculation for Raw Type */
		if (ItemType.raw.toString().equalsIgnoreCase(items.getType())) {
			salesTax = (12.5 * items.getPrice()) / 100;
			perItemTax = items.getQuantity() * salesTax;
			allTotal = perItemTax;
		}

		/* Calculation for Manufactured Type */
		if (ItemType.manufactured.toString().equalsIgnoreCase(items.getType())) {
			salesTax = ((12.5 * items.getPrice()) / 100)
					+ 2 * (((12.5 * items.getPrice()) / 100) + items.getPrice()) / 100;
			perItemTax = items.getQuantity() * salesTax;
			allTotal = perItemTax;
		}

		/* Calculation for Imported Type */
		if (ItemType.imported.toString().equalsIgnoreCase(items.getType())) {
			salesTax = (10 * items.getPrice()) / 100;
			perItemTax = items.getQuantity() * salesTax;
			finalCost = salesTax + perItemTax;
			if (finalCost <= 100) {
				/* If the final cost is up to 100 */
				importedCost = perItemTax + 5;
				allTotal = importedCost;
			} else if (finalCost > 100 && finalCost <= 200) {
				/* if final cost between 100 to 200 */
				importedCost = perItemTax + 10;
				allTotal = importedCost;
			} else {
				/* If the Final Cost exceed 200 */
				importedCost = perItemTax + ((5 * finalCost) / 100);
				allTotal = importedCost;
			}
		}

		System.out.println(Constants.ITEM_NAME + items.getName());
		System.out.println(Constants.ITEM_PRICE + items.getPrice());
		System.out.println(Constants.SALES_TAX + allTotal);

		/* calculate final price here */
		totalTax = allTotal + items.getPrice();

		/* display final price here */
		System.out.println(Constants.FINAL_PRICE + totalTax);

	}
}
