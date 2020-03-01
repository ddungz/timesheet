INSERT INTO tbl_t_schedules(id,user_id,month,confirmed_status,confirmed_at,approved_level,created_at,created_by,updated_at,updated_by,deleted_at,deleted_by)
VALUES	(1,1,"2020-01","01","2019-12-20","03","2019-12-15","admin","2020-01-05","system",null,null),
		(2,2,"2020-01","01","2019-12-18","03","2019-12-15","admin","2020-01-05","system",null,null),
		(3,3,"2020-01","03","2019-12-16","03","2019-12-15","admin","2020-01-05","system",null,null),
		(4,1,"2020-02","02","2020-01-20","02","2020-01-15","admin","2020-01-29","system",null,null),
		(5,2,"2020-02","03","2020-01-19","02","2020-01-15","admin","2020-01-29","system",null,null),
		(6,3,"2020-02","03","2020-01-18","02","2020-01-15","admin","2020-01-29","system",null,null),
		(7,1,"2020-03","03","2020-02-20","01","2020-02-15","admin","2020-02-20","system",null,null),
		(8,2,"2020-03","03","2020-02-19","01","2020-02-15","admin","2020-02-19","system",null,null),
		(9,3,"2020-03","03","2020-02-16","01","2020-02-15","admin","2020-02-16","system",null,null);


INSERT INTO tbl_t_schedule_approvals(id,schedule_id,approval_status,approval_level,approved_by,approved_at,total_deviation,total_missed_log,total_leave,total_correction_payment, total_correction_holiday, total_correction_other,created_at,created_by,updated_at,updated_by,deleted_at,deleted_by)
VALUES	(1,1,"人事承認","01","assistant","2020-01-05",1,1,1,2,3,4,"2019-12-15","admin","2020-01-05","system",null,null),
		(2,1,"総括承認","02","general","2020-01-05",0,1,1,0,0,1,"2019-12-15","admin","2020-01-05","system",null,null),
		(3,1,"管理者承認","03","manager","2020-01-05",0,1,0,4,6,7,"2019-12-15","admin","2020-01-05","system",null,null),
		(4,2,"人事承認","01","assistant","2020-01-05",0,1,0,0,0,0,"2019-12-15","admin","2020-01-05","system",null,null),
		(5,2,"総括承認","02","general","2020-01-05",2,1,1,1,1,0,"2019-12-15","admin","2020-01-05","system",null,null),
		(6,3,"人事承認","01","assistant","2020-01-05",2,0,1,0,0,0,"2019-12-15","admin","2020-01-05","system",null,null);

	
INSERT INTO tbl_t_excluded_types(id,type,name,created_at,created_by,updated_at,updated_by,deleted_at,deleted_by)
VALUES	(1,"01","休職","2019-12-15","admin","2019-12-15",null,null,null),
		(2,"02","出向","2019-12-15","admin","2019-12-15",null,null,null),
		(3,"03","海外勤務","2019-12-15","admin","2019-12-15",null,null,null);

