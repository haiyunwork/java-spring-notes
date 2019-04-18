## Maven Surefire Plugin

### Using JUnit Categories

ref: https://maven.apache.org/surefire/maven-surefire-plugin/examples/junit.html

JUnit 4.8 introduced the notion of Categories. You can use JUnit categories by using the groups parameter.

```xml
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>3.0.0-M3</version>
        <configuration>
            <groups>com.mycompany.SlowTests</groups>
        </configuration>
    </plugin>
```

This will execute only those tests annotated with the @Category(com.mycompany.SlowTests.class) annotation

```java
 public interface SlowTests{}
```

```java
    public class AppTest {
      @Test
      @Category(com.mycompany.SlowTests.class)
      public void testSlow() {
        System.out.println("slow");
      }
 
      @Test
      @Category(com.mycompany.SlowerTests.class)
      public void testSlower() {
        System.out.println("slower");
      }
 
      @Test
      @Category(com.cmycompany.FastTests.class)
      public void testSlow() {
        System.out.println("fast");
      }
    }
```

The @Category annotation can also be applied at class-level.

Multiple categories can be specified by comma-delimiting them in the groups parameter in which case tests annotated with any of the categories will be executed.