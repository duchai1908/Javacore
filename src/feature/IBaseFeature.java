package feature;

import java.util.List;

public interface IBaseFeature <T,E>{
    List<T> findAll();
    void save(T t);
    void deleteById(E id);
    E findIndexById(E id);
}
