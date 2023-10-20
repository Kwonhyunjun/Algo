-- 코드를 입력하세요
SELECT FLAVOR
FROM FIRST_HALF
WHERE TOTAL_ORDER > 3000 
and FLAVOR in (select FLAVOR from ICECREAM_INFO where INGREDIENT_TYPE='fruit_based')
ORDER BY TOTAL_ORDER DESC;

# select * from first_half;
# select * from ICECREAM_INFO;
# select FLAVOR from ICECREAM_INFO where INGREDIENT_TYPE='fruit_based'