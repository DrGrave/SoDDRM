# HOW TO CONFIGURE ENVIRONMENT

To run application you should install jdk 1.8 or higher, gradle 4.3.1, nodejs, docker and docker-compose.

_CREATE ISOGJ DOCKER SUBNET_

```bash
docker network create --subnet=172.2.2.0/16 isogj_subnet
```

_ENVIRONMENTAL VARIABLES_

REGISTRY_HOST=172.2.2.2\
MYSQL_HOST=172.2.2.1


If you use windows you should 
use docker machine ip instead of subnet hosts.

# RUN APPLICATION

To run all services
```bash
gradle build -x test
docker-compose build
docker-compose up -d
```

To run certain services
```bash
gradle build -x test
docker-compose build
docker-compose up -d service_1 service_2...
```
