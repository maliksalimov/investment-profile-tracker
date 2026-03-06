## Task

The problem was to create a full-stack web application for investors to track their active investments effectively. The challenge involved:

* Managing a starting fund of $10 million USD and calculating the remaining balance in real-time.
* Implementing CRUD-like operations such as adding new investments and updating existing investment names.
* Providing dynamic data organization through filtering and sorting capabilities.
* Ensuring the application is production-ready for cloud deployment.

## Description

I solved this problem by building a robust Spring Boot application using a layered architecture (Model-View-Controller):

* **Backend:** Developed with Java and Spring Boot, utilizing Spring Data JPA for data persistence and a Service layer for financial logic.
* **Database:** Used H2 as an in-memory database for rapid development and testing.
* **Frontend:** Created a dynamic user interface with Thymeleaf and Bootstrap 5, allowing for a responsive "Investor Dashboard".
* **Features:** Integrated a real-time fund calculator, an inline update system for asset names, and a sorting engine for alphabetical or amount-based views.

## Installation

To install and run this project locally, you need Java 17+ and Gradle installed:

1. Clone the repository:

```bash
git clone <your-repository-link>

```

2. Navigate to the project directory:

```bash
cd my_spring_portfolio

```

3. Build the project using Gradle:

```bash
./gradlew build

```

## Usage

To start the application, run the following command in your terminal:

```bash
./gradlew bootRun

```

Once the application starts, open your browser and go to:
`http://localhost:8080`

**Key Functionalities:**

* **Add Investment:** Use the form at the bottom to enter the asset name and amount.
* **Add to Fund:** Use the top-right form to increase your total available capital.
* **Update:** Click the "Rename" button next to any investment to change its name.
* **Sort:** Use the "Sort Investments" dropdown to filter by name or dollar amount.

### The Core Team

Malik Səlimov - Three-time RFO finalist and Programming Teacher.

<span><i>Made at <a href='[https://qwasar.io](https://qwasar.io)'>Qwasar SV -- Software Engineering School</a></i></span>
<span><img alt='Qwasar SV -- Software Engineering School's Logo' src='[https://storage.googleapis.com/qwasar-public/qwasar-logo_50x50.png](https://storage.googleapis.com/qwasar-public/qwasar-logo_50x50.png)' width='20px' /></span>