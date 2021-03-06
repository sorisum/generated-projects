#!/bin/bash
git checkout master
for release in {106..106}
do
  version=3.0.${release}-SNAPSHOT

  echo producing backend ${version}  
  rm -rf jpa2-backend
  mvn -Dmaven-bootstrap-plugin.interactive=false -Pjj -Dmaven-bootstrap-plugin.defaultBootstrapPackName=pack-backend-jpa com.jaxio.celerio:maven-bootstrap-plugin:${version}:bootstrap
  mv appli jpa2-backend
  cd jpa2-backend
  mvn -Pdb,metadata,gen,jj generate-sources
  cd ..
  cp README.backend jpa2-backend/README

  echo producing jsf2 ${version}  
  rm -rf jsf2-spring-conversation
  mvn -Dmaven-bootstrap-plugin.interactive=false -Pjj -Dmaven-bootstrap-plugin.defaultBootstrapPackName=pack-jsf2-spring-conversation com.jaxio.celerio:maven-bootstrap-plugin:${version}:bootstrap 
  mv appli jsf2-spring-conversation
  cd jsf2-spring-conversation
  mvn -Pdb,metadata,gen,jj generate-sources
  cd ..
  cp README.jsf2 jsf2-spring-conversation/README  

git add . --a 
git commit -m "generated with Celerio v${version} - http://www.springfuse.com/" 
# git tag ${version}
#git checkout master
done;
