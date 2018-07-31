package com.innerWorkings.utilities;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.innerWorkings.constants.Constants;
import com.innerWorkings.models.OutputObject;
import com.innerWorkings.models.PaidItem;

public class CreateInvoiceFile {
	
	public static void writeToFile(List<OutputObject> outputObjects) throws IOException {
		String file = Constants.WRITE_TO_FILE_PATH;
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file))) {
        	writer.write("***********   Invoice   ***********" + '\n' + '\n');
        	for (OutputObject outputObject : outputObjects) {
        		writer.write("Job " +outputObject.getId() + ":" + '\n');
        		List<PaidItem> paidItems = outputObject.getPaidItems();
        		for (PaidItem paidItem : paidItems) {
					writer.write(paidItem.getName() + " : " + paidItem.getFinalPriceWithSalesTax() + '\n');
				}
        		writer.write("total: " + outputObject.getTotal());
        		writer.write('\n');
        		writer.write('\n');
        		
        	
			}
        } 
    }
}
