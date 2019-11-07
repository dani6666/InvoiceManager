package core.helpers;

import invoicemanager.core.helpers.IdManager;
import junit.framework.TestCase;

import java.util.ArrayList;

public class IdManagerTests extends TestCase {
    private IdManager idManager;

    public void setUp() {
        idManager = new IdManager();
    }

    public void test_getNextId_ReturnsUniqueIds() {
        ArrayList<Integer> returnedInts = new ArrayList<Integer>();

        for (int i = 0; i < 1000; i++) {
            int result = idManager.getNextId();

            assertFalse(returnedInts.contains(result));

            returnedInts.add(result);
        }
    }
}
