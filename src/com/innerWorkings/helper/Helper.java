package com.innerWorkings.helper;

import java.io.IOException;
import java.util.List;

import com.innerWorkings.constants.Constants;
import com.innerWorkings.models.FeeAmounts;
import com.innerWorkings.models.InputObject;
import com.innerWorkings.models.OutputObject;
import com.innerWorkings.utilities.Calculations;
import com.innerWorkings.utilities.CreateInvoiceFile;
import com.innerWorkings.utilities.FileReadWrite;

public class Helper {
	
	public Helper(String textFilePath) {}

	public Helper() {}

	public void run(String path) throws IOException {
		FeeAmounts feeAmounts = FileReadWrite.readYamlFileAndConvertToJava(Constants.FEES_TEXT_FILE_PATH);
		InputObject inputObject =  FileReadWrite.readJSONFileAndConvertToJava(path);
		List<OutputObject> outputObjects = Calculations.getReturnObject(inputObject, feeAmounts);
		CreateInvoiceFile.writeToFile(outputObjects);
	}
}
