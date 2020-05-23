package gal.san.clemente.tarefa6_acceso_datos.model.converter;

import gal.san.clemente.tarefa6_acceso_datos.exception.ProjectException;

public interface IConverter<T, E> {
    T BaseDataToEntity(E baseData) throws ProjectException;
    
    E EntityToBaseData(T entity) throws ProjectException;
}
