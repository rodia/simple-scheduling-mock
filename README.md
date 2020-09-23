# Simple Scheduling

## Consideration & implementation

The Simple Scheduling has been implemented under DropWizard in order to manage the user request using JSON format. I decided that implementation, because I think is a better approach for RestApi over Java technologies.

Other consideration assumed by me. it's using the Facade pattern to get the services. That approach enables the information for Student and Class. In addition, it's possible to have available the current information on the services class.

The project is under maven.

## Usage

The code is <https://github.com/rodia/simple-scheduling-mock>. You can perform the follow command:

```
git clone git@github.com:rodia/simple-scheduling.git SimpleSchedulingMocked
cd SimpleSchedulingMocked/
```

And then, you need perform the following steps

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/SimpleScheduling-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Usually, I use the IntellIJ IDEA IDE. In addition, I use the HTTPie <https://httpie.org/> for Ubuntu 20.04

### Create/Edit/Delete Student

```
echo '{"studentId": 5, "lastname":"Fernandes", "firstname":"Patricia"}' | http POST localhost:8080/api/v1/student
echo '{"studentId": 5, "lastname":"Fernandes", "firstname":"Patricia"}' | http PUT localhost:8080/api/v1/student
echo '{"studentId": 5, "lastname":"Fernandes", "firstname":"Patricia"}' | http DELETE localhost:8080/api/v1/student
```


### Create/Edit/Delete Class

```
echo '{"code": "5", "title":"Programación funcional", "description":"Curson introductorio de programación funcional"}' | http POST localhost:8080/api/v1/class
echo '{"code": "5", "title":"Programación funcional", "description":"Curson introductorio de programación funcional"}' | http PUT localhost:8080/api/v1/class
echo '{"code": "5", "title":"Programación funcional", "description":"Curson introductorio de programación funcional"}' | http DELETE localhost:8080/api/v1/class
```

### Browse list of all Student

```
http localhost:8080/api/v1/student
```

### Browse list of all Classes

```
http localhost:8080/api/v1/class
```

### View all Students assigned to a Class

```
http localhost:8080/api/v1/assigned/student/1
```

### View all Classes assigned to a Student

```
http localhost:8080/api/v1/assigned/class/1
```

### Search Student/Classes by available fields/associations

```
http localhost:8080/api/v1/find/student/name/Camila
http localhost:8080/api/v1/find/class/title/Calculo
```

## Feedback

Regarding of the validations, DropWizard has many tools to manage the request by user.

I know you mention before you don't need this test using DB, but I have an alternative implementation with this approach <https://github.com/rodia/simple-scheduling>. That implementation is using `sqlite-jdbc-3.32.3.2` driver. Please take a lock at if you like.
