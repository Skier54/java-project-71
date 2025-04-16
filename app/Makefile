.DEFAULT_GOAL := build-run

help:
	./build/install/app/bin/app -h

run-dist:
	@./build/install/app/bin/app filepath1.json filepath2.json

start:
	./gradlew run

clean:
	@./gradlew clean

build:
	./gradlew build

report:
	./gradlew jacocoTestReport

check:
	@./gradlew checkstyleMain
	@./gradlew checkstyleTest

test:
	@./gradlew test

build-run: build run

.PHONY: build
