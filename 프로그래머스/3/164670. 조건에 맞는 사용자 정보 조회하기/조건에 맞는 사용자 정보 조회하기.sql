-- 코드를 입력하세요
SELECT USER_ID, NICKNAME, concat(CITY, " ", STREET_ADDRESS1, " ",STREET_ADDRESS2) 전체주소, 
CONCAT(LEFT(TLNO, 3), '-', MID(TLNO, 4, 4), '-', RIGHT(TLNO, 4)) 전화번호
# select *
FROM USED_GOODS_USER a INNER JOIN (SELECT WRITER_ID, count(*) from USED_GOODS_BOARD group by WRITER_ID having count(*) >= 3) b on a.USER_ID = b.WRITER_ID
ORDER BY USER_ID DESC; 

# SELECT WRITER_ID, count(*) from USED_GOODS_BOARD group by WRITER_ID having count(*) >= 3;