package com.example.shopping_campaign_be.dto.order.request;

import com.example.shopping_campaign_be.dto.CartDTO;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
public class RequestParam extends DTOModel {

    private List<CartDTO> cartDTO;


    public List<CartDTO> getCartDTO() {
        return cartDTO;
    }

    public void setCartDTO(List<CartDTO> cartDTO) {
        this.cartDTO = cartDTO;
    }
}
