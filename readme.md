# Waste Sorting App Backend

This is the backend for the Waste Sorting Mobile Application by Enviro365. It provides RESTful APIs to help users identify waste categories, disposal guidelines, and recycling tips.

## 🚀 Tech Stack

*   Java (Spring Boot) – Backend framework
*   H2 Database – In-memory database
*   Lombok & JPA – For clean code and database interaction
*   Postman – API testing

## 📌 Features

*   ✔️ Create waste categories
*   ✔️ Retrieve waste categories (all or by ID)
*   ✔️ Update waste categories
*   ✔️ Delete waste categories

## 🔗 API Endpoints

*   `GET /api/v1/wasteCategory` → Get all waste categories
*   `GET /api/v1/wasteCategory/{id}` → Get category by ID
*   `POST /api/v1/wasteCategory` → Add new category
*   `PUT /api/v1/wasteCategory/{id}` → Update category
*   `DELETE /api/v1/wasteCategory/{id}` → Delete category

## 🛠️ Setup & Run

1.  **Clone the repo:**

    ```bash
    git clone [https://github.com/your-username/waste-sorting-backend.git](https://github.com/your-username/waste-sorting-backend.git)
    cd waste-sorting-backend
    ```

2.  **Build & Run:**

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

3.  **Access API:** Runs on `http://localhost:8080`# EnviroWasteSortingApp
