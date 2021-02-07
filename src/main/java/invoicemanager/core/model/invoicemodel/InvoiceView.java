package invoicemanager.core.model.invoicemodel;

import invoicemanager.core.model.Client;

public class InvoiceView {
    public final int id;
    public final Client client;
    public final String date;
    public final float totalValue;

    public InvoiceView(int id, Client client, String date, float totalValue) {
        this.id = id;
        this.client = client;
        this.date = date;
        this.totalValue = totalValue;
    }
}
