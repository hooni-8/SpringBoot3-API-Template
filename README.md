# 프로젝트 설정 가이드

## 📌 사용할 때 변경해야 할 곳

### 1. `settings.gradle`
- `rootProject.name` 수정

### 2. 패키지 변경
- 프로젝트에 맞게 패키지명을 변경

### 3. `application.yml`
```yaml
spring:
  application:
    root: your-app-name
    name: your-app-name  # 애플리케이션 이름 설정
  
  datasource:
    url: jdbc:postgresql://localhost:5432/your-database  # 데이터베이스 URL 변경
    username: your-username  # 데이터베이스 사용자명 변경
    password: your-password  # 데이터베이스 비밀번호 변경

mybatis:
  config-location: classpath:mybatis-config.xml  # MyBatis 설정 파일 위치 변경
```

### 4. Swagger URL
> http://localhost:8080/template