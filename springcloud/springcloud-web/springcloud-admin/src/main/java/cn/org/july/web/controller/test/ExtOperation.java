package cn.org.july.web.controller.test;

public enum ExtOperation implements IOperation {

    EXP("^") {
        @Override
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    };
    private final String symbol;

    ExtOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return this.symbol;
    }


    private static <T extends Enum<T> & IOperation> void test(Class<T> tClass, double x,
                                                              double y) {
        for (IOperation operation : tClass.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n",
                    x, operation, y, operation.apply(x, y));
        }

    }

    public static void main(String[] args) {
        test(ExtOperation.class,2,3);
        test(Operation.class,2,3);
    }

}
