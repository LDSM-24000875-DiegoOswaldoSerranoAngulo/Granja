package app.utl.granja.Service;

import java.util.List;

public interface BaseService<T> {
    public List<T> findAll();

        public T findById (Long id);

        public T save (T t);

        public T update(Long id, T t);

        boolean delete(Long id);
}
