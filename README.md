![header](https://capsule-render.vercel.app/api?type=wave&color=0:EEFF00,100:a82da8&height=300&section=header&text=managements&fontSize=90)
# 학생·직원 통합 관리 프로그램

## 목차
1. [프로젝트 목적](#1-프로젝트-목적)
2. [사용 기술 스택 및 라이브러리](#2-사용-기술-스택-및-라이브러리)
3. [프로젝트 기능](#3-프로젝트-기능)
4. [프로젝트 구조](#4-프로젝트-구조)
5. [사용 방법](#5-사용-방법)
6. [실행 중 발생할 수 있는 문제 및 해결 방법](#6-실행-중-발생할-수-있는-문제-및-해결-방법)
7. [트러블 슈팅](#7-트러블-슈팅)



## 1. 프로젝트 목적
- 자바 다형성의 활용
- repository - service - controller 개념 적용
- 자바에서의 json 파일 활용 적용
- mysql dml, dcl, ddl 의 사용
- mysql 프로시저, 트리거의 활용
- db연동기술 jdbc 적용
위의 사항들을 배우고 프로젝트에 적용해 보는것에 목적을 둔 관리 프로그램



## 2. 사용 기술 스택 및 라이브러리

### **기본 기술 스택**
- **애플리케이션**: Java (JDK 17)
- **데이터베이스**: MySQL (MySQL 8)
- **연결 기술**: JDBC
- **데이터 처리**: JSON

### **외부 라이브러리**
- **Lombok**: 코드 간결화를 위한 자동 생성 기능 활용
- **Jackson**: JSON 데이터 변환 및 처리



## 3. 프로젝트 기능
- 학생 관리 프로그램, 직원 관리 프로그램을 통합한 통합 관리 프로그램
### ** 학생 관리 프로그램 **
- 학생 번호로 조회, 이름으로 조회
- 학생 평균, 총점 계산기능
- 학생 정보 삭제
- 학생 정보 업데이트
- 학생 정보 등록
### ** 직원 관리 프로그램 **
- 직원 번호로 조회
- 직원 정보 입력
- 직원 정보 삭제
- 직원 정보 업데이트\
- 직원 급여 인상 정책 (직급별 다른 정책)

## 4. 프로젝트 구조


### **아키텍처**
![Image](https://github.com/user-attachments/assets/d1abce09-a1b1-486b-92e4-c6b2a30bf614)


### **ERD (Entity-Relationship Diagram)**
![Image](https://github.com/user-attachments/assets/68773310-5fb9-4251-83df-81dab2a7d52a)

## 5. 사용 방법

1. **Javadoc 확인**: `javadoc/index.html`에서 문서 확인
2. **데이터베이스 테이블 및 프로시저 생성**:  
   - `database/CreateTable.sql` 실행  
   - `database/CreateProcedure.sql` 실행  
3. **DB 연결 설정**:  
   - `/common/Ignore` 파일에서 본인 환경에 맞는 DB 연결 주소 및 패스워드 입력



## 6. 실행 중 발생할 수 있는 문제 및 해결 방법

| 문제 | 원인 | 해결 방법 |
|------|------|---------|
| **DB 연결 실패 (Connection Fail)** | 잘못된 DB 커넥션 설정, 유저 또는 비밀번호 오류 | DB 연결 정보 및 계정 정보 확인 |
| **테이블 또는 프로시저 미생성** | `CreateTable.sql` 또는 `CreateProcedure.sql` 실행되지 않음 | 해당 SQL 파일을 실행하여 테이블과 프로시저 생성 |
| **JDBC 드라이버 오류** | JDBC 드라이버가 설치되지 않음 | 프로젝트의 라이브러리 설정에서 JDBC 드라이버 활성화 확인 |



## 7. 트러블 슈팅
- 팀원간의 라이브러리, 환경이 달라 머지시에 환경설정 파일 충돌 발생
  => 캐시 삭제 후 깃 이그노어에 해당 파일 추가, 이미 올라가있는 파일 원격 레포지토리에서 삭제
  
 [트러블 슈팅 상세 정리 https://velog.io/@dlwjdtjq1234/iml파일-merge-시에-conflict-해결방법](https://velog.io/@dlwjdtjq1234/iml파일-merge-시에-conflict-해결방법)
- 광범위한 에러메시지로 인해 코딩중 오류 발생해도 어느 계층에서 문제가 터진건지 확인하기 어려움
   => 세분화된 예외 처리, 사용자정의 예외 처리

