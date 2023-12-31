# QA-Backend

**Welcome to Test Profile Manager** – your one-stop solution to efficiently manage, create, and interact with testing profiles. Designed with simplicity and versatility in mind, this application combines a user-friendly interface with powerful features to streamline profile management for testing environments.

This is only the backend repository, check out our frontend repository: [QA-Frontend](https://github.com/guillermoaviles/BPPR-QA-Frontend)

# Table of Contents

1. [Overview](#overview)
2. [Features](#features)
3. [Getting Started](#getting-started)
   - [Prerequisites](#prerequisites)
   - [API Endpoints](#api-endpoints)
4. [Documentation](#documentation)
   - [MiBanco Technical Documentation](#mibanco-technical-documentation)
   - [Class Diagram](#class-diagram)
   - [Use Case Diagram](#use-case-diagram)
6. [Team](#team)

## Overview

Crafted with a React Frontend and a robust Java/Spring Boot Backend, Test Profile Manager is a seamless integration of design and functionality. The application is constructed to ensure a smooth and reliable user experience.

## Features

- **Manage Testing Profiles**: Seamlessly create, modify, and remove profiles while identifying active ones.
- **Profile Ownership & Locking**: Enhanced transparency with display features for user details on active profiles.
- **Search & Filter**: Efficiently locate profiles with our refined search and filter capabilities.
- **Bulk Operations & JSON Integration**: Export and import multiple profiles effortlessly with JSON.
- **Flexible Profile Creation**: Experience the ease of creating profiles with optional attributes.
- **Authentication**: Secure user authentication with sign-up, login, and logout functionalities.

## Getting Started

Follow these steps to get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
1. Clone the Repository
```
git clone https://github.com/guillermoaviles/BPPR-QA-Backend.git
```
2. Navigate to the Project Directory
```
cd BPPR-QA-Backend
```
### API Endpoints
`/api/profiles/`

|TYPE|ROUTE|INFO|
|---|---|---|
|GET|/id|Get profile by ID|
|GET|/searchBy(Attribute)|Find by attribute|
|GET|/search|Filter through profile data|
|POST|/new|Add a new profile|
|POST|/export|Export profiles as JSON|
|POST|/import|Import profiles|
|PUT|/{id}|Edit profile data|
|PATCH|/{id}/(Attribute)|Patch by attribute|
|DELETE|/{id}|Delete profile by ID|

# Documentation

## MiBanco Technical Documentation
[View Here](https://docs.google.com/document/d/1N-6HjhP6MUFbh15LUc7hSchip-0jwWlZ/edit?usp=sharing&ouid=112740178667691118982&rtpof=true&sd=true)

## Class Diagram
![Class Diagram](https://github.com/guillermoaviles/BPPR-QA-Frontend/assets/19162359/a349fdb5-e43e-498f-bd18-48a29ec1245e)

## Use Case Diagram
![Use Case Diagram](https://github.com/guillermoaviles/BPPR-QA-Frontend/assets/19162359/0d257f69-0ade-4a06-87c4-fe98713d908d)

# Team:

- [Merianni Nuñez Tejeda](https://github.com/merianni)
- [Guillermo Aviles](https://github.com/guillermoaviles)
