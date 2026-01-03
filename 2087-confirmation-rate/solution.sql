# Write your MySQL query statement below
WITH confirmed AS (SELECT Signups.user_id, COUNT(Confirmed.action) AS count FROM Signups LEFT JOIN Confirmations as Confirmed ON Signups.user_id = Confirmed.user_id AND Confirmed.action = 'confirmed' GROUP BY Signups.user_id),

total AS (SELECT Signups.user_id, COUNT(Confirmations.action) AS count FROM Signups LEFT JOIN Confirmations ON Signups.user_id = Confirmations.user_id GROUP BY Signups.user_id)

SELECT confirmed.user_id, COALESCE(ROUND(confirmed.count / total.count, 2), 0) as confirmation_rate FROM confirmed JOIN total ON confirmed.user_id = total.user_id;