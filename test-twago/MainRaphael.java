import java.util.*;

public class MainRaphael {

    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("Starting...");

                String inputXY = getInputXY();

                int size = getSize(inputXY);

                int quantity = getQuantityOperations(inputXY);

                validInputXY(size, quantity);

                List<String> inputsOperations = getInputOperations(quantity, size);

                int[] arrayResult = processArrayResult(size, inputsOperations);

                System.out.println(Arrays.stream(arrayResult).max().getAsInt());

                System.out.println(".");
                System.out.println(".");
                System.out.println("Array Result: " + Arrays.toString(arrayResult));
                System.out.println(".");
                System.out.println(".");

            } catch (NumberFormatException e) {
                System.out.println("Input invalid. Please use the default format: \nSample Input:\n" +
                        "5 3\n" +
                        "1 2 100\n" +
                        "2 5 100\n" +
                        "3 4 100");

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validInputXY(int size, int quantity) throws Exception {
        if(size < 3 || size > Math.pow(10, 7)) {
            throw new Exception("Input invalid. Size (X) value invalid: " + size);
        }

        if(quantity < 1 || quantity > (2*Math.pow(10, 5))) {
            throw new Exception("Input invalid. Number of operations (Y) invalid: " + quantity);
        }
    }


    private static int[] processArrayResult(int size, List<String> inputsOperations) {
        int[] arrayResult = new int[size];
        for (String input: inputsOperations) {
            int i = getInitialIndex(input);
            int j = getEndIndex(input);
            int k = getOperationValue(input);

            for(int index = i; index <= j; index++) {
                arrayResult[index-1] += k;
            }
        }

        return arrayResult;
    }

    private static void validInputOperations(String line, int size) throws Exception {
        int i = getInitialIndex(line);
        int j = getEndIndex(line);
        int k = getOperationValue(line);

        if(j > size || j < i || i < 1) {
            throw new Exception("Invalid input. Invalid values to <i, j>: " + i + ", " + j);
        }

        if(k < 0 || k > Math.pow(10, 9)) {
            throw new Exception("Invalid input. Invalid value to k: " + k);
        }
    }

    private static int getOperationValue(String input) {
        return Integer.parseInt(input.split(" ")[2]);
    }

    private static int getEndIndex(String input) {
        return Integer.parseInt(input.split(" ")[1]);
    }

    private static int getInitialIndex(String input) {
        return Integer.parseInt(input.split(" ")[0]);
    }

    private static List<String> getInputOperations(int quantity, int size) throws Exception {
        List<String> inputsOperations = new ArrayList<String>();
        for(int i = 1; i <= quantity; i++) {
            System.out.print("Input["+i+"] <i j k> values: ");
            String line = scanner.nextLine();
            validInputOperations(line, size);
            inputsOperations.add(line);
        }
        return inputsOperations;
    }

    private static int getQuantityOperations(String inputXY) {
        return Integer.parseInt(inputXY.split(" ")[1]);
    }

    private static int getSize(String inputXY) {
        return Integer.parseInt(inputXY.split(" ")[0]);
    }

    static String getInputXY() {
        System.out.print("Input <X Y> values: ");
        String intputXY = scanner.nextLine();
        return intputXY;
    }
}
