import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.3.50"
}

group = "dev.cramblings"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	jcenter()
	mavenCentral()
}

dependencies {
	implementation(kotlin("stdlib-jdk8"))
	dependsOnDaysModules(1..2)
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
	freeCompilerArgs += "-Xinline-classes"
	jvmTarget = "1.8"
}

val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
	jvmTarget = "1.8"
}

//TODO move to buildSrc
fun DependencyHandlerScope.dependsOnDaysModules(daysRange: IntRange) {
	daysRange.forEach {
		implementation(project(":aoc-d$it"))
	}
}
