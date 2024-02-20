# abc123 회원이 주문 내역을 확인하는 쿼리
SELECT * FROM `ORDER`
WHERE OR_ME_ID = 'abc123';

# 기타(1)에 포함된 모든 제품을 조회하는 쿼리
SELECT * FROM PRODUCT
WHERE PR_CA_NUM = 1;

# 기타, 자동차, 의류에 포함된 모든 제품을 조회하는 쿼리
SELECT * FROM PRODUCT
WHERE PR_CA_NUM IN(1, 3, 5);

# 등록된 제품들의 카테고리 번호를 조회하는 쿼리
SELECT DISTINCT PR_CA_NUM FROM PRODUCT;

# 가격이 높은 순으로 제품을 정렬하는 쿼리
SELECT * FROM PRODUCT
ORDER BY PR_PRICE DESC, PR_CODE;

# 제품 페이지에서 1페이지에 있는 제품을 조회하는 쿼리(한 페이지에 제품은 2개 조회)
SELECT * FROM PRODUCT LIMIT 0, 2;
# 2페이지에 있는 제품을 조회하는 쿼리(한 페이지에 2개 조회)
# 2번지 = 컨텐츠개수 * (현재페이지 - 1)
SELECT * FROM PRODUCT LIMIT 2, 2;
# 10페이지에 있는 제품을 조회하는 쿼리
-- SELECT * FROM PRODUCT LIMIT 18, 2;

# 카테고리 별 등록된 제품의 개수를 조회
SELECT PR_CA_NUM AS '카테고리번호', COUNT(PR_CA_NUM) AS '제품수'
FROM PRODUCT
GROUP BY PR_CA_NUM;

# 카테고리 별 등록된 제품의 개수가 2개 이상인 카테고리를 조회
SELECT PR_CA_NUM AS '카테고리번호', COUNT(PR_CA_NUM) AS '제품수'
FROM PRODUCT
GROUP BY PR_CA_NUM
HAVING COUNT(PR_CA_NUM) >= 2;

# abc123 회원이 지금까지 주문한 총 금액을 조회하는 쿼리
SELECT OR_ME_ID AS '구매 아이디', SUM(OR_TOTAL_PRICE) AS '총 구매금액' FROM `ORDER`
WHERE OR_ME_ID = 'abc123' AND OR_STATE NOT IN('반품', '환불')
GROUP BY OR_ME_ID;

# 제품별 판매된 개수를 조회하는 쿼리
SELECT OR_PR_CODE, SUM(OR_AMOUNT)
FROM `ORDER`
WHERE OR_STATE NOT IN('반품', '환불')
GROUP BY OR_PR_CODE;

# 제품별 카테고리명을 조회하기 위한 INNER JOIN 쿼리
SELECT PRODUCT.*, CA_NAME
FROM
	PRODUCT
JOIN
	CATEGORY
ON 
	# PRODUCT의 외래키를 CATEGORY의 기본키와 연결
	PRODUCT.PR_CA_NUM = CATEGORY.CA_NUM;
    # 속성명이 다르면 테이블명을 생략할 수 있다
    -- PR_CA_NUM = CA_NUM;

# 기타로 등록된 제품들을 조회하는 쿼리
SELECT * FROM PRODUCT
JOIN CATEGORY
ON PR_CA_NUM = CA_NUM
WHERE CA_NAME = '기타';

# abc123회원이 주문한 제품목록을 조회하는 쿼리
SELECT DISTINCT PR_TITLE AS 제품명 FROM `ORDER` JOIN PRODUCT
ON OR_PR_CODE = PR_CODE
WHERE OR_ME_ID = 'abc123' AND OR_STATE NOT IN('환불', '반품');

# 각 제품별 판매된 개수(판매된 제품에 한해서)
SELECT 
    PR_TITLE, SUM(OR_AMOUNT) AS '판매수'
FROM
    `ORDER`
        JOIN
    PRODUCT ON OR_PR_CODE = PR_CODE
WHERE
	OR_STATE NOT IN('환불', '반품')
GROUP BY PR_CODE;

# 각 제품별 판매된 개수(모든 제품에 한해서)
SELECT
	# IFNULL(속성, 값A) : 속성이 NULL인 경우 NULL 대신 값A로 변경
    PR_TITLE, IFNULL(SUM(OR_AMOUNT), 0) AS 판매수량
FROM
    PRODUCT
        LEFT JOIN
    `ORDER` ON PR_CODE = OR_PR_CODE
WHERE
	OR_STATE IS NULL OR OR_STATE NOT IN("환불", "반품")
GROUP BY PR_CODE;


SELECT
	# IFNULL(속성, 값A) : 속성이 NULL인 경우 NULL 대신 값A로 변경
    PR_TITLE, IFNULL(SUM(OR_AMOUNT), 0) AS 판매수량
FROM
    `ORDER`
        RIGHT JOIN
     PRODUCT ON PR_CODE = OR_PR_CODE
WHERE
	OR_STATE IS NULL OR OR_STATE NOT IN("환불", "반품")
GROUP BY PR_CODE;

# 모든 제품을 조회하는 쿼리
SELECT * FROM PRODUCT;

# 모든 카테고리를 조회하는 쿼리
SELECT * FROM CATEGORY;

# 제품별 카테고리를 조회. 카테고리, 제품을 조회
SELECT
	CA_NAME AS 카테고리, PR_TITLE AS 제품명
FROM
	PRODUCT
		JOIN
	CATEGORY ON CA_NUM = PR_CA_NUM;

# 기타 카테고리에 포함된 모든 제품을 조회
SELECT 
    CA_NAME, PRODUCT.*
FROM
    PRODUCT
        JOIN
    CATEGORY ON CA_NUM = PR_CA_NUM
WHERE
    CA_NAME = '기타';

# abc123 회원이 주문한 제품 목록을 조회
SELECT
    OR_DATE, OR_STATE, OR_AMOUNT, OR_TOTAL_PRICE, PR_TITLE
FROM
    `ORDER`
		JOIN
    PRODUCT ON OR_PR_CODE = PR_CODE
WHERE
    OR_ME_ID = 'abc123';

# 제품별 판매 수량을 조회하는 쿼리
SELECT PRODUCT.*, IFNULL(SUM(OR_AMOUNT), 0) AS 핀메수량
FROM `ORDER` RIGHT JOIN PRODUCT ON PR_CODE = OR_PR_CODE
WHERE OR_STATE NOT IN('반품','환불') OR OR_STATE IS NULL
GROUP BY PR_CODE;

# 인기 제품 조회. 인기 제품은 누적판매량을 기준으로 상위 5개 제품
SELECT PRODUCT.*, IFNULL(SUM(OR_AMOUNT), 0) AS '판매수량'
FROM `ORDER` RIGHT JOIN PRODUCT ON PR_CODE = OR_PR_CODE
WHERE OR_STATE NOT IN('반품','환불') OR OR_STATE IS NULL
GROUP BY PR_CODE
ORDER BY 판매수량 DESC, PR_PRICE ASC
LIMIT 0, 5;

# 가격이 제일 비싼 제품을 조회
SELECT * FROM PRODUCT ORDER BY PR_PRICE DESC
LIMIT 0, 1;


# 카테고리별 등록된 제품 수를 조회하는 쿼리
SELECT 
    ca_name, IF(count(pr_ca_num) > 0, count(pr_ca_num), '등록된 제품 없음') AS '카테고리별 제품수'
FROM
    product
        RIGHT JOIN
    category ON pr_ca_num = ca_num
GROUP BY ca_num;

# 회원별 누적 주문 금액을 조회하는 쿼리
SELECT 
    me_id AS '회원', IFNULL(SUM(or_total_price), 0) AS '회원별 누적 주문금액'
FROM
    `order`
        RIGHT JOIN
    `member` ON or_me_id = me_id
GROUP BY me_id;

# 회원별 등급을 조회하는 쿼리
# 등급은 기본이 브론즈, 누적금액이 5만원 이상이면 실버, 누적 금액이 8만원 이상이면 골드
# CASE문 활용
SELECT 
    me_id AS '회원',
    CASE
    WHEN IFNULL(SUM(or_total_price), 0) >= 80000 THEN '골드'
    WHEN IFNULL(SUM(or_total_price), 0) >= 80000 THEN '실버'
    ELSE '브론즈'
    END AS '등급'
FROM
    `order`
        RIGHT JOIN
    `member` ON or_me_id = me_id
GROUP BY me_id;

# 제품 첨부파일을 추가한 후, 추가한 파일이 이미지인지 동영상인지 조회하는 쿼리
SELECT
	CASE RIGHT(IM_FILE, 3)
    WHEN 'JPG' THEN '이미지'
    WHEN 'PNG' THEN '이미지'
    WHEN 'MP4' THEN '영상'
    END AS 종류,
    IM_FILE
FROM IMAGE;










