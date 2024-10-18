-- History에서 대여일수 찾기
WITH DURATION as (
    SELECT 
        b.DAILY_FEE, 
        b.CAR_TYPE,
        a.HISTORY_ID, 
        DATEDIFF(end_date, start_date)+1 as period, 
        CASE
            WHEN DATEDIFF(end_date, start_date)+1 >= 90 THEN '90일 이상'
            WHEN DATEDIFF(end_date, start_date)+1 >= 30 THEN '30일 이상'
            WHEN DATEDIFF(end_date, start_date)+1 >= 7 THEN '7일 이상'
            ELSE '해당없음'
        END as duration_type
    FROM
        CAR_RENTAL_COMPANY_RENTAL_HISTORY a JOIN CAR_RENTAL_COMPANY_CAR b
        ON a.CAR_ID = b.CAR_ID
    WHERE
        b.CAR_TYPE = '트럭'
)

SELECT
    a.HISTORY_ID,
    ROUND(a.DAILY_FEE * a.period * (100 - IFNULL(b.discount_rate, 0)) / 100) as FEE
FROM
    DURATION a LEFT JOIN car_rental_company_discount_plan b
    ON a.duration_type = b.duration_type
    AND b.car_type = a.car_type
ORDER BY 
    2 DESC,
    1 DESC