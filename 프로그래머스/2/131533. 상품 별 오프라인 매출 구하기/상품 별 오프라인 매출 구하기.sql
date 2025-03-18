-- 코드를 입력하세요
SELECT product_code as 'PRODUCT_CODE'
, SUM(sales_amount) * price as 'SALES'
FROM PRODUCT a JOIN OFFLINE_SALE b ON a.PRODUCT_ID = b.PRODUCT_ID
GROUP BY product_code
ORDER BY 2 DESC, 1 ASC