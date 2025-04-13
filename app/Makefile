.DEFAULT_GOAL := build-run

run:
	./gradlew run

run-dist:
	@./build/install/app/bin/app filepath1.json filepath2.json

clean:
	./gradlew clean

build:
	./gradlew clean build

report:
	./gradlew jacocoTestReport

check:
	gradle checkstyleMain
	gradle checkstyleTest

test:
	./gradlew test

build-run: build run

.PHONY: build