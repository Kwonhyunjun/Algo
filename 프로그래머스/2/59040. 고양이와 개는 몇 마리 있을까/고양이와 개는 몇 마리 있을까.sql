-- 코드를 입력하세요
SELECT ANIMAL_TYPE, count(ANIMAL_TYPE) count
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
ORDER BY ANIMAL_TYPE; 

# select count(*) from ANIMAL_INS; 
# select * from ANIMAL_INS; 