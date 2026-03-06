# Welcome to My Spring Portfolio
***

## Task
Build a web application to track an investor's active investments with a $10 million starting fund. The challenge is to ensure proper fund management, prevent over-investing, and provide real-time calculations of remaining funds while maintaining data integrity.

## Description
Developed a full-stack Spring Boot application with:
- **Backend validation** to prevent investments exceeding available funds
- **Real-time fund calculator** that automatically deducts total invested amount
- **Sorting capabilities** for investments (alphabetical, amount ascending/descending)
- **CRUD operations** for managing investments (Create, Read, Update, Delete)
- **2-minute notifications** after new investments are created
- **Responsive Bootstrap UI** with error handling and user feedback
- **Caching** for improved performance
- **Transaction management** for data consistency

Tech Stack: Java 17, Spring Boot, PostgreSQL, Thymeleaf, Bootstrap 5, Gradle

## Installation
**Prerequisites:** Java 17+, Gradle (or use ./gradlew), PostgreSQL

```bash
# Clone repository
git clone <repository-url>
cd my_spring_portfolio

# Configure database (or use environment variables)
# Edit src/main/resources/application-prod.yaml with your DB credentials

# Create database
psql -U postgres -c "CREATE DATABASE portfolio;"

# Build and run
./gradlew build
./gradlew bootRun
```

## Usage
Access the application at `http://localhost:8080`

**Main Features:**
- View dashboard with all investments and remaining funds
- Add new investments (validates sufficient funds)
- Sort investments by name or amount
- Click investment name to view details
- Update investment names
- Delete investments (funds return to pool)
- Add more money to the fund

```bash
# Run tests
./gradlew test

# Package for deployment
./gradlew bootJar

# Deploy to Heroku
heroku create my-portfolio-app
heroku addons:create heroku-postgresql:mini
git push heroku main
```

### The Core Team
**Malik Salimov** - Full Stack Developer

<span><i>Made at <a href='https://qwasar.io'>Qwasar SV -- Software Engineering School</a></i></span>
<span><img alt='Qwasar SV -- Software Engineering School's Logo' src='https://storage.googleapis.com/qwasar-public/qwasar-logo_50x50.png' width='20px' /></span>
