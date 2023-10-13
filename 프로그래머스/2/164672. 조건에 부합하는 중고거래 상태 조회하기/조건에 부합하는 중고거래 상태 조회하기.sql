-- 코드를 입력하세요
SELECT BOARD_ID, WRITER_ID, TITLE, PRICE, 
CASE
WHEN STATUS = 'RESERVED' then '예약중'
WHEN STATUS = 'DONE' then '거래완료'
WHEN STATUS = 'SALE' then '판매중' 
END STATUS
FROM USED_GOODS_BOARD
WHERE CREATED_DATE = '2022-10-05'
ORDER BY BOARD_ID desc;

