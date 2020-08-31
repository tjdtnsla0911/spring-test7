# Spring Boot 의존성

- mybatis
- jwt
- security
- web
- mysql
- devtools
- lombok

# 참고 사이트

Link: [구글로그인]][https://console.developers.google.com/]
Link: [구글로그인]][https://developers.google.com/identity/sign-in/web/reference/]

Link: [아임포트시작하기]][https://www.iamport.kr/getstarted]
Link: [아임포트결제하기]][https://admin.iamport.kr/payments]
Link: [아임포트결제하기2]][https://docs.iamport.kr/implementation/payment#mobile-web?lang=ko]

# DB

```sql
create user 'cos'@'%' identified by 'cos1234';
GRANT ALL PRIVILEGES ON *.* TO 'areuareu'@'%';
create database areuareu;
use areuareu;
```

# DB 테이블 생성

```sql
DROP TABLE product;
DROP TABLE product_status;
DROP TABLE review;
DROP TABLE user;
DROP TABLE recomment;
DROP TABLE notice;
DROP TABLE qna;
DROP TABLE orders;
DROP TABLE orders_detail;
DROP TABLE wishlist;
DROP TABLE coupon;
DROP TABLE point;
DROP TABLE related_product;
DROP TABLE category;
DROP TABLE cart;

CREATE TABLE product (
	id int auto_increment primary key,
    title varchar(100) not null, #제목
    thumb varchar(1500) not null, #썸네일
    price int, #원가
    disc varchar(100), #설명
    ad boolean not null, #광고 #메인에 걸꺼냐 안걸꺼냐
    discounted int, #할인
    content longtext, #내용
    categoryId int, #1이면 개별상품 2면 세트상품
    bgImg varchar(1500) not null, #메인 큰 사진 경로
    sale boolean, #여긴 일단 null안해놧음 sale 없을수도있으니까
    newly  boolean, #신상
    best  boolean #잘팔림
) engine=InnoDB default charset=utf8;


CREATE TABLE review   (
	id int auto_increment primary key,
    productId  int,
    title   varchar(500),
    content   varchar(1000),
    userId  int,
    createDate timestamp,
    star int, #난 예전에 별개수를 int로 바꿔서 넣어서 일단 int로 했음
    img varchar(1500), #경로
    existenceOfImg boolean, #이미지 올린놈인지아닌지
    orderId int #결제방법때문에필요
) engine=InnoDB default charset=utf8;


CREATE TABLE user   (
	id int auto_increment primary key,
    username varchar(300),
    password  varchar(500),
    email  varchar(1500),
    name   varchar(200),
    gender  varchar(100), #boolean 인가? 헷갈리는데 varchar함
    phone varchar(1500),
    address varchar(2000),
    detail_address varchar(1500),
	provider varchar(2000), #이건 구글로 로그인하는사람 땜시 필요합니다.
    providerId varchar(2000),#이것도 구글로 로그인하는사람 땜시 필요합니다.
    birthday timestamp, #2020-12-21식으로넣을꺼 생각해서 varchar함
    total_amount int,
    role varchar(150),
    cancel boolean, #취소 헷갈려서 varchar함 boolean 같은데.. 탈퇴 체크 같아서 boolean으로 바꿨다
    profile varchar(4500),
    createDate timestamp
) engine=InnoDB default charset=utf8;

CREATE TABLE recomment   (
	id int auto_increment primary key,
    reviewId  int,
    comment   varchar(2000),
    createDate  timestamp
) engine=InnoDB default charset=utf8;

CREATE TABLE notice   (
	id int auto_increment primary key,
    title  varchar(1500),
    content   varchar(1000),
    createDate  timestamp,
    readCount int, #개수니까 int겟지? 맞다
    thumb varchar(2000)
) engine=InnoDB default charset=utf8;

CREATE TABLE qna   (
	id int auto_increment primary key,
    title  varchar(1500),
    content   varchar(1000),
    createDate  timestamp,
    userId int,
    answer boolean ,
    productId int
) engine=InnoDB default charset=utf8;

CREATE TABLE orders   (
	id int auto_increment primary key,
    userId  int,
    orderDate   timestamp,
    totalPrice  int,
    howToPay varchar(300) #결제수단넣는건가 varchar인가? 맞다

) engine=InnoDB default charset=utf8;

CREATE TABLE orders_detail   (
	id int auto_increment primary key,
    orderId  int,
    productId int,#없어서 넣었다
    quantity   int,  #몇개냐 이말
    price  int,
    stats varchar(200), # 상태니까 boolean 해봄 헷갈림 ㅠ
    fee int #택배값 3000고정 할건데 뭐지
) engine=InnoDB default charset=utf8;

CREATE TABLE wishlist   (
	id int auto_increment primary key,
    userId  int,
    productId   int
  ) engine=InnoDB default charset=utf8;

CREATE TABLE coupon   (
	id int auto_increment primary key,
    userId  int,
    code   varchar(1000),
    validityStart  date, #쿠폰 입력가능시작 validity붙임
    validityEnd date,#쿠폰 끝나는 유효기간 validity붙임
    availability boolean # boolean 으로해봄 유효성 헷갈림
) engine=InnoDB default charset=utf8;

CREATE TABLE point   (
	id int auto_increment primary key,
    userId  int,
    historyDate date, #date예약어라서 바꿈
    reason   varchar(500), #이유라서 varchar함
    point int,
    totalPoint int
) engine=InnoDB default charset=utf8;

CREATE TABLE related_product   ( #관련상품
	id int auto_increment primary key,
    parentProductId  int, #detail로 올때 누른 상품
    relatedProductId int #연관된 상품 1-2 , 1-3
) engine=InnoDB default charset=utf8;
select * from related_product;

CREATE TABLE category   (
	id int auto_increment primary key,
    type  varchar(200), #type 헷갈려서 여긴 varchar함,
    parentTypeId int # 확장성을 위함같은데
) engine=InnoDB default charset=utf8;

CREATE TABLE cart(# 종이에는 product_status에 따라서 다르다는데 모르겠음
	id int auto_increment primary key,
    productId int,
    userId int,
    quantity int,
    price int
) engine=InnoDB default charset=utf8;

CREATE TABLE commentOnQnA   (
	id int auto_increment primary key,
    qnAId  int,
    comment   varchar(2000),
    createDate  timestamp
) engine=InnoDB default charset=utf8;
```

# join과 test를 위한 데이터

```sql
#user 더미 데이터
insert into user(username,password,email,name,gender,phone,address,detail_address,birthday,total_amount,role,cancel,profile,provider,providerId,createDate)
values('cos','cos1234','tjdtnsla0321@nate.com','최주호','남','010-2222-0000','부산광역시 진구','서면 파이널센터 4층','1985-02-01',120000,'ROLE_USER',false,'프로필입니다.','직접가입함','직접가입함',now());

insert into user(username,password,email,name,gender,phone,address,detail_address,birthday,total_amount,role,cancel,profile,provider,providerId,createDate)
values('tjdtn','tjdtn123','tjdd@nate.com','김성수','남','010-0000-0000','경북 포항시','북구 학잠동','1993-09-11',200000,'ROLE_USER',false,'프로필입니다.','직접가입함','직접가입함',now());

insert into user(username,password,email,name,gender,phone,address,detail_address,birthday,total_amount,role,cancel,profile,provider,providerId,createDate)
values('tjsgus','tjsgus123','tjsgus@nate.com','문선현','여','010-1111-1111','부산광역시 어딘가','남포동 아파트','1993-12-31',50000,'ROLE_USER',false,'프로필입니다.','직접가입함','직접가입함',now());

insert into user(username,password,email,name,gender,phone,address,detail_address,birthday,total_amount,role,cancel,profile,provider,providerId,createDate)
values('dnjswo','dnjswo1234','dnjswop321@nate.com','이원재','남','010-2322-7440','부산광역시 연산','연산역 집','1992-01-01',2000,'ROLE_USER',false,'프로필입니다.','직접가입함','직접가입함',now());

#product 더미데이터
insert into product(title,thumb,price,disc,ad,discounted,content,categoryId,bgImg, sale, newly, best)
<<<<<<< HEAD
values ('프레시 런드리 디터전트','/img/item1_product.png',28000,'베이비 런드리 디터전트(무향)1L*1ea',true,27000,'content1',1,'/img/main1.jpg', true, false, false);
insert into product(title,thumb,price,disc,ad,discounted,content,categoryId,bgImg, sale, newly, best)
values ('패밀리 키친 세트','/img/item1_product.png',40000,'프레시 디시 앤 프루트 워시 (오렌지) 500ml * 1ea 베이비 보틀 앤 토이 워시 (무향) 500ml * 1ea',true,null,'content2',2,'/img/main2.jpg', false, true, false);
insert into product(title,thumb,price,disc,ad,discounted,content,categoryId,bgImg, sale, newly, best)
values ('기프트 세트','/img/item1_product.png',63000,'OPTION. 구성품 택1 (키친 세트,리빙케어 세트, 런드미 세트중) OPTION 2. 박스 색상 택1 (프레시 네이버,베이비 민트 중)',false,39000,'content3',2,'/img/main3.jpg', true, false, false);
=======
values ('프레시 런드리 디터전트','/img/item1_product.png',28000,'베이비 런드리 디터전트(무향)1L*1ea',true,27000,'content1',1,'/img/main2.jpg', true, false, false);
insert into product(title,thumb,price,disc,ad,discounted,content,categoryId,bgImg, sale, newly, best)
values ('패밀리 키친 세트','/img/item2_product.png',40000,'프레시 디시 앤 프루트 워시 (오렌지) 500ml * 1ea 베이비 보틀 앤 토이 워시 (무향) 500ml * 1ea',true,null,'content2',2,'/img/main2.jpg', false, true, false);
insert into product(title,thumb,price,disc,ad,discounted,content,categoryId,bgImg, sale, newly, best)
values ('기프트 세트','/img/item3_product.png',63000,'OPTION. 구성품 택1 (키친 세트,리빙케어 세트, 런드미 세트중) OPTION 2. 박스 색상 택1 (프레시 네이버,베이비 민트 중)',false,39000,'content3',2,'/img/main3.jpg', true, false, false);



#review 더미데이터
insert into review(productId,content,userId,createDate,star,img,existenceOfImg,orderId)
<<<<<<< HEAD
values(1,'너무비싸서 놀랫네요..',1,now(),5,'/img/home_review1.jpg',true,1);
insert into review(productId,content,userId,createDate,star,img,existenceOfImg,orderId)
values(2,'아르아르 믿을수가없다',2,now(),1,'/img/home_review2.jpg',true,1);
insert into review(productId,content,userId,createDate,star,img,existenceOfImg,orderId)
values(1,'너무비싸서 놀랫네요..',3,now(),3,'/img/home_review1.jpg',true,1);

#recomment 더미데이터
insert into recomment(reviewId,comment,createDate)
values (1,'고객님 너무비싸서 죄송합니다 ㅠ^ㅠ 그래도 사세요 ㅠ',now());
insert into recomment(reviewId,comment,createDate)
values (2,'사랑합니다 고객님 ^^',now());
insert into recomment(reviewId,comment,createDate)
values (3,'참신한 아르아르가 되겟습니다',now());

#notice 더미데이터

insert into notice(title,content,createDate,readcount,thumb)
values ('★경★아르아르 폐쇠★축★','2020년09월10일 아르아르가 드디어 역사속으로 사라집니다.',now(),1,'/img/bannerimg1_home.jpg');
insert into notice(title,content,createDate,readcount,thumb)
values ('[EVENT]아르아르 우한점 오픈기념 코로나 1+1 이벤트','중국 우한점 오픈기념으로인한 제품구매시 증정품은 코로나를 1+1으로 2개를 드립니다',now(),1,'/img/bannerimg2_home.jpg');

insert into notice(title,content,createDate,readcount,thumb)
values ('[EVENT]아르아르 오픈기념 코로나 백신 1+1 이벤트','오픈기념으로인한 제품구매시 증정품은 코로나 백신을 1+1으로 2개를 드립니다',now(),1,'/img/bannerimg3_home.jpg');

#qna 더미데이터
insert into qna(title,content,createDate,userId,answer,productid)
values ('배송문의','신청한지 1년이넘었는데 죽기전 까진오겟죠?',now(),1,true,1);
insert into qna(title,content,createDate,userId,answer,productid)
values ('품질에 이상이있어요..','비누에서 거품이나요..',now(),2,true,1);
insert into qna(title,content,createDate,userId,answer,productid)
values ('품질에 이상이있어요..','비누에서 거품이나요..',now(),2,true,2);
insert into qna(title,content,createDate,userId,answer,productid)
values ('품질에 이상이있어요..','비누에서 거품이나요..',now(),2,true,3);
insert into qna(title,content,createDate,userId,answer,productid)
values ('품질에 이상이있어요..','비누에서 거품이나요..',now(),1,true,2);

#orders 더미데이터
insert into orders(userId,orderDate,totalPrice,howToPay)
values(1,now(),68000,'카카오페이');
insert into orders(userId,orderDate,totalPrice,howToPay)
values(2,now(),50000,'무통장입금');

#orders_detail 더미데이터
insert into orders_detail(orderId,productId,quantity,price,stats,fee)
values (1,1,1,28000,'배송중',3000);
insert into orders_detail(orderId,productId,quantity,price,stats,fee)
values (1,1,2,40000,'배송중',3000);
insert into orders_detail(orderId,productId,quantity,price,stats,fee)
values (2,2,1,10000,'교환',3000);
insert into orders_detail(orderId,productId,quantity,price,stats,fee)
values (2,1,2,40000,'배송중',3000);

#wishlist 더미데이터
insert into wishlist(userid,productId)values(1,1);
insert into wishlist(userid,productId)values(1,2);
insert into wishlist(userid,productId)values(1,3);
insert into wishlist(userid,productId)values(2,2);
insert into wishlist(userid,productId)values(3,3);

#coupon 더미데이터
insert into coupon(userId,code,validityStart,validityEnd,availability)
values(1,'11111-2222-3333-4444',now(),DATE_ADD(now(), INTERVAL 1 MONTH),true);
insert into coupon(userId,code,validityStart,validityEnd,availability)
values(2,'2222-2222-3333-4444',now(),DATE_ADD(now(), INTERVAL 1 MONTH),true);
insert into coupon(userId,code,validityStart,validityEnd,availability)
values(3,'3333-2222-3333-4444',now(),DATE_ADD(now(), INTERVAL 1 MONTH),true);

#point 더미데이터
insert into point(userId,historyDate,reason,point,totalPoint)
values(1,now(),'이벤트',2000,50000);
insert into point(userId,historyDate,reason,point,totalPoint)
values(2,now(),'OO행사',1500,20000);
insert into point(userId,historyDate,reason,point,totalPoint)
values(3,now(),'출금했으니까',-1000,5200);

#related_product 더미데이터
insert into related_product(parentProductId,relatedProductId)
values (1,3);
insert into related_product(parentProductId,relatedProductId)
values (2,1);
insert into related_product(parentProductId,relatedProductId)
values (3,1);
insert into related_product(parentProductId,relatedProductId)
values (1,2);

#category 더미데이터
#parentTypeId는 아직은 필요없지만 카테고리 확장성을 대비하여 만듬.
insert into category(type,parentTypeId)
values ("싱글상품",1);
insert into category(type,parentTypeId)
values ("세트상품",1);

#cart 더미데이터
insert into cart(productId,userId,quantity,price)
values (1,1,2,28000);

insert into cart(productId,userId,quantity,price)
values (2,1,1,40000);

insert into cart(productId,userId,quantity,price)
values (1,2,2,28000);

#commentOnQnA 더미 데이터
INSERT INTO commentOnQnA(qnAId, comment, createDate)
values (1, '네~!', now());

INSERT INTO commentOnQnA(qnAId, comment, createDate)
values (2, '비누에서 거품이 나는 건 정상입니다~!', now());

```

# 아르아르 dto를 위한 join

```sql
##INDEX 페이지 입니다.

#대문 dto
SELECT id,bgimg
FROM product
where ad=true;

#PRODUCTS 카르셀 dto
SELECT title,price,discounted,sale,newly,best
FROM product p INNER JOIN product_status pst
ON p.id = pst.productId;

#REVIEW dto
SELECT *
FROM review r INNER JOIN product p
ON p.id = r.productId;

##SHOP 페이지입니다. 이거를 dto를 만들던지 react에서 categoryId로 분리합시다.
SELECT p.id,thumb,title,price,discounted,sale,newly,best,categoryId
FROM product p INNER JOIN product_status pst
ON p.id = pst.productId
WHERE p.categoryId = 1;

SELECT p.id,thumb,title,price,discounted,sale,newly,best,categoryId
FROM product p INNER JOIN product_status pst
ON p.id = pst.productId
WHERE p.categoryId = 2;

##REVIEW 페이지 입니다.
#r.id는 해당 리뷰를 modal 못할때를 대비해서 게시판형식처럼 detail갈때 씁니다.
#r.star는(별점) 전문가 한테 상의
SELECT p.id, r.id , p.title, r.content, u.username, r.createDate, r.star
FROM review r INNER JOIN product p INNER JOIN user u
ON p.id = r.productId AND u.id = r.userId;


##NOTICE 페이지 입니다.
#해당 페이지는 게시판(공지) 입니다. 댓글은 원래 존재하나 안쓸예정
SELECT * FROM NOTICE

##MyPage 입니다.

## (기본 조인) 숫자 1은 동적으로 바꿔야 한다.
SELECT u.username, u.profile, u.total_amount, (SELECT COUNT(*) FROM coupon where coupon.id = 1)
FROM user u INNER JOIN coupon c
ON u.id = c.userId
WHERE u.id = 1;

#주문 조회 distinct안쓰고 싶은데.. 불안한 join
SELECT distinct o.id, o.orderDate, o.totalPrice, p.title
FROM orders o INNER JOIN orders_detail odt INNER JOIN product p INNER JOIN user u
ON p.id = odt.productId AND o.id = odt.orderId AND u.id = o.userId
WHERE u.id = 1;

#주문 디테일
SELECT o.id, o.orderDate, p.title, odt.price
FROM orders o INNER JOIN orders_detail odt INNER JOIN product p INNER JOIN user u
ON p.id = odt.productId AND o.id = odt.orderId AND u.id = o.userId
WHERE u.id = 1;

#위시 리스트

SELECT p.id, p.title, p.price, p.discounted, p.thumb, pst.newly,pst.sale, pst.best
FROM wishList w INNER JOIN product p INNER JOIN user u
ON p.id = w.productId AND w.userId = u.id
INNER JOIN product_status pst
ON p.id = pst.productId
where u.id = 1;

#취소/교환/반품

SELECT odt.id , p.title,p.price,odt.stats
FROM orders o INNER JOIN orders_detail odt INNER JOIN user u
ON o.id = odt.orderId AND u.id = o.userId
INNER JOIN product p
ON p.id = odt.productId
WHERE u.id = 1;

#쿠폰

SELECT c.id, c.code, c.validityStart, c.validityEnd, c.availability
FROM user u INNER JOIN coupon c
ON u.id = c.userId
WHERE u.id = 1;

#포인트

SELECT p.point, p.reason, p.historyDate
FROM user u INNER JOIN point p
ON u.id = p.userId
WHERE u.id = 1;

#1:1문의

SELECT q.title, q.content, q.createDate
FROM qna q INNER JOIN user u
ON u.id = q.userId
WHERE u.id = 1;

#정보 수정 -> 비밀번호 제외

SELECT * FROM USER u
WHERE u.id = 1;


##Cart 입니다.
SELECT p.id, p.title, c.quantity, p.price
FROM cart c INNER JOIN product p INNER JOIN user u
ON c.userId = u.id AND p.id = c.productId
WHERE u.id = 1;


##payment 입니다.
SELECT p.title, p.price
FROM user u INNER JOIN cart c INNER JOIN product p
ON u.id = c.userId AND p.id = c.productId
WHERE u.id = 1;

```

Linda

````

//home (메인화면)
GET
"/",""           HomeResponseDto

HomeAdResoDto
#대문 dto
SELECT id,bgimg
FROM product
where ad=true;


HomeNoticeRespDto
SELECT id, thumb
FROM notice;


HomeProductRespDto
->Product, Product_Status
```(X)
select p.id, p.thumb, p.title, p.price, p.discounted,
if(ps.sale is null, false, true) "sale",
if(ps.newly is null, false, true) "newly",
if(ps.best is null, false, true) "best "
from product p left outer join product_status ps
on p.id = ps.productId
where p.id = 1;
````

status테이블 없앤다면

```(O)
select id, thumb, title, price, discounted, sale, newly, best
from product
where id = 1;
```

HomeReviewRespDto
->Product
->Product+User+Review

```
select r.content, p.title, p.id, u.username
from review r left outer join user u
on r.userId = u.id
left outer join product p
on r.productId = p.id;
```

// detail
GET
"/shop_view/{id}" ->상품아이디!  
DetailRespDto

DetailProductRespDto

```
select id, thumb, title, price, discounted, sale, newly, best, disc, content
from product
where id = 1;
```

DetailReviewRespDto
->user + product + review +orders

```
SELECT r.userId, r.productId, r.content, r.star, r.createDate, r.orderId, r.img,
(SELECT u.username from user u where u.id = r.userId) as username,
(SELECT o.howtopay from orders o where o.id = r.orderId) as howToPay
FROM product p LEFT OUTER JOIN review r
ON p.id = r.productId
WHERE p.id = 1;
```

DetailQnaRespDto
->qna + user+product

```
## detail page -> qna부분입니다.
SELECT q.answer, q.title, u.username, q.createDate, p.id
FROM qna q LEFT OUTER JOIN user u
ON q.userId = u.id
LEFT OUTER JOIN product p
ON q.productId = p.id
WHERE q.productId = 2;
```

DetailRelatedRespDto
->
##detail page -> 관련상품 부분
SELECT id, thumb, title, price, discounted, sale, newly, best  
FROM product
WHERE id IN (select relatedProductId from related_product where parentProductId= 2);

//shop
GET
"/shop"

ShopRespDto
-> product + category

```

##dicounted가격을 update할때 sale 값을 fasle에서 true로 같이 변경해버리면 되지 자바에서
## status테이블을 product테이블에 넣는다면 sale, newly, best,
SELECT c.type, p.categoryId, p.thumb, p.title, p.price, p.discounted, p.sale, p.newly, p.best
FROM product p LEFT OUTER JOIN category c
ON p.categoryId = c.id;
```

//review
GET
"/review"
ReviewResponseDto

ReviewRespDto

```
SELECT r.id, p.title, r.content, u.username, r.createDate, r.star
FROM review r LEFT OUTER JOIN product p
ON r.productId  = p.id
LEFT OUTER JOIN user u
ON r.userId = u.id;
```

하나 누르면

```ReviewDetailRespDto
##review 하나 눌렀을 때 recomment(X)
SELECT r.img , u.profile, r.star, u.username, r.createDate, o.howToPay, r.content, p.thumb, p.title
FROM review r LEFT OUTER JOIN user u
ON r.userId = u.id
LEFT OUTER JOIN orders o
ON r.orderId = o.id
LEFT OUTER JOIN product p
ON r.productId = p.id
WHERE r.id=1;
```

/review#review_detail!/{id}
/review_detail/{id}

```
##recomment(O) , 댓글 작성자 프로필사진이랑 이름은 "아르아르"고정으로
SELECT r.img , u.profile, r.star, u.username, r.createDate, o.howToPay, r.content, p.thumb, p.title, rc.createDate, rc.comment
FROM review r LEFT OUTER JOIN user u
ON r.userId = u.id
LEFT OUTER JOIN orders o
ON r.orderId = o.id
LEFT OUTER JOIN product p
ON r.productId = p.id
LEFT OUTER JOIN recomment rc
ON r.id = rc.reviewId
WHERE r.id=2;
```

//공지사항
GET
"/notice"

NoticeRespDto

```
SELECT id, title, createDate, readCount
FROM notice;
```

NoticeDetailsRespDto
/notice_detail/{id}

```
##NoticeDetailsRespDto공지사항 하나 눌렀을 때
SELECT id, title, createDate, readCount, content
FROM notice
WHERE id = 2;
```

//여기헤더
//qna
GET
"/qna"

QnARespDto

```
SELECT q.id, q.title, u.username, q.createDate
FROM qna q LEFT OUTER JOIN user u
ON q.userId = u.id;
```

여기에 qna 하나 눌렀을 때
CommentOnQnARespDto

로그인한 유저만 내 질문에 답변을 볼 수 있음..

```
SELECT q.createDate, q.content, p.thumb, p.title, coq.createDate, coq.comment
FROM qna q LEFT OUTER JOIN user u
ON q.userId = u.id
LEFT OUTER JOIN product p
ON q.productId = p.id
LEFT OUTER JOIN commentOnQnA coq
ON q.id = coq.qnaId
WHERE q.id=2;
```

--mypage는 get으로 요청하면 안됨

//mypage
POST
"/shop_mypage/{userId}/order"

MypageOrdersResponseDto
-> orders_detail + orders + product + user

```
SELECT o.id, o.orderDate, o.totalPrice, o.howToPay, od.stats, p.title, o.userId
FROM orders_detail od LEFT OUTER JOIN orders o
ON od.orderId = o.id
LEFT OUTER JOIN product p
ON od.productId = p.id
WHERE o.userId = (
SELECT u.id
FROM orders o LEFT OUTER JOIN user u
ON o.userId = u.id
WHERE u.id = 1);
```

//wish_list
POST
"/shop_mypage/{userId}/wish_list"
MypageWishResponseDto

```
SELECT p.thumb, p.title, p.price, p.discounted, p.sale, p.newly, p.best
FROM wishlist w LEFT OUTER JOIN product p
ON w.productId = p.id
WHERE w.userId in (SELECT u.id FROM wishlist w LEFT OUTER JOIN user u ON w.userId = u.id WHERE u.id = 1);
```

//cancle
POST
"/shop_mypage/{userId}/cancle"
MypageCancleRespDto
##od.quantity는 뺄까...
SELECT od.orderId, od.productId, od.quantity, od.stats, p.title, p.thumb
FROM orders_detail od LEFT OUTER JOIN orders o
ON od.orderId = o.id
LEFT OUTER JOIN product p
ON od.productId = p.id
WHERE o.userId = 2;

//coupon
POST
"/shop_mypage/{userId}/coupon"
MypageCouponResponseDto

```
SELECT c.id, c.code, c.validityStart, c.validityEnd, c.availability
FROM user u LEFT OUTER JOIN coupon c
ON u.id = c.userId
WHERE u.id = 1;
```

//point
POST
"/shop_mypage/{userId}/point"

MypagePointRespDto

```
SELECT p.point, p.reason, p.historyDate
FROM user u LEFT OUTER JOIN point p
ON u.id = p.userId
WHERE u.id = 1;
```

//qna (1:1 문의 부분)
POST
"/shop_mypage/{userId}/qna"
MypageQnaRespDto

```
SELECT q.id, q.title, q.content, q.createDate
FROM qna q LEFT OUTER JOIN user u
ON u.id = q.userId
WHERE u.id = 1;
```

여기에 qna 하나 눌렀을 때
MypageCommentOnQnARespDto

로그인한 유저만 내 질문에 답변을 볼 수 있음..

```
SELECT q.createDate, q.content, p.thumb, p.title, coq.createDate, coq.comment
FROM qna q LEFT OUTER JOIN user u
ON q.userId = u.id
LEFT OUTER JOIN product p
ON q.productId = p.id
LEFT OUTER JOIN commentOnQnA coq
ON q.id = coq.qnaId
WHERE q.id=2;
```

//update 회원정보 수정
POST - 회원가입 페이지 재활용
"/shop_mypage/{userId}/update"

MypageUpdateRespDto

화면 불러와서 값 미리 뿌려져있어야하니까 필요한 쿼리문

```
SELECT u.profile, u.email, u.name, u.gender, u.phone, u.address, u.detail_address, u.birthday
FROM USER u
WHERE u.id = 3;
```

회원정보 수정 과정의 update 하는 쿼리문

```
UPDATE user
SET profile='수정된 프로필', name='수정된 문선현', gender='여', phone='010-3333-3333', address='수정된 부산광역시', detail_address='수정된 상세주소', birthday='1993-04-21'
WHERE id=3;

```

//회원탈퇴
POST -
"/shop_mypage/{userId}/Withdrawal"
MypageWithdrawalResponseDto
**\*\*\*\***\*\***\*\*\*\***어떤 값들을 받아와야하는걸까요? Dto만들어야한다면 어떤것들이 필요한걸가요
탈퇴 쿼리 2가지

1.

```
UPDATE user
SET cancel='1'
WHERE id =3;
```

2. 우선 이걸로 하기로함

```
DELETE FROM user
WHERE id =3;
```

//장바구니
Post
"/shop_cart/{userId}

CartResponseDto ##배송비는 고정
SELECT p.id, p.title, c.quantity, p.price
FROM cart c INNER JOIN product p INNER JOIN user u
ON c.userId = u.id AND p.id = c.productId
WHERE u.id = 1;

--------------- 스프링 서버 안가는 페이지
GET
"/about"

GET
"/cscenter"

````

## 관리자 dto를 위한 join

# 관리자는 각 테이블들에 대한 CRUD가 기본

# 연관 있는것과 join을 하면 페이지수가 줄어든다.

```sql
##상품 CRUD
#category
#product
#product_status
#relatedproduct


##주문 CRUD
#orders
#orders_detail

#cart

#user

#notice

#review

#recomment

#qna

#wishlist

#coupon

#point


````

## ABOUT 페이지 발견해서 만든것들

```sql
##ABOUT 페이지 입니다.
CREATE TABLE about   (
	id int auto_increment primary key,
    subject varchar(500),
    content varchar(500)
) engine=InnoDB default charset=utf8;


##subject는 선택해서 넣습니다.
INSERT into about(subject,content)
values ("제목","내용");
```

# 현재 큰 문제점 discounted를 이용하려면 관련된 dto를 수정해야함

- product_status를 생각해야함.

# VIEW는 뼈대만 간신히 만들고 기능을 우선적으로 할 수 밖에 없음

- -> 완성되고 꾸며도 늦지 않음

# modal도 나중에 넣을 수 있으면 넣기

- ->회원가입과 로그인 페이지가 필요함

# 결제시스템으로 orders와 orders_detail id값이 필요할때

- ->mybatis generatedKey 검색

# 내가 만든 쿼리문 꼭 한번 검사할것

=======

```
내일 mysql 및 스프링 손도 봐야함
그리고 새로운 테이블 추가댐


```

#새로만든 Qnarecomment 입니다
create table Qnarecomment(
id int auto_increment primary key,
qnaId int,
qnaComment varchar(2000)
)engine=InnoDB default charset=utf8;
drop table Qnarecomment;

#########################################

```
use areuareu;
select * from product;
select * from product_status;
select * from related_product;

update related_product set relatedProductId = 0 where id=51;


#이건 자식에 연결되어있는거
select *
from product pro inner join product_status pst inner join related_product rel
on pro.id = pst.productid and pro.id = rel.relatedProductId;


#이건 자식에 연결되어있는거
select *
from product pro inner join product_status pst inner join related_product rel
on pro.id = pst.productid and pro.id = rel.parentProductid and rel.relatedProductId=23;

select pro.title,pro.thumb,pro.price,pro.disc,pro.discounted,pro.content,pro.categoryId,pro.bgImg,pst.sale,pst.newly,pst.best,rel.parentProductId,rel.relatedProductId,ca.parentTypeId
from product pro inner join related_product rel inner join product_status pst inner join category ca
on pro.id= rel.parentProductId and pro.id = pst.productId and ca.parentTypeId = pro.categoryId;
```
