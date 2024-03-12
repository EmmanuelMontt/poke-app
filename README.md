# JFrog Artifactory

Poke Montty utiliza JFrog Artifactory para su desarrollo. Asi que instalaremos una version open source disponible en docker (de manera local) para compilar la aplicacion.

Nos basaremos en este tutorial oficial: https://jfrog.com/help/r/jfrog-installation-setup-documentation/install-artifactory-single-node-with-docker

## Install Docker

Necesitaremos instalar docker.

* Instalar en windows https://www.docker.com/products/docker-desktop/
* Instalar en Linux https://docs.docker.com/desktop/install/linux-install/

## Download Jfrog Image

Descarga la imagen open source de Jfrog

```sh
docker pull docker.bintray.io/jfrog/artifactory-oss
docker pull releases-docker.jfrog.io/jfrog/artifactory-oss:latest
```

## Docker Volumen

Crearemos un docker volume para guardar los datos.

```sh
docker volume create poke-montty
```

## Docker Container

Crearemos nuestro contenedor con el volume creado y los puertos 8081 y 8082

```sh
 docker run --name poke-montty-artifactory -v poke-montty:/var/opt/jfrog/artifactory -d -p 8081:8081 -p 8082:8082 releases-docker.jfrog.io/jfrog/artifactory-oss:latest
```

Checamos que el contenedor este corriendo correctamente

```sh
 docker ps
```

## Login Jfrog

Si todo esta bien podemos entrara a esta url y poder logear con los accesos por default

[Jfrog Login](http://localhost:8082/ui/)

```sh
http://localhost:8082/ui/
```

* User: admin, Password: password

## Change Password

Como estamos utilizando una contrasena default por seguridad te pedira cambiarla


Admin Notice: Your Artifactory server is configured with the default admin credentials. It is highly recommended to change the default admin password. You can change the password from the User Management page.

## Create Project

Crearemos un nuevo proyecto llamado

```sh
Poke Montty
```

## Create Repositories

Con la opcion de ** Quick Repository Creation ** crearemos los repos de tipo

```sh
maven
```

con el prefijo

```sh
poke-montty
```

## Create User

Crea un user llamado

```sh
ash
```

## Assign Repos

Asigna los repósitorios creados

```sh
local
remote
virtual
```

al proyecto

## Assign User

Agregar al proyecto Poke Montty al usuario

```sh
ash
```

con el role de

```sh
Project Admin
```

## Create token

Inicia sesion con el usuario ash y obten un token en perfil de usuario en la opcion

```sh
Generate an identity token
```

obtendras un token similar a este

```sh
cmVmdGtuOjAxOjE3NDE3MzkzMDA6dkJLMGN1ZFVld1k3V1RVdjIzZ1JDdUtSWEpW
```