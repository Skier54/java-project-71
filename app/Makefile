.DEFAULT_GOAL := build-run

clean:
	@./gradlew clean

build:
	@./gradlew clean build

install:
	@./gradlew clean installDist

help:
	./build/install/app/bin/app -h

version:
	@./build/install/app/bin/app -V

run-dist:
	@./build/install/app/bin/app filepath1.json filepath2.json

compare-json:
	@./build/install/app/bin/app src/test/resources/fixtures/filepath1.json src/test/resources/fixtures/filepath2.json

compare-yaml:
	@./build/install/app/bin/app src/test/resources/fixtures/filepath1.yaml src/test/resources/fixtures/filepath2.yaml

run:
	@./gradlew run

test:
	@./gradlew test

report:
	@./gradlew jacocoTestReport

check:
	@./gradlew checkstyleMain
	@./gradlew checkstyleTest

build-run: build run

.PHONY: build
