package gal.san.clemente.tarefa6_acceso_datos.controller.utils;

import java.util.List;

public interface IPagination<T> {
    
    Long getTotalRowCount();
    List<T> getRows(int startIndex, int endIndex);
    
}
