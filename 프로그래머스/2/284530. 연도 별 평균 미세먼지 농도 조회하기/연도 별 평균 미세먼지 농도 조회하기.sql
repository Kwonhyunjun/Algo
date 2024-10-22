-- 코드를 작성해주세요
SELECT
    YEAR(YM) as "YEAR",
    ROUND(AVG(PM_VAL1), 2) as "PM10",
    ROUND(AVG(PM_VAL2), 2) as "PM2.5"
FROM
    AIR_POLLUTION
WHERE 
    LOCATION2 = "수원"
GROUP BY
    YEAR(YM)
ORDER BY 
    1; 