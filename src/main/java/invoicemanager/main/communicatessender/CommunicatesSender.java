package invoicemanager.main.communicatessender;

import invoicemanager.core.model.invoicemodel.InvoiceView;

public class CommunicatesSender implements ICommunicatesSender {
    public void showAvailbleActions() {
        System.out.println();
        System.out.println("1 - Create invoice");
        System.out.println("2 - List invoices");
        System.out.println("3 - Show invoice");
        System.out.println("4 - Quit app");
    }

    public void showInvalidInputError() {
        System.out.println("ERROR ! Invalid input");
    }

    public void creatingInvoiceCommunicate() {
        System.out.println("Creating invoice...");
    }

    public void insertClientNameCommunicate() {
        System.out.println("Client name:");
    }

    public void insertClientSurnameCommunicate() {
        System.out.println("Client surname:");
    }

    public void insertProductsNumberCommunicate() {
        System.out.println("Number of products:");
    }

    public void insertProductNameCommunicate() {
        System.out.println("Product name:");
    }

    public void insertProductCostCommunicate() {
        System.out.println("Product cost:");
    }

    public void searchingForInvoiceCommunicate() {
        System.out.println("Searching for invoice...");
    }

    public void insertSearchedInvoiceIdCommunicate() {
        System.out.println("Specify invoice id");
    }

    public void displayInvoice(InvoiceView invoiceView) {
        System.out.println("Inovice number " + invoiceView.id);
        System.out.println("Clients name: " + invoiceView.client.name);
        System.out.println("Clients surname: " + invoiceView.client.surname);
        System.out.println("Inovice date: " + invoiceView.date);
        System.out.println("Inovice total cost " + invoiceView.totalValue);
        System.out.println();
    }
}
