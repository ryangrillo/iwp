package com.innerWorkings.utilities;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.innerWorkings.constants.Constants;
import com.innerWorkings.models.FeeAmounts;
import com.innerWorkings.models.InputObject;

public class CalculationsTest {
	 
	private InputObject inputObject;
	
	private FeeAmounts feeAmounts;

	    @Before
	    public void initJob() {
	       inputObject=  FileReadWrite.readJSONFileAndConvertToJava(Constants.JOBS_TEXT_FILE_PATH);
	    }
	    @Before
	    public void initFeeAmounts() {
	    	feeAmounts = FileReadWrite.readYamlFileAndConvertToJava(Constants.FEES_TEXT_FILE_PATH);
	    }

	@Test
	public void test_round_to_nearest_even_cent_with_odd_decimal_and_expect_even_result() {
		double testValue = 29.915;
		assertEquals(29.92, Calculations.roundToNearestEvenCent(testValue), 0.001);
	}
	@Test
	public void test_round_to_nearest_even_cent_with_even_decimal_and_expect_even_result() {
		double testValue = 314.622;
		assertEquals(314.62, Calculations.roundToNearestEvenCent(testValue), 0.001);
	}
	
	@Test
	public void test_round_to_nearest_even_cent_with_zero_and_expect_even_result() {
		double testValue = 0.00;
		assertEquals(0.00, Calculations.roundToNearestEvenCent(testValue), 0.001);
	}
	
	@Test
	public void test_round_to_nearest_cent_above_halfway_decimal_and_expect_next_decimal() {
		double testValue = 34.866;
		assertEquals(34.87, Calculations.roundToNearestCent(testValue), 0.001);
	}
	
	@Test
	public void test_round_to_nearest_cent_below_halfway_decimal_and_expect_lower_decimal() {
		double testValue = 518.864;
		assertEquals(518.86, Calculations.roundToNearestCent(testValue), 0.001);
	}
	
	@Test
	public void test_round_to_nearest_cent_with_zero_and_expect_zero() {
		double testValue = 0.00;		
		assertEquals(0.00, Calculations.roundToNearestCent(testValue), 0.001);
	}

	
	@Test
	public void test_get_margins_for_job1_and_expect_sixteen() {
		double testValue = 16.0;
		assertEquals(testValue, Calculations.getMargines(inputObject.getJobs().get(0), feeAmounts), 0.001);
		
	}
	@Test
	public void test_get_margins_for_job2_and_expect_eleven() {
		double testValue = 11.0;
		assertEquals(testValue, Calculations.getMargines(inputObject.getJobs().get(1), feeAmounts), 0.001);
		
	}
	@Test
	public void test_get_margins_for_job3_and_expect_sixteen() {
		double expectedValue = 16.0;
		assertEquals(expectedValue, Calculations.getMargines(inputObject.getJobs().get(2), feeAmounts), 0.001);
	}
	
	@Test
	public void test_calculateFinalTotalForEachJob_for_Job1_and_expect() {
		double expectedValue = 2940.3;
		assertEquals(expectedValue, Calculations.calculateFinalTotalForEachJob(inputObject.getJobs().get(0), feeAmounts), 0.001);
	}
	@Test
	public void test_calculateFinalTotalForEachJob_for_Job2_and_expect() {
		double expectedValue = 346.96;
		assertEquals(expectedValue, Calculations.calculateFinalTotalForEachJob(inputObject.getJobs().get(1), feeAmounts), 0.001);
	}
	@Test
	public void test_calculateFinalTotalForEachJob_for_Job3_and_expect() {
		double expectedValue = 24608.68;
		assertEquals(expectedValue, Calculations.calculateFinalTotalForEachJob(inputObject.getJobs().get(2), feeAmounts), 0.001);
	}
	
}
