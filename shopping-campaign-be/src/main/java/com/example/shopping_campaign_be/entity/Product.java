package com.example.shopping_campaign_be.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;

    private String price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

//    @ManyToOne(fetch = FetchType.LAZY) // สินค้าอาจมีส่วนลดได้หลายแบบ หรือไม่มีเลยก็ได้
//    @JoinColumn(name = "discount_id") // Optional: ถ้าต้องการให้สินค้ามีส่วนลดโดยตรง
//    private Discount discount;
//
//    // เพิ่มฟังก์ชันสำหรับคำนวณราคาหลังจากหักส่วนลด
//    public BigDecimal getPriceAfterDiscount() {
//        if (this.discount == null) {
//            return this.price;
//        }
//
//        BigDecimal discountedPrice = this.price;
//
//        if (this.discount.getDiscountType() == Discount.DiscountType.FIXED_AMOUNT) {
//
//            discountedPrice = discountedPrice.subtract(this.discount.getDiscountValue());
//
//        } else if (this.discount.getDiscountType() == Discount.DiscountType.PERCENTAGE) {
//
//            BigDecimal discountAmount = this.price.multiply(this.discount.getDiscountValue().divide(new BigDecimal(100)));
//            discountedPrice = discountedPrice.subtract(discountAmount);
//
//        }
//
//        return discountedPrice.max(BigDecimal.ZERO); // ไม่ให้ราคาติดลบ
//    }


}
