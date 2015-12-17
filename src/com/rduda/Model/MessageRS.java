package com.rduda.Model;

import com.rduda.Model.API.Account;
import com.rduda.Model.API.Message;
import com.rduda.Model.API.MessageStore;
import com.rduda.Model.API.REST;
import com.rduda.Model.API.Request.MessageList;
import com.rduda.Model.API.Request.MessageMapping;
import com.rduda.Model.Exception.NoSuchFriendException;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robin on 2015-11-28.
 * <p>
 * Message store implemented as REST service.
 */
class MessageRS implements MessageStore {
    @Override
    public List<Message> getMessagesFrom(Account context, String target, long offset) throws NoSuchFriendException {
        MessageList result = new MessageList();
        try {
            result = REST.getClient()
                    .path(REST.Message.GET)
                    .queryParam("actor", context.getActor())
                    .queryParam("token", context.getToken())
                    .queryParam("target", target)
                    .request(REST.TYPE)
                    .get(MessageList.class);
        } catch (NotFoundException e) {
            throw new NoSuchFriendException();
        }
        return new ArrayList<>(result.getList());
    }

    @Override
    public void sendMessage(Message envelope) throws NoSuchFriendException {
        MessageMapping message = (MessageMapping) envelope;
        try {
            REST.getClient()
                    .path(REST.Message.SEND)
                    .request(REST.TYPE)
                    .post(Entity.entity(message, REST.TYPE), MessageMapping.class);
        } catch (NotFoundException e) {
            throw new NoSuchFriendException();
        }
    }

    @Override
    public List<Message> getLatestMessages(Account context) {
        MessageList result = new MessageList();

        result = REST.getClient()
                .path(REST.Message.THREADS)
                .queryParam("actor", context.getActor())
                .queryParam("token", context.getToken())
                .request(REST.TYPE)
                .get(MessageList.class);

        return new ArrayList<>(result.getList());
    }
}
