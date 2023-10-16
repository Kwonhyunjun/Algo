-- 코드를 입력하세요
SELECT c.PRODUCT_CODE ,sum(c.price * s.sales_amount) SALES
FROM PRODUCT c join OFFLINE_SALE s on c.product_id = s.product_id
GROUP BY c.PRODUCT_CODE
ORDER BY SALES DESC, PRODUCT_CODE; 

# SELECT * 
# FROM PRODUCT;

# SELECT count(*) 
# FROM OFFLINE_SALE;