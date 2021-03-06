package course.springdata.jsonprocessingex2.controllers;

import com.google.gson.Gson;
import course.springdata.jsonprocessingex2.models.dtos.CarSeedDto;
import course.springdata.jsonprocessingex2.models.dtos.CustomerSeedDto;
import course.springdata.jsonprocessingex2.models.dtos.PartSeedDto;
import course.springdata.jsonprocessingex2.models.dtos.SupplierSeedDto;
import course.springdata.jsonprocessingex2.services.*;
import course.springdata.jsonprocessingex2.utils.FileIOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static course.springdata.jsonprocessingex2.constants.GlobalConstants.*;

@Component
public class AppController implements CommandLineRunner {
    private final CarService carService;
    private final PartService partService;
    private final SaleService saleService;
    private final CustomerService customerService;
    private final SupplierService supplierService;
    private final Gson gson;
    private final FileIOUtil fileIOUtil;

    @Autowired
    public AppController(CarService carService, PartService partService, SaleService saleService,
                         CustomerService customerService, SupplierService supplierService, Gson gson, FileIOUtil fileIOUtil) {
        this.carService = carService;
        this.partService = partService;
        this.saleService = saleService;
        this.customerService = customerService;
        this.supplierService = supplierService;
        this.gson = gson;
        this.fileIOUtil = fileIOUtil;
    }

    @Override
    public void run(String... args) throws Exception {

        // Seed the Database
        this.seedSuppliers();
        this.seedParts();
        this.seedCars();
        this.seedCustomers();
        this.seedSales();

        // Car Dealer Query and Export Data
        // Query 1 - Ordered Customers
        this.exportFirstQuery();

        // Query 2 - Cars from Make Toyota
        this.exportSecondQuery();

        // Query 3 - Local Suppliers
        this.exportThirdQuery();

        // Query 4 - Cars with THeir List of Parts
        this.exportFourthQuery();

        //Query 5 - Total Sales by Customer
        this.exportFifthQuery();

        //Query 6 - Sales with Applied Discount
        this.exportSixthQuery();

    }

    private void exportSixthQuery() throws IOException {
        this.fileIOUtil.write(this.gson.toJson(this.saleService.getSalesWithAppliedDiscount()), QUERY_06_PATH);
    }

    private void exportFifthQuery() throws IOException {
        this.fileIOUtil.write(this.gson.toJson(this.customerService.getCustomersCountOfSalesAndTotalMoneySpent()), QUERY_05_PATH);
    }

    private void exportFourthQuery() throws IOException {
        this.fileIOUtil.write(this.gson.toJson(this.carService.getCarsWithTheirListOfParts()), QUERY_04_PATH);
    }

    private void exportThirdQuery() throws IOException {
        this.fileIOUtil.write(this.gson.toJson(this.supplierService.getSuppliersWhoAreNotImporters()), QUERY_03_PATH);
    }

    private void exportSecondQuery() throws IOException {
        this.fileIOUtil.write(this.gson.toJson(this.carService.getAllCarsMadeByToyotaOrderedByModelAscTravelledDistanceDesc()), QUERY_02_PATH);
    }

    private void exportFirstQuery() throws IOException {
        this.fileIOUtil.write(this.gson.toJson(this.customerService.getAllCustomersOrderedByBirthDateAscIsYoungDriverAsc()), QUERY_01_PATH);
    }

    private void seedSales() {
        this.saleService.seedSales();
    }

    private void seedCustomers() throws FileNotFoundException {
        CustomerSeedDto[] dtos = this.gson
                .fromJson(new FileReader(CUSTOMERS_FILE_PATH), CustomerSeedDto[].class);
        this.customerService.seedCustomers(dtos);
    }

    private void seedCars() throws FileNotFoundException {
        CarSeedDto[] dtos = this.gson
                .fromJson(new FileReader(CARS_FILE_PATH), CarSeedDto[].class);
        this.carService.seedCars(dtos);
    }

    private void seedParts() throws FileNotFoundException {
        PartSeedDto[] dtos = this.gson
                .fromJson(new FileReader(PARTS_FILE_PATH), PartSeedDto[].class);
        this.partService.seedParts(dtos);
    }

    private void seedSuppliers() throws FileNotFoundException {
        SupplierSeedDto[] dtos = this.gson
                .fromJson(new FileReader(SUPPLIERS_FILE_PATH), SupplierSeedDto[].class);
        this.supplierService.seedSuppliers(dtos);
    }
}
