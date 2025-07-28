package sqa.main;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class ShippingVehicleTest {
    
    private ShippingVehicle shippingVehicle = new ShippingVehicle();
    
    static Stream<Arguments> provideTestCases() {
        return Stream.of(
            // TC01: 0, 0, 0 -> [0,0,0]
            Arguments.of("TC01", 0, 0, 0, Arrays.asList(0, 0, 0)),
            
            // TC02: 1, 0, 0 -> [1,0,0] (Large=0, Medium=0, Small=1)
            Arguments.of("TC02", 1, 0, 0, Arrays.asList(1, 0, 0)),
            
            // TC03: 0, 1, 0 -> [0,1,0] (Large=0, Medium=1, Small=0)
            Arguments.of("TC03", 0, 1, 0, Arrays.asList(0, 1, 0)),
            
            // TC04: 0, 0, 1 -> [0,0,1] (Large=1, Medium=0, Small=0)
            Arguments.of("TC04", 0, 0, 1, Arrays.asList(0, 0, 1)),
            
            // TC05: 100, 0, 0 -> [100,0,0]
            Arguments.of("TC05", 100, 0, 0, Arrays.asList(100, 0, 0)),
            
            // TC06: 0, 200, 0 -> [-1]
            Arguments.of("TC06", 0, 200, 0, Arrays.asList(-1)),
            
            // TC07: 0, 0, 501 -> [-1]
            Arguments.of("TC07", 501, 0, 0, Arrays.asList(-1)),
            
            // TC08: 101, 0, 0 -> [-1]
            Arguments.of("TC08", 101, 0, 0, Arrays.asList(-1)),
            
            // TC09: -1, 0, 0 -> [-1]
            Arguments.of("TC09",-1, 0, 0, Arrays.asList(-1)),
            
            // TC10: 0, -3, 0 -> [-1]
            Arguments.of("TC10", 0, -3, 0, Arrays.asList(-1)),
            
            // TC11: 0, 0, -2 -> [-1]
            Arguments.of("TC11", 0, 0, -2, Arrays.asList(-1)),
            
            // TC12: 99, 0, 6 -> [99,0,6]
            Arguments.of("TC12", 99, 0, 6, Arrays.asList(99, 0, 6)),
            
            // TC13: 90, 10, 0 -> [90,10,0]
            Arguments.of("TC13", 90, 10, 0, Arrays.asList(90, 10, 0)),
            
            // TC14: 90, 15, 0 -> [90,15,0]
            Arguments.of("TC14", 90, 15, 0, Arrays.asList(90, 15, 0)),
            
            // TC15: 90, 20, 0 -> [90,20,0]
            Arguments.of("TC15", 90, 20, 0, Arrays.asList(90, 20, 0)),
            
            // TC16: 100, 1, 1 -> [100,0,0]
            Arguments.of("TC16", 100, 1, 1, Arrays.asList(100, 0, 0)),
            
            // TC17: 60, 50, 40 -> [60,50,40]
            Arguments.of("TC17", 60, 50, 40, Arrays.asList(60, 50, 40)),
            
            // TC18: 10, 80, 20 -> [10,80,20]
            Arguments.of("TC18",  10, 80, 20, Arrays.asList(10, 80, 20)),
            
            // TC19: 10, 190, 10 -> [10,190,0]
            Arguments.of("TC19", 10, 190, 10, Arrays.asList(10, 190, 0)),
            
            // TC20: 70, 61, 0 -> [70,60,0]
            Arguments.of("TC20", 0, 61, 70, Arrays.asList(70, 60, 0)),
            
            // TC21: 0, 90, 30 -> [0,90,30]
            Arguments.of("TC21",0, 90, 30, Arrays.asList(0, 90, 30)),
            
            // TC22: 0, 100, 0 -> [0,100,0]
            Arguments.of("TC22", 0, 100, 0, Arrays.asList(0, 100, 0)),
            
            // TC23: 10, 0, 300 -> [10,0,300]
            Arguments.of("TC23",10, 0, 300, Arrays.asList(10, 0, 300)),
            
            // TC24: 0, 50, 225 -> [0,50,225]
            Arguments.of("TC24", 0, 50, 225, Arrays.asList(0, 50, 225)),
            
            // TC25: 60, -1, 20 -> [-1]
            Arguments.of("TC25", 60, -1, 20, Arrays.asList(-1))
        );
    }
    
    @ParameterizedTest(name = "{0}: small={1}, medium={2}, large={3}")
    @MethodSource("provideTestCases")
    void testShippingCalculation(String testCaseId, int smallSize, int mediumSize, int largeSize, List<Integer> expected) {
        List<Integer> result = shippingVehicle.calculate(smallSize, mediumSize, largeSize);
        assertEquals(expected, result, 
            String.format("Test %s failed: calculate(%d, %d, %d)", testCaseId, smallSize, mediumSize, largeSize));
    }
}