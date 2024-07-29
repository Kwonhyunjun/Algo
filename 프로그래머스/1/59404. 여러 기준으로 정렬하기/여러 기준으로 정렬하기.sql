-- 코드를 입력하세요
-- 이름이 같은 동물 중에서는 보호를 나중에 시작한 동물을 먼저 보여줌
SELECT ANIMAL_ID, NAME, DATETIME
FROM ANIMAL_INS
ORDER BY NAME, DATETIME DESC; 