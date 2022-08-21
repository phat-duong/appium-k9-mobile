# appium-k9-mobile

##command to build
```
mvn clean package -DskipTests=true
```

##command to run
* Remove all allure-re* folders
* Execute command
```
java -Dplatform=android/ios -Dremote=true/false -jar targer/appium-k9-mobile-1.0-SNAPSHOT-fat-tests.jar
```
