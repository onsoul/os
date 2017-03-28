package com.wise.chat.logic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.wise.chat.core.bean.Proto;
import com.wise.chat.core.pb.Message;
import com.wise.chat.core.service.MsgService;

/**
 * 消息服务
 * <p>
 * Created by Tony on 4/14/16.
 */
@Service("msgService")
public class MsgServiceImpl implements MsgService {

    private Logger logger = LoggerFactory.getLogger(MsgServiceImpl.class);

    @Override
    public boolean receive(Proto proto) {
        System.out.println("==receive===");
        logger.debug("producer:{} ", proto);
        Message.MsgData bady;
        try {
        	bady = Message.MsgData.parseFrom(proto.getBody());
            ByteString data=bady.getData();
        } catch (InvalidProtocolBufferException e) {
            logger.error("invalid proto {} {}", proto, e.getMessage());
            
        }
        // TODO
        return true;
    }
}