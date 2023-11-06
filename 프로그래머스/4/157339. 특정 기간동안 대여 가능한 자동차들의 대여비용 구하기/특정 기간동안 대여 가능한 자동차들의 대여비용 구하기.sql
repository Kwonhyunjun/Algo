-- 코드를 입력하세요

# 11월 1일 부터 11월 30일까지 대여 가능한 자동차 
# END_DATE 가 11월 1일 이전 끝 OR START_DATE가 11월 30일 이후에 시작
# SELECT * FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY WHERE START_DATE >= '2022-11-30'; 
# 10월달 12달 반납

# SELECT * FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY h INNER JOIN CAR_RENTAL_COMPANY_CAR c on h.CAR_ID = c.CAR_ID
# WHERE START_DATE >= '2022-11-30' OR END_DATE <'2022-11-01'
# GROUP BY h.CAR_ID;

# 목표 : 전체 차  - 안되는 차 = 가능 차를 구한 다음
# 그 중에서 세단과 SUV만 골라서
# 30일 간 대여금액을 할인율에 맞춰 계산한 것을 다시 조건으로 구해야됨

SELECT c.CAR_ID, c.CAR_TYPE, ROUND((daily_fee * 30 * (1 - discount_rate /100)), 0) FEE 
FROM CAR_RENTAL_COMPANY_CAR c JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN p on c.CAR_TYPE = p.CAR_TYPE
WHERE CAR_ID not in(
(SELECT DISTINCT(car_id) FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY WHERE START_DATE <= '2022-11-30' AND END_DATE >= '2022-11-01')) and c.CAR_TYPE in ('세단', 'SUV') and p.DURATION_TYPE like '%30%'
and ROUND((daily_fee * 30 * (1 - discount_rate /100)), 0) BETWEEN 500000 and 2000000
ORDER BY ROUND((daily_fee * 30 * (1 - discount_rate /100)), 0) DESC, c.CAR_TYPE, c.CAR_ID DESC; 


# 세단, SUV인 car_id 출력
# select * from CAR_RENTAL_COMPANY_CAR where CAR_TYPE in ('세단', 'SUV');

