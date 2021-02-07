package invoicemanager.main.inputfetcher;

import java.util.Scanner;

public class InputFetcher implements IInputFetcher {
    private final Scanner inputScanner;

    public InputFetcher() {

        inputScanner = new Scanner(System.in);
    }

    public int readInt() {
        String input  = inputScanner.nextLine();

        return Integer.parseInt(input);
    }

    public String readString() {

        return inputScanner.nextLine();
    }

    public float readFloat() {

        String input = inputScanner.nextLine();

        return Float.parseFloat(input);
    }
}
