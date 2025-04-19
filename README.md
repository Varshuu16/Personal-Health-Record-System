

# Personal Health Record (PHR) App

A web application built with **Spring Boot** for managing personal health records, insurance details, and telemedicine appointments. It supports different roles including Users, Admins, and Healthcare Providers.

## Features
 User management for health records, insurance, and telemedicine.
 Admin interface for managing users and healthcare providers.
 Integration with telemedicine services.
 Role-based access control (User, Admin, Healthcare Provider).

## Technologies
- **Backend**: Spring Boot
- **Database**: MySQL (or other relational DB)
- **Security**: Spring Security
- **Documentation**: Swagger

## Setup

1. Clone the repository:
   bash
   git clone https://github.com/yourusername/phr-app.git
   cd phr-app
   

2. Configure `application.properties` for database connection.

3. Build and run the app:
   bash
   mvn clean install
   mvn spring-boot:run
   

The app will be available at `http://localhost:8080`.

## License
MIT License.

