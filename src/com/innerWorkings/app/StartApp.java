package com.innerWorkings.app;

import java.io.IOException;

import com.innerWorkings.constants.Constants;
import com.innerWorkings.helper.Helper;

public class StartApp {
	public static void main(String[] args) throws IOException {
		
		Helper helper = new Helper();
		helper.run(Constants.JOBS_TEXT_FILE_PATH);
	}
}
