-- 코드를 입력하세요
SELECT a.FLAVOR
FROM 
(select FLAVOR, sum(TOTAL_ORDER) SUM_ORDER from FIRST_HALF group by flavor) a JOIN
(select FLAVOR, sum(TOTAL_ORDER) SUM_ORDER from JULY group by flavor) b on a.FLAVOR = b.FLAVOR
ORDER BY (a.SUM_ORDER +b.SUM_ORDER) DESC limit 3;