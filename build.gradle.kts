plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // 테스트 의존성
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // SQLite JDBC 드라이버 의존성 추가
    implementation("org.xerial:sqlite-jdbc:3.34.0")
}

tasks.test {
    useJUnitPlatform()
}
