# 영화 웡카의 영화 정보를 검색하는 쿼리(배우 X, 감독 X, 제작국가 X, 장르 X)
SELECT * FROM movie WHERE mo_title = '웡카';

# 영화 웡카에 출연한 배우 및 감독을 조회하는 쿼리
SELECT 
    mo_title AS 제목, ch_name AS 이름, mp_role AS 구분
FROM
    movie
        JOIN
    `join` ON mo_num = jo_mo_num
        JOIN
    `movie_person` ON mp_num = jo_mp_num
        JOIN
    `character` ON ch_num = mp_ch_num
WHERE
    mo_title = '웡카';
    
# CGV강남 1상영관에 등록된 좌석을 조회하는 쿼리
SELECT 
    th_name, se_name
FROM
    seat
        JOIN
    screen ON se_sc_num = sc_num
        JOIN
    theater ON th_num = sc_th_num
WHERE
    th_name = 'CGV강남' AND sc_name = 1;
    
# CGV강남에 등록된 좌석을 조회하는 쿼리
SELECT 
    th_name, sc_name, se_name
FROM
    seat
        JOIN
    screen ON se_sc_num = sc_num
        JOIN
    theater ON th_num = sc_th_num
WHERE
    th_name = 'CGV강남';
    
# CGV강남에 등록된 좌석 수를 조회하는 쿼리
SELECT 
    th_name, COUNT(*) AS 좌석수
FROM
    seat
        JOIN
    screen ON se_sc_num = sc_num
        JOIN
    (SELECT 
        *
    FROM
        theater) AS th ON th_num = sc_th_num
WHERE
    th_name = 'CGV강남';


# 영화 웡카를 상영하고 있는 극장을 조회하는 쿼리
SELECT distinct th_name, mo_title FROM theater JOIN screen ON sc_th_num = th_num
JOIN `schedule` ON sc_num = sh_sc_num
JOIN movie ON sh_mo_num = mo_num
WHERE mo_title = '웡카';

# CGV강남 1상영관에 웡카 상영 시간을 조회하는 쿼리
SELECT mo_title as 영화, th_name as 극장, sh_date as 날짜, sh_time as 시간 FROM schedule JOIN screen ON sh_sc_num = sc_num
JOIN theater ON th_num = sc_th_num
JOIN movie ON mo_num = sh_mo_num
WHERE th_name = 'CGV강남' AND sc_name = 1 AND mo_title = '웡카';

# CGV강남 1상영관에 있는 좌석들을 조회하는 쿼리
SELECT 
    se_name
FROM
    seat
        JOIN
    screen ON se_sc_num = sc_num
        JOIN
    theater ON sc_th_num = th_num
WHERE
    th_name = 'CGV강남' AND sc_name = 1;

# 2월 9일 10:30분 CGV강남 1상영관에서 상영하는 웡카의 좌석을 조회하는 쿼리
SELECT 
    sh_date, sh_time, se_name
FROM
    seat
        JOIN
    screen ON se_sc_num = sc_num
        JOIN
    theater ON sc_th_num = th_num
        JOIN
    schedule ON sh_sc_num = sc_num
WHERE
    th_name = 'CGV강남' AND sc_name = 1
        AND sh_date = '2024-02-09'
        AND sh_time = '10:30';

# CGV강남 1상영관 2월 9일 10:30 웡카를 예매한 좌석들을 조회
SELECT se_name FROM ticketing_list JOIN ticketing ON tl_ti_num = ti_num
JOIN seat ON tl_se_num = se_num
JOIN schedule ON ti_sh_num = sh_num
JOIN screen ON sh_sc_num = sc_num
JOIN theater ON sc_th_num = th_num
JOIN movie ON mo_num = sh_mo_num
WHERE th_name = 'CGV강남' AND sc_name = 1 AND sh_date = '2024-02-09' AND sh_time = '10:30' AND mo_title = '웡카';

# 1번 스케쥴을 예매한 좌석들을 조회
SELECT 
    se_name
FROM
    schedule
        JOIN
    ticketing ON ti_sh_num = sh_num
		JOIN
	ticketing_list ON tl_ti_num = ti_num
		JOIN
	seat ON se_num = tl_se_num
WHERE
    sh_num = 1;
    
# 1번 스케쥴에서 좌석들 예약 상태를 조회 하는 쿼리 (예약되면 tl_num를 보여주고, 아니면 null)
SELECT 
    se_name AS 좌석, IFNULL(tl_num, 'O')
FROM
    seat
        JOIN
    screen ON sc_num = se_sc_num
        JOIN
    schedule ON sh_sc_num = sc_num
        LEFT JOIN
    (SELECT 
        *
    FROM
        ticketing_list
    JOIN ticketing ON ti_num = tl_ti_num
    WHERE
        ti_sh_num = 1) AS t ON tl_se_num = se_num
WHERE
    sh_num = 1;

# abc123 회원이 예매한 영화 목록을 조회하는 쿼리
SELECT DISTINCT
    ti_me_id, mo_title
FROM
    ticketing
        JOIN
    schedule ON ti_sh_num = sh_num
        JOIN
    movie ON sh_mo_num = mo_num
WHERE
    ti_me_id = 'abc123';

# 1번 상영시간(웡카, CGV강남 1상영관 10:30 스케줄)이 예매된 수량을 조회
-- SELECT 
--     COUNT(*)
-- FROM
--     ticketing_list
--         JOIN
--     ticketing ON tl_ti_num = ti_num
-- WHERE
--     ti_sh_num = 1;
SELECT 
    SUM(ti_adult) + SUM(ti_teenager) AS 예매수량
FROM
    ticketing
WHERE
    ti_sh_num = 1;

# 폴 킹 감독이 감독으로 연출한 영화를 조회하는 쿼리
SELECT 
    mo_title
FROM
    movie
        JOIN
    `join` ON jo_mo_num = mo_num
        JOIN
    movie_person ON mp_num = jo_mp_num
        JOIN
    `character` ON ch_num = mp_ch_num
WHERE
    mp_role = '감독' AND ch_name = '폴 킹';

# 장르별 등록된 영화 개수를 조회하는 쿼리
SELECT ge_name, count(gi_mo_num) FROM genre LEFT JOIN genre_include
ON ge_name = gi_ge_name
group by ge_name;

# 판타지로 등록된 모든 영화를 조회하는 쿼리
SELECT 
    mo_title
FROM
    genre_include
        JOIN
    movie ON gi_mo_num = mo_num
WHERE
    gi_ge_name = '판타지';

# 상영 예정인 영화를 조회하는 쿼리
SELECT * FROM movie WHERE mo_date > '2024-02-08';

# 전체 관람가 영화를 조회하는 쿼리
SELECT * FROM movie WHERE mo_ag_name = '전체관람가';

# 영화 제목에 '카'를 포함하는 영화 조회
SELECT * FROM movie WHERE mo_title like '%카%';


# 2월 9, 10일에 예매 가능한 영화 목록을 조회하는 쿼리
SELECT 
    *
FROM
    schedule
        JOIN
    movie ON sh_mo_num = mo_num
WHERE
    sh_date BETWEEN '2024-02-09' AND '2024-02-10';

SELECT DISTINCT
    mo_title, sh_date
FROM
    (SELECT 
        *
    FROM
        schedule
    WHERE
        sh_date BETWEEN '2024-02-09' AND '2024-02-10') AS sh
        JOIN
    movie ON sh_mo_num = mo_num;

