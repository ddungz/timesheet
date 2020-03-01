INSERT INTO tbl_t_users(id, username, email, password, firstname, lastname, user_code, department_code, group_code, excluded_type, created_at, created_by, updated_at, updated_by, deleted_at, deleted_by)
VALUES	(1,"asahinaka","asahinaka@admin.com","$2y$12$glqy503Ps95tObI8IO3pteckeeLYbxi01WlPi5nUqqXjl/GBXDsNm","あさひ","なか","9999999","10100","10101",NULL,"2020-02-02 20:20:20","admin","2020-02-02 20:20:20",NULL,NULL,NULL),
		(2,"admin","admin@admin.com","$2y$12$glqy503Ps95tObI8IO3pteckeeLYbxi01WlPi5nUqqXjl/GBXDsNm","Admin","なか","9999998","10100","10101",NULL,"2020-02-02 20:20:20","admin","2020-02-02 20:20:20",NULL,NULL,NULL),
		(3,"fu-ji","fu-ji@admin.com","$2y$12$glqy503Ps95tObI8IO3pteckeeLYbxi01WlPi5nUqqXjl/GBXDsNm","fu-ji","なか","9999997","20200","20202",NULL,"2020-02-02 20:20:20","admin","2020-02-02 20:20:20",NULL,NULL,NULL),
		(4,"fujiko","fujiko@admin.com","$2y$12$glqy503Ps95tObI8IO3pteckeeLYbxi01WlPi5nUqqXjl/GBXDsNm","fujiko","なか","9999996","20200","20204",NULL,"2020-02-02 20:20:20","admin","2020-02-02 20:20:20",NULL,NULL,NULL),
		(5,"fujio","fujio@admin.com","$2y$12$glqy503Ps95tObI8IO3pteckeeLYbxi01WlPi5nUqqXjl/GBXDsNm","fujio","なか","9999995","30300","30301",NULL,"2020-02-02 20:20:20","admin","2020-02-02 20:20:20",NULL,NULL,NULL);


INSERT INTO tbl_t_roles(id, name, category, category_name, title, display_order, created_at, created_by, updated_at, updated_by, deleted_at, deleted_by)
VALUES	(1,"ROLE_SYSTEM_ADMIN","00","システム管理者","システム管理者担当",1,"2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
		(2,"ROLE_MANAGER","01","管理","管理担当",2,"2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
		(3,"ROLE_GENERAL","02","管理","総括担当",3,"2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
		(4,"ROLE_ASSISTANT","02","管理","補佐担当",4,"2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
		(5,"ROLE_USER","03","ユーザ","社員",5,"2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL);


INSERT INTO tbl_t_user_roles(id, user_id, role_id, created_at, created_by, updated_at, updated_by, deleted_at, deleted_by)
VALUES	(1,1,2,"2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
		(2,1,3,"2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
		(3,2,2,"2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL);


INSERT INTO tbl_t_departments(id, code, name, created_at, created_by, updated_at, updated_by, deleted_at, deleted_by)
VALUES	(1,"10100","〇〇総合研究所","2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
	    (2,"20200","技術研究所","2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
	    (3,"30300","総合研究所","2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL);

INSERT INTO tbl_t_groups(department_id, code, name, created_at, created_by, updated_at, updated_by, deleted_at, deleted_by)
VALUES	(1,"10101","〇〇総合研究所01研","2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
	    (1,"10102","〇〇総合研究所02研","2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
	    (1,"10103","〇〇総合研究所03研","2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
	    (1,"10104","〇〇総合研究所04研","2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
	    (1,"10105","〇〇総合研究所05研","2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
	    (2,"20201","技術研究所01","2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
	    (2,"20202","技術研究所02","2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
	    (2,"20203","技術研究所03","2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
	    (2,"20204","技術研究所04","2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
	    (2,"20205","技術研究所05","2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
	    (3,"30301","総合研究所","2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
	    (3,"30302","総合研究所〇〇研","2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL);

    
INSERT INTO tbl_t_projects(id, code, name, status, created_at, created_by, updated_at, updated_by, deleted_at, deleted_by)
VALUES	(1,"PJT-1010","プロジェクト１０１０","05","2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
		(2,"PJT-4325","プロジェクト４３２５","04","2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
		(3,"PJT-7533","プロジェクト７５３３","03","2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
		(4,"PJT-3414","プロジェクト３４１４","02","2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
		(5,"PJT-7678","プロジェクト７６７８","01","2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
		(6,"PJT-9456","プロジェクト９４５６","01","2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL);

	
INSERT INTO tbl_t_user_projects(id, user_id, project_id, created_at, created_by, updated_at, updated_by, deleted_at, deleted_by)
VALUES	(1,1,2,"2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
		(2,1,1,"2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
		(3,2,3,"2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
		(4,2,4,"2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
		(5,1,5,"2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL),
		(6,1,6,"2020-02-03 15:31:49","system","2020-02-03 15:31:49",NULL,NULL,NULL);

		