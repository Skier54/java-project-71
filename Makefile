.DEFAULT_GOAL := build-run

run:
	@./gradlew run

run-dist:
	@./build/install/app/bin/app filepath1.json filepath2.json

clean:
	@./gradlew clean

build:
	@./gradlew clean
	@./gradlew installDist

report:
	@./gradlew jacocoTestReport

check:
	@./gradlew checkstyleMain
	@./gradlew checkstyleTest

test:
	@./gradlew test

build-run: build run

.PHONY: build