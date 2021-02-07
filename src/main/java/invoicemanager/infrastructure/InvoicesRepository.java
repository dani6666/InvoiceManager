package invoicemanager.infrastructure;

import invoicemanager.core.interfaces.IInvoicesRepository;
import invoicemanager.core.model.invoicemodel.Invoice;

import java.util.ArrayList;

public class InvoicesRepository implements IInvoicesRepository {
    private static ArrayList<Invoice> invoices = new ArrayList<Invoice>();

    public ArrayList<Invoice> getInvoices(){
        return invoices;
    }

    public void addInvoice(Invoice invoice){
        invoices.add(invoice);
    }
}
