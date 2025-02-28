# Requeriments

The following repository was made with the help with `WSL2 debian 12 (bookworm)`, `docker` and `Visual Studio Code` with the `Java extensions by Red Hat` installed.

### Java JDK
Version: 17.0.14

Installed in host machine, not docker.

### Database
MySQL

Be sure that docker-stack contains data.sql inside `docker-stack/mysql/data/data.sql`. This file contains a dump of the data. (Only the schema of the database. No data.).

### Docker
Installed in host machine, not wsl2. Be sure that wsl2 integration is enabled inside docker desktop settings.

## Install WSL2 in Windows
1) Open a powershell terminal and run

```powershell
> wsl --install -d Debian
```

2) Restart your device, then open Debian (You can find it in windows search bar by typing Debian or starting in a powershell terminal executing `wsl --distribution Debian`) and install the necessary packages (jdk-17 & maven). Also we need to install wget and curl to let vscode install the server side of `wsl` in wsl2.

```bash
$ sudo apt update
$ sudo apt install openjdk-17-jdk maven curl wget
```

## How to make this thing work
1) Open this project with wsl2, you can open a Debian terminal and navigate with cd to the local repository. Then execute 

```bash
$ code .
```
- This will open vscode with `wsl`. 
- NOTE: If this is the first time your opening vscode in wsl, vscode will download some packages to let vscode can connect to wsl, that´s the reason why you need wget.


2) Once the repo is open in vscode, be sure to be in the root of the project, then, navigate to docker stack in terminal with 

```bash
$ cd docker-stack
```

3) We have to run mysql, execute the following command and wait until it finishes

- NOTE: If this is the first time you're using docker or using mysql with docker, it will download the image, so it could take a while

- NOTE 2: The database schema is inside `docker-stack/mysql/data/` Docker will automatically read the data and execute the sql.

```bash
$ docker compose up -d
```

4) Once the containers are up, you'll need to go one level up with

```bash
$ cd ../
```

5) Now, you have to install the dependencies with maven, so first go inside `product-store` directory with
```bash
$ cd productstore
```

## Run the project
They're two ways to run the project, using vscode or using the terminal

### Using VsCode with the java extensions installed
1) First, be sure to have the `Language Support for Java(TM) by Red Hat` extension, you can download in the `Extensions: marketplace` section inside vscode.

2) In vscode go to the following file

```
productstore/src/main/java/edu/lasallebajio/productstore/ProductStoreApplication.java
```
- This is the main class of the project

3) Then, press the play button in the top right corner in visual studio to run the service, you can run it normal or in debug mode.

### Using terminal 😈
1) Be sure that you're located in the following directory `productstore` where the pom.xml file is.

2) Run

```bash
$ mvn spring-boot:run
```

3) See? It's easier. Just use terminal.

## Stop the project
To stop the project just press the stop button if you're using vscode tools or just send a `Ctrl + C` in the terminal, for both methods.

Then stop the container, but...

**ATTENTION**

They're many ways to stop a container, preserving data or deleting completely.

First go inside `docker-stack` using cd. Then choose one of the following options...

### Preserving data
If you want to preserve the data, just run
```bash
$ docker compose down
```

This will stop the container preserving the volume.

### Deleting data
If you want to delete the data (Database), run the following command
```bash
$ docker compose down -v
```

This will stop the container and deleting the volumes associated or mentioned in the `docker-compose.yml` file.


# Important notes!!!

## pom.xml
This file contains the info of your dependencies and some configurations, like the `tests`. The tests are disabled in this project, if you want to enable it just change this line

```
<skipTests>true</skipTests>
```

to

```
<skipTests>false</skipTests>
```

## application.properties
This file contains some spring boot and database configurations, like the port of the spring application or the database one, the project name, the database name, user, password, etc.

There's one configuration that allows hibernate update the database, create tables, etc. this is `spring.jpa.hibernate.ddl-auto` by default is update, this means that hibernate can create new tables automatically, drop them, etc. without deleting the data. This is helpful while developing, there are other values that you can check in hibernate doc or stackoverflow or chatgpt.

## docker-compose.yml
This file is for the docker configuration, in this case only contains the image and container configuration for mysql. You can consult the password for the database here.
P.D.: I know it's better to use a `.env` file, but this is a simple project, go ahead if you want to integrate a `.env`.

## About the repo...
I use `main` as prod branch, `develop` as working branch.
If you want to implement a feature, fix, etc. just create a new branch that comes from `develop` using the prefix `feature/` or `fix` and separating words by `-` symbol.

Example: 
- `feature/new-endpoint`
- `fix/readme-file`

#
# Final note

And, that's it! Now you're running a Spring Boot Application. Congrats and good luck!

```bash
 ____________________________________
< By Alonso González-Leal (@agopdev) >
 ------------------------------------
        \   ^__^
         \  (oo)\_______
            (__)\       )\/\
                ||----w |
                ||     ||

# Go and check my other repos!

```