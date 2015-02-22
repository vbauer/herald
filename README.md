
# Herald [![Build Status](https://travis-ci.org/vbauer/herald.svg)](https://travis-ci.org/vbauer/herald) [![Coverage Status](https://coveralls.io/repos/vbauer/herald/badge.svg?branch=master)](https://coveralls.io/r/vbauer/herald?branch=master) [![Maven](https://img.shields.io/github/tag/vbauer/herald.svg?label=maven)](https://jitpack.io/#vbauer/herald)


## Supported logging frameworks

* [JavaTM 2 platform's core logging framework](http://docs.oracle.com/javase/7/docs/api/java/util/logging/package-summary.html)
* [Apache Commons Logging](http://commons.apache.org/proper/commons-logging)
* [Simple Logging Facade for Java (SLF4J)](http://www.slf4j.org)
* [Logback](http://logback.qos.ch)
* [Apache Log4j](http://logging.apache.org/log4j)


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
    <version>1.0.0</version>
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
    compile 'com.github.vbauer:herald:1.0.0'
}
```


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
