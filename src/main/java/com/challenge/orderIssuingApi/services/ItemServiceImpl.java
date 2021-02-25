package com.challenge.orderIssuingApi.services;

import com.challenge.orderIssuingApi.enums.ItemProfitability;
import com.challenge.orderIssuingApi.exceptions.item.AmountNotMultipleException;
import com.challenge.orderIssuingApi.exceptions.item.BadProfitabilityException;
import com.challenge.orderIssuingApi.exceptions.item.UnreportedAmountException;
import com.challenge.orderIssuingApi.exceptions.item.UnreportedUnitPriceException;
import com.challenge.orderIssuingApi.models.Item;
import com.challenge.orderIssuingApi.models.OrderRequest;
import com.challenge.orderIssuingApi.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public double getTenPercentShorter(Double value) {
        return (value - (value * 0.1));
    }

    public ItemProfitability getItemProfitability(Item item) {
        if(item.getUnitPrice() > item.getProduct().getUnitPrice()) {
            return ItemProfitability.GREAT;
        } else {
            double minimumPriceToGoodProfitability = getTenPercentShorter(item.getProduct().getUnitPrice());

            if(item.getUnitPrice() >= minimumPriceToGoodProfitability)
                return ItemProfitability.GOOD;
            else
                return ItemProfitability.BAD;
        }
    }

    public boolean isItemAmountMultiple(Item item) {
        if(item.getProduct().getMultiple() == null || item.getAmount() % item.getProduct().getMultiple() == 0)
            return true;
        else
            return false;
    }

    @Override
    public void validate(Item item) {
        if(item.getAmount() <= 0)
            throw new UnreportedAmountException(item.getProduct().getName());

        if(item.getUnitPrice() <= 0)
            throw new UnreportedUnitPriceException(item.getProduct().getName());

        ItemProfitability itemProfitability = getItemProfitability(item);

        if(itemProfitability == ItemProfitability.BAD)
            throw new BadProfitabilityException(item.getProduct().getName());
        else
            item.setProfitability(itemProfitability);

        if(!isItemAmountMultiple(item))
            throw new AmountNotMultipleException(item.getProduct().getName());
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void setOrderRequest(Item item, OrderRequest orderRequest) {
        item.setOrderRequest(orderRequest);
    }

    @Override
    public void deleteById(Integer id) {
        try {
            itemRepository.deleteById(id);
        } catch(NoSuchElementException nsee) {
            throw nsee;
        }
    }

    @Override
    public void deleteAll(List<Item> items) {
        for(Item item : items) {
            try {
                deleteById(item.getId());
            } catch(NoSuchElementException nsee) {
                throw nsee;
            }
        }
    }
}
