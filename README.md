# TimeAgo
TimeAgo is a simple past time difference calculation library that will return a string with difference of words.


## For Gradle:
Step 1. Add it in your root build.gradle at the end of repositories:
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Step 2. Add the dependency:
```
dependencies {
        implementation 'com.github.mrasif:timeago:v1.0.1'
}
```
### For Maven:
Step 1. Add the JitPack repository to your build file:
```
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>
```
Step 2. Add the dependency:
```
<dependency>
    <groupId>com.github.mrasif</groupId>
    <artifactId>timeago</artifactId>
    <version>v1.0.1</version>
</dependency>
```
### For SBT:
Step 1. Add the JitPack repository to your build.sbt file:
```
resolvers += "jitpack" at "https://jitpack.io"
```
Step 2. Add the dependency:
```
libraryDependencies += "com.github.mrasif" % "timeago" % "v1.0.1"
```
### For Leiningen:
Step 1. Add it in your project.clj at the end of repositories:
```
:repositories [["jitpack" "https://jitpack.io"]]
```
Step 2. Add the dependency:
```
:dependencies [[com.github.mrasif/timeago "v1.0.1"]]
```

### Example
**1. It will calculate difference form current timestamp.**

```java
SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
Date past = format.parse("28/01/2019 17:23:46");
String words=TimeAgo.format(past)
```

**2. It will also calculate difference form current timestamp.**

```java
String words=TimeAgo.format("dd/MM/yyyy hh:mm:ss","28/01/2019 17:23:46")
```

**2. It will calculate difference form another timestamp.**

```java
SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
Date past = format.parse("28/01/2019 17:23:46");
Date now = format.parse("29/02/2020 17:23:46");
String words=TimeAgo.format(past)
```

**1. It will also calculate difference form another timestamp.**

```java
String words=TimeAgo.format("dd/MM/yyyy hh:mm:ss","28/01/2019 17:23:46","29/02/2020 17:23:46")
```

Now you can enjoy this features.

