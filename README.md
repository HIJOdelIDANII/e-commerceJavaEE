# E-commerce JEE Project

This is a **Java EE E-commerce project** using **MySQL (via Docker)** as the database and **Smart Tomcat Plugin** for running the web application directly from IntelliJ.

---

---

## 🛠️ Prerequisites

- **Java 11+**
- **IntelliJ IDEA (with Smart Tomcat Plugin installed)**
- **Maven (configured in IntelliJ)**
- **Docker Desktop (if windows) (with Docker Compose)**
---

## 🏃‍♂️ How to Run the Project in IntelliJ (Using Smart Tomcat)

1. Clone the project:
    ```bash
    git clone https://github.com/HIJOdelIDANII/e-commerceJavaEE.git
    ```

2. Open the project in IntelliJ.

3. Import the project as a **Maven project**:
    - Right-click `pom.xml` -> **Add as Maven Project** (if needed).

4. Install **Smart Tomcat Plugin**:
    - Go to **File -> Settings -> Plugins -> Marketplace**.
    - Search for `Smart Tomcat`.
    - Install it, then restart IntelliJ.

5. Configure Smart Tomcat:
    - Go to **Run -> Edit Configurations**.
    - Add a new configuration: **Smart Tomcat**.
    - Set the **Tomcat Base Directory** (version 9).
    - Set **WebApp Directory** to: `src/main/webapp`.

6. Build & Run:
    - Use Maven to `clean`, `compile`, and `package`.
    - Start the project using **Smart Tomcat (green play button)**.

7. Access your app at:
    ```
    http://localhost:8080/
    ```
   you can change the port int the configuration of smart tomcat

---

## 🐳 How to Run MySQL in Docker (Database Setup)

### 1. Start MySQL Container

Run:
```bash
docker-compose up -d
```
### 2. Access MySQL Directly (Optional)
```bash
docker exec -it <container_id> mysql -u root -p
```