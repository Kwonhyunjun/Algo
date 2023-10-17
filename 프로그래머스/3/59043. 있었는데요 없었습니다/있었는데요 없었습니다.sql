-- 코드를 입력하세요
select a.ANIMAL_ID, a.NAME
from ANIMAL_INS a inner join ANIMAL_OUTS b on a.ANIMAL_ID = b.ANIMAL_ID
where TIMESTAMPDIFF(MINUTE,a.DATETIME, b.DATETIME) < 0
order by a.DATETIME; 

# select * from ANIMAL_INS;