-- 코드를 작성해주세요
SELECT
    COUNT(ID) as FISH_COUNT,
    b.FISH_NAME
FROM 
    FISH_INFO a INNER JOIN FISH_NAME_INFO b 
    ON a.FISH_TYPE = b.FISH_TYPE
GROUP BY b.FISH_NAME
ORDER BY 1 DESC