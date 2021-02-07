package invoicemanager.core.model.invoicemodel;

import invoicemanager.core.model.Client;
import invoicemanager.core.model.Product;

import java.util.ArrayList;

public class Invoice {
    public final int id;
    public final Client client;
    public final String date;
    public final ArrayList<Product> products;
    public final float totalValue;

    public Invoice(int id, Client client, String date, float totalValue) {
        this.id = id;
        this.client = client;
        this.date = date;
        products = new ArrayList<Product>();
        this.totalValue = totalValue;
    }
}
