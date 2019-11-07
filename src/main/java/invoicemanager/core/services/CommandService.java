package invoicemanager.core.services;

import invoicemanager.core.interfaces.ICommandService;
import invoicemanager.core.interfaces.IInvoiceMapper;
import invoicemanager.core.interfaces.IInvoicesRepository;
import invoicemanager.core.model.invoicemodel.Invoice;
import invoicemanager.core.model.invoicemodel.CreateInvoiceRequest;
import invoicemanager.core.model.invoicemodel.InvoiceView;

import java.util.ArrayList;

public class CommandService implements ICommandService {
    private final IInvoicesRepository invoicesRepository;
    private final IInvoiceMapper invoiceMapper;

    public CommandService(IInvoicesRepository invoicesRepository, IInvoiceMapper invoiceMapper) {
        this.invoicesRepository = invoicesRepository;
        this.invoiceMapper = invoiceMapper;
    }

    public ArrayList<InvoiceView> getInvoiceList() {
        return invoiceMapper.mapToVectorInvoiceView(invoicesRepository.getInvoices());
    }

    public void addInvoice(CreateInvoiceRequest request) {
        invoicesRepository.addInvoice(invoiceMapper.mapToFullInvoice(request));
    }

    public InvoiceView getInvoiceById(int id) {
        for (Invoice invoice : invoicesRepository.getInvoices()) {
            if (invoice.id == id) {
                return invoiceMapper.mapToInvoiceView(invoice);
            }
        }

        return null;
    }
}
