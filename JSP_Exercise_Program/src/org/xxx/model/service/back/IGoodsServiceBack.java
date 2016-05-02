package org.xxx.model.service.back;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.xxx.model.entity.Goods;

public interface IGoodsServiceBack<V> {

    /**
     * ��Ʒ���Ӳ���
     * @param vo ������Ҫ���ӵ���Ʒ��Ϣ
     * @return �ɹ�����true, ʧ�ܷ���false
     * @throws Exception
     */
    public boolean insert(Goods vo) throws Exception;
    
    /**
     * ִ�����ݵ�����ɾ������
     * @param ids
     * @return 
     * <li>key=flag value=IGoodsDAO.doDelete()</li>
     * @throws Exception
     */
    public Map<String, Goods> deleteAll(Set<Integer> gids) throws Exception;

    /**
     * ʵ�����ݵķ�ҳ��ʾ����,�������·�����
     * <li>����IGoodsDAO�ӿ��е�getAllCount()������ͳ��ȫ��������</li>
     * @param currentPage ��ʾ��ǰҳ
     * @param lineSize    ��ʾÿҳ��ʾ��¼��
     * @return ��List���Ϸ���
     * @throws Exception
     */
    
    public List<Goods> goodsListSplit( Integer currentPage, Integer lineSize) throws Exception;


 
}
