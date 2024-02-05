USE account;

insert into type values("수입"), ("지출");

# 지출 : 식비, 교통비, 건강, 통신, 경조사, 저축, 마트, 기타
# 수입 : 월급, 용돈, 부수입, 상여, 기타
insert into category(ca_ty_name, ca_name) values("지출", "식비"),
("지출", "교통비"),
("지출", "건강"),
("지출", "경조사"),
("지출", "저축"),
("지출", "마트"),
("지출", "기타"),
("수입", "월급"),
("수입", "용돈"),
("수입", "부수입"),
("수입", "상여"),
("수입", "기타");


select * from category;