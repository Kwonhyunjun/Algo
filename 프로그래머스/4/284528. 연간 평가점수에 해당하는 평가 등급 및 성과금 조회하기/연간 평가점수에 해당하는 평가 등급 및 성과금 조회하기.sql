WITH SCORE_2022 as (
    SELECT
        EMP_NO, 
        ROUND(AVG(SCORE)) 'AVG_SCORE',
        CASE
            WHEN AVG(SCORE) >= 96 THEN 'S'
            WHEN AVG(SCORE) >= 90 THEN 'A'
            WHEN AVG(SCORE) >= 80 THEN 'B'
            ELSE 'C'
        END as 'GRADE'
    FROM 
        HR_GRADE
    GROUP BY 
        EMP_NO
)

SELECT
    a.EMP_NO,
    EMP_NAME,
    GRADE, 
    CASE
        WHEN GRADE = 'S' THEN SAL * 0.2
        WHEN GRADE = 'A' THEN SAL * 0.15
        WHEN GRADE = 'B' THEN SAL * 0.1
        ELSE 0 
    END as "BONUS"
FROM 
    HR_EMPLOYEES a INNER JOIN SCORE_2022 b ON a.EMP_NO = b.EMP_NO
ORDER BY 
    1