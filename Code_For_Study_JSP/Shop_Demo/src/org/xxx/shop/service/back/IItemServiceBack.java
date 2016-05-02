package cn.mldn.shop.service.back;

import cn.mldn.shop.vo.Item;

import java.util.List;
import java.util.Set;

public interface IItemServiceBack {
    /**
     *
     * @param vo
     * @return
     * @throws Exception
     */
    public boolean insert(Item vo) throws Exception;

    /**
     *
     * @param vo
     * @return
     * @throws Exception
     */
    public boolean update(Item vo) throws Exception;

    /**
     *
     * @param ids
     * @return
     * @throws Exception
     */
    public boolean delete(Set<Integer> ids) throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Item show(int id) throws Exception;

    /**
     *
     * @return
     * @throws Exception
     */
    public List<Item> list()throws Exception;
}
