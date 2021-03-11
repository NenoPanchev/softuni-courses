package course.springdata.xmlprocessingex2.controllers;

import course.springdata.xmlprocessingex2.models.dtos.*;
import course.springdata.xmlprocessingex2.services.*;
import course.springdata.xmlprocessingex2.utils.XmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

import java.io.IOException;

import static course.springdata.xmlprocessingex2.constants.GlobalConstants.*;

@Component
public class AppController implements CommandLineRunner {
    private final CarService carService;
    private final PartService partService;
    private final SaleService saleService;
    private final CustomerService customerService;
    private final SupplierService supplierService;
    private final XmlParser xmlParser;

    @Autowired
    public AppController(CarService carService, PartService partService, SaleService saleService,
                         CustomerService customerService, SupplierService supplierService, XmlParser xmlParser) {
        this.carService = carService;
        this.partService = partService;
        this.saleService = saleService;
        this.customerService = customerService;
        this.supplierService = supplierService;
        this.xmlParser = xmlParser;
    }

    @Override
    public void run(String... args) throws Exception {

        // Seed the Database
        this.seedSuppliers();
        this.seedParts();
        this.seedCars();
        this.seedCustomers();
        this.seedSales();

//         Car Dealer Query and Export Data
//         Query 1 - Ordered Customers
        this.exportFirstQuery();

//         Query 2 - Cars from Make Toyota
        this.exportSecondQuery();

//         Query 3 - Local Suppliers
        this.exportThirdQuery();

//         Query 4 - Cars with THeir List of Parts
        this.exportFourthQuery();

//        Query 5 - Total Sales by Customer
        this.exportFifthQuery();

        //Query 6 - Sales with Applied Discount
        this.exportSixthQuery();

    }

    private void exportSixthQuery() throws IOException, JAXBException {
        this.xmlParser
                .marshalToFile(QUERY_06_PATH, this.saleService.getSalesWithAppliedDiscount());
    }

    private void exportFifthQuery() throws IOException, JAXBException {
        this.xmlParser
                .marshalToFile(QUERY_05_PATH, this.customerService.getCustomersCountOfSalesAndTotalMoneySpent());
    }

    private void exportFourthQuery() throws IOException, JAXBException {
        this.xmlParser
                .marshalToFile(QUERY_04_PATH, this.carService.getCarsWithTheirListOfParts());
    }

    private void exportThirdQuery() throws IOException, JAXBException {
        this.xmlParser
                .marshalToFile(QUERY_03_PATH, this.supplierService.getSuppliersWhoAreNotImporters());
    }

    private void exportSecondQuery() throws IOException, JAXBException {
        this.xmlParser
                .marshalToFile(QUERY_02_PATH, this.carService.getAllCarsMadeByToyotaOrderedByModelAscTravelledDistanceDesc());
    }

    private void exportFirstQuery() throws IOException, JAXBException {
        this.xmlParser
                .marshalToFile(QUERY_01_PATH, this.customerService.getAllCustomersOrderedByBirthDateAscIsYoungDriverAsc());
    }

    private void seedSales() {
        this.saleService.seedSales();
    }

    private void seedCustomers() throws FileNotFoundException, JAXBException {
        CustomerSeedRootDto rootDto = this.xmlParser
                .unmarshalFromFile(CUSTOMERS_FILE_PATH, CustomerSeedRootDto.class);
        this.customerService.seedCustomers(rootDto.getCustomers());
    }

    private void seedCars() throws FileNotFoundException, JAXBException {
        CarSeedRootDto rootDto = this.xmlParser
                .unmarshalFromFile(CARS_FILE_PATH, CarSeedRootDto.class);
        this.carService.seedCars(rootDto.getCars());
    }

    private void seedParts() throws FileNotFoundException, JAXBException {
        PartSeedRootDto rootDto = this.xmlParser
                .unmarshalFromFile(PARTS_FILE_PATH, PartSeedRootDto.class);
        this.partService.seedParts(rootDto.getParts());
    }

    private void seedSuppliers() throws FileNotFoundException, JAXBException {
        SupplierSeedRootDto rootDto = this.xmlParser
                .unmarshalFromFile(SUPPLIERS_FILE_PATH, SupplierSeedRootDto.class);
        this.supplierService.seedSuppliers(rootDto.getSuppliers());
    }
}
