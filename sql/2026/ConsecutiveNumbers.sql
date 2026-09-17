-- Table: Logs

-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | id          | int     |
-- | num         | varchar |
-- +-------------+---------+
-- In SQL, id is the primary key for this table.
-- id is an autoincrement column starting from 1.
 

-- Find all numbers that appear at least three times consecutively.

-- Return the result table in any order.

-- The result format is in the following example.

 

-- Example 1:

-- Input: 
-- Logs table:
-- +----+-----+
-- | id | num |
-- +----+-----+
-- | 1  | 1   |
-- | 2  | 1   |
-- | 3  | 1   |
-- | 4  | 2   |
-- | 5  | 1   |
-- | 6  | 2   |
-- | 7  | 2   |
-- +----+-----+
-- Output: 
-- +-----------------+
-- | ConsecutiveNums |
-- +-----------------+
-- | 1               |
-- +-----------------+
-- Explanation: 1 is the only number that appears consecutively for at least three times.
-- Write your PostgreSQL query statement below
-- with tmp as (select num, 
-- LAG(num, 1) OVER(order by num) as prev_num
-- from Logs)
-- select num as "ConsecutiveNums"
-- from tmp
-- group by num
-- having count(*) filter(where prev_num = num) >= 3;


-- with tmp as (select id,  num, 
-- LAG(num, 1, num) OVER(order by id) as prev_num
-- from Logs)
-- select id, num, prev_num,
-- from tmp;


 with tmp as 
 (select id, num, 
-- LAG(id, 1, 0) OVER(order by id) as prev_id,
LAG(num, 1, null) OVER(order by id) as prev_num,
LEAD(num, 1, null) OVER(order by id) as next_num
from Logs)

select num as "ConsecutiveNums"
-- count(*) filter(where prev_num = num and num = next_num ) as counts,
from tmp
group by num
having count(*) filter(where prev_num = num and num = next_num ) >= 1;