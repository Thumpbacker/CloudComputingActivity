package com.gcu.data;

import java.util.List;

public interface DataAccessInterface<T> {
    public T getByID(int id);
    public List<T> getOrders();
    public List<T> searchOrders(String searchTerm);
    public int addOne(T newOrder);
    public boolean deleteOne(long id);
    public T updateOne(long idToUpdate, T updateOrder);
}
