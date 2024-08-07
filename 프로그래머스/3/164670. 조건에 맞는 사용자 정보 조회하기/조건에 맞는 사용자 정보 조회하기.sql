-- 코드를 입력하세요
WITH TARGET_USER AS (
    SELECT WRITER_ID, COUNT(WRITER_ID)
    FROM USED_GOODS_BOARD 
    GROUP BY WRITER_ID
    HAVING COUNT(WRITER_ID) >= 3
)


SELECT a.USER_ID, a.NICKNAME, CONCAT(a.CITY, " ", a.STREET_ADDRESS1, " ", a.STREET_ADDRESS2) '전체주소', 
    CONCAT(SUBSTRING(TLNO, 1, 3), '-', SUBSTRING(TLNO, 4, 4), '-',  SUBSTRING(TLNO, 8, 4)) '전화번호'
FROM USED_GOODS_USER a JOIN TARGET_USER b ON a.USER_ID = b.WRITER_ID
ORDER BY a.USER_ID DESC
