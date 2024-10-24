
WITH total_score as (
    SELECT EMP_NO, SUM(SCORE) as "SCORE" FROM HR_GRADE GROUP BY EMP_NO
)

SELECT
    SCORE,
    a.EMP_NO,
    EMP_NAME,
    POSITION,
    EMAIL
FROM 
    HR_EMPLOYEES a INNER JOIN total_score b ON a.EMP_NO = b.EMP_NO
WHERE
    score = (SELECT MAX(SCORE) FROM total_score )


    