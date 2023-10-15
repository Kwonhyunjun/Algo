-- 코드를 입력하세요
# SELECT ANIMAL_ID, NAME 
# FROM

# select * from ANIMAL_INS where name = 'daisy'; 
# select * from ANIMAL_OUTS where name = 'daisy'; 

select B.ANIMAL_ID, B.NAME 
from ANIMAL_INS A right join ANIMAL_OUTS B on A.ANIMAL_ID = B.ANIMAL_ID
where A.ANIMAL_ID is null;

