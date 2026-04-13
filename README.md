# IBM Clinic Management — Microservices Demo

A clinic management application built as a set of Spring Boot microservices, designed to demonstrate core microservices concepts including service discovery, API gateway routing, and independent deployability.

---

## What Are Microservices?

Microservices is an architectural style that breaks a large application into smaller, independent services that communicate with each other over APIs. Each service owns a specific business capability, has its own codebase, and can be developed, deployed, and scaled independently.

**Advantages of this approach:**

- **Separation of Concerns** — Each service focuses on one specific domain, keeping the code focused and maintainable.
- **Scalability** — Individual services can be scaled independently based on load, without affecting others.
- **Resilience** — If one service fails, the rest of the system continues to operate normally.

---

## Project Architecture

```
                        ┌─────────────────────────────┐
                        │     ibm-clinic-eureka-server │
                        │         (port 8761)          │
                        │   Service Registry &         │
                        │   Discovery                  │
                        └──────────────┬──────────────┘
                                       │  all services register here
                        ┌──────────────▼──────────────┐
  Client / Browser ───► │   ibm-clinic-api-gateway    │
  (Postman, Angular,     │        (port 9001)          │
   React, etc.)         │   Single entry point,        │
                        │   routes by path prefix      │
                        └──┬────────────┬─────────┬───┘
                           │            │         │
               ┌───────────▼──┐  ┌──────▼──────┐  ┌───▼─────────────┐
               │ ibm-doctor-  │  │ ibm-patient- │  │ ibm-appointment │
               │   service    │  │   service    │  │    -service     │
               │  (port 9003) │  │  (port 9004) │  │   (port 9002)   │
               └──────┬───────┘  └──────┬───────┘  └────────┬────────┘
                      │                 │                    │
                      └─────────────────┴────────────────────┘
                                        │
                               ┌────────▼────────┐
                               │    MongoDB       │
                               │  (port 27017)    │
                               │  database: ibm   │
                               └─────────────────┘
```

### Services at a Glance

| Service | Port | Description |
|---|---|---|
| `ibm-clinic-eureka-server` | 8761 | Service registry — all microservices register here so they can discover each other |
| `ibm-clinic-api-gateway` | 9001 | Single entry point for all clients — routes requests to the correct microservice |
| `ibm-appointment-service` | 9002 | Manages clinic appointments |
| `ibm-doctor-service` | 9003 | Manages doctor records |
| `ibm-patient-service` | 9004 | Manages patient records and insurance plans |

---

## Prerequisites

Make sure the following are installed on your machine before you begin:

| Tool | Version | Download |
|---|---|---|
| Java JDK | 17 | https://adoptium.net |
| Maven | 3.8+ | https://maven.apache.org/download.cgi |
| MongoDB Community | 6+ | https://www.mongodb.com/try/download/community |
| Eclipse IDE | 2023-09+ | https://www.eclipse.org/downloads/ (use the **Eclipse IDE for Enterprise Java and Web Developers** package) |
| Git | Any | https://git-scm.com/downloads |
| Postman _(optional)_ | Any | https://www.postman.com/downloads |

> **MongoDB must be running** before you start any of the Spring Boot services. It connects to `mongodb://localhost:27017/` using a database named `ibm`.

---

## Step 1 — Clone the Repository

Open a terminal (Command Prompt or Git Bash on Windows) and run:

```bash
git clone <repository-url>
cd ibm-microservices-demo
```

You will see five project folders:

```
ibm-microservices-demo/
├── ibm-clinic-eureka-server/
├── ibm-clinic-api-gateway/
├── ibm-appointment-service/
├── ibm-doctor-service/
└── ibm-patient-service/
```

---

## Step 2 — Import Projects into Eclipse

Each folder is a separate Maven project and must be imported individually.

1. Open **Eclipse**.
2. Go to **File → Import**.
3. Select **Maven → Existing Maven Projects** and click **Next**.
4. Click **Browse** and navigate to the `ibm-microservices-demo` folder.
5. Eclipse will detect all five `pom.xml` files. Make sure **all five are checked**.
6. Click **Finish**.

Eclipse will import all five projects into the workspace.

---

## Step 3 — Update Maven Dependencies

After import, Eclipse needs to download all dependencies declared in each `pom.xml`.

1. In the **Package Explorer**, select all five projects (click the first, then Shift+click the last).
2. Right-click → **Maven → Update Project**.
3. In the dialog, make sure **Force Update of Snapshots/Releases** is checked.
4. Click **OK**.

Wait for the progress bar in the bottom-right corner of Eclipse to complete. This may take a few minutes on the first run as Maven downloads dependencies from the internet.

> If you see red error markers after the update, try right-clicking on the individual project → **Maven → Update Project** again for that specific project.

---

## Step 4 — Start MongoDB

Make sure MongoDB is running before starting any service.

**On Windows:**
```
net start MongoDB
```

Or open **Services** (`Win + R` → `services.msc`) and start the **MongoDB** service.

**On macOS/Linux:**
```bash
sudo systemctl start mongod
# or
brew services start mongodb-community
```

You can verify MongoDB is up by opening a browser and going to `http://localhost:27017` — you should see a plain text message from MongoDB.

---

## Step 5 — Run the Services (Order Matters)

The services must be started in the following order. Wait for each one to finish starting before moving to the next.

### 1. Eureka Server

In Eclipse, open the `ibm-clinic-eureka-server` project, navigate to:
```
src/main/java/com/ibm/server/App.java
```
Right-click → **Run As → Spring Boot App**.

✅ Ready when you see in the console:
```
Started App in X.XXX seconds
```

Verify: open `http://localhost:8761` in your browser — you should see the Eureka dashboard.

---

### 2. API Gateway

Open `ibm-clinic-api-gateway` → `src/main/java/com/ibm/gateway/App.java`

Right-click → **Run As → Spring Boot App**.

✅ Ready when the console shows `Started App`.

---

### 3. Doctor Service

Open `ibm-doctor-service` → `src/main/java/com/ibm/doctor/App.java`

Right-click → **Run As → Spring Boot App**.

✅ Ready when the console shows `Started App`.

---

### 4. Patient Service

Open `ibm-patient-service` → `src/main/java/com/ibm/patient/App.java`

Right-click → **Run As → Spring Boot App**.

✅ Ready when the console shows `Started App`.

---

### 5. Appointment Service

Open `ibm-appointment-service` → `src/main/java/com/ibm/appointment/App.java`

Right-click → **Run As → Spring Boot App**.

✅ Ready when the console shows `Started App`.

---

After all five services are running, refresh the Eureka dashboard at `http://localhost:8761`. You should see **ibm-doctor-service**, **ibm-patient-service**, and **ibm-appointment-service** listed as registered instances.

---

## Step 6 — Verify Everything Is Up

### Eureka Dashboard
```
http://localhost:8761
```
All three microservices should be listed under "Instances currently registered with Eureka".

### Health Check / Test Endpoints
These endpoints return a simple string to confirm each service is reachable through the gateway:

| URL | What it checks |
|---|---|
| `http://localhost:9001/testing-purpose` | Gateway itself |
| `http://localhost:9001/ibm-doctor-service/testing-purpose` | Gateway → Doctor Service |
| `http://localhost:9001/ibm-patient-service/testing-purpose` | Gateway → Patient Service |
| `http://localhost:9001/ibm-appointment-service/testing-purpose` | Gateway → Appointment Service |

Each should return a `200 OK` with a short message.

---

## Step 7 — Explore & Test the APIs

### Option A — Swagger UI (Recommended for learning)

Each microservice exposes a Swagger UI that lets you view all available endpoints and call them directly from the browser — no Postman needed.

| Service | Swagger UI URL |
|---|---|
| Doctor Service | `http://localhost:9003/swagger-ui/index.html` |
| Patient Service | `http://localhost:9004/swagger-ui/index.html` |
| Appointment Service | `http://localhost:9002/swagger-ui/index.html` |

**How to use Swagger UI:**

1. Open one of the URLs above.
2. You will see all API endpoints grouped by controller.
3. Click on any endpoint to expand it.
4. Click **Try it out** → fill in the required fields → click **Execute**.
5. The response will appear below, along with the HTTP status code.

> **Important:** When adding new records via POST, **leave the ID field blank**. MongoDB will auto-generate a unique ID for each document.

---

### Option B — Postman

All endpoints are also accessible via Postman. Use the gateway port `9001` as the base URL for all requests.

#### Sample Request Bodies

**Add a Doctor** — `POST http://localhost:9001/ibm-doctor-service/ibm-doctor/doctors`
```json
{
  "name": "Dr. Aisha Khan",
  "gender": "Female",
  "specialization": "Dermatology",
  "contact": "+91-9876543220",
  "email": "aisha.khan@ibmclinic.com",
  "password": "doctor@123"
}
```

**Add an Insurance Plan** — `POST http://localhost:9001/ibm-patient-service/ibm-patient/insurances`  
_(Note: Insurance is added by directly saving to the collection — use Swagger UI on port 9004 for this, as there is no POST insurance endpoint via the controller. Use the MongoDB shell or seed data instead.)_

**Add a Patient** — `POST http://localhost:9001/ibm-patient-service/ibm-patient/patients`
```json
{
  "insuranceId": "<id of an existing insurance document>",
  "name": "Anjali Desai",
  "dateOfBirth": "1995-07-19",
  "gender": "Female",
  "contact": "+91-9123456790",
  "email": "anjali.desai@email.com",
  "password": "patient@123"
}
```

**Add an Appointment** — `POST http://localhost:9001/ibm-appointment-service/ibm-appointment/appointments`
```json
{
  "doctorId": "<id of an existing doctor document>",
  "patientId": "<id of an existing patient document>",
  "date": "2026-05-01",
  "slot": "10:00 AM",
  "status": "SCHEDULED"
}
```

---

## Full API Reference

All endpoints below are accessible through the **API Gateway on port 9001**.

### Doctor Service — base path `/ibm-doctor-service/ibm-doctor`

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/doctors` | Add a new doctor |
| `GET` | `/doctors` | Get all doctors |
| `GET` | `/doctors/{id}` | Get doctor by ID |
| `GET` | `/doctor?email=` | Get doctor by email |
| `PUT` | `/doctors/{id}` | Update doctor details |
| `DELETE` | `/doctors/{id}` | Delete a doctor |

### Patient Service — base path `/ibm-patient-service/ibm-patient`

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/patients` | Add a new patient |
| `GET` | `/patients` | Get all patients |
| `GET` | `/patients/{id}` | Get patient by ID |
| `GET` | `/patient?email=` | Get patient by email |
| `PUT` | `/patients/{id}` | Update patient details |
| `DELETE` | `/patients/{id}` | Delete a patient |
| `GET` | `/insurances` | Get all insurance plans |
| `GET` | `/insurances/{id}` | Get insurance by ID |
| `GET` | `/insurances/patient-id?patientId=` | Get insurance for a patient |
| `PUT` | `/insurances/{id}` | Update an insurance plan |
| `DELETE` | `/insurances/{id}` | Delete an insurance plan |

### Appointment Service — base path `/ibm-appointment-service/ibm-appointment`

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/appointments` | Schedule a new appointment |
| `GET` | `/appointments` | Get all appointments |
| `GET` | `/appointments/{id}` | Get appointment by ID |
| `GET` | `/appointments/patient?patientId=` | Get appointments for a patient |
| `GET` | `/appointments/doctor?doctorId=` | Get appointments for a doctor |

---

## Seed Data

The project includes a `DataSeeder` component in each microservice that automatically inserts sample records into MongoDB on the **first startup only**. If the collection already has data, the seeder is skipped.

The following records are inserted:

**Doctors**
| ID | Name | Specialization |
|---|---|---|
| D001 | Dr. Arjun Mehta | Cardiology |
| D002 | Dr. Priya Sharma | Neurology |
| D003 | Dr. Rohan Verma | Orthopedics |

**Insurance Plans**
| ID | Package | Type | Amount |
|---|---|---|---|
| INS001 | Silver Shield | Individual | ₹5,000 |
| INS002 | Gold Care | Family | ₹12,000 |
| INS003 | Platinum Plus | Corporate | ₹25,000 |

**Patients**
| ID | Name | Insurance |
|---|---|---|
| P001 | Rahul Gupta | INS001 |
| P002 | Sneha Patel | INS002 |
| P003 | Vikram Singh | INS003 |

**Appointments**
| ID | Doctor | Patient | Date | Slot |
|---|---|---|---|---|
| A001 | D001 | P001 | 2026-04-15 | 10:00 AM |
| A002 | D002 | P002 | 2026-04-16 | 11:30 AM |
| A003 | D003 | P003 | 2026-04-17 | 02:00 PM |

---

## Stopping Services

To stop a service in Eclipse, go to the **Console** panel, click the red **Terminate** button (square icon).

To stop a service running outside Eclipse using the command line (Windows):

**Step 1 — Find the process ID using the port:**
```cmd
netstat -ano | findstr :<PORT>
```
Replace `<PORT>` with the port number, e.g. `9003`. Look for the PID in the last column.

**Step 2 — Kill the process:**
```cmd
taskkill /PID <PID> /F
```
Replace `<PID>` with the number from Step 1.

**Example — kill whatever is running on port 9003:**
```cmd
netstat -ano | findstr :9003
taskkill /PID 18432 /F
```

---

## Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Programming language |
| Spring Boot 3.2.4 | Application framework |
| Spring Cloud 2023.0.0 | Microservices tooling (Eureka, Gateway) |
| Spring Data MongoDB | Database integration |
| MongoDB | NoSQL document database |
| springdoc-openapi 2.1.0 | Swagger UI / OpenAPI documentation |
| Spring AOP | Cross-cutting concerns (logging exceptions) |
| Maven | Build and dependency management |

---

## Project Structure (per microservice)

```
ibm-doctor-service/
└── src/main/java/com/ibm/doctor/
    ├── App.java                     ← Spring Boot entry point
    ├── controller/
    │   └── DoctorController.java    ← REST endpoints
    ├── service/
    │   ├── IDoctorService.java      ← Service interface
    │   └── DoctorService.java       ← Business logic
    ├── repository/
    │   └── DoctorRepository.java    ← MongoDB queries
    ├── model/
    │   └── Doctor.java              ← Data model / MongoDB document
    ├── exception/
    │   ├── UserNotFoundException.java
    │   └── GlobalExceptionHandler.java
    ├── aop/
    │   └── DoctorServiceAfterThrowingAspect.java  ← Exception logging
    └── seeder/
        └── DoctorDataSeeder.java    ← Initial seed data
```

The Patient and Appointment services follow the same structure.
