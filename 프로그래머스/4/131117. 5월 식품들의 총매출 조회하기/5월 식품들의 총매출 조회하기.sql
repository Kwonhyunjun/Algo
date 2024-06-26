-- 코드를 입력하세요
SELECT a.PRODUCT_ID, PRODUCT_NAME, (SUM(AMOUNT) * PRICE) FEE
FROM FOOD_PRODUCT a JOIN FOOD_ORDER b on a.PRODUCT_ID = b.PRODUCT_ID
WHERE SUBSTRING(PRODUCE_DATE, 1, 7) = '2022-05'
GROUP BY a.PRODUCT_ID
ORDER BY (SUM(AMOUNT) * PRICE) DESC, a.PRODUCT_ID;