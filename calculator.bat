@echo off
mode con: cols=80 lines=40

javac -d bin src/App.java src/components/MrCalculator.java src/components/Display.java src/components/OperationType.java
jar cfe mr-calculator.jar App -C bin .
java -jar mr-calculator.jar
