-- 코드를 입력하세요
WITH review_count as(
    SELECT MEMBER_ID, COUNT(*) as 'CNT'
    FROM REST_REVIEW
    GROUP BY MEMBER_ID
),
MOST_REVIEW as(
    SELECT MEMBER_ID, CNT
    FROM review_count
    WHERE CNT = (SELECT MAX(CNT) FROM review_count)
)

# SELECT * FROM MOST_REVIEW

SELECT MEMBER_NAME, REVIEW_TEXT, DATE_FORMAT(REVIEW_DATE, '%Y-%m-%d') as 'REVIEW_DATE'
FROM MEMBER_PROFILE a INNER JOIN REST_REVIEW b ON a.MEMBER_ID = b.MEMBER_ID
WHERE a.MEMBER_ID in (SELECT MEMBER_ID FROM MOST_REVIEW)
ORDER BY 3, 2