# 08 Build Automation & CI/CD with Jenkins
repository to show the complete automated CI pipeline with Jenkins

- virtual machine on Digital ocean platform having at least 4GB memory is created. Firewall has to be configured to allow access through the port 8080 where Jenkins will be running.
- *apt get* updates the package managent tool APT
- *apt install docker.io* - installs docker on virtual machine 
- **Jenkins** can be run as a docker container: 
    *docker run -p 8080:8080 -p 50000:50000 -d \
    -v jenkins_home:/var/jenkins_home jenkins/jenkins:lts*
    Inital password for jenkins server is to be found in `/var/jenkins_home/secrets` in docker container. 
- named volume `jenkins_home` is created to persist data 

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
*docker run -p 8080:8080 -p 50000:50000 -d \
 -v jenkins_home:/var/jenkins_home \
 -v /var/run/docker.sock:/var/run/docker.sock jenkins/jenkins:lts*

- to execute docker command from jenkins container:
    fetch latest version of docker:
 *curl https://get.docker.com/ > dockerinstall && chmod 777 dockerinstall && ./dockerinstall*
    
- after login as root user the permissions on `/var/run/docker.sock` have to be changed to read-write for all.
- after login as non-root user the docker command can be run
- docker can be used in any build as any other linux command
