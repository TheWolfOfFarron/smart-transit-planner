#  Public Transport Route Optimizer

##  Problem Statement

Develop a desktop application for optimizing public transport routes within a city. The system supports three types of users:

- **Traveler** (no authentication required)
  - View a sorted list of all public transport lines
  - View the optimal route between two stations (graphically)
  - Search for a transport line by number

- **Employee** (authentication required)
  - All traveler operations
  - CRUD operations for transport lines
  - Export transport line data (CSV, JSON, XML, TXT)
  - View transport statistics using charts (bar, pie, ring, etc.)

- **Administrator** (authentication required)
  - CRUD operations for employee accounts
  - View list of all authenticated users

The GUI supports **multilingual functionality** (minimum 3 international languages).

---

##  Tools & Technologies Used

| Tool | Purpose |
|------|---------|
| **Java** | Main programming language |
| **IntelliJ IDEA** | Primary development IDE |
| **PostgreSQL** | Relational database used for data persistence |
| **Hibernate** | ORM framework for Java–Database integration |
| **JUnit 5** | Unit testing framework |

###  Design Patterns Implemented

| Pattern | Application |
|--------|-------------|
| **Composite** | Used in Controller and Repository layers |
| **Observer** | Used for client language selection |
| **Proxy** | Used for creating new Repositories |
| **Singleton** | Ensures single instance for central components |
| **Builder** | Used for complex object creation logic |



## 🔧 UML Diagrams

### 1. **Class Diagrams**

- **Client Side**: `Start` class launches the client on a separate thread; the `Client` class handles communication.
- **Server Side**: Structured in three layers:
  - **Repo + Database** (persistence)
  - **BLL** (business logic)
  - **Server/ClientHandler** (communication layer)

### 2. **EERD (Enhanced ER Diagram)**

- Two tables:
  - `Users`: Stores authenticated users
  - `Transport`: Stores public transport lines

### 3. **Use Case Diagram**

- Depicts operations per user type (Traveler, Employee, Administrator)

### 4. **Activity Diagrams**

- Represent all possible user actions and navigation logic

### 5. **Sequence Diagrams**

Includes diagrams for:
- Login
- Filtering users
- CRUD operations for:
  - Managers
  - Employees
- Displaying statistics
- Searching for transport lines
- Finding optimal routes

---

##  Application Overview

### Launch Flow

- Initial screen: Choose Visitor or Authenticated User
- **Visitor**:
  - View or search transport lines (e.g., `refresh()` and `find()` functions)
- **Authenticated User**:
  - Redirected to their role-specific panel (employee or admin)
  - Can perform CRUD operations or statistical analysis
- Multiple windows enhance UX and ergonomics

---

##  Multilingual Support

The application supports at least three international languages, using an observer pattern for UI language selection. This ensures flexibility and better user accessibility.

---

##  Statistics and Data Export

Employees can view data visualizations in various chart formats:

- Radial (pie)
- Ring
- Column/bar

Data export is supported in:

- CSV
- JSON
- XML
- TXT

---

## 📚 Bibliography

- [Hibernate Tutorial – JavaTpoint](https://www.javatpoint.com/hibernate-tutorial)
- [PostgreSQL Official Site](https://www.postgresql.org/)

---

## 🧑‍💻 Author

- **Name**: Bogdan Andrei
- **Group**: 30233
- **Course Project**: Tema 3
