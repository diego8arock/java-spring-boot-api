package com.mercadolibre.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.mercadolibre.api.database.CouponRepository;
import com.mercadolibre.api.database.ItemRepository;
import com.mercadolibre.api.dtos.CouponDTO;
import com.mercadolibre.api.dtos.ItemDTO;
import com.mercadolibre.api.models.ItemsCoupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponServices {
    
    @Autowired
    private CouponRepository repo; 

    @Autowired
    private ItemRepository itemRepo;

    public CouponDTO newCoupon(CouponDTO newItem){
        return repo.save(newItem);
    }

    public List<CouponDTO> getCoupons(){
        return repo.findAll();
    }

    public ItemsCoupon validateCoupon(ItemsCoupon itemsCoupon){

        List<ItemDTO> items = new ArrayList<ItemDTO>();

        //findById instead of findAllById because of multiple Ids in request
        Consumer<String> lambdaFindById = x -> {
            ItemDTO i = itemRepo.findById(x).get();
            items.add(i);
        };

        itemsCoupon.getItem_ids().forEach(lambdaFindById);
        items.sort((i1,i2)-> i1.getPrice().compareTo(i2.getPrice()));

        ItemsCoupon result = new ItemsCoupon();
        Double total = 0.0;

        for (ItemDTO item : items) {
         
            if(total + item.getPrice() > itemsCoupon.getAmount()) break;
               
            total += item.getPrice();
            result.addItemID(item.getId());

        }

        result.setAmount(total);

        return result;
    }

    public void deleteCoupon(Long id){
        repo.deleteById(id);
    }
    
}
