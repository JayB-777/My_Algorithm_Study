# WITH RECURSIVE Generation AS (
#     SELECT ID, PARENT_ID, 1 AS Gen
#     FROM ECOLI_DATA
#     WHERE PARENT_ID IS NULL #3번호출했을때, 해당 ID의 PARENT_ID가 NULL이어야 함
#     UNION ALL
#     SELECT ED.ID, ED.PARENT_ID, Gen + 1
#     FROM ECOLI_DATA AS ED
#     JOIN Generation AS G
#     ON ED.PARENT_ID = G.ID
# )
# SELECT ID
# FROM Generation
# WHERE Gen = 3
# ORDER BY ID ASC;

WITH RECURSIVE Ancestry AS (
    -- Anchor Member: 모든 ID에서 시작
    SELECT ID, PARENT_ID, ID AS StartID, 1 AS Gen
    FROM ECOLI_DATA

    UNION ALL

    -- Recursive Member: 부모를 추적
    SELECT ED.ID, ED.PARENT_ID, A.StartID, A.Gen + 1
    FROM ECOLI_DATA AS ED
    JOIN Ancestry AS A
    ON ED.ID = A.PARENT_ID
)
SELECT StartID AS ID
FROM Ancestry
WHERE PARENT_ID IS NULL AND GEN = 3 -- 루트 조상을 찾음
ORDER BY StartID ASC;