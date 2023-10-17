# select * from APPOINTMENT; 

select MCDP_CD '진료과 코드', count(MCDP_CD) '5월예약건수' 
from APPOINTMENT
where month(APNT_YMD) = 5
group by MCDP_CD
order by count(PT_NO), MCDP_CD;