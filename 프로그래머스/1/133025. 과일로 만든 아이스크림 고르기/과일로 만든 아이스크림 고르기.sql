SELECT FH.FLAVOR
FROM FIRST_HALF AS FH
JOIN ICECREAM_INFO AS IC
ON FH.FLAVOR = IC.FLAVOR
WHERE IC.INGREDIENT_TYPE = 'fruit_based'
AND FH.TOTAL_ORDER >= 3000;