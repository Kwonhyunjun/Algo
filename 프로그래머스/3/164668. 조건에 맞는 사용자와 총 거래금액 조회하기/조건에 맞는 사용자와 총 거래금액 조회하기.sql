-- 코드를 입력하세요
SELECT USER_ID, NICKNAME, SUM(PRICE) TOTAL_SALES
FROM USED_GOODS_BOARD a INNER JOIN USED_GOODS_USER b ON a.WRITER_ID = b.USER_ID
WHERE STATUS = 'DONE'
GROUP BY WRITER_ID
HAVING SUM(PRICE) >= 700000
ORDER BY 3 ASC

# SELECT WRITER_ID, SUM(PRICE) TOTAL_SALES
# FROM USED_GOODS_BOARD
# WHERE STATUS = 'DONE'
# GROUP BY WRITER_ID
# HAVING SUM(PRICE) > 700000

# SELECT * FROM USED_GOODS_USER