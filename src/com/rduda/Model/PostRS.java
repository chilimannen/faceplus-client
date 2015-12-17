package com.rduda.Model;

import com.rduda.Model.API.Account;
import com.rduda.Model.API.Post;
import com.rduda.Model.API.PostStore;
import com.rduda.Model.API.REST;
import com.rduda.Model.API.Request.PostList;
import com.rduda.Model.API.Request.PostMapping;
import com.rduda.Model.API.Request.RequestMapping;
import com.rduda.Model.Exception.FriendException;
import com.rduda.Model.Exception.NoSuchFriendException;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robin on 2015-11-28.
 * <p>
 * Implementation of a post-store using a REST service as storage.
 */
class PostRS implements PostStore {
    @Override
    public void addPost(Post headers) throws FriendException {
        PostMapping post = (PostMapping) headers;

        try {
            REST.getClient()
                    .path(
                            (post.getActor().equals(post.getTarget()))
                                    ? REST.Post.POST_HOME : REST.Post.POST_FRIEND
                    )
                    .request(REST.TYPE)
                    .post(Entity.entity(post, REST.TYPE), RequestMapping.class);
        } catch (NotFoundException ignored) {
            throw new FriendException();
        }
    }

    @Override
    public void removePost(Account context, long postId) {
        PostMapping post = new PostMapping(new RequestMapping(context))
                .setId(postId);

        REST.getClient()
                .path(REST.Post.REMOVE)
                .request(REST.TYPE)
                .post(Entity.entity(post, REST.TYPE), RequestMapping.class);
    }

    @Override
    public List<Post> getHomePosts(Account context) {
        PostList result = REST.getClient()
                .path(REST.Post.POST_HOME)
                .queryParam("actor", context.getActor())
                .queryParam("token", context.getToken())
                .request(REST.TYPE)
                .get(PostList.class);

        return new ArrayList<>(result.getList());
    }

    @Override
    public List<Post> getStreamPosts(Account context) {
        PostList result = REST.getClient()
                .path(REST.Post.STREAM_POSTS)
                .queryParam("actor", context.getActor())
                .queryParam("token", context.getToken())
                .request(REST.TYPE)
                .get(PostList.class);

        return new ArrayList<>(result.getList());
    }

    @Override
    public List<Post> getFriendPosts(Account context, String friend) throws NoSuchFriendException {
        PostList result = new PostList();
        try {
            result = REST.getClient()
                    .path(REST.Post.POST_FRIEND)
                    .queryParam("actor", context.getActor())
                    .queryParam("token", context.getToken())
                    .queryParam("target", friend)
                    .request(REST.TYPE)
                    .get(PostList.class);
        } catch (NotFoundException e) {
            throw new NoSuchFriendException();
        }
        return new ArrayList<>(result.getList());
    }
}
