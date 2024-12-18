-- 코드를 입력하세요
SELECT B.BOOK_ID, A.AUTHOR_NAME, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
FROM BOOK AS B
JOIN AUTHOR AS A
ON B.AUTHOR_ID = A.AUTHOR_ID
WHERE B.CATEGORY = '경제'
ORDER BY B.PUBLISHED_DATE;