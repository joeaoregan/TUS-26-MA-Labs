# Microservices Architecture - Labs
## Technological University of the Shannon

![TUS](https://img.shields.io/badge/TUS-2026-black?style=flat-square&logo=data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+CjwhLS0gQ3JlYXRlZCB3aXRoIElua3NjYXBlIChodHRwOi8vd3d3Lmlua3NjYXBlLm9yZy8pIC0tPgoKPHN2ZwogICB3aWR0aD0iMTU3LjU1OTM2bW0iCiAgIGhlaWdodD0iMjA1LjE3MTE2bW0iCiAgIHZpZXdCb3g9IjAgMCAxNTcuNTU5MzYgMjA1LjE3MTE2IgogICB2ZXJzaW9uPSIxLjEiCiAgIGlkPSJzdmcxIgogICB4bWw6c3BhY2U9InByZXNlcnZlIgogICB4bWxuczppbmtzY2FwZT0iaHR0cDovL3d3dy5pbmtzY2FwZS5vcmcvbmFtZXNwYWNlcy9pbmtzY2FwZSIKICAgeG1sbnM6c29kaXBvZGk9Imh0dHA6Ly9zb2RpcG9kaS5zb3VyY2Vmb3JnZS5uZXQvRFREL3NvZGlwb2RpLTAuZHRkIgogICB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciCiAgIHhtbG5zOnN2Zz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciPjxzb2RpcG9kaTpuYW1lZHZpZXcKICAgICBpZD0ibmFtZWR2aWV3MSIKICAgICBwYWdlY29sb3I9IiNmZmZmZmYiCiAgICAgYm9yZGVyY29sb3I9IiMwMDAwMDAiCiAgICAgYm9yZGVyb3BhY2l0eT0iMC4yNSIKICAgICBpbmtzY2FwZTpzaG93cGFnZXNoYWRvdz0iMiIKICAgICBpbmtzY2FwZTpwYWdlb3BhY2l0eT0iMC4wIgogICAgIGlua3NjYXBlOnBhZ2VjaGVja2VyYm9hcmQ9IjAiCiAgICAgaW5rc2NhcGU6ZGVza2NvbG9yPSIjZDFkMWQxIgogICAgIGlua3NjYXBlOmRvY3VtZW50LXVuaXRzPSJtbSI+PGlua3NjYXBlOnBhZ2UKICAgICAgIHg9IjAiCiAgICAgICB5PSIwIgogICAgICAgd2lkdGg9IjE1Ny41NTkzNiIKICAgICAgIGhlaWdodD0iMjA1LjE3MTE2IgogICAgICAgaWQ9InBhZ2UyIgogICAgICAgbWFyZ2luPSIwIgogICAgICAgYmxlZWQ9IjAiIC8+PC9zb2RpcG9kaTpuYW1lZHZpZXc+PGRlZnMKICAgICBpZD0iZGVmczEiPjxzdHlsZQogICAgICAgaWQ9InN0eWxlMSI+LmNscy0xe2ZpbGw6I2EzOTQ2MTt9PC9zdHlsZT48c3R5bGUKICAgICAgIGlkPSJzdHlsZTEtNCI+LmNscy0xe2ZpbGw6I2EzOTQ2MTt9PC9zdHlsZT48L2RlZnM+PGcKICAgICBpbmtzY2FwZTpsYWJlbD0iTGF5ZXIgMSIKICAgICBpbmtzY2FwZTpncm91cG1vZGU9ImxheWVyIgogICAgIGlkPSJsYXllcjEiCiAgICAgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoMjA4LjE2MDkzLDQ4Ljg3NTE2MikiPjxnCiAgICAgICBpZD0iQXJ0d29yayIKICAgICAgIHRyYW5zZm9ybT0ibWF0cml4KDAuMjY0NTgzMzMsMCwwLDAuMjY0NTgzMzMsLTIwOC4xNjA5NCwtNDguODc1MTU4KSI+PHBhdGgKICAgICAgICAgY2xhc3M9ImNscy0xIgogICAgICAgICBkPSJNIDU5NS40OCwwIEggNDc2LjM4IFYgNTguNTIgSCAzNTcuMyBWIDAgSCAyMzguMiBWIDU4LjUyIEggMTE5LjEgViAwIEggMCB2IDM1Ny4yOSBoIDExOS4xIGEgMTc4LjY0LDE3OC42NCAwIDEgMSAzNTcuMjgsMCBoIDExOS4wNiB6IgogICAgICAgICBpZD0icGF0aDEiIC8+PHJlY3QKICAgICAgICAgY2xhc3M9ImNscy0xIgogICAgICAgICB4PSI0NzYuMzgiCiAgICAgICAgIHk9IjcxNS45MDAwMiIKICAgICAgICAgd2lkdGg9IjExOS4xIgogICAgICAgICBoZWlnaHQ9IjU5LjU0OTk5OSIKICAgICAgICAgaWQ9InJlY3QxIiAvPjxyZWN0CiAgICAgICAgIGNsYXNzPSJjbHMtMSIKICAgICAgICAgeT0iNzE1LjkwMDAyIgogICAgICAgICB3aWR0aD0iMTE5LjEiCiAgICAgICAgIGhlaWdodD0iNTkuNTQ5OTk5IgogICAgICAgICBpZD0icmVjdDIiCiAgICAgICAgIHg9IjAiIC8+PHJlY3QKICAgICAgICAgY2xhc3M9ImNscy0xIgogICAgICAgICB5PSI1OTYuNzk5OTkiCiAgICAgICAgIHdpZHRoPSIxMTkuMSIKICAgICAgICAgaGVpZ2h0PSI1OS41NDk5OTkiCiAgICAgICAgIGlkPSJyZWN0MyIKICAgICAgICAgeD0iMCIgLz48cmVjdAogICAgICAgICBjbGFzcz0iY2xzLTEiCiAgICAgICAgIHg9IjQ3Ni4zOTk5OSIKICAgICAgICAgeT0iNTk2Ljc5OTk5IgogICAgICAgICB3aWR0aD0iMTE5LjEiCiAgICAgICAgIGhlaWdodD0iNTkuNTQ5OTk5IgogICAgICAgICBpZD0icmVjdDQiIC8+PHJlY3QKICAgICAgICAgY2xhc3M9ImNscy0xIgogICAgICAgICB4PSIxMTkuMSIKICAgICAgICAgeT0iNTM3LjI1IgogICAgICAgICB3aWR0aD0iMzU3LjI5OTk5IgogICAgICAgICBoZWlnaHQ9IjU5LjU0OTk5OSIKICAgICAgICAgaWQ9InJlY3Q1IiAvPjxwb2x5Z29uCiAgICAgICAgIGNsYXNzPSJjbHMtMSIKICAgICAgICAgcG9pbnRzPSI0NzYuMzksNjU2LjM1IDExOS4xLDY1Ni4zNSAxMTkuMSw3MTUuOSAyMzguMiw3MTUuOSAyMzguMiw3NzUuNDUgMzU3LjI5LDc3NS40NSAzNTcuMjksNzE1LjkgNDc2LjM5LDcxNS45ICIKICAgICAgICAgaWQ9InBvbHlnb241IiAvPjxyZWN0CiAgICAgICAgIGNsYXNzPSJjbHMtMSIKICAgICAgICAgeD0iNDc2LjM5OTk5IgogICAgICAgICB5PSI0MTguMTYiCiAgICAgICAgIHdpZHRoPSIxMTkuMSIKICAgICAgICAgaGVpZ2h0PSIxMTkuMSIKICAgICAgICAgaWQ9InJlY3Q2IiAvPjxyZWN0CiAgICAgICAgIGNsYXNzPSJjbHMtMSIKICAgICAgICAgeT0iNDE4LjE2IgogICAgICAgICB3aWR0aD0iMTE5LjEiCiAgICAgICAgIGhlaWdodD0iMTE5LjEiCiAgICAgICAgIGlkPSJyZWN0NyIKICAgICAgICAgeD0iMCIgLz48L2c+PC9nPjwvc3ZnPgo=)
![Microservices Architecture](https://img.shields.io/badge/Module-Microservices%20Architecture-blue?style=flat-square)
![Springboot Microservice](https://img.shields.io/badge/Topic-Springboot%20Microservice-red?style=flat-square)


![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge\&logo=apache-maven\&logoColor=white)
![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge\&logo=openjdk\&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring\_Boot-3.1.4-6DB33F?style=for-the-badge\&logo=spring-boot\&logoColor=white)
![Material for MkDocs](https://img.shields.io/badge/Material_for_MkDocs-526CFE?style=for-the-badge&logo=materialformkdocs&logoColor=white)

![GitHub repo size](https://img.shields.io/github/repo-size/joeaoregan/TUS-26-MA-Labs?style=flat-square\&color=orange)
![Last Commit](https://img.shields.io/github/last-commit/joeaoregan/TUS-26-MA-Labs?style=flat-square\&color=blue)
![GitHub top language](https://img.shields.io/github/languages/top/joeaoregan/TUS-26-MA-Labs)
![Stars](https://img.shields.io/github/stars/joeaoregan/TUS-26-MA-Labs?style=social)

---

### Docs

[![MkDocs](https://img.shields.io/badge/MkDocs-009485?style=for-the-badge&logo=mkdocs&logoColor=white)](https://joeaoregan.github.io/TUS-26-MA-Labs/) [Documentation on GitHub Pages](https://joeaoregan.github.io/TUS-26-MA-Labs/)

### Labs

#### RESTful APIs

- [Lab#1 Getting started with Springboot – Helloworld Example](https://joeaoregan.github.io/TUS-26-MA-Labs/labs1-7/lab1/)
- [Lab#2 Configuring H2 DB and YAML application.properties](https://joeaoregan.github.io/TUS-26-MA-Labs/labs1-7/lab2/)
- [Lab#3 Building a Rest API to support the creation of a new account and customer details](https://joeaoregan.github.io/TUS-26-MA-Labs/labs1-7/lab3/)
- [Lab#4 Exception Handling –check if customer already exists](https://joeaoregan.github.io/TUS-26-MA-Labs/labs1-7/lab4/)
- [Lab#5 Implementing a READ API that fetches the details based on mobile number](https://joeaoregan.github.io/TUS-26-MA-Labs/labs1-7/lab5/)
- [Lab#6 RESTfulAPI for Updating and Deleting customer accounts](https://joeaoregan.github.io/TUS-26-MA-Labs/labs1-7/lab6/)
- [Lab#7 Exceptions , Data Validations and Audit Columns](https://joeaoregan.github.io/TUS-26-MA-Labs/labs1-7/lab7/)

#### RESTful APIs 2

- [Lab#8 Loans MicroService](https://joeaoregan.github.io/TUS-26-MA-Labs/labs8-9/lab8/)
- [Lab#9 Cards MicroService](https://joeaoregan.github.io/TUS-26-MA-Labs/labs8-9/lab9/)

#### Spring Cloud Config

- [Lab#10 Configuration with Springboot alone](https://joeaoregan.github.io/TUS-26-MA-Labs/labs10-19/lab10/index.md)
- [Lab#11 Configuration with Environment interface](https://joeaoregan.github.io/TUS-26-MA-Labs/labs10-19/lab11/index.md)
- [Lab#12 Configuration with @ConfigurationProperties](https://joeaoregan.github.io/TUS-26-MA-Labs/lab12/index.md)
- [Lab#13 Springboot Profiles](https://joeaoregan.github.io/TUS-26-MA-Labs/lab13/index.md)
- [Lab#14 Activating Springboot Profiles](https://joeaoregan.github.io/TUS-26-MA-Labs/lab14/index.md)

#### API

- [API Overview](https://joeaoregan.github.io/TUS-26-MA-Labs/api/)
- [Accounts API](https://joeaoregan.github.io/TUS-26-MA-Labs/api/accounts/)
- [Loans API](https://joeaoregan.github.io/TUS-26-MA-Labs/api/loans/)
- [Cards API](https://joeaoregan.github.io/TUS-26-MA-Labs/api/cards/)

---

### Setup 

#### Virtual Environment

```bash
python -m venv venv
.\venv\Scripts\Activate.ps1
```

#### Install Material for MkDocs

```bash
pip install mkdocs-material
```
or
```bash
python -m pip install mkdocs-material
```

Create a new site in the current folder:

```bash
python -m mkdocs new .
```

### Spring Initializr

<https://start.spring.io/>
