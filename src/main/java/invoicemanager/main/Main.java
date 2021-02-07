package invoicemanager.main;

import invoicemanager.core.helpers.IdManager;
import invoicemanager.core.interfaces.ICommandService;
import invoicemanager.core.interfaces.IInvoiceMapper;
import invoicemanager.core.mappers.InvoiceMapper;
import invoicemanager.core.services.CommandService;
import invoicemanager.infrastructure.InvoicesRepository;
import invoicemanager.main.communicatessender.CommunicatesSender;
import invoicemanager.main.inputfetcher.InputFetcher;
import invoicemanager.main.invoicedatamanager.IInvoiceDataManager;
import invoicemanager.main.invoicedatamanager.InvoiceDataManager;

public class Main {
    public static void main(String[] args) {
        IInvoiceMapper invoiceMapper = new InvoiceMapper(new IdManager());
        ICommandService commandService = new CommandService(new InvoicesRepository(), invoiceMapper);
        IInvoiceDataManager invoiceDataManager =
                new InvoiceDataManager(new CommunicatesSender(), new InputFetcher());

        RuntimeManager runtimeManager = new RuntimeManager(new InputFetcher(),
                new CommunicatesSender(), invoiceDataManager, commandService);
        runtimeManager.runApp();
    }
}

