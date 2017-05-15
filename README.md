# TODO-EE
Java EE todo application with gradle build. The project is not dependent on IDE for development or deployment.

## Requirements

1. Glassfish server
2. Postgresql
3. Gradle

## Set up

Update the `todo-ear/gradle.build` with correct variable values. 

1. domain: glassfish domain to use
2. asadminBin: Path to where your asadmin command is. Usually in ${glassfish_home}/glassfish/bin.

Also update the path to `asadmin` in `scripts/createresource`.

1. ASADMIN: same as `asadminBin` set up perviously
2. Update database connection variables if necessary.

Make sure that the database `todo` is created and postgres is running before continuing with the setup.

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
2. Use configuration file to store configuration variables from `build.gradle` and `createresources` script.
3. Implement same api using JAX-WS
4. Implement same application for both JAX-WS and JAX-RS that can be accessed via different links.
5. Add token based authentication for JAX-RS



