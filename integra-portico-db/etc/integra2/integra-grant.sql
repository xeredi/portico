DECLARE
	CURSOR c IS SELECT table_name FROM user_tables;
	cmd VARCHAR2(200);
BEGIN
	FOR t IN c LOOP
		cmd := 'GRANT SELECT ON '|| t.table_name|| ' TO integra2';
		EXECUTE IMMEDIATE cmd;
	END LOOP;
END;
