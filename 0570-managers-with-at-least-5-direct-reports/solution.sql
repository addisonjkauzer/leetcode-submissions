# Write your MySQL query statement below
SELECT manager.name FROM Employee AS manager JOIN Employee as subord ON manager.id = subord.managerId GROUP BY manager.id HAVING COUNT(subord.id) >= 5;