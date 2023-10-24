-- 코드를 입력하세요
SELECT HISTORY_ID, CAR_ID, date_format(START_DATE, '%Y-%m-%d') START_DATE, date_format(END_DATE, '%Y-%m-%d') END_DATE,
case 
    when datediff(end_date, start_date)+1  >= 30 then '장기 대여'
    else '단기 대여'
end as RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE year(START_DATE) = 2022 and month(START_DATE) = 9
ORDER BY HISTORY_ID DESC ;

# select * from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# WHERE year(START_DATE) = year(END_DATE) and month(START_DATE) = month(END_DATE) and day(START_DATE) = day(END_DATE); 

# select datediff(end_date, start_date)from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# WHERE history_id = 513;