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
- [3.3] Test if Service pass the right argument to addStudent