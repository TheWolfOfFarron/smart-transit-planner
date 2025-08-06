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


