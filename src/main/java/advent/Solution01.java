package advent;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Solution01 {

    public static void main(String[] args) {
        Solution01.test();

        //String[] inputs = AdventBroker.loadInputs(1, 1);
        //String result = Solution01.solve(inputs);
        //AdventBroker.sendResult(1, 1, result);
    }

    //private - I don't want to call it from another class
    private static String solve(String[] inputs) {
        String result = "";

        //  load row
        String inputData = RestAssured.given().cookie("session", "53616c7465645f5fe36b6c1894c468c978abdcfa1a7999583cc033e70bac342c8f7cc9a1838169f9d46ee812826719f1").when().get("https://adventofcode.com/2021/day/1/input").then().
                extract().asString();
        String[] inputArray = inputData.split("\n");

        //  convert string to number
        int[] inputNumbers = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            inputNumbers[i] = Integer.parseInt(inputArray[i]);
        }

        // set counter == 0
        int counter = 0;

        //  compare to previous number
        //  if higher, increment counter
        for (int x = 0; x < inputArray.length - 1; x++) {
            if (inputNumbers[x + 1] > inputNumbers[x]) {
                counter += 1;
            }
        }
        System.out.println(counter);
        // convert counter to string
        result = Integer.toString(counter);

        // return
        return result;
    }

//    public static int countIncreasedMeasurement(String[] input, int[] numbers){
//        // set counter == 0
//        int counter = 0;
//
//        //  compare to previous number
//        //  if higher, increment counter
//        for (int x = 0; x < input.length - 1; x++) {
//            if (numbers[x + 1] > numbers[x]) {
//                counter += 1;
//            }
//        }
//        System.out.println(counter);
//        return counter;
//
//    }

    public static void test() {
        String[] testData = {"199", "200", "208", "210", "200", "207", "240", "269", "260", "263"};
        assert (solve(testData) == "7") : "test failed! fix your shit!";
    }
}
