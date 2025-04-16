-- 코드를 입력하세요
WITH TBL as (
    
SELECT a.car_id, daily_fee, HISTORY_ID,  
DATEDIFF(end_date, start_date)+1 DIFF,
    CASE 
        WHEN DATEDIFF(end_date, start_date)+1 >= 90 THEN '90일 이상'
        WHEN DATEDIFF(end_date, start_date)+1 >= 30 THEN '30일 이상'
        WHEN DATEDIFF(end_date, start_date)+1 >= 7 THEN '7일 이상'
        ELSE NULL
    END as duration
FROM CAR_RENTAL_COMPANY_CAR a INNER JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY b ON a.CAR_ID = b.CAR_ID
WHERE a.CAR_TYPE = '트럭'

)

# SELECT CAR_TYPE, DISCOUNT_RATE FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
# WHERE DURATION_TYPE = '90일 이상' AND CAR_TYPE = '트럭'


SELECT HISTORY_ID, ROUND(diff * daily_fee * (1 - IFNULL((
        SELECT discount_rate * 0.01
        FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
        WHERE duration_type = tbl.duration AND car_type = '트럭'
    ), 0)), 0) AS fee
FROM TBL 
ORDER BY 2 DESC, 1 DESC