package ru.fccland.complaints.card.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 08.11.12
 * Time: 8:40
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="CMPL_ATTACHED_FILE")
public class AttachedFile implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="CMPL_SEQ_ATTACHED_FILE")
    @SequenceGenerator(name="CMPL_SEQ_ATTACHED_FILE", sequenceName="CMPL_SEQ_ATTACHED_FILE")
    @Column(name="ATTACHED_FILE_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name="COMPLAINT_ID")
    private Complaint complaint;
    @ManyToOne
    @JoinColumn(name="DOC_TYPE_ID")
    private DocType docType;
    @Column(name="HTTP_SESSION_ID")
    private String httpSessionId;
    @Column(name="ATTACHED_FILE_NAME")
    private String fileName;
    @Column(name="ATTACHED_FILE_DESCR")
    private String fileDescription;
    @Column(name="ATTACHED_FILE_INSERTED")
    private Date fileInsterted;

    public AttachedFile() {
    }

    public AttachedFile(Long id, Complaint complaint, DocType docType, String httpSessionId, String fileName, String fileDescription, Date fileInsterted) {
        this.id = id;
        this.complaint = complaint;
        this.docType = docType;
        this.httpSessionId = httpSessionId;
        this.fileName = fileName;
        this.fileDescription = fileDescription;
        this.fileInsterted = fileInsterted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public String getHttpSessionId() {
        return httpSessionId;
    }

    public void setHttpSessionId(String httpSessionId) {
        this.httpSessionId = httpSessionId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public Date getFileInsterted() {
        return fileInsterted;
    }

    public void setFileInsterted(Date fileInsterted) {
        this.fileInsterted = fileInsterted;
    }

    @Override
    public String toString() {
        return "AttachedFile{" +
                "id=" + id +
                ", complaint=" + complaint +
                ", docType=" + docType +
                ", httpSessionId='" + httpSessionId + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileDescription='" + fileDescription + '\'' +
                ", fileInsterted=" + fileInsterted +
                '}';
    }
}
