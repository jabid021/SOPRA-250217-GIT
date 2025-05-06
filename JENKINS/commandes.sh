# Création d'un container Jenkins en version LTS JDK 21, avec le binding de notre Docker
docker run -d --name jenkins -p 8085:8080 -v /var/run/docker.sock:/var/run/docker.sock jenkins/jenkins:lts-jdk21

# Ce container a deux utilisateurs : "jenkins" et "root". "jenkins" n'a pas les droits superuser, donc on va se connecter en "root" pour les commandes système
docker exec -it -u root jenkins bash

# On va y installer la commande Docker, qui utilisera le docker.sock de notre machine, grâce au binding de volume qu'on a fait
apt update
apt install -y docker.io

# Pour vérifier que ça fonctionne bien, on a la même liste de containers que sur notre propre ordinateur
docker ps

# On vérifie les droits sur docker.sock
ls -la /var/run/docker.sock

# On change le groupe du fichier docker.sock
chgrp docker /var/run/docker.sock

# On vérifie que le groupe a bien changé en "docker"
ls -la /var/run/docker.sock

# On affecte l'utilisateur "jenkins" au groupe "docker"
usermod -aG docker jenkins

# Ctrl+D pour se déconnecter, et relancer une nouvelle connexion au container avec l'utilisateur "jenkins"
docker exec -it jenkins bash

# On vérifie que Docker fonctionne
docker ps

# On génère une nouvelle clé de type ED25519
ssh-keygen -t ed25519

# On scan le SSH du domaine github.com pour récupérer une clé publique et s'assurer que ce domaine est OK et sécurisé
# > Et la redirection de la sortie de la commande ssh-keyscan (>>) vers le fichier "known_hosts" permet de "sauvegarder" le domaine github.com comme on domaine connu et valide
ssh-keyscan github.com >> ~/.ssh/known_hosts

# On récupère la clé publique pour l'ajouter à notre compte Github
cat ~/.ssh/id_ed25519.pub

# On récupère la clé privée pour l'ajouter dans les Credentials de Jenkins
cat ~/.ssh/id_ed25519

# On peut vérifier si la connexion SSH est OK avec github.com
ssh git@github.com

# Pour récupérer le mot de passe admin de Jenkins
cat /var/jenkins_home/secrets/initialAdminPassword
