# 프로젝트 이름: MongMong Calendar Application

## 프로젝트 개요
MongMong Calendar Application은 Java Swing과 SQLite를 사용하여 개발된 캘린더 애플리케이션입니다. 사용자는 캘린더에서 월별로 일정을 확인하고, 일정을 추가, 삭제할 수 있습니다.

## 기능
- 캘린더 페이지에서 월별 일정 확인
- 날짜별 일정 추가 및 삭제
- 일정 상세 정보 확인 및 관리
- MVC 패턴과 Gradle을 활용한 프로젝트 구조

## 설치 및 실행 방법
1. 프로젝트 클론: git clone https://github.com/mlnyx/mongmong.git
2. IntelliJ IDEA에서 프로젝트를 열고, Gradle을 통해 필요한 의존성을 다운로드합니다.
3. `org.example.Main` 클래스를 실행하여 애플리케이션을 시작합니다.

## 구조
- `src/main/java/org/example/view`: 사용자 인터페이스 관련 클래스
- `src/main/java/org/example/model`: 데이터 처리 관련 클래스
- `src/main/java/org/example/controller`: 사용자 입력 처리 및 뷰-모델 연결 클래스
- `src/main/resources`: 리소스 파일 (이미지 등)

## 개발자 가이드
- 프로젝트는 MVC 패턴을 따릅니다. 각 기능을 개발할 때 해당하는 폴더(view, model, controller)에 클래스를 추가하세요.
- SQLite 데이터베이스는 `src/main/java/org/example/database`에 위치합니다.
- UI 변경은 `src/main/java/org/example/view` 폴더의 클래스에서 진행하세요.

## 기여 방법
1. 새 기능 또는 버그 수정을 위한 새 브랜치를 생성하세요.
2. 변경 사항을 커밋하고 브랜치에 푸시하세요.
3. `main` 브랜치로 풀 리퀘스트를 생성하세요.

## 라이센스
이 프로젝트는 [MIT License](LICENSE) 하에 배포됩니다.
