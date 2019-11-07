package invoicemanager.core.interfaces;

import invoicemanager.core.model.invoicemodel.CreateInvoiceRequest;
import invoicemanager.core.model.invoicemodel.Invoice;
import invoicemanager.core.model.invoicemodel.InvoiceView;

import java.util.ArrayList;

public interface IInvoiceMapper {
    InvoiceView mapToInvoiceView(Invoice invoice);

    ArrayList<InvoiceView> mapToVectorInvoiceView(ArrayList<Invoice> invoices);

    Invoice mapToFullInvoice(CreateInvoiceRequest invoiceRequest);
}
