-- 코드를 입력하세요

-- 젊은 동물의 아이디와 이름을 조회하는 SQL 결과는 아이디 순으로 조회
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION != 'Aged'
ORDER BY ANIMAL_ID;