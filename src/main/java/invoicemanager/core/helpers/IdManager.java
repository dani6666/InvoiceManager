package invoicemanager.core.helpers;

import invoicemanager.core.interfaces.IIdManager;

public class IdManager implements IIdManager {
    private static int currentId = 1;

    public int getNextId() {
        return currentId++;
    }

}
