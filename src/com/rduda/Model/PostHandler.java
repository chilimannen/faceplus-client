package com.rduda.Model;

import com.rduda.Model.API.*;
import com.rduda.Model.Exception.FriendException;
import com.rduda.Model.Exception.NoSuchFriendException;
import com.rduda.Model.Exception.PostInvalidArgumentsException;

import java.util.Date;
import java.util.List;

/**
 * Created by Robin on 2015-11-28.
 * <p>
 * PostHandler implementation for Frontend.
 */
class PostHandler implements PostManager {
    private StoreProvider provider;
    private Account account;
    private PostStore posts;

    public PostHandler(StoreProvider provider, Account account) {
        this.provider = provider;
        this.posts = provider.getPostStore();
        this.account = account;
    }

    @Override
    public void postHome(String content) throws PostInvalidArgumentsException, FriendException {
        posts.addPost(provider.getPostModel(account, account.getActor(), content, new Date().toString()));
    }

    @Override
    public void postFriend(String target, String content) throws FriendException {
        posts.addPost(provider.getPostModel(account, target, content, new Date().toString()));
    }

    @Override
    public void removePost(long postId) {
        posts.removePost(account, postId);
    }

    @Override
    public List<Post> getHomePosts() {
        return posts.getHomePosts(account);
    }

    @Override
    public List<Post> getFriendPosts(String friend) throws NoSuchFriendException {
        return posts.getFriendPosts(account, friend);
    }

    @Override
    public List<Post> getStreamPosts() {
        return posts.getStreamPosts(account);
    }
}
