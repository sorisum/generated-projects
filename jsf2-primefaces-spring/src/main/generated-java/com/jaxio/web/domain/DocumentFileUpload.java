/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/domain/FileUpload.e.vm.java
 */
package com.jaxio.web.domain;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import com.jaxio.domain.Document;

public class DocumentFileUpload {
    private Document document;

    public DocumentFileUpload(Document document) {
        this.document = document;
    }

    /**
     * Primefaces support for documentBinary file upload
     */
    public void onDocumentBinaryFileUpload(FileUploadEvent fileUploadEvent) {
        UploadedFile uploadedFile = fileUploadEvent.getFile(); //application code
        document.setDocumentBinary(uploadedFile.getContents());
        document.setDocumentSize(document.getDocumentBinary().length);
        document.setDocumentContentType(uploadedFile.getContentType());
        document.setDocumentFileName(FilenameUtils.getName(uploadedFile.getFileName()));
    }
}