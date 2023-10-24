-- 코드를 입력하세요
select distinct(CAR_ID) from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where month(START_DATE) = 10 and CAR_ID in (select CAR_ID from CAR_RENTAL_COMPANY_CAR where CAR_TYPE ='세단')
order by CAR_ID desc; 

# select CAR_ID from CAR_RENTAL_COMPANY_CAR where CAR_TYPE ='세단';