--
-- JOB_FINAUTORIZACIONES_BASE  (Scheduler Job) 
--
BEGIN
  SYS.DBMS_SCHEDULER.CREATE_JOB
    (
       job_name        => 'JOB_FINAUTORIZACIONES_BASE'
      ,start_date      => TO_TIMESTAMP_TZ('2016/04/07 01:00:00.000000 +02:00','yyyy/mm/dd hh24:mi:ss.ff tzr')
      ,repeat_interval => 'FREQ=DAILY'
      ,end_date        => NULL
      ,job_class       => 'DEFAULT_JOB_CLASS'
      ,job_type        => 'STORED_PROCEDURE'
      ,job_action      => 'FINALIZARAUTORIZACIONBASE'
      ,comments        => 'Extingue las autorizaciones base cuando llegan a fecha fin'
    );
  SYS.DBMS_SCHEDULER.SET_ATTRIBUTE
    ( name      => 'JOB_FINAUTORIZACIONES_BASE'
     ,attribute => 'RESTARTABLE'
     ,value     => FALSE);
  SYS.DBMS_SCHEDULER.SET_ATTRIBUTE
    ( name      => 'JOB_FINAUTORIZACIONES_BASE'
     ,attribute => 'LOGGING_LEVEL'
     ,value     => SYS.DBMS_SCHEDULER.LOGGING_RUNS);
  SYS.DBMS_SCHEDULER.SET_ATTRIBUTE_NULL
    ( name      => 'JOB_FINAUTORIZACIONES_BASE'
     ,attribute => 'MAX_FAILURES');
  SYS.DBMS_SCHEDULER.SET_ATTRIBUTE_NULL
    ( name      => 'JOB_FINAUTORIZACIONES_BASE'
     ,attribute => 'MAX_RUNS');
  BEGIN
    SYS.DBMS_SCHEDULER.SET_ATTRIBUTE
      ( name      => 'JOB_FINAUTORIZACIONES_BASE'
       ,attribute => 'STOP_ON_WINDOW_CLOSE'
       ,value     => FALSE);
  EXCEPTION
    -- could fail if program is of type EXECUTABLE...
    WHEN OTHERS THEN
      NULL;
  END;
  SYS.DBMS_SCHEDULER.SET_ATTRIBUTE
    ( name      => 'JOB_FINAUTORIZACIONES_BASE'
     ,attribute => 'JOB_PRIORITY'
     ,value     => 3);
  SYS.DBMS_SCHEDULER.SET_ATTRIBUTE_NULL
    ( name      => 'JOB_FINAUTORIZACIONES_BASE'
     ,attribute => 'SCHEDULE_LIMIT');
  SYS.DBMS_SCHEDULER.SET_ATTRIBUTE
    ( name      => 'JOB_FINAUTORIZACIONES_BASE'
     ,attribute => 'AUTO_DROP'
     ,value     => FALSE);

  SYS.DBMS_SCHEDULER.ENABLE
    (name                  => 'JOB_FINAUTORIZACIONES_BASE');
END;
/
