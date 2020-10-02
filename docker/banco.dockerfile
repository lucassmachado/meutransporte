FROM mysql:5.7
EXPOSE 3306 
COPY ./docker/db/ /docker-entrypoint-initdb.d/