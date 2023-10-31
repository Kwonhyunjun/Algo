-- 코드를 입력하세요
# SELECT * from REST_INFO ;
# SELECT * from REST_REVIEW ;

select a.REST_ID, a.REST_NAME,	a.FOOD_TYPE,	a.FAVORITES, a.ADDRESS, round(avg(b.REVIEW_SCORE), 2) SCORE
from REST_INFO a inner join REST_REVIEW b on a.REST_ID = b.REST_ID
where ADDRESS like '서울%'
group by REST_ID
ORDER BY SCORE DESC, FAVORITES DESC;