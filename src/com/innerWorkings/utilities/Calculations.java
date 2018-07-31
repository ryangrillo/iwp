package com.innerWorkings.utilities;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.innerWorkings.constants.Constants;
import com.innerWorkings.models.FeeAmounts;
import com.innerWorkings.models.InputObject;
import com.innerWorkings.models.Item;
import com.innerWorkings.models.Job;
import com.innerWorkings.models.OutputObject;
import com.innerWorkings.models.PaidItem;

public class Calculations {

	public static List<OutputObject> getReturnObject(InputObject inputObject, FeeAmounts feeAmounts) {
		List<PaidItem> paidItems;
		List<OutputObject> outputObjects = new ArrayList<OutputObject>();

		double total = 0;
		for (Job job : inputObject.getJobs()) {
			paidItems = createTaxedItems(job.getItems(), feeAmounts);
			total = calculateFinalTotalForEachJob(job, feeAmounts);
			DecimalFormat df = new DecimalFormat(Constants.DECIMAL_FORMAT);
			String formattedTotal = df.format(total);
			OutputObject outputObject = new OutputObject(paidItems, formattedTotal, job.getId());
			outputObjects.add(outputObject);
		}
		return outputObjects;
	}

	public static List<PaidItem> createTaxedItems(List<Item> items, FeeAmounts feeAmounts) {
		List<PaidItem> calculatedItems = new ArrayList<>();
		double salesTax = feeAmounts.getSalesTax();
		for (Item item : items) {
			if (item.isExempt()) {
				double rounded = roundToNearestCent(item.getPrice());
				DecimalFormat df = new DecimalFormat(Constants.DECIMAL_FORMAT);
				String formattedTotal = df.format(rounded);
				PaidItem paidItem = new PaidItem(item.getName(), formattedTotal);
				calculatedItems.add(paidItem);
			} else {
				double rounded = roundToNearestCent(item.getPrice());
				DecimalFormat df = new DecimalFormat(Constants.DECIMAL_FORMAT);
				String formattedTotal = df.format((rounded * (1 + (salesTax / 100))));
				PaidItem paidItem = new PaidItem(item.getName(), formattedTotal);
				calculatedItems.add(paidItem);
			}
		}
		return calculatedItems;
	}

	public static double getMargines(Job job, FeeAmounts feeAmounts) {
		double fee = feeAmounts.getBaseMargin();
		if (job.isHasExtraMargin()) {
			fee = feeAmounts.getExtraMargin() + fee;
		}
		return fee;
	}

	public static double calculateFinalTotalForEachJob(Job job, FeeAmounts feeAmounts) {
		double taxAdjusted = 0;
		double margin = getMargines(job, feeAmounts);
		double salesTax = feeAmounts.getSalesTax();
		double total = 0;
		double rounded = 0;
		List<Item> items = job.getItems();
		for (Item item : items) {
			if (item.isExempt()) {
				taxAdjusted = item.getPrice() * (margin / 100 + 1);
				total = total + taxAdjusted;
			} else {
				taxAdjusted = item.getPrice() * (((margin / 100 + salesTax / 100)) + 1);
				total = total + taxAdjusted;
			}
			rounded = roundToNearestEvenCent(total);
		}
		return rounded;
	}

	public static double roundToNearestEvenCent(double amount) {
		// For final cost
		double result = (Math.round((amount * 100) / 2) * 2) / 100.00;
		return result;
	}

	public static double roundToNearestCent(double amount) {
		// for individual items
		double result = Math.round(amount * 100) / 100.00;
		return result;
	}
}
