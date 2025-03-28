-- 코드를 입력하세요
SELECT user_id, product_id
FROM ONLINE_SALE

# WHERE user_id = 15 and product_id = 12
GROUP BY user_id, product_id
# ORDER BY user_id, product_id
HAVING COUNT(ONLINE_SALE_ID) > 1
ORDER BY 1 , 2 DESC