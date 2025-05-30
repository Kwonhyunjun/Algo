-- 코드를 입력하세요
SELECT b.CATEGORY, SUM(SALES) AS 'TOTAL_SALES'
FROM BOOK_SALES a INNER JOIN BOOK b ON a.BOOK_ID = b.BOOK_ID
WHERE YEAR(a.SALES_DATE) = 2022 and MONTH(a.SALES_DATE) = 1
GROUP BY b.CATEGORY
ORDER BY 1;