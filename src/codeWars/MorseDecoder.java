package codeWars;

import static java.lang.Math.min;

public class MorseDecoder {
    public static String decodeBits(String bits) {
        String sanitizedBits = removeOuterZeroes(bits);
        char[] bitsArray = sanitizedBits.toCharArray();

        int timeUnitLengthInDots = findTimeUnitLengthInDots(bitsArray);

        return bitsToMorse(bitsArray, timeUnitLengthInDots);
    }

    public static String decodeMorse(String morseCode) {
        return MorseCode.get(morseCode);
    }


    private static String removeOuterZeroes(String input) {
        String filteredInput = input.replaceAll("^0+", "");
        filteredInput = filteredInput.replaceAll("0+$", "");
        return filteredInput;
    }


    private static int findTimeUnitLengthInDots(char[] bitsArray) {
        int lowestNumberOfSequentialDots = 0;

        int currentSequenceLength = 0;
        for (char digit : bitsArray) {
            if (digit == '0') {
                if (currentSequenceLength == 0) {
                    continue;
                } else {
                    if (lowestNumberOfSequentialDots == 0) {
                        lowestNumberOfSequentialDots = currentSequenceLength;
                    } else {
                        lowestNumberOfSequentialDots = min(currentSequenceLength, lowestNumberOfSequentialDots);
                    }
                    currentSequenceLength = 0;
                }
            }
            if (digit == '1') {
                lowestNumberOfSequentialDots++;
            }
        }
        if (lowestNumberOfSequentialDots == 0) {
            lowestNumberOfSequentialDots = currentSequenceLength;
        } else {
            lowestNumberOfSequentialDots = min(currentSequenceLength, lowestNumberOfSequentialDots);
        }

        if (lowestNumberOfSequentialDots == null) {
            if (currentSequenceLength != 0) {
                lowestNumberOfSequentialDots = currentSequenceLength;
            } else {
                console.log("oops!");
            }
        }

        return lowestNumberOfSequentialDots;
    }


    private static String bitsToMorse(char[] bitsArray, int timeUnitLengthInDots) {
        String morse = "";

        char currentChar = bitsArray[1];
        int currentSequenceLength = 0;

        for (char digit : bitsArray) {
            if (digit == currentChar) {
                currentSequenceLength++;
            } else {
                morse += processCurrentSequence(currentChar, currentSequenceLength, timeUnitLengthInDots);
                currentChar = digit;
                currentSequenceLength = 1;
            }
        }
        morse += processCurrentSequence(currentChar, currentSequenceLength, int timeUnitLengthInDots);

        return morse;
    }

    private static String processCurrentSequence(char digit, int repetitions, int timeUnitLengthInDots) {
        int dotLength = timeUnitLengthInDots;
        int dashLength = timeUnitLengthInDots * 3;
        int pauseLengthInsideCharacter = timeUnitLengthInDots;
        int pauseLengthInsideWord = timeUnitLengthInDots * 3;
        int pauseLengthBetweenwords = timeUnitLengthInDots * 7;

        char moreseCharacter = "";
        if (digit == '0') {
        } else if (digit == '1') {
        }
    }


}
