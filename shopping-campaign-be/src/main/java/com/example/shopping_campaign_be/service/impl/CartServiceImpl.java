package com.example.shopping_campaign_be.service.impl;

import com.example.shopping_campaign_be.constant.DiscountConstants;
import com.example.shopping_campaign_be.dto.CartDTO;
import com.example.shopping_campaign_be.dto.order.request.CartRequestParam;
import com.example.shopping_campaign_be.dto.order.request.RequestParam;
import com.example.shopping_campaign_be.entity.*;
import com.example.shopping_campaign_be.repository.*;
import com.example.shopping_campaign_be.service.CartService;
import com.example.shopping_campaign_be.util.GsonUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    DiscountRepository discountRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Cart initCart(RequestParam param) {

        if (param == null) {
            throw new IllegalArgumentException("CartDTO cannot be null");
        }

        CartDTO cartDTO = GsonUtil.fromJson(String.valueOf(param.getCartDTO()), CartDTO.class);

        Cart cartObj = new Cart();

        Optional<Product> productOpt = productRepository.findById(cartDTO.getProduct_id());
        Product productObj = productOpt.orElseThrow(() -> new EntityNotFoundException("Product ID " + cartDTO.getProduct_id() + " not found."));

        Optional<Discount> discountOpt = discountRepository.findById(cartDTO.getDiscount_id());
        Discount discountObj = discountOpt.orElseThrow(() -> new EntityNotFoundException("Discount ID " + cartDTO.getDiscount_id() + " not found."));

        Optional<User> userOpt = userRepository.findById(cartDTO.getUser_id());
        User userObj = userOpt.orElseThrow(() -> new EntityNotFoundException("User ID " + cartDTO.getUser_id() + " not found."));

        cartObj.setQuantity(GsonUtil.toJson(cartDTO.getQuantity()));
        cartObj.setProduct(productObj);
        cartObj.setDiscount(discountObj);
        cartObj.setUser(userObj);

        return cartObj;

    }

    @Override
    public Optional<Cart> saveCart(CartDTO cartParam) {

        if (cartParam == null) {
            throw new IllegalArgumentException("CartDTO cannot be null");
        }

        Cart cartConverted = cartConvertJsonToObject(cartParam);
        Cart cartSaved = cartRepository.saveAndFlush(cartConverted);

        return Optional.of(cartSaved);
    }

    public Cart cartConvertJsonToObject(CartDTO cartParam) {

        Cart cartObj = new Cart();

        String product_id = cartParam.getProduct_id();
        String discount_id = cartParam.getDiscount_id();
        String user_id = cartParam.getUser_id();

        Optional<Product> productOpt = productRepository.findById(product_id);
        Product productObj = productOpt.orElseThrow(() -> new EntityNotFoundException("Product ID " + product_id + " not found."));

        Optional<Discount> discountOpt = discountRepository.findById(discount_id);
        Discount discountObj = discountOpt.orElseThrow(() -> new EntityNotFoundException("Discount ID " + discount_id + " not found."));

        Optional<User> userOpt = userRepository.findById(user_id);
        User userObj = userOpt.orElseThrow(() -> new EntityNotFoundException("User ID " + user_id + " not found."));

        cartObj.setQuantity(cartParam.getQuantity());
        cartObj.setProduct(productObj);
        cartObj.setDiscount(discountObj);
        cartObj.setUser(userObj);

        return cartObj;
    }

    @Override
    public List<Cart> getCartAll() {

        List<Cart> cartList = cartRepository.findAll();

        return cartList;
    }

    @Override
    public Optional<Cart> getCartById(String id) {

        Optional<Cart> cartId = cartRepository.findById(id);

        return cartId;
    }

    public CartRequestParam cartCalculate(RequestParam param) {

        CartRequestParam cartRequestParam = new CartRequestParam();

        if (param == null) {
            throw new IllegalArgumentException("CartDTO cannot be null");
        }

        CartDTO cartDTO = GsonUtil.fromJson(String.valueOf(param.getCartDTO()), CartDTO.class);


        Optional<Product> productOpt = productRepository.findById(cartDTO.getProduct_id());
        Product productObj = productOpt.orElseThrow(() -> new EntityNotFoundException("Product ID " + cartDTO.getProduct_id() + " not found."));

        Optional<Discount> discountOpt = discountRepository.findById(cartDTO.getDiscount_id());
        Discount discountObj = discountOpt.orElseThrow(() -> new EntityNotFoundException("Discount ID " + cartDTO.getDiscount_id() + " not found."));

        Optional<User> userOpt = userRepository.findById(cartDTO.getUser_id());
        User userObj = userOpt.orElseThrow(() -> new EntityNotFoundException("User ID " + cartDTO.getUser_id() + " not found."));


        BigDecimal discountedPrice = new BigDecimal(discountObj.getDiscountValue());

        if (discountObj.getDiscountType().equals(DiscountConstants.COUPON_FIXED_T)) {

            discountedPrice = discountedPrice.subtract(DiscountConstants.COUPON_FIXED);

        } else if (discountObj.getDiscountType().equals(DiscountConstants.COUPON_PERCENTAGE_T)) {

            BigDecimal discountAmount = discountedPrice.multiply( DiscountConstants.COUPON_PERCENTAGE.divide(new BigDecimal(100)) );
            discountedPrice = discountedPrice.subtract(discountAmount);

        } else if (discountObj.getDiscountType().equals(DiscountConstants.ON_TOP_PERCENTAGE_T)) {

            if (productObj.getCategory().getName().equals(DiscountConstants.CLOTHING_T)) {

                BigDecimal discountAmount = discountedPrice.multiply(DiscountConstants.ON_TOP_PERCENTAGE.divide(new BigDecimal(100)));
                discountedPrice = discountedPrice.subtract(discountAmount);
            }

        } else if (discountObj.getDiscountType().equals(DiscountConstants.ON_TOP_POINT_T)) {

            discountedPrice = discountedPrice.subtract(DiscountConstants.ON_TOP_POINT.multiply(discountedPrice));

        } else if (discountObj.getDiscountType().equals(DiscountConstants.SEASONAL_CAMPAIGN_T)) {
            BigDecimal discountAmount = discountedPrice.divide(new BigDecimal("300"));
            discountedPrice = discountedPrice.subtract(discountAmount.multiply(DiscountConstants.SEASONAL_CAMPAIGN));
        }

        cartRequestParam.putBigDecimal("Price", discountedPrice);

        return cartRequestParam;
    }

}
