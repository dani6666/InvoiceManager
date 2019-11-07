package invoicemanager.main.inputfetcher;

import java.io.IOException;

public interface IInputFetcher {
    int readInt() throws IOException;

    String readString() throws IOException;

    float readFloat();
}
