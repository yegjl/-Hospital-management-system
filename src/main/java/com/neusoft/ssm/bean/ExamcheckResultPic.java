package com.neusoft.ssm.bean;

public class ExamcheckResultPic {
    private Integer id;

    private Integer resultid;

    private String directory;

    public ExamcheckResultPic(Integer id, Integer resultid, String directory) {
        this.id = id;
        this.resultid = resultid;
        this.directory = directory;
    }

    public ExamcheckResultPic() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResultid() {
        return resultid;
    }

    public void setResultid(Integer resultid) {
        this.resultid = resultid;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory == null ? null : directory.trim();
    }
}