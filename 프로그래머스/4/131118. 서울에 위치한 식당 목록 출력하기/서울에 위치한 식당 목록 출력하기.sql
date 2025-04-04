WITH review_avg AS (
    SELECT REST_ID, ROUND(AVG(REVIEW_SCORE), 2) as 'SCORE'
    FROM REST_REVIEW
    GROUP BY REST_ID
),

seoul_resto AS (
    SELECT *
    FROM REST_INFO
    WHERE ADDRESS LIKE "서울%"
)



SELECT a.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, SCORE
FROM seoul_resto a JOIN review_avg b ON a.REST_ID = b.REST_ID
ORDER BY SCORE DESC, FAVORITES DESC