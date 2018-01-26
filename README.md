# gpbl app

Run mysql

```
docker run -it --rm -v $PWD/sql:/docker-entrypoint-initdb.d -p "3306:3306" -e MYSQL_DATABASE=gpbl-app -e MYSQL_RANDOM_ROOT_PASSWORD=yes -e MYSQL_USER=gpbl-app -e MYSQL_PASSWORD=gpbl-app mysql:latest --sql_mode='STRICT_ALL_TABLES,ERROR_FOR_DIVISION_BY_ZERO,PIPES_AS_CONCAT'
```

Add employee_personaldata.csv
```
mkdir src/main/resources/data
cp employee_personaldata src/main/resources/data/
```

Run web app (Windows)
```
> gradlew bootRun
```
