package invoicemanager.core.interfaces;

import invoicemanager.core.model.invoicemodel.Invoice;

import java.util.ArrayList;

public interface IInvoicesRepository {
    ArrayList<Invoice> getInvoices();

    void addInvoice(Invoice invoice);
}
