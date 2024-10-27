WITH average as (
    SELECT 
        DEPT_ID, ROUND(AVG(SAL), 0) as 'AVG_SAL'
    FROM
        HR_EMPLOYEES
    GROUP BY 
        DEPT_ID
)

SELECT a.DEPT_ID, b.DEPT_NAME_EN, a.AVG_SAL  FROM average a JOIN HR_DEPARTMENT b ON a.DEPT_ID = b.DEPT_ID
ORDER BY 
    3 desc