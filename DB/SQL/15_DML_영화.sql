# 사용자가 아이디가 abc123, 비번이 asd123인 회원가입 진행
INSERT INTO member VALUES('abc123','asd123', 'USER');
# 사용자가 아이디가 qwe123, 비번이 qweqwe로 회원가입을 진행
INSERT INTO member(me_id, me_pw) VALUES('qwe123','qweqwe');
# 관리자가 아이디가 admin, 비번이 admin으로 회원 가입을 진행
INSERT INTO member VALUES('admin','admin','ADMIN');

select * from member;

# CGV에서 영화 웡카를 관리자가 등록하려고 한다. 이 때 해야하는 쿼리를 순서대로 써보세요.
# 영화 정보(제목, 내용, 개봉일, 상영시간), 감독, 배우들, 장르, 연령, 제작 국가, 트레일러, 스틸컷
# 0. 모든 국가를 nation 테이블에 추가(한국, 미국, 영국, 일본, 중국)
INSERT INTO `nation`
VALUES('한국'),
('미국'),
('영국'),
('일본'),
('중국');
SELECT * FROM NATION;

# 1. 폴 킹, 티모시 샬라메 ,  칼라 레인 ,  올리비아 콜맨 ,  톰 데이비스 ,  휴 그랜트 ,  샐리 호킨스 정보를
#    character 테이블에 추가
INSERT INTO `character`
VALUES(NULL, '폴 킹', '1978-07-29', '', '미국'),
(NULL, '티모시 샬라메', '1995-12-27', '', '미국'),
(NULL, '칼라 레인', '2009-04-20', '', '미국'),
(NULL, '올리비아 콜맨', '1974-01-30', '', '영국'),
(NULL, '톰 데이비스', '1979-04-27', '', '영국'),
(NULL, '휴 그랜트', '1960-09-09', '', '영국'),
(NULL, '샐리 호킨스', '1976-04-27', '', '영국');
SELECT * FROM `CHARACTER`;

# 2. 폴 킹, 티모시 샬라메 ,  칼라 레인 ,  올리비아 콜맨 ,  톰 데이비스 ,  휴 그랜트 ,  샐리 호킨스 정보를
#    movie_person 테이블에 추가(1에서 추가한 정보를 이용)
INSERT INTO movie_person(mp_role, mp_pic, mp_ch_num)
VALUES('감독', '', 1),
('배우', '', 2),
('배우', '', 3),
('배우', '', 4),
('배우', '', 5),
('배우', '', 6),
('배우', '', 7);
SELECT * FROM movie_person;

# 3. 모든 연령을 age 테이블에 추가(전체관람가, 12세 이상 관람가, 15세 이상 관람가, 청소년 관람불가, 제한관람가)
INSERT INTO AGE VALUES('전체관람가'),
('12세 이상 관람가'),
('15세 이상 관람가'),
('청소년 관람 불가'),
('제한 관람가');
SELECT * FROM AGE;

# 4. 영화 정보를 이용해서 영화를 등록(movie 테이블)
INSERT INTO movie(mo_title, mo_date, mo_content, mo_running, mo_ag_name)
VALUES('웡카', '2024-01-31', '세상에서 가장 달콤한 여정!', 116, '전체관람가');
SELECT * FROM MOVIE;

# 5. 폴 킹, 티모시 샬라메 ,  칼라 레인 ,  올리비아 콜맨 ,  톰 데이비스 ,  휴 그랜트 ,  샐리 호킨스 정보를
#    join 테이블에 추가(2,3에서 추가한 정보를 이용), 배역을 모르면 ""로
INSERT INTO `JOIN`(jo_casting, jo_mo_num, jo_mp_num)
VALUES('감독', 1, '1'),
('', 1, '2'),
('', 1, '3'),
('', 1, '4'),
('', 1, '5'),
('', 1, '6'),
('', 1, '7');
SELECT * FROM `JOIN`;

# 6. 모든 장르를 genre 테이블에 추가(액션, 범죄, SF, 드라마, 판타지, 코미디, 로맨스, 스릴러, 공포, 멜로)
INSERT INTO genre
VALUES('액션'),('범죄'),('SF'),('드라마'),('판타지'),('코미디'),('로맨스'),('스릴러'),('공포'),('멜로');
SELECT * FROM genre;

# 7. 트레일러 정보를 추가. 파일명은 임의로 정해서 추가. 트레일러 3개, 스틸컷 4개
INSERT INTO movie_file(mf_filename, mf_type, mf_mo_num)
VALUES('웡카_트레일러1.mp4', '트레일러', 1),
('웡카_트레일러2.mp4', '트레일러', 1),
('웡카_트레일러3.mp4', '트레일러', 1),
('웡카_스틸컷1.png', '스틸컷', 1),
('웡카_스틸컷2.png', '스틸컷', 1),
('웡카_스틸컷3.png', '스틸컷', 1),
('웡카_스틸컷4.png', '스틸컷', 1);
SELECT * FROM movie_file;

# 8. 영화 제작에 영화와 제작 국가 정보를 추가
INSERT INTO production_nation(pn_na_name, pn_mo_num)
VALUES('미국',1), ('영국',1);

# 9. 장르 포함에 영화와 장르를 추가
INSERT INTO genre_include(gi_mo_num, gi_ge_name)
VALUES(1, '판타지'), (1, '드라마');

