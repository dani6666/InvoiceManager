package core.mappers;

import invoicemanager.core.interfaces.IIdManager;
import invoicemanager.core.mappers.InvoiceMapper;
import invoicemanager.core.model.Client;
import invoicemanager.core.model.Product;
import invoicemanager.core.model.invoicemodel.CreateInvoiceRequest;
import invoicemanager.core.model.invoicemodel.Invoice;
import invoicemanager.core.model.invoicemodel.InvoiceView;
import junit.framework.TestCase;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

public class InvoiceMapperTests extends TestCase {
    private InvoiceMapper invoiceMapper;

    public void setUp() {
        IIdManager idManagerMock = Mockito.mock(IIdManager.class);

        when(idManagerMock.getNextId()).thenReturn(1);

        invoiceMapper = new InvoiceMapper(idManagerMock);
    }

    public void test_mapToInvoiceView_ReturnsInvoiceViewWithFullProperties() {
        Invoice invoice = new Invoice(1, new Client("name1", "surname1"), "01-01-2018", 20.5f);
        invoice.products.add(new Product("productName", 20.5f));

        InvoiceView result = invoiceMapper.mapToInvoiceView(invoice);

        assertNotNull(result);
        assertNotNull(result.date);
        assertFalse(result.id == 0);
        assertFalse(result.totalValue == 0);
        assertNotNull(result.client);
        assertNotNull(result.client.name);
        assertNotNull(result.client.surname);
    }

    public void test_mapToFullInvoice_ReturnsInvoiceWithFullProperties() {
        CreateInvoiceRequest invoice = new CreateInvoiceRequest(new Client("name1", "surname1"));
        invoice.products.add(new Product("productName", 20.5f));

        Invoice result = invoiceMapper.mapToFullInvoice(invoice);

        assertNotNull(result);
        assertNotNull(result.products);
        assertNotNull(result.date);
        assertFalse(result.id == 0);
        assertFalse(result.totalValue == 0);
        assertNotNull(result.client);
        assertNotNull(result.client.name);
        assertNotNull(result.client.surname);
    }
}
