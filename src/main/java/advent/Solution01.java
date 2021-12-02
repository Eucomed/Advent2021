package advent;

import io.restassured.RestAssured;

public class Solution01 {
    String inputData = RestAssured.given().cookie("session", "53616c7465645f5fe36b6c1894c468c978abdcfa1a7999583cc033e70bac342c8f7cc9a1838169f9d46ee812826719f1").when().get("https://adventofcode.com/2021/day/1/input").then().
            extract().asString();
    String[] inputArray = inputData.split("\n");

    public static void main(String[] args) {
        Solution01 solution1 = new Solution01();
        Solution01.solve1(solution1.inputArray);
        Solution01.solve2(solution1.inputArray);

        Solution01.test1();
        Solution01.test2();

        //String[] inputs = AdventBroker.loadInputs(1, 1);
        //String result = Solution01.solve(inputs);
        //AdventBroker.sendResult(1, 1, result);
    }

    //private - I don't want to call it from another class
    private static String solve1(String[] inputs) {
        String result = "";

        //  convert string to number
        int[] inputNumbers = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            inputNumbers[i] = Integer.parseInt(inputs[i]);
        }

        int counter = 0;
        int counterValue = countIncreasedMeasurement(inputNumbers);
        System.out.println(counterValue);
        result = Integer.toString(counterValue);
        return result;
    }

    private static String solve2(String[] inputs) {
        String counter;
        int[] finalArray = new int[inputs.length];
        for (int x = 0; x < finalArray.length - 2; x++) {
            finalArray[x] = Integer.parseInt(inputs[x]) + Integer.parseInt(inputs[x + 1]) + Integer.parseInt(inputs[x + 2]);
        }
        int counterValue = countIncreasedMeasurement(finalArray);
        System.out.println(counterValue);
        counter = Integer.toString(counterValue);
        return counter;
    }

    public static int countIncreasedMeasurement(int[] input) {
        int counter = 0;
        for (int x = 0; x < input.length - 1; x++) {
            if (input[x + 1] > input[x]) {
                counter += 1;
            }
        }
        return counter;
    }

    public static void test1() {
        String[] testData = {"199", "200", "208", "210", "200", "207", "240", "269", "260", "263"};
        assert (solve1(testData) == "7") : "Test1 failed! fix your shit!";
    }

    public static void test2() {
        String[] testData = {"199", "200", "208", "210", "200", "207", "240", "269", "260", "263"};
        assert (solve2(testData) == "5") : "Test2 failed! fix your shit!";
    }
}
