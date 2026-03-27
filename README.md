# 08 Build Automation & CI/CD with Jenkins
repository to show the complete automated CI pipeline with Jenkins

### Run Jenkins Server
- virtual machine on Digital ocean platform having at least 4GB memory is created. Firewall has to be configured to allow access through the port 8080 where Jenkins will be running.
- *apt get* updates the package managent tool APT
- *apt install docker.io* - installs docker on virtual machine 
- **Jenkins** can be run as a docker container: 
    *docker run -p 8080:8080 -p 50000:50000 -d \
    -v jenkins_home:/var/jenkins_home jenkins/jenkins:lts*
    Inital password for jenkins server is to be found in `/var/jenkins_home/secrets` in docker container. 
- 

### Freestyle Job in Jenkins
    `Plugins` must be installed to be accessible in `Tools`.
    `Tools` can be used to define build steps in configuration of the Jenkins job. 
    Jenkins job is able to execute shell commands as a single build step - command and tools (e.g. node, npm, docker) available inside the container can be referenced. 

### Install build tool NPM in Jenkins Container
- Login docker container as root user: *docker exec -u 0 -it <container_id> bash*
- on Nodesource `https://deb.nodesource.com/` - debian binaries for NodeJS can be downloaded. on `https://github.com/nodesource/distributions` instructions how to iinstall binaries can be found: 
*apt update*
*apt install curl*
*curl -fsSL https://deb.nodesource.com/setup_23.x -o nodesource_setup.sh*
*bash nodesource_setup.sh*
*apt install nodejs -y*

### Docker in Jenkins
- docker runtime file from virtual machine can be attached to a container as a new volume:

*docker run -p 8080:8080 -p 50000:50000 -d*
 *-v jenkins_home:/var/jenkins_home*
 *-v /var/run/docker.sock:/var/run/docker.sock jenkins/jenkins:lts*

- to execute docker command from jenkins container:
    fetch latest version of docker:
 *curl https://get.docker.com/ > dockerinstall && chmod 777 dockerinstall && ./dockerinstall*

- after login as root user the permissions on `/var/run/docker.sock` have to be changed to read-write for all.
- after login as non-root user the docker command can be run
- docker can be used in any build as any other linux command in Jenkins

### Push docker image to private repository in Jenkins Build
- docker hub private repository has to be created 
- docker hub private repository credentials must be saved in Jenkins 
- in Jenkins Build - Environment - USERNAME and PASSWORD variable has to be defined as a secret text. These variables can be referenced in the shell command for *docker build* and *docker push*

## Push docker image to Nexus Repository
- insecure registry of Nexus must be specified inside `/etc/docker/daemon.json` file on Jenkins server
- docker container has to be restart to load insecure registry
- permissions on `/var/run/docker.sock` file has to be double checked. 
- build command inside Jenkins job has to be changed - nexus repository IP and port has to be part of the image name. Target repository for *docker push* command has to be updated. 