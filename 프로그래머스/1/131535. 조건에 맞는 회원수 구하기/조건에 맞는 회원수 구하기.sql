-- 코드를 입력하세요
SELECT count(*)
FROM USER_INFO
WHERE year(JOINED) = 2021 and AGE between 20 and 29; 