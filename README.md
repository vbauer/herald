
# Herald [![Build Status](https://travis-ci.org/vbauer/herald.svg)](https://travis-ci.org/vbauer/herald) [![Coverage Status](https://coveralls.io/repos/vbauer/herald/badge.svg?branch=master)](https://coveralls.io/r/vbauer/herald?branch=master) [![Maven](https://img.shields.io/github/tag/vbauer/herald.svg?label=maven)](https://jitpack.io/#vbauer/herald)

<img align="right" style="margin-left: 15px" width="280" height="400" src="misc/white-rabbit.png">

> "Why, sometimes I've believed as many as six impossible things before breakfast." - Lewis Carroll, Alice in Wonderland.

**Herald** provides a very simple [BeanPostProcessor](http://docs.spring.io/spring-framework/docs/2.5.6/api/org/springframework/beans/factory/config/BeanPostProcessor.html) which does all the magic for you. You can annotate any bean field with a `@Log` annotation to let Herald inject suitable logger in this field. It does not matter whether it is a static field or not.

Just forget about this code:
```java
private static final Logger LOGGER = LoggerFactory.getLogger(Foo.class);
```

Write less code, use short form:
```java
@Log
private Logger logger;
```

The project is integrated with Spring framework, but can be used without it:
```java
LoggerInjector.inject(bean);
```


## Supported logging frameworks

* [JavaTM 2 platform's core logging framework](http://docs.oracle.com/javase/7/docs/api/java/util/logging/package-summary.html)
* [Apache Commons Logging](http://commons.apache.org/proper/commons-logging)
* [Simple Logging Facade for Java (SLF4J)](http://www.slf4j.org)
* [SLF4J Extended logger](http://www.slf4j.org/extensions.html#extended_logger)
* [Logback](http://logback.qos.ch)
* [Apache Log4j](https://logging.apache.org/log4j/1.2/)
* [Apache Log4j 2](http://logging.apache.org/log4j/2.x/)

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
    <version>1.0.3</version>
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
    compile 'com.github.vbauer:herald:1.0.3'
}
```


## Spring configuration

### Java based configuration

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

### XML Schema-based configuration

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean class="com.github.vbauer.herald.processor.LogBeanPostProcessor" />

</beans>
```

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


## Might also like

* [houdini](https://github.com/vbauer/houdini) - Type conversion system for Spring framework.
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
