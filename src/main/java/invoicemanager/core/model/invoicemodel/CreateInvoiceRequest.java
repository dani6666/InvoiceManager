package invoicemanager.core.model.invoicemodel;

import invoicemanager.core.model.Client;
import invoicemanager.core.model.Product;

import java.util.ArrayList;

public class CreateInvoiceRequest {
    public final Client client;
    public final ArrayList<Product> products;

    public CreateInvoiceRequest(Client client) {
        this.client = client;
        products = new ArrayList<Product>();
    }
}
