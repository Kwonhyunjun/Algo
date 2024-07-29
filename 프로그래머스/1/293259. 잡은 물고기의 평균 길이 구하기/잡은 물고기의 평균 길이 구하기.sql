-- 코드를 작성해주세요
SELECT ROUND(AVG(LENGTH), 2) as 'AVERAGE_LENGTH'
FROM (
        SELECT 
            CASE 
                WHEN LENGTH is null THEN 10
                ELSE LENGTH
            END as 'LENGTH'
        FROM FISH_INFO) as NEW_TABLE