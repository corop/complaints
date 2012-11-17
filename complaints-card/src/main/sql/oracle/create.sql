CREATE SEQUENCE  CMPL_SEQ_CATEGORY  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
CREATE SEQUENCE  CMPL_SEQ_DEPARTMENT  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
CREATE SEQUENCE  CMPL_SEQ_DOC_TYPE  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
CREATE SEQUENCE  CMPL_SEQ_ATTACHED_FILE  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
CREATE SEQUENCE  CMPL_SEQ_COMPLAINT  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
CREATE SEQUENCE  CMPL_SEQ_COMPLAINT_AUTHOR  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

/*==============================================================*/
/* Table: CMPL_ATTACHED_FILE                                    */
/*==============================================================*/
create table CMPL_ATTACHED_FILE 
(
   ATTACHED_FILE_ID     INTEGER              not null,
   COMPLAINT_ID         INTEGER,
   DOC_TYPE_ID          INTEGER              not null,
   HTTP_SESSION_ID   VARCHAR2(64)        not null,
   ATTACHED_FILE_NAME   VARCHAR2(256)        not null,
   ATTACHED_FILE_DESCR  VARCHAR2(1024),
   ATTACHED_FILE_INSERTED TIMESTAMP            not null,
   constraint PK_CMPL_ATTACHED_FILE primary key (ATTACHED_FILE_ID)
);

/*==============================================================*/
/* Index: REL_DOC_TYPE_TO_FILE_FK                               */
/*==============================================================*/
create index REL_DOC_TYPE_TO_FILE_FK on CMPL_ATTACHED_FILE (
   DOC_TYPE_ID ASC
);

/*==============================================================*/
/* Index: REL_COMPLAINT_TO_FILE_FK                              */
/*==============================================================*/
create index REL_COMPLAINT_TO_FILE_FK on CMPL_ATTACHED_FILE (
   COMPLAINT_ID ASC
);

/*==============================================================*/
/* Index: INDEX_ATTACHED_FILE_INSERTED                          */
/*==============================================================*/
create index INDEX_ATTACHED_FILE_INSERTED on CMPL_ATTACHED_FILE (
   ATTACHED_FILE_INSERTED ASC
);

/*==============================================================*/
/* Index: INDEX_ATTACHED_FILE_HTTP_SESSI                        */
/*==============================================================*/
create index INDEX_ATTACHED_FILE_HTTP_SESSI on CMPL_ATTACHED_FILE (
   HTTP_SESSION_ID ASC
);


/*==============================================================*/
/* Table: CMPL_CATEGORY                                         */
/*==============================================================*/
create table CMPL_CATEGORY 
(
   CATEGORY_ID          INTEGER              not null,
   CATEGORY_NAME        VARCHAR2(300)        not null,
   constraint PK_CMPL_CATEGORY primary key (CATEGORY_ID)
);

/*==============================================================*/
/* Table: CMPL_COMPLAINT                                        */
/*==============================================================*/
create table CMPL_COMPLAINT 
(
   COMPLAINT_ID         INTEGER              not null,
   DEPARTMENT_ID        INTEGER,
   COMPLAINT_AUTHOR_ID  INTEGER,
   CATEGORY_ID          INTEGER              not null,
   HTTP_SESSION_ID   VARCHAR2(64)        not null,
   CLIENT_IP   VARCHAR2(32)        not null,
   COMPLAINT_GOV_NAME   VARCHAR2(128)        not null,
   COMPLAINT_FNAME      VARCHAR2(32),
   COMPLAINT_LNAME      VARCHAR2(32),
   COMPLAINT_TNAME      VARCHAR2(32),
   COMPLAINT_COMPANY    VARCHAR2(64),
   COMPLAINT_POST_INDEX VARCHAR2(10)         not null,
   COMPLAINT_POST_ADDRESS VARCHAR2(64)         not null,
   COMPLAINT_PHONE      VARCHAR2(12)         not null,
   COMPLAINT_EMAIL      VARCHAR2(32)         not null,
   COMPLAINT_APPEAL     CLOB,
   COMPLAINT_INSERTED   TIMESTAMP            not null,
   COMPLAINT_SENDED     INTEGER              default 0 not null,
   constraint PK_CMPL_COMPLAINT primary key (COMPLAINT_ID)
);

/*==============================================================*/
/* Index: REL_DEPARTMENT_TO_COMPLAINT_FK                        */
/*==============================================================*/
create index REL_DEPARTMENT_TO_COMPLAINT_FK on CMPL_COMPLAINT (
   DEPARTMENT_ID ASC
);

/*==============================================================*/
/* Index: REL_CATEGORY_TO_COMPLAINT_FK                          */
/*==============================================================*/
create index REL_CATEGORY_TO_COMPLAINT_FK on CMPL_COMPLAINT (
   CATEGORY_ID ASC
);

/*==============================================================*/
/* Index: REL_AUTHOR_TO_COMPLAINT_FK                            */
/*==============================================================*/
create index REL_AUTHOR_TO_COMPLAINT_FK on CMPL_COMPLAINT (
   COMPLAINT_AUTHOR_ID ASC
);

/*==============================================================*/
/* Index: INDEX_COMPLAINT_INSERTED                              */
/*==============================================================*/
create index INDEX_COMPLAINT_INSERTED on CMPL_COMPLAINT (
   COMPLAINT_INSERTED ASC
);

/*==============================================================*/
/* Index: INDEX_COMPLAINT_EMAIL                                 */
/*==============================================================*/
create index INDEX_COMPLAINT_EMAIL on CMPL_COMPLAINT (
   COMPLAINT_EMAIL ASC
);

/*==============================================================*/
/* Index: INDEX_COMPLAINT_HTTP_SESSION_I                        */
/*==============================================================*/
create index INDEX_COMPLAINT_HTTP_SESSION_I on CMPL_COMPLAINT (
   HTTP_SESSION_ID ASC
);

/*==============================================================*/
/* Index: INDEX_CLIENT_IP                                       */
/*==============================================================*/
create index INDEX_CLIENT_IP on CMPL_COMPLAINT (
   CLIENT_IP ASC
);



/*==============================================================*/
/* Table: CMPL_COMPLAINT_AUTHOR                                 */
/*==============================================================*/
create table CMPL_COMPLAINT_AUTHOR 
(
   COMPLAINT_AUTHOR_ID  INTEGER              not null,
   COMPLAINT_AUTHOR_NAME VARCHAR2(64)         not null,
   constraint PK_CMPL_COMPLAINT_AUTHOR primary key (COMPLAINT_AUTHOR_ID)
);

/*==============================================================*/
/* Table: CMPL_DEPARTMENT                                       */
/*==============================================================*/
create table CMPL_DEPARTMENT 
(
   DEPARTMENT_ID        INTEGER              not null,
   DEPARTMENT_CODE      VARCHAR2(8)          not null,
   DEPARTMENT_NAME      VARCHAR2(128)         not null,
   DEPARTMENT_EMAIL     VARCHAR2(64)         not null,
   constraint PK_CMPL_DEPARTMENT primary key (DEPARTMENT_ID)
);

/*==============================================================*/
/* Index: INDEX_DEPARTMENT_CODE                                 */
/*==============================================================*/
create index INDEX_DEPARTMENT_CODE on CMPL_DEPARTMENT (
   DEPARTMENT_CODE ASC
);

/*==============================================================*/
/* Table: CMPL_DOC_TYPE                                         */
/*==============================================================*/
create table CMPL_DOC_TYPE 
(
   DOC_TYPE_ID          INTEGER              not null,
   DOC_TYPE_NAME        VARCHAR2(64)         not null,
   constraint PK_CMPL_DOC_TYPE primary key (DOC_TYPE_ID)
);

alter table CMPL_ATTACHED_FILE
   add constraint FK_CMPL_ATT_REL_COMPL_CMPL_COM foreign key (COMPLAINT_ID)
      references CMPL_COMPLAINT (COMPLAINT_ID);

alter table CMPL_ATTACHED_FILE
   add constraint FK_CMPL_ATT_REL_DOC_T_CMPL_DOC foreign key (DOC_TYPE_ID)
      references CMPL_DOC_TYPE (DOC_TYPE_ID);

alter table CMPL_COMPLAINT
   add constraint FK_CMPL_COM_REL_AUTHO_CMPL_COM foreign key (COMPLAINT_AUTHOR_ID)
      references CMPL_COMPLAINT_AUTHOR (COMPLAINT_AUTHOR_ID);

alter table CMPL_COMPLAINT
   add constraint FK_CMPL_COM_REL_CATEG_CMPL_CAT foreign key (CATEGORY_ID)
      references CMPL_CATEGORY (CATEGORY_ID);

alter table CMPL_COMPLAINT
   add constraint FK_CMPL_COM_REL_DEPAR_CMPL_DEP foreign key (DEPARTMENT_ID)
      references CMPL_DEPARTMENT (DEPARTMENT_ID);

/      
CREATE OR REPLACE TRIGGER CMPL_INC_SEQ_CATEGORY
BEFORE INSERT
ON CMPL_CATEGORY
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
begin
  if :new.CATEGORY_ID is null then
    select CMPL_SEQ_CATEGORY.NEXTVAL into :new.CATEGORY_ID
     from dual;
  end if;
end;      
/
CREATE OR REPLACE TRIGGER CMPL_INC_SEQ_DEPARTMENT
BEFORE INSERT
ON CMPL_DEPARTMENT
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
begin
  if :new.DEPARTMENT_ID is null then
    select CMPL_SEQ_DEPARTMENT.NEXTVAL into :new.DEPARTMENT_ID
     from dual;
  end if;
end;      
/
CREATE OR REPLACE TRIGGER CMPL_INC_SEQ_COMPLAINT
BEFORE INSERT
ON CMPL_COMPLAINT
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
begin

  if :new.COMPLAINT_INSERTED is null then
    :new.COMPLAINT_INSERTED := sysdate;
  end if;

  if :new.COMPLAINT_SENDED is null then
    :new.COMPLAINT_SENDED := 0;
  end if;

  if :new.COMPLAINT_ID is null then
    select CMPL_SEQ_COMPLAINT.NEXTVAL into :new.COMPLAINT_ID
     from dual;
  end if;
end;      
/
CREATE OR REPLACE TRIGGER CMPL_INC_SEQ_ATTACHED_FILE
BEFORE INSERT
ON CMPL_ATTACHED_FILE
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
begin
  if :new.ATTACHED_FILE_INSERTED is null then
    :new.ATTACHED_FILE_INSERTED := sysdate;
  end if;
  if :new.ATTACHED_FILE_ID is null then
    select CMPL_SEQ_ATTACHED_FILE.NEXTVAL into :new.ATTACHED_FILE_ID
     from dual;
  end if;
end;      
/
CREATE OR REPLACE TRIGGER CMPL_INC_SEQ_DOC_TYPE
BEFORE INSERT
ON CMPL_DOC_TYPE
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
begin
  if :new.DOC_TYPE_ID is null then
    select CMPL_SEQ_DOC_TYPE.NEXTVAL into :new.DOC_TYPE_ID
     from dual;
  end if;
end;      
/
CREATE OR REPLACE TRIGGER CMPL_INC_SEQ_COMPLAINT_AUTHOR
BEFORE INSERT
ON CMPL_COMPLAINT_AUTHOR
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
begin
  if :new.COMPLAINT_AUTHOR_ID is null then
    select CMPL_SEQ_COMPLAINT_AUTHOR.NEXTVAL into :new.COMPLAINT_AUTHOR_ID
     from dual;
  end if;
end;      


