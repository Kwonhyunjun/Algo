-- 코드를 입력하세요
# SELECT HOUR(DATETIME) as 'HOUR', COUNT(*) as 'COUNT'
# FROM ANIMAL_OUTS
# GROUP BY HOUR(DATETIME)
# ORDER BY 1

with recursive rc as (
    select 0 as hour
    union all
    select hour+1 from rc where hour<23
)

SELECT rc.hour, count(hour(a.datetime)) as count
FROM rc left join ANIMAL_OUTS as a ON rc.hour = hour(a.datetime) 
group by rc.hour
ORDER BY 1 

