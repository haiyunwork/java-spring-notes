## lombok @Builder

ref: https://projectlombok.org/features/Builder

The @Builder annotation produces complex builder APIs for your classes.

@Builder lets you automatically produce the code required to have your class be instantiable with code such as:
Person.builder().name("Adam Savage").city("San Francisco").job("Mythbusters").job("Unchained Reaction").build();

@Builder can be placed on a class, or on a constructor, or on a method. While the "on a class" and "on a constructor" mode are the most common use-case

@Builder can generate so-called 'singular' methods for collection parameters/fields. These take 1 element instead of an entire list, and add the element to the list. For example: Person.builder().job("Mythbusters").job("Unchained Reaction").build(); would result in the List<String> jobs field to have 2 strings in it. To get this behaviour, the field/parameter needs to be annotated with @Singular.

基于已存在对象创建builder的方法：

```java
@Builder(toBuilder=true)
class Foo {
   int x;
   ...
}

Foo f0 = Foo.builder().build();
Foo f1 = f0.toBuilder().x(42).build();
```
