-- 코드를 입력하세요

WITH JANUARY AS(
    SELECT * 
    FROM BOOK_SALES
    WHERE SALES_DATE LIKE '2022-01%'
)


SELECT b.AUTHOR_ID, c.AUTHOR_NAME, b.CATEGORY, SUM(b.PRICE * a.SALES) 'TOTAL_SALES'
FROM JANUARY a JOIN BOOK b JOIN AUTHOR c ON a.BOOK_ID = b.BOOK_ID AND b.AUTHOR_ID = c.AUTHOR_ID
GROUP BY b.AUTHOR_ID, b.CATEGORY
ORDER BY 1, 3 DESC