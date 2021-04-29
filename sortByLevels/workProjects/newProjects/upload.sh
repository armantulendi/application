mvn clean package
scp target/withfront-0.0.1-SNAPSHOT.jar user@mars:/home/user/

ssh user@mars<<EOF
pgrep java | xargs kill -9
nohup java -jar withfront-0.0.1-SNAPSHOT.jar>log.txt&
nginx -s reload
EOF
