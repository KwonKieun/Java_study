SELECT * FROM COURSE;
SELECT * FROM LECTURE;
# 컴퓨터공학 고길동 학생이 수강신청한 강의 개수를 조회하는 쿼리
SELECT ST_NAME AS '이름', ST_MAJOR AS '전공', COUNT(*) AS '신청한 강의 수'
FROM COURSE JOIN STUDENT
ON CO_ST_NUM = ST_NUM
WHERE ST_NAME = '고길동' AND ST_MAJOR = '컴퓨터공학'
GROUP BY CO_ST_NUM;

# 컴퓨터공학 고길동 학생이 수강신청한 학점을 조회하는 쿼리
SELECT ST_NAME AS '이름', ST_MAJOR AS '전공', SUM(LE_POINT) AS '수강 신청 학점'
FROM COURSE JOIN STUDENT
ON CO_ST_NUM = ST_NUM
JOIN LECTURE
ON CO_LE_NUM = LE_NUM
WHERE ST_NAME = '고길동' AND ST_MAJOR = '컴퓨터공학'
GROUP BY CO_ST_NUM;

# 24학년 신입생을 조회하는 쿼리
SELECT * FROM STUDENT
WHERE ST_NUM LIKE '2024%' AND ST_GRADE = 1;

# 각 전공별 학생수를 조회하는 쿼리
SELECT ST_MAJOR AS '전공', COUNT(*) AS '학생 수'
FROM STUDENT
GROUP BY ST_MAJOR;

# 강의별 수강신청한 학생 수를 조회하는 쿼리 : 강의명, 학생 수 순으로 조회
SELECT LE_TITLE AS '강의명', COUNT(*) AS '학생 수'
FROM LECTURE JOIN COURSE
ON LE_NUM = CO_LE_NUM
GROUP BY LE_NUM;

# 컴퓨터공학을 다니는 학생 정보를 조회(O)
SELECT * FROM student
WHERE st_major = '컴퓨터공학';

# 컴퓨터공학을 다니는 1학년 학생정보 조회(O)
SELECT * FROM STUDENT
WHERE ST_MAJOR = '컴퓨터공학' 
AND ST_GRADE = 1;

# 컴퓨터공학 또는 화학공학을 다니는 1학년 학생 정보 조회(O)
SELECT * FROM STUDENT
WHERE ST_MAJOR IN('컴퓨터공학', '화학공학')
AND ST_GRADE = 1;

# 컴퓨터공학을 다니는 학생 수를 조회(O)
SELECT ST_MAJOR AS 학과, COUNT(*) AS 학생수 FROM STUDENT
WHERE ST_MAJOR = '컴퓨터공학'
GROUP BY ST_MAJOR;

# 학생들이 등록된 학과를 조회(O)
SELECT ST_MAJOR AS 학과 FROM STUDENT
GROUP BY ST_MAJOR;
SELECT DISTINCT ST_MAJOR AS 학과 FROM STUDENT;

# 학생들이 3명 이상 등록된 학과들을 조회(O)
SELECT ST_MAJOR AS 학과, COUNT(*) AS 학생수 FROM STUDENT
GROUP BY ST_MAJOR
HAVING COUNT(*) >= 3;

# 컴퓨터개론을 수강하는 학생 수를 조회(O)
SELECT LE_TITLE AS 강의명, COUNT(*) AS 학생수 FROM LECTURE JOIN COURSE ON LE_NUM = CO_LE_NUM
WHERE LE_TITLE = '컴퓨터개론'
GROUP BY CO_LE_NUM;  -- 묶어주는 것은 기본키로

SELECT * FROM COURSE;
SELECT * FROM LECTURE;

# 각 강의별 수강하는 학생 수를 조회, 강의명과 학생수를 조회(O)
SELECT LE_TITLE AS 강의명, COUNT(*) AS 학생수 FROM LECTURE JOIN COURSE ON LE_NUM = CO_LE_NUM
GROUP BY CO_LE_NUM;

# 홍길동 학생이 수강하는 강의 목록을 조회(O)
SELECT ST_NAME, LE_TITLE
FROM COURSE JOIN STUDENT ON CO_ST_NUM = ST_NUM
JOIN LECTURE ON CO_LE_NUM = LE_NUM
WHERE ST_NAME = '홍길동';

# 기계공학에 소속된 교수의 수를 조회
SELECT PR_MAJOR AS 학과, COUNT(*) AS '교수의 수' FROM PROFESSOR
WHERE PR_MAJOR = '기계공학';

SELECT * FROM PROFESSOR;

# 김교수가 강의하는 강의명을 조회
SELECT 
    PR_NAME, LE_TITLE
FROM
    PROFESSOR
        JOIN
    LECTURE ON PR_NUM = LE_PR_NUM
WHERE
    PR_NAME = '김교수';
