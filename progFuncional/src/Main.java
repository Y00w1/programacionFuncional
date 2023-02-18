import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Lista genérica con valores enteros ");
        List<Double> numbs = CollectionUtils.createListGen(()->{
            return Double.parseDouble(""+Math.round(Math.random()*30));
        }, 10);

        //Acción sobre la lista sin retorno (imprimir los valores)
        CollectionUtils.transformList(numbs, System.out::println);

        System.out.println("Transformar la lista por su cuadrado");
        List<Double> squaredNumbs = CollectionUtils.transformReturn(numbs, (num) -> Math.pow(num, 2));
        CollectionUtils.transformList(squaredNumbs, System.out::println);

        System.out.println("Filtrar la lista con número mayores de 10");
        List<Double> greaterTenNumbs = CollectionUtils.filterGen(numbs, (num) -> num > 10);
        System.out.println("Números mayores que 10:");
        CollectionUtils.transformList(greaterTenNumbs, System.out::println);

        System.out.println("Reducir la lista sumando los valores");
        Double sum = CollectionUtils.reduceSum(numbs);
        System.out.println("Sumatoria de valores: " + sum);



    }
}