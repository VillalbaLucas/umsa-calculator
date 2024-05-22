package components;

import java.math.BigDecimal;
import java.util.Scanner;

public class MrCalculator {
    private final Scanner scanIn = new Scanner(System.in);
    private BigDecimal firstArg;
    private BigDecimal secondArg;
    private int option; 
    private Display display = new Display();

    public void powerOn() throws InterruptedException {
        display.printOn();

        do {
            display.printOptions();
            option = scanIn.nextInt();
            operationMenu(option);

        } while (option!=0);
        powerOff();
    }

    private void operationMenu(int option) {
        BigDecimal result;
        display.clean();
        switch (option) {
            case 1:
                display.printLoadArg();
                firstArg = scanIn.nextBigDecimal();
                display.printLoadArg();
                secondArg = scanIn.nextBigDecimal();
                result = firstArg.add(secondArg);
                display.printOperation(firstArg, secondArg, result, OperationType.SUMA);
                break;
            case 2:
                display.printLoadArg();
                firstArg = scanIn.nextBigDecimal();
                display.printLoadArg();
                secondArg = scanIn.nextBigDecimal();
                result = firstArg.subtract(secondArg);
                display.printOperation(firstArg, secondArg, result, OperationType.SUMA);
                break;
            case 3:
                display.printLoadArg();
                firstArg = scanIn.nextBigDecimal();
                display.printLoadArg();
                secondArg = scanIn.nextBigDecimal();
                result = firstArg.multiply(secondArg);
                display.printOperation(firstArg, secondArg, result, OperationType.SUMA);
                break;
            case 4:
                display.printLoadArg();
                firstArg = scanIn.nextBigDecimal();
                display.printLoadArg();
                secondArg = scanIn.nextBigDecimal();
                if(secondArg.equals(BigDecimal.ZERO) )
                    return;
                result = firstArg.divide(secondArg);
                display.printOperation(firstArg, secondArg, result, OperationType.DIV);
                break;
            case 5:
                display.printLoadArg();
                firstArg = scanIn.nextBigDecimal();
                display.printLoadArg();
                secondArg = scanIn.nextBigDecimal();
                result = firstArg.pow(secondArg.toBigInteger().intValue());
                display.printOperation(firstArg, secondArg, result, OperationType.POW);
                break;
            case 6:
                display.printLoadArg();
                firstArg = scanIn.nextBigDecimal();
                result = BigDecimal.valueOf(Math.log(firstArg.doubleValue()));
                display.printOperation(firstArg, secondArg, result, OperationType.LOG);
                break;
            default:
                break;
        }
    }

    public void powerOff() throws InterruptedException{
        display.printOff();
    }
}
