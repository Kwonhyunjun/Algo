SELECT year(b.SALES_DATE) YEAR, month(b.SALES_DATE) MONTH, 
a.GENDER, count(DISTINCT b.USER_ID) USERS
FROM USER_INFO a Inner JOIN ONLINE_SALE b on a.USER_ID = b.USER_ID
WHERE a.GENDER is not null
GROUP BY year(b.SALES_DATE), month(b.SALES_DATE), a.GENDER
# ORDER BY year(b.SALES_DATE), month(b.SALES_DATE), a.GENDER;

# select * from ONLINE_SALE
# group by year(sales_date), month(sales_date);