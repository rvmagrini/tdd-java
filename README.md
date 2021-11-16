# Basic Testing Tutorial for Java
## Unit Testing, Integration Testing, JUnit5 Framework, Assertions with AssertJ and Mocking with Java Mockito

## Process:

### 1: [INITIALIZING]
TASKS:
- [1.1] Create Spring Boot Project
- [1.2] Create Entity
- [1.3] Create Repository, Service and Controller Units

### 2: [TESTING REPOSITORY]
#### Important Annotations: @DataJpaTest, @Autowired
TASKS:
- [2.1] Configure In-Memory Database for Testing
- [2.2] Test when Email exists and when it does not exist

### 3: [TESTING SERVICE]
#### Important Annotations: @ExtendWith(MockitoExtension.class), @Mock
TASKS:
- [3.1] Set up Service Testing (Mock, Autocloseable)
- [3.2] Refactor Autocloseable and test if Service can getAllStudents
- [3.3] Test if addStudent Service passes expected argument to save Repository
- [3.4] Test if addStudent Service throws expected Exception when Email is already taken and if Repository never saving anything in this condition
- [3.5] Test if deleteStudent Service can call deleteById Repository
- [3.6] Test if deleteStudent Service throws expected Exception when id was not found and if Repository is never deleting anything in this condition

