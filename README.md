# TODO-EE
Java EE todo application with gradle build. The project is not dependent on IDE for development or deployment.

## Requirements

1. Glassfish server
2. Java derby
3. Gradle

## Set up

Update the `gradle.build` with correct variable values.

1. dbhome: Path of derby database. `todo` database is expected with password and username `todo`.
2. domain: glassfish domain to use
3. asadminBin: Path to where your asadmin command is. Usually in ${glassfish_home}/glassfish/bin.

```
$ git clone https://github.com/adikari/todo-ee.git
$ cd todo-ee
$ gradle startServer
$ gradle flywayMigrate
$ gradle run -t
```
Assuming everything went successfully, you can go to http://localhost:8080/todo-rest/ to access the site.

## Note
In order for login to work, you will need to create `jdbcRealm` that uses `APPUSER` table in the database for authentication. In order to create the realm you will need to create `jdbcResource` and `jdbc connection pool`.

I will add instruction for this later.



