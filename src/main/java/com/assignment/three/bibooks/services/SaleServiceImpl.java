package com.assignment.three.bibooks.services;

import com.assignment.three.bibooks.model.Sale;
import com.assignment.three.bibooks.repositories.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;

    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public List<Sale> getSales() {
        List<Sale> sales = new ArrayList<>();
        saleRepository.findAll().forEach(sales::add);
        return sales;
    }

    @Override
    public Sale getSaleById(Integer id) {
        return saleRepository.findById(id).get();
    }


    @Override
    public Sale insert(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public void updateSale(Integer id, Sale sale) {
        Sale saleFromDB = saleRepository.findById(id).get();
        System.out.println(saleFromDB);
        saleFromDB.setDateCreated(sale.getDateCreated());
        saleFromDB.setStatus(sale.getStatus());
        saleFromDB.setLastModified(sale.getLastModified());
        saleFromDB.setIdUser1(sale.getIdUser1());
        saleFromDB.setIdUser(sale.getIdUser());
        saleFromDB.setBookCopyId(sale.getBookCopyId());
        saleRepository.save(saleFromDB);

    }

    @Override
    public void deleteSale(Integer saleId) {
        saleRepository.deleteById(saleId);
    }
}