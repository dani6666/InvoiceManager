package invoicemanager.main.communicatessender;

import invoicemanager.core.model.invoicemodel.InvoiceView;

public interface ICommunicatesSender {
    void showAvailbleActions();

    void showInvalidInputError();

    void creatingInvoiceCommunicate();

    void insertClientNameCommunicate();

    void insertClientSurnameCommunicate();

    void insertProductsNumberCommunicate();

    void insertProductNameCommunicate();

    void insertProductCostCommunicate();

    void searchingForInvoiceCommunicate();

    void insertSearchedInvoiceIdCommunicate();

    void displayInvoice(InvoiceView invoiceView);
}
