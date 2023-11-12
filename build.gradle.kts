plugins {
    id("java") // Java 플러그인을 추가합니다. 이는 Java 언어로 작성된 프로젝트임을 나타냅니다.
}

group = "org.example" // 프로젝트의 그룹 ID를 설정합니다. 일반적으로 도메인 이름을 역순으로 사용합니다.
version = "1.0-SNAPSHOT" // 프로젝트의 버전을 설정합니다. SNAPSHOT은 개발 중인 버전임을 나타냅니다.

repositories {
    mavenCentral() // 의존성을 다운로드할 리포지토리를 Maven Central로 지정합니다.
}

dependencies {
    // 테스트를 위한 JUnit 의존성을 추가합니다.
    // JUnit은 Java 프로그래밍 언어용의 단위 테스트 프레임워크입니다.
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // SQLite JDBC 드라이버 의존성을 추가합니다.
    // 이를 통해 SQLite 데이터베이스에 접근하고 상호작용할 수 있습니다.

    implementation("org.xerial:sqlite-jdbc:3.34.0")
}
tasks.test {
    useJUnitPlatform() // 테스트 작업을 실행할 때 JUnit 플랫폼을 사용하도록 설정합니다.
}
