-- 코드를 입력하세요
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d')DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE month(DATE_OF_BIRTH) = 3 and TLNO is not NULL and GENDER = 'W'
ORDER BY MEMBER_ID; 