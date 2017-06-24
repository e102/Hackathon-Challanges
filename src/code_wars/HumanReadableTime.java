package src.code_wars;

public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        try {
            int readableHours = calculateTimeUnitsPresentInXSeconds("hour", seconds);
            seconds -= readableHours * 3600;
            int readableMinutes = calculateTimeUnitsPresentInXSeconds("minute", seconds);
            seconds -= readableMinutes * 60;
            int readableSeconds = calculateTimeUnitsPresentInXSeconds("seconds", seconds);

            return formatToHumanReadable(readableHours, readableMinutes, readableSeconds);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
            return "will never be reached";
        }
    }

    private static int calculateTimeUnitsPresentInXSeconds(String unitName, int seconds) throws Exception {
        int units = 0;
        int secondsPerUnit;
        switch (unitName) {
            case "hour":
                secondsPerUnit = 3600;
                break;
            case "minute":
                secondsPerUnit = 60;
                break;
            case "seconds":
                secondsPerUnit = 1;
                break;
            default:
                throw new Exception("Unit not recognized. Only accepts [hour,minute,second]");
        }

        while ((units + 1) * secondsPerUnit <= seconds) {
            units++;
        }

        return units;
    }

    private static String formatToHumanReadable(int hours, int minutes, int seconds) {
        String hoursString = padIfNecessary(Integer.toString(hours));
        String minutesString = padIfNecessary(Integer.toString(minutes));
        String secondsString = padIfNecessary(Integer.toString(seconds));

        return hoursString + ":" + minutesString + ":" + secondsString;
    }

    private static String padIfNecessary(String input) {
        if (input.length() == 2) {
            return input;
        }

        return ("0" + input);
    }

}