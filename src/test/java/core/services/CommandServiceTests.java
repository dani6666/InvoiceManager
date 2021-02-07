package core.services;

import invoicemanager.core.interfaces.IInvoiceMapper;
import invoicemanager.core.interfaces.IInvoicesRepository;
import invoicemanager.core.model.invoicemodel.Invoice;
import invoicemanager.core.model.invoicemodel.InvoiceView;
import invoicemanager.core.services.CommandService;
import junit.framework.TestCase;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

public class CommandServiceTests extends TestCase {
    private CommandService commandService;

    public void setUp() {
        ArrayList<Invoice> invoices = new ArrayList<Invoice>();
        Invoice invoice1 = new Invoice(2,null, "", 0);
        invoices.add(invoice1);
        Invoice invoice2 = new Invoice(3, null,"",0);
        invoices.add(invoice2);

        ArrayList<InvoiceView> invoiceViews = new ArrayList<InvoiceView>();
        invoiceViews.add(new InvoiceView(0, null, "", 0));
        invoiceViews.add(new InvoiceView(1, null, "", 0));

        InvoiceView invoiceViewWithId = new InvoiceView(3, null, "", 0);

        IInvoicesRepository invoicesRepository = Mockito.mock(IInvoicesRepository.class);
        when(invoicesRepository.getInvoices()).thenReturn(invoices);

        IInvoiceMapper invoiceMapper = Mockito.mock(IInvoiceMapper.class);
        when(invoiceMapper.mapToVectorInvoiceView(invoices)).thenReturn(invoiceViews);
        when(invoiceMapper.mapToInvoiceView(invoice2)).thenReturn(invoiceViewWithId);

        commandService = new CommandService(invoicesRepository, invoiceMapper);
    }

    public void test_getInvoiceList_ReturnsNonEmptyList() {
        ArrayList<InvoiceView> result = commandService.getInvoiceList();

        assertNotNull(result);
        assertFalse(result.size() == 0);
    }

    public void test_getInvoiceById_ReturnsInvoiceWithProperId() {
        InvoiceView result = commandService.getInvoiceById(3);

        assertEquals(3, result.id);
    }

    public void test_getInvoiceById_ReturnsNull_ForNonexistentId() {
        InvoiceView result = commandService.getInvoiceById(4);

        assertNull(result);
    }
}
