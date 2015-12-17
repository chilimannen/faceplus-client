package com.rduda.Model;

import com.rduda.Model.API.*;
import com.rduda.Model.Exception.NoSuchFriendException;

import java.util.List;

/**
 * Created by Robin on 2015-11-28.
 * <p>
 * Message handler implementation for Frontend.
 */
class MessageHandler implements MessageManager {
    private Account account;
    private MessageStore messages;
    private StoreProvider provider;

    public MessageHandler(StoreProvider provider, Account account) {
        this.provider = provider;
        this.messages = provider.getMessageStore();
        this.account = account;
    }

    @Override
    public List<Message> getMessagesFrom(String target, long offset) throws NoSuchFriendException {
        try {
            return MessageBean.fromList(messages.getMessagesFrom(account, target, offset));
        } catch (NoSuchFriendException e) {
            throw new NoSuchFriendException();
        }
    }

    @Override
    public void sendMessageTo(String target, String content) throws NoSuchFriendException {
        try {
            Message message = provider.getMessageModel(account, target, content);
            messages.sendMessage(message);
        } catch (NoSuchFriendException e) {
            throw new NoSuchFriendException();
        }
    }

    @Override
    public List<Message> getLatestMessages() {
        return messages.getLatestMessages(account);
    }
}
