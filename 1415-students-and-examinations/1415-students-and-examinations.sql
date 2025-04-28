# Write your MySQL query statement below
Select
s.student_id as student_id,
s.student_name as student_name,
sb.subject_name as subject_name,
Count(e.subject_name) as attended_exams
from
Students s
Cross Join
Subjects sb
Left Join
Examinations e
on
s.student_id = e.student_id
and 
sb.subject_name = e.subject_name
Group by s.student_id, s.student_name, sb.subject_name
Order by s.student_id, sb.subject_name;
