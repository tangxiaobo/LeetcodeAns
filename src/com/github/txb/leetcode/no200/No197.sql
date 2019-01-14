/**

  197. Rising Temperature

  Given a Weather table, write a SQL query to find all dates' Ids with higher temperature compared to its previous (yesterday's) dates.
  +---------+------------------+------------------+
  | Id(INT) | RecordDate(DATE) | Temperature(INT) |
  +---------+------------------+------------------+
  |       1 |       2015-01-01 |               10 |
  |       2 |       2015-01-02 |               25 |
  |       3 |       2015-01-03 |               20 |
  |       4 |       2015-01-04 |               30 |
  +---------+------------------+------------------+

  For example, return the following Ids for the above Weather table:
  +----+
  | Id |
  +----+
  |  2 |
  |  4 |
  +----+

  Created by tanghui on 2018/6/13.

 */

--MySQL
select w1.Id from Weather w1
inner join Weather w2
on to_days(w1.RecordDate) = to_days(w2.RecordDate) + 1
where w1.Temperature > w2.Temperature