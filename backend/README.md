<p align="center">
  <a href="https://jansorry.com">
    <img src="./assets/title.png" width="400" height="160"  alt="logo">
  </a>
</p>

---

## 📚 TOC

- [DEPLOY URL](#-deploy-url)
- [SPECIFICATION](#-specification)
- [INTRODUCTION](#-introduction)
- [SERVICE LAYOUT](#-service-layout)
- [SKILLS](#-skills)
- [DEPLOY STRUCTURE](#-deploy-structure)
- [UML](#-uml)
- [ERD](#-erd)
- [FUNCTION](#-function)

<br>

---

<H2 align="center">MEMBER</H2>

<p align="center">
  <a href="https://github.com/takealook97">
    <img src="https://github.com/takealook97.png/" width="150" alt="takealook97">
  </a>
  <a href="https://github.com/sunju5402">
    <img src="https://github.com/sunju5402.png/" width="150" alt="smarfy99">
  </a>
  <a href="https://github.com/ozllzlme">
    <img src="https://github.com/ozllzlme.png/" width="150" alt="smarfy99">
  </a>
  <br>
  김건우 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 이선주 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 김예림
</p>

<br>

---

## 🕊️ Deploy URL

- ✅ front-server : https://jansorry.com
- ✅ back-server : https://jansorry.store
- ✅ back-swagger : https://jansorry.store/swagger-ui/index.html

<br>

## 📝 Specification

- notion : https://takealook97.notion.site/jansorry-d926a1053a9e4e02ac849c5f1a3d263b?pvs=4

<br>

---

## 📢 Introduction

### main-service

- **명절 잔소리 영수증 서비스**
- 잔소리를 학업·진로/건강·외모/연애·결혼/취업·직장/가족·자녀/기타 별로 카테고리를 나눠, 사용자가 해당 잔소리를 쉽게 찾을 수 있다.
- 잔소리에 대한 사용자의 대응을 등록할 수 있다.
- 실시간/나이대별/팔로잉/트렌드 피드를 제공하고, 해당 피드에 좋아요 및 팔로우를 누를 수 있다.
- 사용자가 들은 잔소리를 기반으로 영수증을 만들고, 오픈 그래프를 활용하여 어른용/친구용 영수증을 공유할 수 있다.

### sub-service

- 카카오 소셜 로그인
- 나이대/성별/전체를 기준으로 잔소리 통계
- 잔소리 모의고사
- 관리 페이지

<br>

## 🏠 Service Layout

### 메인 페이지

<img src="./assets/service/main.png" width="700" alt="main">


<br>

---

## 🛠️ Skills

<img src="./assets/skills.png" width="700" alt="배포 구조 이미지">

### language

- back : Java 17
- front : Html, CSS, JavaScript, TypeScript

### framework

- back : SpringBoot 3.2.2, Spring Data JPA
- front : Next.js

### skills

- back : Spring Security, JWT, Oauth2.0, Spring Batch, QueryDSL
- front :

### database

- MySQL 8.0.35
- Redis

### server

- AWS EC2
- Docker
- Nginx
- Jira
- GitLab CI/CD

<br>

---

## 🌐 System Architecture

<img src="./assets/system_architecture.png" width="700" alt="배포 구조 이미지">

<br>

## 💾 ERD

<img src="./assets/erd.png" width="700" alt="erd">

<br>

---

## ⚙️ Function

### 🎯 회원

💡 회원은 Spring Security & JWT & Oauth2.0 사용하여 카카오 소셜 로그인 구현

- [x] 회원 가입
- [x] 로그인 / 로그아웃
- [x] 마이페이지
- [x] 닉네임 수정
- [x] 회원 탈퇴 (soft deletion)
- [x] 팔로잉/팔로워 목록

### 🎯 잔소리

💡 학업·진로/건강·외모/연애·결혼/취업·직장/가족·자녀/기타 총 6개의 카테고리로 잔소리 분류

- [x] 잔소리 카드 상세 조회
- [x] 잔소리 카드 전체 조회 (카테고리별로 잔소리와 가격 제공)

### 🎯 잔소리 대응

💡 사용자가 받은 잔소리에 대한 대응 생성

- [x] 대응 생성
- [x] 대응 상세 조회 (해당 사용자가 작성한 대응을 상세 조회)
- [x] 대응 전체 조회 (해당 사용자가 작성한 대응 목록들을 전체 조회, 무한스크롤)
- [x] 대응 삭제 (soft deletion)

### 🎯 피드

💡 실시간/나이대/팔로잉/트렌드 별로 잔소리-대응 피드 무한스크롤로 제공, 동시성을 고려하여 팔로우 및 좋아요 3초 디바운싱 적용

- [x] 실시간 피드 조회
- [x] 팔로잉 피드 조회
- [x] 나이대별 피드 조회 (10/20/30대 별로 피드 조회)
- [x] 트랜드 피드 조회 (좋아요 순으로 30개의 피드를 뽑은 다음, 랜덤으로 10개 피드 제공)

### 🎯영수증

💡 영수증은 3개까지만 저장 가능, 어른용/친구용 별로 글자 크기 상이

- [x] 영수증 저장 (3개까지만 저장 가능)
- [x] 영수증 상세조회 (3개중 n번째의 영수증 조회)
- [x] 영수증 삭제 (soft deletion)
- [x] 영수증 개수 확인

### 🎯 좋아요

💡 동시성을 고려하여 redis에 좋아요 정보 저장 후, 배치를 이용해 db에 반영

- [x] 좋아요 등록
- [x] 좋아요 취소

### 🎯 팔로우

💡 동시성을 고려하여 redis에 팔로우 정보 저장 후, 배치를 이용해 db에 반영

- [x] 회원 검색 (닉네임으로 회원 조회)
- [x] 팔로잉 등록
- [x] 팔로잉 취소
- [x] 팔로잉 전체 조회
- [x] 팔로워 전체 조회
