# Social Network Opinion Platform

This project is a **Spring Boot**-based backend for a social network where users can create **Areas**, post **Surveys** in those areas, and allow **users to give feedback** (marks and comments) on the surveys.

---

## 🧠 Project Concepts

### 1. **Area**
An area is like a group or category (e.g., "Fitness", "Restaurants", "Books") that:
- Has an **owner** (a `User`)
- Has **members** (`List<User>`, many-to-many)
- Has **surveys** created inside it

### 2. **Survey**
A survey is a question or request for feedback posted in an area. It contains:
- A **title** and **description**
- A reference to the **area** it belongs to
- A list of **survey responses** (marks + comments from users)

### 3. **SurveyResponse**
A response from a user to a specific survey. Includes:
- A **numerical mark** (e.g. 1–5)
- An optional **comment**
- A reference to both the **survey** and the **user**
- Only one response per user per survey (enforced by a unique constraint)

---

## 🧩 Technologies Used

- **Java 17**
- **Spring Boot 3.4.3**
- **Spring Data JPA** (PostgreSQL)
- **Spring Web**
- **Spring Security + OAuth2** *(planned, placeholder)*
- **Lombok**

---

## 📂 Project Structure

```
social-network/
├── entity/
│   ├── Area.java
│   ├── Survey.java
│   ├── SurveyResponse.java
├── repository/
│   ├── AreaRepository.java
│   ├── SurveyRepository.java
│   ├── SurveyResponseRepository.java
├── service/
│   ├── AreaService.java
│   ├── SurveyService.java
│   └── SurveyResponseService.java
├── controller/
│   ├── AreaController.java
│   ├── SurveyController.java
│   └── SurveyResponseController.java
└── SocialNetworkApplication.java
```

---

## 📬 Available Endpoints

### 🔹 Create Area
```http
POST /api/areas
```
**Params:** `ownerId`, `name`, `description`

---

### 🔹 Add Survey to Area
```http
POST /api/surveys
```
**Params:** `areaId`, `title`, `description`

---

### 🔹 Submit Survey Response (mark + comment)
```http
POST /api/survey-responses
```
**Params:** `surveyId`, `userId`, `mark`, `comment`

---

## 📝 Example Use Case
1. A user creates an **Area** called "Favorite Books"
2. The user adds a **Survey** titled "What did you think about '1984'?"
3. Other users leave a **mark** (e.g., 4/5) and a comment like "Very thought-provoking"

---

## 🚀 Getting Started

1. Clone the repository
```bash
git clone https://github.com/your-username/social-network.git
cd social-network
```

2. Configure `application.properties` for your PostgreSQL setup:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/socialdb
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

3. Run the application
```bash
./mvnw spring-boot:run
```

4. Test the endpoints with Postman or Swagger

---

## 🛡️ Future Features (Planned)
- Authentication & JWT login
- Public/private area visibility
- Survey types (multiple choice, ratings)
- User roles & permissions
- API docs via Swagger

---

## 🧑‍💻 Author
**Mikhail Povolotskiy** — social network architect, Spring Boot + data modeling expert

---

## 📄 License
MIT (or specify your preferred license)
