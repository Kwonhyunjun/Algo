-- 코드를 작성해주세요

WITH UNUPGRADE as (
    SELECT PARENT_ITEM_ID, COUNT(PARENT_ITEM_ID)
    FROM ITEM_TREE
    WHERE PARENT_ITEM_ID is not NULL
    GROUP BY PARENT_ITEM_ID    
)

SELECT ITEM_ID,ITEM_NAME, RARITY
FROM ITEM_INFO
WHERE ITEM_ID not in (SELECT PARENT_ITEM_ID
    FROM ITEM_TREE
    WHERE PARENT_ITEM_ID is not NULL
    GROUP BY PARENT_ITEM_ID )
ORDER BY 1 DESC