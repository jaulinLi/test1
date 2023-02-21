package com.pinyougou.page.service.mq;

import com.pinyougou.model.Item;
import com.pinyougou.mq.MessageInfo;
import com.pinyougou.page.service.ItemPageService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TopicMessageListener implements MessageListener {

    @Autowired
    private ItemPageService itemPageService;

    @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage){
            ObjectMessage objectMessage = (ObjectMessage) message;
            try {
                MessageInfo messageInfo = (MessageInfo) objectMessage.getObject();

                if (messageInfo.getMethod()==MessageInfo.METHOD_UPDATE){
                    List<Item> items = (List<Item>) messageInfo.getContext();

                    Set<Long> goodsIds = getGoodsIds(items);

                    for (Long goodsId : goodsIds) {
                        itemPageService.buildHtml(goodsId);
                    }

                } else if (messageInfo.getMethod()==MessageInfo.METHOD_DELETE){
                    List<Long> ids = (List<Long>) messageInfo.getContext();

                    for (Long id : ids) {
                        itemPageService.deleteHtml(id);
                    }
                }
            } catch (JMSException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Set<Long> getGoodsIds(List<Item> items){
        Set<Long> set = new HashSet<Long>();
        for (Item item : items) {
            set.add(item.getGoodsId());
        }
        return set;
    }
}
