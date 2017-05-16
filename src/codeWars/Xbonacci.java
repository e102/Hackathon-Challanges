package codeWars;

public class Xbonacci {

    public double[] xbonacci(double[] signature, int numberOfElementsToGet) {

        double[] outputArray = new double[numberOfElementsToGet];
        System.arraycopy(signature, 0, outputArray, 0, signature.length - 1);

//        int numbersToSum = signature.length;
//        int sum = 0;
//        int numbersSummed = 0;
//        for (int i = signature.length; i < outputArray.length; i++) {
//            while (numbersSummed < numbersToSum) {
//                sum += signature[i - 1 - numbersSummed];
//                numbersSummed++;
//            }
//
//            outputArray[i] = sum;
//        }

        return outputArray;
    }
}