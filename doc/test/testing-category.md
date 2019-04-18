## Testing Category

### Unit Test

Tests the smallest unit of functionality, typically a method/function

The code under test should not access Network, Database, File system, or Spin up a thread.

In short, unit tests are as simple as possible, easy to debug, reliable (due to reduced external factors), fast to execute and help to prove that the smallest building blocks of your program function as intended

### Integration Test

Integration Test 测试系统中一个组件的功能接口，验证组件间交互逻辑（为限定测试范围， Mock部分依赖组件）. 

在Integration Test中，被测试的组件接口，可以包含访问 Network, Database, File system，以及多线程。

### End-To-End Test

End-To-End Test 测试一个系统对外提供的功能接口，被测试的系统应该部署运行在（接近生产环境）测试环境。

### refs

1. [stackoverflow: What's the difference between unit, functional, acceptance, and integration tests?](https://stackoverflow.com/questions/4904096/whats-the-difference-between-unit-functional-acceptance-and-integration-test)
1. [Martin Fowler: Testing Strategies in a Microservice Architecture](http://martinfowler.com/articles/microservice-testing/)
  * Unit tests - exercise the smallest pieces of testable software in the application to determine whether they behave as expected.
  * Integration tests - verify the communication paths and interactions between components to detect interface defects.
  * Component tests - limit the scope of the exercised software to a portion of the system under test, manipulating the system through internal code interfaces and using test doubles to isolate the code under test from other components.
  * Contract tests - verify interactions at the boundary of an external service asserting that it meets the contract expected by a consuming service.
  * End-To-End tests - verify that a system meets external requirements and achieves its goals, testing the entire system, from end to end.
1. [Google: Test Sizes](https://testing.googleblog.com/2010/12/test-sizes.html)
