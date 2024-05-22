package components;

import static java.lang.System.out;

import java.math.BigDecimal;

public class Display {
    private String reset= "\u001B[0m";
    private String cyan = "\033[36m";
    private String magenta= "\033[35m";
    private String blue ="\033[34m";
    private String yellow ="\033[33m";
    private String green = "\033[32m";
    private String red ="\033[31m";
    private String tab = "\t\t";
    private String[] bipbup = {red, yellow, cyan, green}; 
    private String[] loadBar={"-", "\\", "|", "/"};

    public void printOn() throws InterruptedException{
        out.print(red+tab+"Welcome i am Mr. Calculator!"+"\n");
        loadAnimation();
    }

    public void printOptions(){
        out.println(magenta+tab+"Menu de opciones");
        out.println("================================================\n");
        out.println("1. Suma"+tab+tab+"2. Resta");
        out.println("3. Multiplicacion"+tab+"4. Division");
        out.println("5. Potencia      "+tab+"6. Logaritmo");
        out.println("\n"+tab+red+"[ 0. Exit ]");
        out.println(reset);
    }

    public void printLoadArg(){
        out.println(yellow+"Pro favor ingrese los valores");
        out.printf("Argumento: ");
    }

    public void printOperation(BigDecimal first, BigDecimal second, BigDecimal result, OperationType operation){
        clean();
        if(operation.name().equals("SUMA")){
            out.printf("Argumento: %.2f"+tab+"Argumento: %.2f\n", first, second);
            out.printf("Resultado: [ %.2f ]", result);
        }

        if(operation.name().equals("DIV")){
            out.printf("Dividendo: %.2f"+tab+"Divisor: %.2f\n", first, second);
            out.printf("Resultado: [ %f ]", result);
        }

        if(operation.name().equals("POW")){
            out.printf("Base: %.2f"+tab+"Potencia: %.2f\n", first, second);
            out.printf("Resultado: [ %.2f ]", result);
        }

        if(operation.name().equals("LOG")){
            out.printf("Logaritmo: %.2f\n", first);
            out.printf("Resultado: [ %f ]", result);
        }
        out.print("\n\n\n\n");
    }

    private void loadAnimation() throws InterruptedException {
        for(int i=0; i<32; i++){
            out.print("\n\n");
            out.printf(blue+"\t=========[%s]=========", loadBar[i%4]);
            out.printf("\n\t  Cargando %sBip %sBup!", bipbup[i%2], bipbup[(i%2)+2]);
            Thread.sleep(100);
            clean();
        }
    }

    public void printOff() throws InterruptedException{
        out.print("\n\n");
        out.print(red+tab+"Nos vemos rey!");
        for(int i = 0; i<3; i++ ){
            out.printf("%s.", bipbup[i]);
            Thread.sleep(1000);
        }
        clean();
    }

    public void clean(){
        out.print("\033[H\033[2J");  
        out.flush();  
    }
}
