# java-docker-compose

[![Build Status](https://travis-ci.org/ssullivan/java-docker-compose.svg?branch=master)](https://travis-ci.org/ssullivan/java-docker-compose)
[![codecov](https://codecov.io/github/ssullivan/java-docker-compose/coverage.svg?branch=master)](https://codecov.io/github/ssullivan/java-docker-compose?branch=master)

## Description
This is a Java library for parsing a limited subset of the docker-compose file format that the docker stack deploy
accepts. It is being developed to initially support versions >= 3 of the docker-compose file format.


## Download

### Gradle

### Maven

## Usage Example
```java
final ComposeFileReader reader = new ComposeFileReader();
ComposeFile composeFile = reader.read(someInputStream);
```
