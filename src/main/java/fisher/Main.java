package fisher;

public class Main {

    public static void main(String[] args) {
        System.out.println(checkCPF("11111111111"));
        System.out.println(checkCPF("22222222222"));
        System.out.println(checkCPF("33333333333"));
        System.out.println(checkCPF("44444444444"));
        System.out.println(checkCPF("55555555555"));
        System.out.println(checkCPF("66666666666"));
        System.out.println(checkCPF("77777777777"));
        System.out.println(checkCPF("88888888888"));
        System.out.println(checkCPF("99999999999"));
        System.out.println(checkCPF("00000000000"));
        System.out.println(checkCPF("1231231233"));
        System.out.println(checkCPF("123123"));
        System.out.println(checkCPF("123123123312"));
        System.out.println(checkCPF("54647142949"));
        System.out.println(checkCPF("99999999998"));
        System.out.println(checkCPF("cccaaaaaaab"));
    }

    private static String checkCPF(String stringToCheck) {
        final var numericArray = toNumericArray(stringToCheck);
        if (numericArray.length != 11) {
            return "WRONG: LENGTH IS NOT 11!";
        }
        if (isAllNumbersTheSame(numericArray)) {
            return "WRONG: ALL NUMBERS ARE THE SAME!";
        }
        final var firstCheckNumber = getCheckNumber(numericArray, 10, 9);
        final var secondCheckNumber = getCheckNumber(numericArray, 11, 10);
        if (numericArray[9] != firstCheckNumber || numericArray[10] != secondCheckNumber) {
            return "WRONG: CHECK SUM IS INCORRECT!";
        }
        return "CORRECT!";
    }

    private static int[] toNumericArray(String stringToCheck) {
        return stringToCheck.chars()
                .map(Character::getNumericValue)
                .toArray();
    }

    private static boolean isAllNumbersTheSame(int[] arrayToCheck) {
        final int firstItem = arrayToCheck[0];
        for (int item : arrayToCheck) {
            if (firstItem != item) {
                return false;
            }
        }
        return true;
    }

    private static int getCheckNumber(int[] arrayToCheck, int startFrom, int amountOfInvolved) {
        int sum = 0;
        for (int i = 0; i < amountOfInvolved; i++) {
            sum = sum + (arrayToCheck[i] * startFrom--);
        }
        final var something = 11 - (sum % 11);
        if (something > 9) {
            return 0;
        } else {
            return something;
        }
    }
}
