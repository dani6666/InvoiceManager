package invoicemanager.main.invoicedatamanager;

import invoicemanager.core.model.Client;
import invoicemanager.core.model.invoicemodel.InvoiceView;
import invoicemanager.core.model.Product;
import invoicemanager.core.model.invoicemodel.CreateInvoiceRequest;
import invoicemanager.main.communicatessender.ICommunicatesSender;
import invoicemanager.main.inputfetcher.IInputFetcher;

import java.io.IOException;
import java.util.ArrayList;

public class InvoiceDataManager implements IInvoiceDataManager {
    private final ICommunicatesSender communicatesSender;
    private final IInputFetcher inputFetcher;

    public InvoiceDataManager(ICommunicatesSender communicatesSender, IInputFetcher inputFetcher) {
        this.communicatesSender = communicatesSender;
        this.inputFetcher = inputFetcher;
    }

    public CreateInvoiceRequest getInvoiceCreationRequest() throws IOException {
        communicatesSender.creatingInvoiceCommunicate();
        communicatesSender.insertClientNameCommunicate();
        String clientName = inputFetcher.readString();
        communicatesSender.insertClientSurnameCommunicate();
        String clientSurname = inputFetcher.readString();

        CreateInvoiceRequest invoice = new CreateInvoiceRequest(new Client(clientName, clientSurname));

        communicatesSender.insertProductsNumberCommunicate();
        int productNumber = inputFetcher.readInt();

        for (int i = 0; i < productNumber; i++) {

            communicatesSender.insertProductNameCommunicate();
            String productName = inputFetcher.readString();
            communicatesSender.insertProductCostCommunicate();
            float productCost = inputFetcher.readFloat();

            invoice.products.add(new Product(productName, productCost));
        }

        return invoice;
    }

    public int getInvoiceShowRequest() throws IOException{
        communicatesSender.searchingForInvoiceCommunicate();
        communicatesSender.insertSearchedInvoiceIdCommunicate();

        return inputFetcher.readInt();
    }

    public void showInvoice(InvoiceView invoice) {

        communicatesSender.displayInvoice(invoice);
    }

    public void showInvoices(ArrayList<InvoiceView> invoices) {
        for (InvoiceView invoice : invoices) {
            showInvoice(invoice);
        }
    }
}
