# Requeriments

The following repository was made with the help with `WSL2 debian 12 (bookworm)`, `docker` and `Visual Studio Code` with the `Java extensions by Red Hat` installed.

### Java JDK
Version: 17.0.14

Installed in host machine, not docker.

### Database
MySQL

Be sure that docker-stack container data.sql inside `docker-stack/mysql/data/data.sql`. This file contains a dump of the data.

### Docker
Installed in host machine, not wsl2. Be sure that wsl2 integraion is enabled inside docker desktop settings.

## Install WSL2 in Windows
1) Open a powershell terminal and run

```powershell
> wsl --install -d Debian
```

2) Restart your device, then open Debian (You can find it in windows search bar by typing Debian or starting in a powershell terminal executing `wsl`) and install the necessary packages

```bash
$ sudo apt update
$ sudo apt install openjdk-17-jdk maven
```

## How to make this thing work
1) Open this project with wsl2 and then go to docker stack with 

```bash
$ cd docker-stack
```

2) Run the following command and wait until it finishes

```bash
$ docker compose up -d
```

3) Using VsCode with the java extensions installed, go to

```
productstore-service-java/productstore/src/main/java/edu/lasallebajio/productstore
```

4) Then, press the play button in the top right corner in visual studio to run the service, you can start it as normal or in debug mode.