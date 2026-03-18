# Investment Profile Tracker

Investment Profile Tracker is a Spring Boot web application for managing active investments against a centralized fund. It is designed for reliable portfolio tracking, safe transaction handling, and clear financial visibility through a server-rendered dashboard.

## Overview

The application starts with a default fund balance of $10,000,000 and supports full investment lifecycle operations. It validates incoming data, protects against over-allocation, and keeps remaining balance calculations consistent.

## Core Capabilities

- Create, view, update, and delete investments
- Track remaining fund balance in real time
- Prevent investments that exceed available capital
- Add capital to the fund with validation
- Sort investments by name or amount
- View detailed investment information
- Execute delayed asynchronous notifications for newly created investments
- Use transaction boundaries and locking for consistency

## Technology Stack

- Java 17
- Spring Boot 3.2
- Spring MVC + Thymeleaf
- Spring Data JPA
- Hibernate Validation
- H2 (development) and PostgreSQL (production)
- Gradle

## Project Structure

- `src/main/java/.../controller`: HTTP request handling and page navigation
- `src/main/java/.../service`: business rules, transactions, and notifications
- `src/main/java/.../repository`: JPA repositories and aggregate queries
- `src/main/java/.../model`: persistence entities and validation annotations
- `src/main/resources/templates`: Thymeleaf views
- `src/main/resources/application-dev.yaml`: development profile configuration
- `src/main/resources/application-prod.yaml`: production profile configuration

## Prerequisites

- Java 17 or newer
- Git
- PostgreSQL (for production profile)

Gradle is included via wrapper scripts, so no global Gradle installation is required.

## Getting Started

```bash
git clone https://github.com/maliksalimov/investment-profile-tracker.git
cd my_spring_portfolio
./gradlew clean build
./gradlew bootRun
```

Application URL:

```text
http://localhost:8080
```

## Profile Configuration

Development profile uses H2 file storage and enables additional SQL/web diagnostics.

Production profile uses PostgreSQL and environment-based credentials:

- `DATABASE_URL`
- `DATABASE_USER`
- `DATABASE_PASSWORD`
- `PORT` (optional; defaults to 8080)

To run with a specific profile:

```bash
./gradlew bootRun --args='--spring.profiles.active=dev'
./gradlew bootRun --args='--spring.profiles.active=prod'
```

## Build, Test, and Package

```bash
./gradlew test
./gradlew bootJar
```

Generated artifact:

```text
build/libs/my-spring-portfolio.jar
```

## Deployment Notes

- Ensure PostgreSQL is reachable from the runtime environment
- Set required production environment variables
- Start with the `prod` profile in hosted environments
- Keep `ddl-auto` strategy aligned with your migration policy before production rollout

## Author

Malik Salimov
