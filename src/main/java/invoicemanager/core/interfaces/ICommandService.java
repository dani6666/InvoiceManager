package invoicemanager.core.interfaces;

import invoicemanager.core.model.invoicemodel.CreateInvoiceRequest;
import invoicemanager.core.model.invoicemodel.InvoiceView;

import java.util.ArrayList;

public interface ICommandService {
    ArrayList<InvoiceView> getInvoiceList();

    void addInvoice(CreateInvoiceRequest request);

    InvoiceView getInvoiceById(int id);
}
