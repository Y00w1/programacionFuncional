import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CollectionUtils {
    public static <T> List<T> createListGen(Supplier<T> supplier, int amount){
        List<T> genList = new ArrayList<>();
        for(int i = 0; i < amount; i++){
            genList.add(supplier.get());
        }
        return genList;
    }

    public static <T, R> List<R> transformReturn(List<T> list, Function<T, R> function) {
        List<R> newList = new ArrayList<>();
        for (T value : list){
            newList.add(function.apply(value));
        }
        return newList;
    }

    public static <T> void transformList(List<T> list, Consumer<T> function){
        list.forEach(function);
    }

    public static <T, R> List<R> filterGen(List<T> list, Predicate<T> filter){
        List<R> filteredList = new ArrayList<>();
        for(T value : list){
            if (filter.test(value)){
                filteredList.add((R) value);
            }
        }
        return filteredList;
    }

    public static Double reduceSum(List<Double> list){
        return list.stream().reduce(0.0, Double::sum);
    }

}
