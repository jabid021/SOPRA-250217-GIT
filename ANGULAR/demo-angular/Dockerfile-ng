FROM nginx:latest

# COPY ./dist/demo-angular/browser/ /usr/share/nginx/html/

RUN apt update
RUN apt install npm -y

WORKDIR /app

# Copier les fichiers package.json & package-lock.json
COPY package*.json .

# Avec ces fichiers, on peut lancer l'installation des dépendances
RUN npm install

# On copie la suite : les sources et la config etc.
COPY . .

# Builder l'application
RUN ./node_modules/.bin/ng build

RUN cp ./dist/demo-angular/browser/* /usr/share/nginx/html/

EXPOSE 80
