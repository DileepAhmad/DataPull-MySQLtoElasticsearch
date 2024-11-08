# DataPull-MySQLtoElasticsearch
# My Spring Boot Data Migration Project

This project demonstrates how to perform data migration from MySQL to Elasticsearch in a Spring Boot application. The application fetches data from MySQL and migrates it to Elasticsearch periodically using scheduled tasks. This project also exposes RESTful APIs to interact with product data.

## Features

- **Data Migration**: Automatically migrates data from MySQL to Elasticsearch.
- **Scheduled Migration**: Runs the migration task every 30 seconds using cron jobs.
- **Elasticsearch Integration**: Performs CRUD operations with Elasticsearch for storing and retrieving data.
- **MySQL Integration**: Reads and writes product data to a MySQL database.
- **RESTful APIs**: Provides endpoints to add and retrieve product data.

## Prerequisites

Before running the application, make sure you have the following installed:

- **Java 11 or higher**
- **Maven** (for building the project)
- **MySQL** (for storing product data)
- **Elasticsearch** (for storing migrated data)
- **IDE** (IntelliJ IDEA, Eclipse, or any Java-supported IDE)

## Setup

### 1. Clone the Repository

Clone the repository to your local machine using Git:

```bash
git clone https://github.com/yourusername/my-spring-boot-project.git
cd my-spring-boot-project
