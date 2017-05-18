# TODO-EE
Java EE todo application with gradle build. The project is not dependent on IDE for development or deployment.

## Requirements

1. [Glassfish server](http://www.oracle.com/technetwork/java/javaee/downloads/index.html)
2. [Postgresql](https://www.postgresql.org/)
3. [Gradle](https://gradle.org/)
4. [JDK 8 or above](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

## Pre-requisite

1. Create config file and glassfish password file

```
    cp config.example config
    cp passwordfile.example passwordfile
```

2. Update the values in the config file appropriately.

  **gfDomain:** glassfish domain to use
  **gfUser:** Username to log in to glassfish as.
  **gfPasswordFile:** Path to password file. Check the password.example

3. Update `Database connection variables` in `scripts/createresource`. Thats the information for glassfish to connect to the database.

4. Make sure that the database `todo` is created and postgres is running.

5. Make sure `asadmin` is in path. Verify this by typing `asadmin --help`. If no command found add that to your ``$PATH.

```
export PATH=$PATH:path_to_glassfish_home/glassfish/bin
```

**Important**: Glassfish doesn't come with postgress by default. You will need:

1. Download the postgres java driver jar from [here](https://jdbc.postgresql.org/download/postgresql-42.1.1.jar).
2. Copy that into `path_to_glassfish_home/glassfish/modules/`.

### First time setup

```
$ git clone https://github.com/adikari/todo-ee.git
$ cd todo-ee
$ ./scripts/createresource
$ gradle startServer
$ gradle flywayMigrate
$ gradle deploy
```

Assuming everything went successfully, you can go to http://localhost:8080/todo-rest/ to access the site. The rest api can be accessed at http://localhost:8080/todo-rest/api/.


There are 2 default users seeded to the database. Password is currently saved as plain text. Check the [migration script](https://github.com/adikari/todo-ee/blob/master/Todo-ejb/src/main/resources/db/migration/V4__Add_Users.sql) for username and password to login.


### Development

Once the initial setup is done, now on you can just use:

```
$ cd path_to_todo-ee
$ gradle startServer && gradle deploy -t
```

On file save, the code is automatically compiled, `ear` is built and deployed to the server. Only need to refresh the browser to see the changes.

## TODO

1. Add browser live reload if web files are changed or added.
2. Use configuration file to store configuration variables from `createresources` script.
3. Implement same api using JAX-WS
4. Implement same application for both JAX-WS and JAX-RS that can be accessed via different links.
5. Add token based authentication for JAX-RS



