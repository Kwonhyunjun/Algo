-- 코드를 작성해주세요
SELECT
    COUNT(*) as 'FISH_COUNT',
    MONTH(TIME) as 'MONTH'
FROM
    FISH_INFO
GROUP BY
    MONTH(TIME)
ORDER BY
    2; 
    