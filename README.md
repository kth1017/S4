# S4
spring, jpa, thymeleaf / S3 복습용 기초적인 게시판 페이지 pratice / 2203

# 개요
- SSR 방식의 스프링 mvc 기반 상품 관리 페이지 예제

- ERD를 비롯한 DB 설계 기초 학습

- 간단한 페이지 작성을 위한 타임리프 기초 학습

- db는 h2, 조작은 orm인 jpa 사용

# 요약
@준비
- ovenapp.io로 간단한 게시판 기획
- rdb 사용을 위해 스키마 구성
- draw.io로 erd 작성(member, post, comment, category) 

@코드
- back component : 규모가 작기에 service는 분리하지 않고 entity, repository, controller
- view : thymeleaf 사용 
