# Logstash Demo

Ceci est une démo permettant de tester une configuration rapide de Logstash sur des logs Apache.

## Prérequis
* Un server Apache (ou LAMP ou XAMPP)
* La stack ELK, si elle n'est pas installée, vous trouverez les instrcutions ici : <https://github.com/cwoodrow/elasticsearch-workshop>
* Télécharger la dernière version de gatling <https://gatling.io/download/>

## Logs Apache
Dans un premier temps, nous allons parser les logs d'un serveur Apache.

### Web app

Ajouter l'application **ma-zone** à votre serveur web, cette opération peut être effectuée en créant un lien symbolique :

    cd <le répertoire htdocs de votre installation de Apache>
    ln -s <répertoire du projet>/apache ma-zone

Vérifiez que vous disposez bien de l'accès à l'URL (exactement!) <http://localhost/ma-zone/>

### Gatling

Nous allons à présent lancer Gatling afin de créer des logs dans Apache :

    cd <répertoire du projet>/user-files
    ${GATLING_HOME}/bin/gatling.sh -df data/ -sf simulations/ -s mazone

### Logstash

Vous pouvez à présent parser les logs à l'aide de **Logstash**.