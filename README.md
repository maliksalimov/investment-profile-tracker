# Investment Profile Tracker

> A full-stack web application for managing and monitoring investment portfolios — built with Java Spring Boot and a lightweight HTML/CSS frontend.

---

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

---

## Overview

**Investment Profile Tracker** is a web-based application designed to help investors organize, track, and analyze their financial portfolios in one place. The application provides a clean interface for managing investment profiles, monitoring asset performance, and maintaining an up-to-date view of holdings — all backed by a robust Java Spring Boot server.

---

## Features

- 📊 **Portfolio Dashboard** — Get a consolidated view of all your investment positions
- 💼 **Profile Management** — Create and manage multiple investment profiles
- 📈 **Asset Tracking** — Monitor individual holdings and their current values
- 🔄 **CRUD Operations** — Add, update, and remove investments with ease
- 🌐 **Web Interface** — Accessible from any browser with no additional software required

---

## Tech Stack

| Layer       | Technology             |
|-------------|------------------------|
| Backend     | Java, Spring Boot      |
| Frontend    | HTML, CSS              |
| Build Tool  | Gradle                 |
| Runtime     | JVM (Java 17+)         |

---

## Prerequisites

Before running this application, ensure you have the following installed:

- **Java Development Kit (JDK)** — version 17 or higher
  - [Download JDK](https://adoptium.net/)
- **Git**
  - [Download Git](https://git-scm.com/)

> No separate installation of Gradle is required — the project includes the Gradle Wrapper (`gradlew`).

---

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/maliksalimov/investment-profile-tracker.git
cd investment-profile-tracker
```

### 2. Build the Project

**macOS / Linux:**
```bash
./gradlew build
```

**Windows:**
```cmd
gradlew.bat build
```

### 3. Run the Application

**macOS / Linux:**
```bash
./gradlew bootRun
```

**Windows:**
```cmd
gradlew.bat bootRun
```

### 4. Access the Application

Open your browser and navigate to:

```
http://localhost:8080
```

---

## Project Structure

```
investment-profile-tracker/
├── gradle/
│   └── wrapper/              # Gradle wrapper configuration
├── src/
│   ├── main/
│   │   ├── java/             # Java source files (controllers, services, models)
│   │   └── resources/
│   │       ├── static/       # HTML, CSS, and frontend assets
│   │       └── application.properties
│   └── test/                 # Unit and integration tests
├── build.gradle              # Project dependencies and build configuration
├── settings.gradle           # Gradle project settings
├── gradlew                   # Unix Gradle wrapper script
└── gradlew.bat               # Windows Gradle wrapper script
```

---

## Usage

1. **Launch the app** following the steps in [Getting Started](#getting-started)
2. **Navigate** to `http://localhost:8080` in your browser
3. **Create an investment profile** to begin tracking your portfolio
4. **Add assets** to your profile, including position details and values
5. **Monitor** your investments through the dashboard

---

## Contributing

Contributions are welcome! To contribute:

1. Fork the repository
2. Create a new branch: `git checkout -b feature/your-feature-name`
3. Commit your changes: `git commit -m 'Add your feature'`
4. Push to the branch: `git push origin feature/your-feature-name`
5. Open a Pull Request

Please ensure your code follows the existing style and that all tests pass before submitting.

---

## License

This project is open source and available under the [MIT License](LICENSE).

---

<p align="center">
  Made by <a href="https://github.com/maliksalimov">maliksalimov</a>
</p>
