package com.vertx.example.api;

import com.google.common.collect.Lists;
import io.vertx.ext.web.FileUpload;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Path("/upload")
public class TestRest3 {

    @POST
    @Path("/importData")
    public String importData(@Context RoutingContext context) throws Exception {
        Set<FileUpload> fileUploadSet = context.fileUploads();
        if (fileUploadSet == null || fileUploadSet.isEmpty()) {
            return "no file upload!";
        }

        Iterator<FileUpload> fileUploadIterator = fileUploadSet.iterator();
        List<String> urlList = Lists.newArrayList();
        while (fileUploadIterator.hasNext()) {
            FileUpload fileUpload = fileUploadIterator.next();

            // default folder is file-uploads in vertx
            // Could you give us method to change default upload folder?
            // Add BodyHandler.create().setUploadsDirectory("....") in your code.
            urlList.add(fileUpload.uploadedFileName());
            break;
        }

        return "upload file!";
    }
}
