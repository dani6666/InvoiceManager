package invoicemanager.main;

import invoicemanager.core.interfaces.ICommandService;
import invoicemanager.core.model.invoicemodel.CreateInvoiceRequest;
import invoicemanager.core.model.invoicemodel.InvoiceView;
import invoicemanager.main.communicatessender.ICommunicatesSender;
import invoicemanager.main.inputfetcher.IInputFetcher;
import invoicemanager.main.invoicedatamanager.IInvoiceDataManager;

import java.io.IOException;
import java.util.ArrayList;

class RuntimeManager {
    private final IInputFetcher inputFetcher;
    private final ICommunicatesSender communicatesSender;
    private final IInvoiceDataManager invoiceDataManager;
    private final ICommandService commandService;

    RuntimeManager(IInputFetcher inputFetcher, ICommunicatesSender communicatesSender,
                   IInvoiceDataManager invoiceDataManager, ICommandService commandService) {
        this.inputFetcher = inputFetcher;
        this.communicatesSender = communicatesSender;
        this.invoiceDataManager = invoiceDataManager;
        this.commandService = commandService;
    }

    void runApp() {
        char userInput;
        while (true) {
            communicatesSender.showAvailbleActions();
            try {
                userInput = inputFetcher.readString().charAt(0);

                switch (userInput) {
                    case '1':
                        CreateInvoiceRequest createInvoiceRequest =
                                invoiceDataManager.getInvoiceCreationRequest();
                        commandService.addInvoice(createInvoiceRequest);
                        break;
                    case '2':
                        ArrayList<InvoiceView> invoiceViews = commandService.getInvoiceList();
                        invoiceDataManager.showInvoices(invoiceViews);
                        break;
                    case '3':
                        int invoiceId = invoiceDataManager.getInvoiceShowRequest();
                        InvoiceView invoiceView = commandService.getInvoiceById(invoiceId);
                        if (invoiceView == null) {
                            communicatesSender.showInvalidInputError();
                        }
                        invoiceDataManager.showInvoice(invoiceView);
                        break;
                    case '4':
                        return;
                    default:
                        communicatesSender.showInvalidInputError();
                        break;
                }
            } catch (IOException ex) {
                communicatesSender.showInvalidInputError();
            }
        }
    }
}
