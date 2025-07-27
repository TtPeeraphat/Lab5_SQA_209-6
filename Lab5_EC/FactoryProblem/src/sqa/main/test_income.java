package sqa.main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class test_income {

	 @ParameterizedTest(name = "TC{index}: impeller={0}, motor={1}, grill={2} => expected={3}")
	    @CsvSource({
	        // TC1-TC9: impeller valid (1000), motor valid/invalid, grill valid/invalid
	        "1000,300,500,29000",    // TC1: valid
	        "1000,300,499,-1",       // TC2: grill < 500
	        "1000,300,3001,-1",      // TC3: grill > 3000
	        "1000,299,500,-1",       // TC4: motor < 300
	        "1000,299,499,-1",       // TC5: motor < 300, grill < 500
	        "1000,299,3001,-1",      // TC6: motor < 300, grill > 3000
	        "1000,801,500,-1",       // TC7: motor > 800
	        "1000,801,499,-1",       // TC8: motor > 800, grill < 500
	        "1000,801,3001,-1",      // TC9: motor > 800, grill > 3000

	        // TC10-TC18: impeller < 1000 (999), motor valid/invalid, grill valid/invalid
	        "999,300,500,-1",        // TC10: impeller < 1000
	        "999,300,499,-1",        // TC11: impeller < 1000, grill < 500
	        "999,300,3001,-1",       // TC12: impeller < 1000, grill > 3000
	        "999,299,500,-1",        // TC13: impeller < 1000, motor < 300
	        "999,299,499,-1",        // TC14: impeller < 1000, motor < 300, grill < 500
	        "999,299,3001,-1",       // TC15: impeller < 1000, motor < 300, grill > 3000
	        "999,801,500,-1",        // TC16: impeller < 1000, motor > 800
	        "999,801,499,-1",        // TC17: impeller < 1000, motor > 800, grill < 500
	        "999,801,3001,-1",       // TC18: impeller < 1000, motor > 800, grill > 3000

	        // TC19-TC27: impeller > 5000 (5001), motor valid/invalid, grill valid/invalid
	        "5001,300,500,-1",       // TC19: impeller > 5000
	        "5001,300,499,-1",       // TC20: impeller > 5000, grill < 500
	        "5001,300,3001,-1",      // TC21: impeller > 5000, grill > 3000
	        "5001,299,500,-1",       // TC22: impeller > 5000, motor < 300
	        "5001,299,499,-1",       // TC23: impeller > 5000, motor < 300, grill < 500
	        "5001,299,3001,-1",      // TC24: impeller > 5000, motor < 300, grill > 3000
	        "5001,801,500,-1",       // TC25: impeller > 5000, motor > 800
	        "5001,801,499,-1",       // TC26: impeller > 5000, motor > 800, grill < 500
	        "5001,801,3001,-1"       // TC27: impeller > 5000, motor > 800, grill > 3000
	    })
	    void strongRobustECTest(int impeller, int motor, int cover, double expectedIncome) {
	        Income income = new Income();
	        double actualIncome = income.calculateIncome(impeller, motor, cover);

	        assertEquals(expectedIncome, actualIncome, 0.001, 
	            String.format(
	                "Expected Result: ผลที่ควรได้คือ %.0f บาท | แต่ Actual Result คือ %.0f บาท | Input: impeller=%d, Motor=%d, Cover=%d",
	                expectedIncome, actualIncome, impeller, motor, cover
	            )
	        );
	    }
	}