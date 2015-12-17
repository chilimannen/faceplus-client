package com.rduda.Model;

import com.rduda.Model.API.Image;

/**
 * Created by Robin on 2015-11-26.
 * <p>
 * ImageBean.
 */
public class ImageMapping implements Image {
    private String base64;
    private Long id;

    public ImageMapping() {
    }

    public ImageMapping(Image image) {
        this.base64 = image.getBase64();
        this.id = image.getId();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getBase64() {
        return base64;
    }

    public ImageMapping setBase64(String base64) {
        this.base64 = base64;
        return this;
    }

    public ImageMapping setId(Long id) {
        this.id = id;
        return this;
    }
}
