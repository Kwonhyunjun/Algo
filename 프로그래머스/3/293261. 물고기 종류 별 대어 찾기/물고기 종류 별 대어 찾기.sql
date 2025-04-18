SELECT a.ID, FISH_NAME, LENGTH
FROM (
        SELECT ID, FISH_TYPE, LENGTH, 
            RANK() OVER (PARTITION BY FISH_TYPE ORDER BY LENGTH DESC) as N
        FROM FISH_INFO
    ) a JOIN FISH_NAME_INFO b ON a.FISH_TYPE = b.FISH_TYPE
WHERE a.N = 1
ORDER BY 1;