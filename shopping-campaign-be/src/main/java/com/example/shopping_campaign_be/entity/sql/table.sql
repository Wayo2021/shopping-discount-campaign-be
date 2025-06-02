-- Insert Category
INSERT INTO category (name) VALUES ('Clothing'), ('Accessories'), ('Electronics');

-- Insert Product
INSERT INTO product (name, price, category_id) VALUES ('Hoodie', '700', 1);
INSERT INTO product (name, price, category_id) VALUES ('T-Shirt', '350', 1);
INSERT INTO product (name, price, category_id) VALUES ('Hat', '250', 2);
INSERT INTO product (name, price, category_id) VALUES ('Watch', '850', 2);
INSERT INTO product (name, price, category_id) VALUES ('Bag', '640', 2);
INSERT INTO product (name, price, category_id) VALUES ('Belt', '230', 2);
INSERT INTO product (name, price, category_id) VALUES ('Smartphone', '1000', 3);

-- Insert User
INSERT INTO user (name, points) VALUES ('Wayo Wayo', '100'), ('Somchai Somchai', '150');

-- Insert Discount
INSERT INTO discount (name, discountType, discountValue) VALUES ('Fixed Amount', 'Coupon Fixed', 50);
INSERT INTO discount (name, discountType, discountValue) VALUES ('Percentage Discount', 'Coupon Percentage', 10);
INSERT INTO discount (name, discountType, discountValue) VALUES ('Percentage discount by item category', 'Ontop Percentage', 15);
INSERT INTO discount (name, discountType, discountValue) VALUES ('Discount by points', 'Ontop Point', 1);
INSERT INTO discount (name, discountType, discountValue) VALUES ('Special campaigns', 'Seasonal campaign', 40);

-- Insert Point (สำหรับการสะสมคะแนนของผู้ใช้)
INSERT INTO point (points_spent, points_balance, user_id) VALUES (20, 80, 1);
INSERT INTO point (points_spent, points_balance, user_id) VALUES (30, 120, 2);

-- Insert Cart (ตะกร้าสินค้าของผู้ใช้)
INSERT INTO cart (quantity, product_id, discount_id, user_id) VALUES ('2', 1, 1, 1);
INSERT INTO cart (quantity, product_id, discount_id, user_id) VALUES ('1', 2, 2, 2);