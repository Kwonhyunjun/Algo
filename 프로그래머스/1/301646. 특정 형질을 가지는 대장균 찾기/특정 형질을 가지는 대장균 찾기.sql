-- 코드를 작성해주세요
SELECT COUNT(*) as 'COUNT'
FROM ECOLI_DATA
WHERE (subString(CONV(GENOTYPE, 10, 2), -2, 1) = 0) AND
    (
        subString(CONV(GENOTYPE, 10, 2), -1, 1) = 1 OR
        subString(CONV(GENOTYPE, 10, 2), -3, 1) = 1
    )