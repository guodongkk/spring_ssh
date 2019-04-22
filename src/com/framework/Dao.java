package com.framework;
/*
 * @author :张
 * Date  : 2019/4/22
 * @Description: Dao
 */

import java.util.List;

public interface Dao<T> {
    /*
     *  查询全部
     */
    public List<T> findAll();
    /*
     * 添加
     */
    public void add(T t);
    /*
     *  通过id查询
     */
    public T findById(Integer id);
    /*
     *  修改
     */
    public void update(T t);

    /*
     *  单条删除
     */
    public void delete(T t);

    /*
    *  批量删除
    */


}
