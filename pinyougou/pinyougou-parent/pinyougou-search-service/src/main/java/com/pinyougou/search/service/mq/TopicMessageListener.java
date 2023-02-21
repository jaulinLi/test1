package com.pinyougou.search.service.mq;

import com.pinyougou.model.Item;
import com.pinyougou.mq.MessageInfo;
import com.pinyougou.search.service.ItemSearchService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.util.List;

public class TopicMessageListener implements MessageListener {

    @Autowired
    private ItemSearchService itemSearchService;

    @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage){
            ObjectMessage objectMessage = (ObjectMessage) message;

            try {
                MessageInfo messageInfo = (MessageInfo) objectMessage.getObject();

                //修改，增加索引
                if (messageInfo.getMethod()==MessageInfo.METHOD_UPDATE){

                    List<Item> items = (List<Item>) messageInfo.getContext();
                    itemSearchService.importItems(items);

                } else if (messageInfo.getMethod()==MessageInfo.METHOD_DELETE){
                    List<Long> ids = (List<Long>) messageInfo.getContext();
                    itemSearchService.deleteByGoodsIds(ids);
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
