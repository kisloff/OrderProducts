package ru.kkiselev.model.DAO;

import ru.kkiselev.model.POJO.Basket;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by kv on 28.12.16.
 */
public class BasketDAO implements DAO<Basket> {

    @Override
    public List<Basket> getAll(){
        return null;
    }

    @Override
    public Basket getById(long id){
        return null;
    }

    @Override
    public void deleteById(long id){

    }

    @Override
    public void updateById(Basket instance) {

    }
}
