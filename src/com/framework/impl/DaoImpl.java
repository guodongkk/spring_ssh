package com.framework.impl;/*
 * @author :张
 * Date  : 2019/4/22
 * @Description: DaoImpl
 */

import com.framework.Dao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class DaoImpl<T> implements Dao<T> {


    private Class<T> entityClass;
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    protected Session getSession(){
//        return sessionFactory.getCurrentSession();
//    }
     @Autowired
    private HibernateTemplate hibernateTemplate;


    public DaoImpl(){
//       获得泛型的class
        ParameterizedType pt=(ParameterizedType)getClass().getGenericSuperclass();
        entityClass=(Class<T>) pt.getActualTypeArguments()[0];
    }

     @Override
    public List<T> findAll(){
//        一个接口中只有一个方法就可以采用lamda表达式（参数名） ->{方法体}
         /*(session) ->{
             return session.createQuery("from " + entityClass.getSimpleName()).list();
         }*/

//      匿名内部类，没有名字的类
         /*   newHibernateCallback<List<T>>(){
         @Override
         public List<T> doInHibernate(Session session) throws HibernateException{
              Query<T> query=session.createQuery("from " + entityClass.getSimpleName(),entityClass);
              return query.list();
         }
         }
 */
        //执行查询
         List<T> list = hibernateTemplate.execute(new QueryHibernateCallback());
         return list;
     }

    @Override
    public void add(T t) {
        hibernateTemplate.save(t);
    }

    @Override
    public T findById(Integer id) {
        return hibernateTemplate.get(entityClass,id);
    }

    @Override
    public void update(T t) {
        hibernateTemplate.update(t);
    }

    @Override
    public void delete(T t) {
        hibernateTemplate.delete(t);
    }


//支持查询的内部类
    class QueryHibernateCallback implements HibernateCallback<List<T>>{
        @Override
         public List<T> doInHibernate(Session session) throws HibernateException{
            return session.createQuery("from " + entityClass.getSimpleName()).list();
        }
     }
//    @Override
//    public List<T> pfindAll() {
//        return this.getSession()
//                .createQuery("from " + entityClass.getSimpleName()).list();
//    }
//
//    @Override
//    public void add(T t) {
//      this.getSession().save(t);
//    }
//
//    @Override
//    public T findById(Integer id) {
//        return (T)this.getSession()
//                .get(entityClass,id);
//    }
//
//
//    @Override
//    public void update(T t) {
//     this.getSession().update(t);
//    }
//
//    @Override
//    public void delete(T t) {
//    this.getSession().delete(t);
//    }
//
//    @Override
//    public void deleteAll(Integer[] ids, String hql) {
// this.getSession().createQuery(hql).setParameterList("ids",ids).executeUpdate();
//    }
}
