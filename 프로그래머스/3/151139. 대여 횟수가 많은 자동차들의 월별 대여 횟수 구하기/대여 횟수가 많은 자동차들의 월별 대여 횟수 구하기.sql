SELECT MONTH(start_date) MONTH, CAR_ID, COUNT(history_id) RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID in (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE MONTH(START_DATE) between 8 and 10
    GROUP BY CAR_ID
    HAVING count(CAR_ID) >= 5
) and MONTH(START_DATE) between 8 and 10
GROUP BY MONTH(start_date), CAR_ID
ORDER BY MONTH(start_date), CAR_ID DESC;
