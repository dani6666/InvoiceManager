package invoicemanager.main.invoicedatamanager;

import invoicemanager.core.model.invoicemodel.CreateInvoiceRequest;
import invoicemanager.core.model.invoicemodel.InvoiceView;

import java.io.IOException;
import java.util.ArrayList;

public interface IInvoiceDataManager {
    CreateInvoiceRequest getInvoiceCreationRequest() throws IOException;

    int getInvoiceShowRequest() throws IOException;

    void showInvoice(InvoiceView invoice);

    void showInvoices(ArrayList<InvoiceView> invoices);
}
