# DML


# 회원 상태 member_state
INSERT INTO member_state
VALUES('이용중'), ('가입대기'), ('정지');

# 회원 member
INSERT INTO member(me_id, me_ms_state, me_pw, me_email, me_name, me_phone, me_authority)
VALUES
('admin', '이용중', 'admin', 'admin@gamil.com', 'admin', '010-0000-0000', 'ADMIN'),
('user1111', '이용중', 'user1111', 'user1111@gamil.com', '홍길동', '010-1111-1111', 'USER'),
('user2222', '가입대기', 'user2222', 'user2222@gamil.com', '홍길순', '010-2222-2222', 'WUSER'),
('user3333', '가입대기', 'user3333', 'user3333@gamil.com', '김철수', '010-3333-3333', 'WUSER'),
('user4444', '이용중', 'user4444', 'user4444@gamil.com', '김영희', '010-4444-4444', 'USER'),
('user5555', '이용중', 'user5555', 'user5555@gamil.com', '김민준', '010-5555-5555', 'USER'),
('user6666', '가입대기', 'user6666', 'user6666@gamil.com', '유재석', '010-6666-6666', 'WUSER'),
('user7777', '가입대기', 'user7777', 'user7777@gamil.com', '강호동', '010-7777-7777', 'WUSER'),
('user8888', '이용중', 'user8888', 'user8888@gamil.com', '조세호', '010-5555-5555', 'USER');


# 카테고리 category
INSERT INTO category(ca_name)
VALUES('TEAM3 공지사항'), ('게임'), ('스포츠'), ('자격증'), ('취미/문화'), ('지역/모임'), 
('생활'), ('미용'), ('컴퓨터/통신'), ('패션'), ('증고/판매'), ('동물');

# 게시판 board
INSERT INTO board(bo_ca_num, bo_name)
VALUES
(1, '공지'), (1, '가입인사'), (1, '등업신청'),
(2, '리그 오브 레전드'), (2, 'FIFA'), (2, '로스트아크'), (2, '메이플스토리'),
(3, '축구'), (3, '야구'), (3, '농구'), (3, '배구'),
(4, '국가기술자격'), (4, '국가전문자격'), (4, '민간자격'),
(5, '여행'), (5, '뜨개질'), (5, '그림'), (5, '책'), 
(6, '동창/동문'), (6, '친목/모임'),
(7, '다이어트'), (7, '건강'), (7, '가족'), (7, '육아'), 
(8, '화장품'), (8, '성형'), (8, '공동구매'),
(9, '삼성'), (9, '애플'), (9, 'LG'), (9, 'IT'),
(10, '상의'), (10, '하의'), (10, '신발'), (10, '직구'),
(11, '책'), (11, '옷'), (11, '신발'),
(12, '강아지'), (12, '고양이'), (12, '햄스터'), (12, '거북이');


