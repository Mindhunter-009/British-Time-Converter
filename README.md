# British-Time-Converter

Small Java/Maven project that converts times to British spoken form (e.g. `12:00` → `noon`, `07:30` → `half past seven`).

Repository layout
- Project root: `British-Time-Converter`
- Main sources: `src/main/java/org/example/`
  - `TimeToSpeechConverter.java` (core converter)
  - `BritishTimeApp.java` (optional CLI `main` entry)
- Tests: `src/test/java/org/example/TimeToSpeechConverterTest.java`

Prerequisites (Windows)
- Java 17 JDK installed and `JAVA_HOME` set
- Maven 3.6+ installed and on `PATH`
- IntelliJ IDEA (optional)

Build
1. Open PowerShell or CMD and change to project root: cd C:\Your File Path\British-Time-Converter
2. Build the project: mvn clean package

Run tests
- Run all unit tests: mvn test
- IntelliJ:
  - Open the project and run tests from the `test` Option in Test File.

Run the application
- From IntelliJ:
  - Run the `org.example.BritishTimeApp` main . Configure program arguments if needed.
- From command line (after `mvn clean package`):
  - Interactive mode (reads `HH:mm` from stdin):
    ```
    java -cp target\classes org.example.BritishTimeApp
    ```
    Then type a time like:
    ```
    12:00
    ```
  - Non-interactive example:
    ```
    echo 06:32 | java -cp target\classes org.example.BritishTimeApp
    ```

Example CLI outputs
- `00:00` → `midnight`
- `12:00` → `noon` 
- `01:00` → `one o'clock`
- `02:05` → `five past two`
- `06:32` → `six thirty-two`
- `07:30` → `half past seven`
- `11:55` → `five to twelve`

Notes on expected behavior
- Handles special cases: `midnight` (`00:00`) and `noon` (`12:00`).
  
