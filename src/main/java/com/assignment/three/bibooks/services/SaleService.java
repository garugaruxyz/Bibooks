package com.assignment.three.bibooks.services;

import com.assignment.three.bibooks.model.Sale;
import com.assignment.three.bibooks.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SaleService {

    List<Sale> getSales();

    Sale getSaleById(Integer id);

    Sale insert(Sale sale);

    void updateSale(Integer id, Sale sale);

    void deleteSale(Integer saleId);
}
