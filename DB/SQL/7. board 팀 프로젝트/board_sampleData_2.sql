# 관리자, 유저 데이터
insert into `user`(u_id, u_pw, u_mail, u_phone, u_name, u_admin)
values('admin', 'admin', 'admin1234@naver.com', '010-1234-1234', '관리자', 1);

insert into `user`(u_id, u_pw, u_mail, u_phone, u_name, u_admin)
values('user1234', 'user1234!!', 'user1234@naver.com', '010-1234-5678', '홍길동', 0);

insert into `user`(u_id, u_pw, u_mail, u_phone, u_name, u_admin)
values('user5678', 'user5678!!', 'user5678@naver.com', '010-5678-5678', '유재석', 0);

insert into `user`(u_id, u_pw, u_mail, u_phone, u_name, u_admin)
values('user1111', 'user1111!!', 'user1111@naver.com', '010-1111-1111', '김철수', 0);

insert into `user`(u_id, u_pw, u_mail, u_phone, u_name, u_admin)
values('user2222', 'user2222!!', 'user2222@naver.com', '010-2222-2222', '고길동', 0);

# 카테고리
insert into `category`(c_name) values("자유 게시판");
insert into `category`(c_name) values("취미 게시판");
insert into `category`(c_name) values("장터 게시판");

# 게시판
-- "자유 게시판" 카테고리의 게시판
INSERT INTO board(b_name, b_c_num) VALUE("이모저모", 1);	# 1번

-- "취미 게시판" 카테고리의 게시판
INSERT INTO board(b_name, b_c_num) VALUE("게임", 2);		# 3번
INSERT INTO board(b_name, b_c_num) VALUE("운동", 2);		# 4번
INSERT INTO board(b_name, b_c_num) VALUE("뜨개질", 2);	# 5번

-- "장터 게시판" 카테고리의 게시판
INSERT INTO board(b_name, b_c_num) VALUE("책", 3);		# 7번
INSERT INTO board(b_name, b_c_num) VALUE("옷", 3);		# 8번

-- "자유 게시판" 카테고리
-- "이모 저모" 게시판의 게시글
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "오늘 먹은 거 자랑", "오늘 아침 삼겹살 점심 햄버거 저녁 소곱창 먹었음\n(사진)\n(사진)\n(사진)\n\n번개모임 하길 잘한듯~!", "2024-02-19", "user1111");	
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "소곱창 먹기 번개모임 후기", "아 요새 계속 소곱창 먹고 싶었는데 같이 먹을 사람이 없어서 이 카페 사람들이랑 모였다\n역시 소곱창은 사람이 많아야 존마탱!\n(사진)\n(사진)\n(사진)\n(사진)\n(사진)", "2024-02-19", "user1111");	
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "연남동 맛집 공유", "1. 연어무한리필집\n(사진)\n가격: 1인당 23000원\n맛: 맛있음\n짧은 후기: 얼어붙은 경제 속 안식처\n\n2. 돈부리\n(사진)\n가격: 좀 비쌈\n맛: 기대 이상\n짧은 후기: 웨이팅 좀 있어서 일찍 가야함\n\n", "2024-02-10", "user2222");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "강남역 맛집", "1. 연어무한리필집\n(사진)\n가격: 1인당 23000원\n맛: 맛있음\n짧은 후기: 얼어붙은 경제 속 안식처\n\n2. 돈부리\n(사진)\n가격: 좀 비쌈\n맛: 기대 이상\n짧은 후기: 웨이팅 좀 있어서 일찍 가야함\n\n", "2024-02-10", "user1111");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "역삼역 맛집", "1. 연어무한리필집\n(사진)\n가격: 1인당 23000원\n맛: 맛있음\n짧은 후기: 얼어붙은 경제 속 안식처\n\n2. 돈부리\n(사진)\n가격: 좀 비쌈\n맛: 기대 이상\n짧은 후기: 웨이팅 좀 있어서 일찍 가야함\n\n", "2024-02-10", "user1234");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "오늘 먹은 거 자랑", "1. 연어무한리필집\n(사진)\n가격: 1인당 23000원\n맛: 맛있음\n짧은 후기: 얼어붙은 경제 속 안식처\n\n2. 돈부리\n(사진)\n가격: 좀 비쌈\n맛: 기대 이상\n짧은 후기: 웨이팅 좀 있어서 일찍 가야함\n\n", "2024-02-09", "user5678");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "소곱창 맛집", "1. 연어무한리필집\n(사진)\n가격: 1인당 23000원\n맛: 맛있음\n짧은 후기: 얼어붙은 경제 속 안식처\n\n2. 돈부리\n(사진)\n가격: 좀 비쌈\n맛: 기대 이상\n짧은 후기: 웨이팅 좀 있어서 일찍 가야함\n\n", "2024-02-09", "user1234");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "짬뽕 맛집", "1. 연어무한리필집\n(사진)\n가격: 1인당 23000원\n맛: 맛있음\n짧은 후기: 얼어붙은 경제 속 안식처\n\n2. 돈부리\n(사진)\n가격: 좀 비쌈\n맛: 기대 이상\n짧은 후기: 웨이팅 좀 있어서 일찍 가야함\n\n", "2024-02-09", "user1111");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "연남동 맛집 공유", "1. 연어무한리필집\n(사진)\n가격: 1인당 23000원\n맛: 맛있음\n짧은 후기: 얼어붙은 경제 속 안식처\n\n2. 돈부리\n(사진)\n가격: 좀 비쌈\n맛: 기대 이상\n짧은 후기: 웨이팅 좀 있어서 일찍 가야함\n\n", "2024-02-08", "user1111");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "강남역 맛집", "1. 연어무한리필집\n(사진)\n가격: 1인당 23000원\n맛: 맛있음\n짧은 후기: 얼어붙은 경제 속 안식처\n\n2. 돈부리\n(사진)\n가격: 좀 비쌈\n맛: 기대 이상\n짧은 후기: 웨이팅 좀 있어서 일찍 가야함\n\n", "2024-02-08", "user1234");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "연남동 맛집 공유", "1. 연어무한리필집\n(사진)\n가격: 1인당 23000원\n맛: 맛있음\n짧은 후기: 얼어붙은 경제 속 안식처\n\n2. 돈부리\n(사진)\n가격: 좀 비쌈\n맛: 기대 이상\n짧은 후기: 웨이팅 좀 있어서 일찍 가야함\n\n", "2024-02-07", "user1111");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(1, "오늘 먹은 거 자랑", "1. 연어무한리필집\n(사진)\n가격: 1인당 23000원\n맛: 맛있음\n짧은 후기: 얼어붙은 경제 속 안식처\n\n2. 돈부리\n(사진)\n가격: 좀 비쌈\n맛: 기대 이상\n짧은 후기: 웨이팅 좀 있어서 일찍 가야함\n\n", "2024-02-07", "user1234");

-- "취미 게시판" 카테고리
-- "게임" 게시판의 게시글
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(2, "게임 취미 TEST 1", "게임 취미 TEST 1 내용", "2024-02-19", "user1111");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(2, "게임 취미 TEST 2", "게임 취미 TEST 2 내용", "2024-02-17", "user1234");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(2, "게임 취미 TEST 3", "게임 취미 TEST 3 내용", "2024-02-15", "user1111");
-- "뜨개질" 게시판의 게시글
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(4, "뜨개질 취미 TEST 1", "뜨개질 취미 TEST 1 내용", "2024-02-19", "user1234");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(4, "뜨개질 취미 TEST 2", "뜨개질 취미 TEST 2 내용", "2024-02-15", "user1111");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(4, "뜨개질 취미 TEST 3", "뜨개질 취미 TEST 3 내용", "2024-02-01", "user1111");
-- "운동" 게시판의 게시글
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(3, "운동 취미 TEST 1", "운동 취미 TEST 1 내용", "2024-02-19", "user1111");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(3, "운동 취미 TEST 2", "운동 취미 TEST 2 내용", "2024-02-15", "user1234");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(3, "운동 취미 TEST 3", "운동 취미 TEST 3 내용", "2024-02-10", "user1111");

-- "장터 게시판" 카테고리
-- "책" 게시판의 게시글
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(5, "책 판매 TEST 1", "책 판매 TEST 1 내용", "2024-01-25", "user5678");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(5, "책 판매 TEST 2", "책 판매 TEST 2 내용", "2024-01-24", "user1234");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(5, "책 판매 TEST 3", "책 판매 TEST 3 내용", "2024-01-23", "user2222");

-- "옷" 게시판의 게시글
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(6, "옷 판매 TEST 1", "옷 판매 TEST 1 내용", "2024-01-26", "user1111");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(6, "옷 판매 TEST 2", "옷 판매 TEST 2 내용", "2024-01-25", "user1234");
INSERT INTO post(p_b_num, p_title, p_content, p_date, p_u_id) VALUE(6, "옷 판매 TEST 3", "옷 판매 TEST 3 내용", "2024-01-24", "user5678");

-- 댓글
INSERT INTO comment(com_content, com_date, com_u_id, com_p_num)
VALUES("맛있겠다", "2024-02-19", "user5678", 1);

INSERT INTO comment(com_content, com_date, com_u_id, com_p_num)
VALUES("맛있겠다2", "2024-02-19", "user2222", 1);

INSERT INTO comment(com_content, com_date, com_u_id, com_p_num)
VALUES("맛있겠다3", "2024-02-19", "user1234", 1);

INSERT INTO comment(com_content, com_date, com_u_id, com_p_num)
VALUES("맛있겠다4", "2024-02-19", "user2222", 1);

INSERT INTO comment(com_content, com_date, com_u_id, com_p_num)
VALUES("맛있겠다5", "2024-02-19", "user1234", 1);

INSERT INTO comment(com_content, com_date, com_u_id, com_p_num)
VALUES("맛있겠다6", "2024-02-19", "user2222", 1);

INSERT INTO comment(com_content, com_date, com_u_id, com_p_num)
VALUES("맛있겠다!!", "2024-02-07", "user5678", 12);

INSERT INTO comment(com_content, com_date, com_u_id, com_p_num)
VALUES("맛있겠다2!!", "2024-02-07", "user1234", 12);

INSERT INTO comment(com_content, com_date, com_u_id, com_p_num)
VALUES("맛있겠다3!!", "2024-02-07", "user2222", 12);

INSERT INTO comment(com_content, com_date, com_u_id, com_p_num)
VALUES("맛있겠다4!!", "2024-02-07", "user1111", 12);

INSERT INTO comment(com_content, com_date, com_u_id, com_p_num)
VALUES("맛있겠다5!!", "2024-02-07", "user1234", 12);

INSERT INTO comment(com_content, com_date, com_u_id, com_p_num)
VALUES("맛있겠다6!!", "2024-02-07", "user5678", 12);