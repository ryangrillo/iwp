package com.innerWorkings.utilities;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.innerWorkings.models.FeeAmounts;
import com.innerWorkings.models.InputObject;

public class FileReadWrite {

	public static InputObject readJSONFileAndConvertToJava(String path) {
		ObjectMapper mapper = new ObjectMapper();
		InputObject inputObject = null;

		try {
			inputObject = mapper.readValue(new File(path), InputObject.class);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputObject;

	}
	public static FeeAmounts readYamlFileAndConvertToJava(String path) {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		FeeAmounts feeAmounts = null;
        try {
            feeAmounts = mapper.readValue(new File(path), FeeAmounts.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
		return feeAmounts;
	}
}