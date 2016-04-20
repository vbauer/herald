
# Herald

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Herald-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/2042)
[![Build Status](https://travis-ci.org/vbauer/herald.svg)](https://travis-ci.org/vbauer/herald)
[![Coverage Status](https://coveralls.io/repos/vbauer/herald/badge.svg?branch=master)](https://coveralls.io/r/vbauer/herald?branch=master)
[![Dependency Status](https://www.versioneye.com/user/projects/563d05224d415e001e0000ef/badge.svg?style=flat)](https://www.versioneye.com/user/projects/563d05224d415e001e0000ef)
[![Maven](https://img.shields.io/github/tag/vbauer/herald.svg?label=maven)](https://jitpack.io/#vbauer/herald)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/10aa5200922f4850a3ea21e8fe81ecd9)](https://www.codacy.com/app/bauer-vlad/herald)

<img align="right" style="margin-left: 15px" width="280" height="400" src="misc/white-rabbit.png">

> "Why, sometimes I've believed as many as six impossible things before breakfast." - Lewis Carroll, Alice in Wonderland.

**Herald** provides a very simple way to initialize logger objects and does all magic for you.
You can annotate any field of some class with a `@Log` annotation to let Herald inject suitable logger in this field. 
It does not matter whether it is a static field or not.

Just forget about this code:
```java
private static final Logger LOGGER =
    LoggerFactory.getLogger(Foo.class);
```

Write less code, use short form:
```java
@Log
private Logger logger;
```

**Online documentation:**

The last version of documentation for this project is available here:

* [Maven site](https://vbauer.github.io/herald)
* [Javadoc](https://vbauer.github.io/herald/apidocs)


## Main features

* Ready-To-Use solution
* Small library size with zero dependencies
* Compact and very simple API
* Compatible with:
    * Pure Java SE
    * [Spring Framework](https://spring.io)
        * [Spring Boot](http://projects.spring.io/spring-boot/)
    * [Guice](https://github.com/google/guice)
    * [RoboGuice](https://github.com/roboguice/roboguice)
    * [Android Platform](http://developer.android.com)


## Supported logging frameworks

* [JavaTM 2 platform's core logging framework](http://docs.oracle.com/javase/7/docs/api/java/util/logging/package-summary.html)
* [Apache Commons Logging](http://commons.apache.org/proper/commons-logging)
* [Simple Logging Facade for Java (SLF4J)](http://www.slf4j.org)
* [SLF4J Extended logger](http://www.slf4j.org/extensions.html#extended_logger)
* [Logback](http://logback.qos.ch)
* [Apache Log4j](https://logging.apache.org/log4j/1.2/)
* [Apache Log4j 2](http://logging.apache.org/log4j/2.x/)
* [JBoss Logging](http://docs.jboss.org/jbosslogging/latest/org/jboss/logging/Logger.html)
* [Syslog4j](http://syslog4j.org)
* [Syslog4j fork](https://github.com/Graylog2/syslog4j-graylog2) from [Graylog](https://www.graylog.org)
* [Fluent Logger for Java](https://github.com/fluent/fluent-logger-java)
* [Play Framework Logging API](https://www.playframework.com/documentation/2.4.x/JavaLogging)

It is also possible to add other logging frameworks:

* Create new class in your project, it should implement interface `com.github.vbauer.herald.logger.LogFactory`.
  Add all necessary logic about logger creation in this class.
* Create `ServiceLoader`'s file in your project: "META-INF/services/com.github.vbauer.herald.logger.LogFactory".
* Add full class name of your new extension in this file.

That's all!


## Setup

Maven:
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>

<dependency>
    <groupId>com.github.vbauer</groupId>
    <artifactId>herald</artifactId>
    <version>1.2.1</version>
</dependency>
```

Gradle:
```groovy
repositories {
    maven {
        url "https://jitpack.io"
    }
}

dependencies {
    compile 'com.github.vbauer:herald:1.2.1'
}
```

## Configuration

### Java configuration

The project is integrated with Spring & Guice frameworks, but can be used without it:
```java
LoggerInjector.inject(bean);

// or even using varargs:
LoggerInjector.inject(bean1, bean2, bean3);
```

As you can see, it is unnecessary to do some specific configuration when you use it in Java without IOC container.  

### Android configuration

You need to create base class for your component (ex: Activity) and call `LoggerInjector.inject`:

```java
public class BaseActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoggerInjector.inject(this);
    }
}
```

### Guice / RoboGuice configuration

**Herald** contains specific Guice module to support `@Log` annotation (`com.github.vbauer.herald.ext.guice.LogModule`):

```java
final Injector injector = Guice.createInjector(new LogModule());
```

Now, all your beans will be processed with LoggerInjector and logger fields will be initialized if necessary.

### Spring configuration

#### Java based configuration

You need to configure only one `BeanPostProcessor`:

```java
@Configuration
public class AppContext {

    @Bean
    public LogBeanPostProcessor logBeanPostProcessor() {
        return new LogBeanPostProcessor();
    }

}
```

#### XML Schema-based configuration

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean class="com.github.vbauer.herald.ext.spring.LogBeanPostProcessor" />

</beans>
```

#### Spring Boot support

Herald has out of the box integration with Spring Boot. You do not need to define `LogBeanPostProcessor` in your application context.
Spring Boot [auto-configuration](https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-auto-configuration.html) attempts to automatically configure your Spring application based on the jar dependencies that you have added.

See [LogAutoConfiguration](src/main/java/com/github/vbauer/herald/ext/spring/LogAutoConfiguration.java) for more details.


## @Log annotation

You can use `@Log` annotation in 2 ways:

* Put it on class - All suitable logger fields will be injected. Validation check will be switched off, so all undefined logger fields will be skipped.
* Put it on field - It allows you to inject only suitable logger and throws `MissedLogFactoryException` otherwise.

It is also possible to configure logger name using this annotation:

```java
@Log("MyCustomLoggerName")
private Logger logger;
```

If you do not specify it, then class name will be used as logger name.

If you want to specify mandatory for logger instantiation, use `required` parameter (default is `true`).
Use `@Log(required = false)` to make your logger object optional (it could be useful in some rare cases).


## FAQ

* **Q:** How to select protocol for Syslog4j?
    * **A:** Use @Log.name(), default protocol is "udp".
* **Q:** How to configure Syslog4j with Herald?
    * **A:** Use standard Syslog4j API, ex:
    ```java
    final SyslogIF syslog = Syslog.getInstance("udp");
    syslog.getConfig().setHost("192.168.100.1");
    syslog.getConfig().setPort(1514);
    ```


## Development

To build project in strict mode with tests, you can run:

```bash
mvn -P strict clean package
```


## Might also like

* [jconditions](https://github.com/vbauer/jconditions) - Extra conditional annotations for JUnit.
* [jackdaw](https://github.com/vbauer/jackdaw) - Java Annotation Processor which allows to simplify development.
* [houdini](https://github.com/vbauer/houdini) - Type conversion system for Java projects.
* [caesar](https://github.com/vbauer/caesar) - Library that allows to create async beans from sync beans.
* [commons-vfs2-cifs](https://github.com/vbauer/commons-vfs2-cifs) - SMB/CIFS provider for Commons VFS.
* [avconv4java](https://github.com/vbauer/avconv4java) - Java interface to avconv tool.


## License

Copyright 2015 Vladislav Bauer

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

See [LICENSE](LICENSE) file for more details.
