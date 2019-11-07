package invoicemanager.core.mappers;

import invoicemanager.core.interfaces.IIdManager;
import invoicemanager.core.interfaces.IInvoiceMapper;
import invoicemanager.core.model.invoicemodel.Invoice;
import invoicemanager.core.model.invoicemodel.InvoiceView;
import invoicemanager.core.model.Product;
import invoicemanager.core.model.invoicemodel.CreateInvoiceRequest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InvoiceMapper implements IInvoiceMapper {
    private final IIdManager idManager;

    public InvoiceMapper(IIdManager idManager) {
        this.idManager = idManager;
    }

    public InvoiceView mapToInvoiceView(Invoice invoice) {

        return new InvoiceView(invoice.id, invoice.client, invoice.date, invoice.totalValue);
    }

    public ArrayList<InvoiceView> mapToVectorInvoiceView(ArrayList<Invoice> invoices) {
        ArrayList<InvoiceView> invoiceViews = new ArrayList<InvoiceView>();

        for (Invoice invoice : invoices) {
            invoiceViews.add(mapToInvoiceView(invoice));
        }

        return invoiceViews;
    }

    public Invoice mapToFullInvoice(CreateInvoiceRequest invoiceRequest) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        float invoiceTotalValue = 0;
        for (Product product : invoiceRequest.products) {
            invoiceTotalValue += product.cost;
        }

        return new Invoice(idManager.getNextId(), invoiceRequest.client, formatter.format(date), invoiceTotalValue);
    }
}
