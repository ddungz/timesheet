# Installation

### Eclipse
- Download [Eclipse 2019.12](https://www.eclipse.org/downloads/packages/release/2019-12/r/eclipse-ide-enterprise-java-developers)
- Open eclipse and go to Help > Eclipse Marketplace, search for "spring tool suite" and install the latest.

### Java JDK
- Download [JDK 11.0.6](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html) or [OpenJDK 11](https://jdk.java.net/java-se-ri/11)
- Add JAVA_HOME="C:\Program Files\Java\jdk-11.0.6" to System variable path.

### Lombok
- Download [plugin](https://projectlombok.org/download)
- Execute command: `java -jar lombok.jar` will install plugin into selected eclipse
- Restart eclipse.

### Setup
Import project
- Right click to project name > Properties > Java Build Path > Libraries.
- Click on Modulepath > Add Library... > JRE System Library > Execution Environment > select JDK 11 > OK.
- Make sure Java Compiler is using JDK 11 and Window > Preferences > Java > Installed JREs > Execution Environments > JavaSE-11 is checked.

Fix eclipse Missing tools.jar when launching STS application error
- Close eclipse, open eclipse.ini and add the following in line of before -vmargs
    ```
    -vm
    C:\Program Files\Java\jdk-11.0.6\bin\javaw.exe
    ```

For Package Presentation style
- Select project > Ctrl+F10 > Package Presentation

We are using spring-boot-devtools to auto reload changes without restart. When using IntelliJ,
following [these methods](https://attacomsian.com/blog/spring-boot-auto-reload-thymeleaf-templates) to fix it if it doesn't.



# Getting started

Change package name to actual name for:
- config package
- Mybatis config


### Running
> ./mvnw spring-boot:run

### Debugging
> ./mvnw spring-boot:run -Drun.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8001"

### Kill running port (optional)
> netstat -ano | findstr :PORT_NUMBER

 TCP         0.0.0.0:8080           0.0.0.0:0              LISTENING       23328
> taskkill /PID 23328 /F

